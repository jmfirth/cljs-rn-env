(ns cljs-rn-env.db
  (:require [clojure.spec :as s]))

;; spec of app-db
(s/def ::view string?)
(s/def ::main-view map?)
(s/def ::repl-view map?)
(s/def ::app-db
  (s/keys :req-un [::view ::main-view ::repl-view]))

;; initial state of app-db
(def app-db
  {;; current view
   :view "main"

   :main-view
   {:title "Main"}

   :repl-view
   {:title "REPL"
    :statement "(+ 1 1)"
    :messages []}})
