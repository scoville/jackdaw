(ns jackdaw.test.commands.base
  (:require
   [clojure.pprint :as pprint]))

(set! *warn-on-reflection* true)

(def command-map
  {:stop (constantly true)

   :sleep (fn [_ [sleep-ms]]
            (Thread/sleep sleep-ms))

   :println (fn [_ params]
              (println (apply str params)))

   :pprint (fn [_ params]
             (pprint/pprint params))

   :do (fn [machine [do-fn]]
         (do-fn @(:journal machine)))

   :do! (fn [machine [do-fn]]
          (do-fn (:journal machine)))

   :inspect (fn [machine [inspect-fn]]
              (inspect-fn machine))})
