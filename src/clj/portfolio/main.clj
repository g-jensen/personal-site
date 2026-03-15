(ns portfolio.main
  (:require [clojure.java.io :as io]
            [hiccup2.core :as hiccup] 
            [portfolio.page :as page]
            [portfolio.pages.home :as home]
            [portfolio.pages.math :as math]
            [portfolio.pages.projects.bezier-curve :as projects.bezier-curve]
            [portfolio.pages.projects.fourier-series :as projects.fourier-series]
            [portfolio.pages.projects.graphing-calculator :as projects.graphing-calculator]
            [portfolio.pages.projects.http-server :as projects.http-server]
            [portfolio.pages.projects.music-player :as projects.music-player]
            [portfolio.pages.projects.programming-challenges :as projects.programming-challenges]
            [portfolio.pages.projects.specc :as specc]
            [portfolio.pages.projects.text-editor :as projects.text-editor]
            [portfolio.pages.projects.set :as projects.set]
            [portfolio.pages.projects.scattergories :as projects.scattergories]
            [portfolio.pages.projects.catchphrase :as projects.catchphrase]
            [portfolio.pages.projects.homelab :as projects.homelab]
            [portfolio.pages.contact :as contact]
            [blog-site.static :as blog]))

(defn generate-page! [page]
  (io/make-parents (:file-name page))
  (spit (:file-name page) (str (hiccup/html (:hiccup page)))))

(def pages
  {
   "."                      home/page
   "homelab"                projects.homelab/page
   "set"                    projects.set/page
   "scattergories"          projects.scattergories/page
   "catchphrase"            projects.catchphrase/page
   "bezier-curve"           projects.bezier-curve/page
   "fourier-series"         projects.fourier-series/page
   "graphing-calculator"    projects.graphing-calculator/page
   "http-server"            projects.http-server/page
   "music-player"           projects.music-player/page
   "text-editor"            projects.text-editor/page
   "programming-challenges" projects.programming-challenges/page
   "math"                   math/page
   "specc"                  specc/page
   "contact"                contact/page
  })

(defn -main [& [destination-path blog-src-path :as args]]
  (run! generate-page! (map (fn [[k v]] (page/->page (str destination-path k "/index.html") v)) pages))
  (blog/-main blog-src-path (str destination-path "blog") ".html" page/nav-bar))