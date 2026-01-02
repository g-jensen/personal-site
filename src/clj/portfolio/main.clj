(ns portfolio.main
  (:require [hiccup2.core :as hiccup] 
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
            [blog-site.static :as blog]))

(def page-path "resources/public/")

(defn generate-page! [page]
  (spit (:file-name page) (str (hiccup/html (:hiccup page)))))

(def pages
  {
   "index"                  home/page
   "bezier-curve"           projects.bezier-curve/page
   "fourier-series"         projects.fourier-series/page
   "graphing-calculator"    projects.graphing-calculator/page
   "http-server"            projects.http-server/page
   "music-player"           projects.music-player/page
   "text-editor"            projects.text-editor/page
   "programming-challenges" projects.programming-challenges/page
   "math"                   math/page
   "specc"                  specc/page
  })

(defn -main [& args]
  (run! generate-page! (map (fn [[k v]] (page/->page (str page-path k ".html") v)) pages))
  (blog/-main "resources/posts" "resources/public/blog" ".html" page/nav-bar))