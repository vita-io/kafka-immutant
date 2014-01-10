(ns immutant.init
  (:import  [kafka.server KafkaConfig KafkaServer]
            [java.util    Properties])
  (:require [immutant.daemons :as daemons]))

(def config  (KafkaConfig. (doto (Properties.)
  (.setProperty "port"       		"9092");
  (.setProperty "broker.id"  		"1")
  (.setProperty "log.dir"    		"/var/log/kafka/")
  (.setProperty "zookeeper.connect" "zookeeper"))))

(def server (KafkaServer. config (kafka.utils.SystemTime$/MODULE$)))


;; start a daemon
(daemons/daemonize "kafka" #(.startup server) #(do (.shutdown server) (.awaitShutdown server)))
