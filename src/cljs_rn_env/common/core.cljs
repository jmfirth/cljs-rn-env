(ns cljs-rn-env.common.core
  (:require [reagent.core :as r :refer [atom]]
            [re-frame.core :refer [subscribe dispatch dispatch-sync]]
            [native-base.core :as nb]
            [cljs-rn-env.events :as events]
            [cljs-rn-env.subs]
            [cljs.tools.reader :refer [read-string]]
            [cljs.js :refer [empty-state js-eval eval-str]]
            [clojure.string :as string]))


(defn eval [s]
  (let [opts {:eval js-eval
              :source-map true
              :context :expr}]
    (try (eval-str (empty-state) s nil opts (fn [result] result))
         (catch js/Object e nil))))


(defn layout [props & children]
  (let []
    [nb/container
     [nb/header
      (:header-left props)
      [nb/title (:header-title props)]
      (:header-right props)]
     [nb/content children]]))


(defn main-view []
  (let [state (subscribe [:main-view])]
    (fn []
      [layout {:header-title (:title @state)
               :header-right [nb/button {:transparent true
                                         :on-press #(dispatch [:set-view "repl"])}
                              [nb/icon {:name "md-code-working"}]]}
       [nb/card
        [nb/card-item {:header true}
         [nb/text "Clojurescript REPL"]]
        [nb/card-item
         [nb/text
          "Click the top-left icon to enter the REPL, and the back button within to return."]]]])))


(defn create-message [type body] {:type type :body body})


(defn message [m]
  (let [style {:font-family "monospace" :font-size 12}]
    (fn []
      (if (= (:type m) "user")
        [nb/text {:style style} (clojure.string/join " " [">" (:body m)])]
        [nb/text {:style style} (:body m)]))))


(defn repl-view []
  (let [state (subscribe [:repl-view])]
    [layout {:header-title (:title @state)
             :header-left [nb/button {:transparent true
                                      :on-press #(dispatch [:set-view "main"])}
                           [nb/icon {:name "md-arrow-back"}]]}
     (map-indexed (fn [k m] [message m]) (:messages @state))
     [nb/grid
      [nb/col
       [nb/input-group
        [nb/input {:on-change-text #(dispatch [:set-statement %])}]]]
      [nb/col {:style {:width 70}}
       [nb/button
        {:on-press #(do
                      (dispatch [:add-message (create-message "user" (:statement @state))])
                      (dispatch [:add-message (create-message "repl" (str (eval (:statement @state))))])
                      (dispatch [:set-statement ""]))}
        "evaluate"]]]]))


(defn app-root []
  (let [view (subscribe [:view])]
    (fn []
      (do (aset js/console "disableYellowBox" true)
          (aset js/console "disableRedBox" true)
          (cond (= @view "main") [main-view]
                (= @view "repl") [repl-view]
                :else [main-view])))))
