(defproject {{raw-name}} "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Mozilla Public License, v. 2.0"
            :url "http://mozilla.org/MPL/2.0/"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot {{namespace}}
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
