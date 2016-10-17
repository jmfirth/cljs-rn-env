(ns cljs-rn-env.android.core
  (:require [reagent.core :as r]
            [re-frame.core :refer [subscribe dispatch-sync]]
            [cljs-rn-env.events :as events]
            [cljs-rn-env.subs]
            [cljs-rn-env.common.core :as c]))


(def ReactNative (js/require "react-native"))


(defn alert [title] (.alert (.-Alert ReactNative) title))


(def app-registry (.-AppRegistry ReactNative))


(defn app-root []
  (let [view (subscribe [:view])]
    (fn []
      (do (aset js/console "disableYellowBox" true)
          (aset js/console "disableRedBox" true)
          (cond (= @view "main") [c/main-view]
                (= @view "repl") [c/repl-view]
                :else [c/main-view])))))


(defn init []
  (dispatch-sync [:initialize-db])
  (.registerComponent app-registry "CljsRnEnv" #(r/reactify-component app-root)))
