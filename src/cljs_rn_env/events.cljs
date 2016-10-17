(ns cljs-rn-env.events
  (:require
    [re-frame.core :refer [reg-event-db after]]
    [clojure.spec :as s]
    [cljs-rn-env.db :as db :refer [app-db]]))

;; -- Middleware ------------------------------------------------------------
;;
;; See https://github.com/Day8/re-frame/wiki/Using-Handler-Middleware
;;
(defn check-and-throw
  "Throw an exception if db doesn't have a valid spec."
  [spec db]
  (when-not (s/valid? spec db)
    (let [explain-data (s/explain-data spec db)]
      (throw (ex-info (str "Spec check failed: " explain-data) explain-data)))))

(def validate-spec-mw
  (if goog.DEBUG
    (after (partial check-and-throw ::db/app-db))
    []))

;; -- Handlers --------------------------------------------------------------

(reg-event-db
  :initialize-db
  validate-spec-mw
  (fn [_ _]
    app-db))

(reg-event-db
 :set-view
 validate-spec-mw
 (fn [db [_ value]]
   (assoc db :view value)))

(reg-event-db
 :set-statement
 validate-spec-mw
 (fn [db [_ value]]
   (assoc-in db [:repl-view :statement] value)))

(reg-event-db
 :add-message
 (fn [db [_ value]]
   (assoc-in db [:repl-view :messages] (conj (get-in db [:repl-view :messages]) value))))

#_(reg-event-db
  :set-greeting
  validate-spec-mw
  (fn [db [_ value]]
    (assoc db :greeting value)))
