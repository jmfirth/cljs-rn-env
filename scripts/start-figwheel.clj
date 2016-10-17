(ns start-figwheel
  (:require [figwheel-sidecar.repl-api :refer [stop-figwheel! start-figwheel! cljs-repl]]))

(def figwheel-config
  {:figwheel-options {}
   :build-ids ["android"]
   :all-builds
   [{:id "android"
     :source-paths ["src" "env/dev"]
     :figwheel true
     :compiler
     {:output-to "target/android/not-used.js"
      :main "env.android.main"
      :output-dir "target/android"
      :optimizations :none}}]})

(defn start-app
  []
  (do
    (stop-figwheel!)
    (start-figwheel! figwheel-config)
    (cljs-repl)))

(defn disable-messages []
  (do
    (aset js/console "disableYellowBox" true)
    (aset js/console "disableRedBox" true)))
