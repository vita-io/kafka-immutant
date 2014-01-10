(defproject touch/immutant-kafka "0.8.0"
  :repositories {"conjars" "http://conjars.org/repo/"
  				 "jboss" "http://repository.jboss.org/nexus/content/groups/public"}
  :dependencies [
  	[org.clojure/clojure "1.5.1"]
    [clj-kafka/clj-kafka             "0.1.2-0.8"   :exclusions [org.apache.kafka/kafka_2.10 org.scala-lang/scala-library org.scala-lang/scala-compiler org.apache.zookeeper/zookeeper log4j]]
    [org.apache.zookeeper/zookeeper  "3.4.5"       :exclusions [org.slf4j/slf4j-log4j12 jline org.slf4j/slf4j-api com.sun.jdmk/jmxtools com.sun.jmx/jmxri]]
    [org.apache.kafka/kafka_2.9.2    "0.8.0"]
])
