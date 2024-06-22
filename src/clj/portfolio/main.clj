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
            [portfolio.pages.projects.text-editor :as projects.text-editor]))

(def page-path "resources/public/")

(defn generate-page! [page]
  (spit (:file-name page) (str (hiccup/html (:hiccup page)))))

(defn -main [& args]
  (run! generate-page! [(page/->page (str page-path "index.html") home/page)
                        (page/->page (str page-path "bezier-curve") projects.bezier-curve/page)
                        (page/->page (str page-path "fourier-series") projects.fourier-series/page)
                        (page/->page (str page-path "graphing-calculator") projects.graphing-calculator/page)
                        (page/->page (str page-path "http-server") projects.http-server/page)
                        (page/->page (str page-path "music-player") projects.music-player/page)
                        (page/->page (str page-path "text-editor") projects.text-editor/page)
                        (page/->page (str page-path "programming-challenges") projects.programming-challenges/page)
                        (page/->page (str page-path "math") math/page)
                        (page/->page (str page-path "specc") specc/page)
                        ]))