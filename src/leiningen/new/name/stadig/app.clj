(ns leiningen.new.name.stadig.app
  (:require
   [leiningen.new.templates :refer [renderer year date project-name
                                    ->files sanitize-ns name-to-path
                                    multi-segment]]
   [leiningen.core.main :as main]))

(def render (renderer "name.stadig.app"))

(defn name.stadig.app
  [name]
  (let [render (renderer "name.stadig.app")
        main-ns (multi-segment (sanitize-ns name))
        data {:raw-name name
              :name (project-name name)
              :namespace main-ns
              :nested-dirs (name-to-path main-ns)
              :year (year)
              :date (date)}]
    (main/info "Generating a project called" name
               "based on the 'name.stadig.app' template.")
    (->files data
             ["project.clj" (render "project.clj" data)]
             ["README.md" (render "README.md" data)]
             ["doc/intro.md" (render "intro.md" data)]
             [".gitignore" (render "gitignore" data)]
             ["src/{{nested-dirs}}.clj" (render "core.clj" data)]
             ["test/{{nested-dirs}}_test.clj" (render "test.clj" data)]
             ["LICENSE.txt" (render "LICENSE.txt" data)]
             ["CHANGELOG.md" (render "CHANGELOG.md" data)]
             "resources")))
