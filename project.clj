(defproject mustangjaro/barometer "0.1.3"
  :description "A thin wrapper over Coda Hale's metrics library for the JVM"
  :url "https://github.com/mustangJaro/barometer"
  :license {:name "Apache License, Version 2.0"}

  :plugins [[lein-shell "0.5.0"]
            [lein-cljfmt "0.6.4"]
            [lein-codox "0.10.3"]]

  :dependencies [[org.clojure/clojure "1.9.0"]
                 [com.workiva/utiliva "0.1.0"]
                 [com.workiva/recide "1.0.1"]
                 [galdre/morphe "1.2.0"]
                 [org.clojure/tools.logging "0.4.0"]
                 [io.dropwizard.metrics/metrics-core "4.1.9"]
                 [io.dropwizard.metrics/metrics-graphite "4.1.9"]
                 [io.dropwizard.metrics/metrics-jvm "4.1.9"]
                 [io.dropwizard.metrics/metrics-json "4.1.9"]]

  :deploy-repositories {"clojars"
                        {:url "https://repo.clojars.org"
                         :sign-releases false}}

  :source-paths      ["src"]
  :test-paths        ["test"]

  :global-vars {*warn-on-reflection* true}

  :aliases {"docs" ["do" "clean-docs," "with-profile" "docs" "codox"]
            "clean-docs" ["shell" "rm" "-rf" "./documentation"]}

  :codox {:metadata {:doc/format :markdown}
          :themes [:rdash]
          :html {:transforms [[:title]
                              [:substitute [:title "Barometer API Docs"]]
                              [:span.project-version]
                              [:substitute nil]
                              [:pre.deps]
                              [:substitute [:a {:href "https://clojars.org/mustangJaro/barometer"}
                                            [:img {:src "https://img.shields.io/clojars/v/mustangJaro/barometer.svg"}]]]]}
          :output-path "documentation"}

  :profiles {:dev [{:dependencies [[criterium "0.4.3"]]}]
             :docs {:dependencies [[codox-theme-rdash "0.1.2"]]}})
