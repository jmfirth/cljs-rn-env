(ns cljs-rn-env.ios.core
  (:require [reagent.core :as r :refer [atom]]
            [re-frame.core :refer [subscribe dispatch dispatch-sync]]
            [cljs-rn-env.events]
            [cljs-rn-env.subs]))


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
