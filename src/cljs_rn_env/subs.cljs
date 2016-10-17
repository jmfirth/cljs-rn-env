(ns cljs-rn-env.subs
  (:require [re-frame.core :refer [reg-sub]]))

(reg-sub
 ;; get current view
 :view
 (fn [db _]
   (:view db)))

(reg-sub
 ;; get main view state
 :main-view
 (fn [db _]
   (:main-view db)))

(reg-sub
 ;; get repl view state
 :repl-view
 (fn [db _]
   (:repl-view db)))
