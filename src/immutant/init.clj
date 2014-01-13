(ns immutant.init
  (:import  [kafka.server KafkaConfig KafkaServer]
            [java.util    Properties])
  (:require [immutant.daemons :as daemons]))

;https://kafka.apache.org/documentation.html#brokerconfigs
(def config  (KafkaConfig. (doto (Properties.)
  (.setProperty "port"              "9090")
  (.setProperty "broker.id"         "1")
  (.setProperty "log.dir"           "/var/log/kafka")
  (.setProperty "num.partitions"    "8")
  (.setProperty "zookeeper.connect" "zookeeper")
  (.setProperty "auto.create.topics.enable" "true"))))

(def server (KafkaServer. config (kafka.utils.SystemTime$/MODULE$)))


;; start a daemon
(daemons/daemonize "kafka" #(.startup server) #(do (.shutdown server) (.awaitShutdown server)))
