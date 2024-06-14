(ns portfolio.main-spec
  (:require [hiccup2.core :as hiccup]
            [portfolio.main :as sut]
            [portfolio.pages.home :as home]
            [portfolio.pages.math :as math]
            [portfolio.pages.projects.bezier-curve :as projects.bezier-curve]
            [portfolio.pages.projects.fourier-series :as projects.fourier-series]
            [portfolio.pages.projects.graphing-calculator :as projects.graphing-calculator]
            [portfolio.pages.projects.http-server :as projects.http-server]
            [portfolio.pages.projects.isometric-engine :as projects.isometric-engine]
            [portfolio.pages.projects.multiplayer-game :as projects.multiplayer-game]
            [portfolio.pages.projects.music-player :as projects.music-player]
            [portfolio.pages.projects.programming-challenges :as projects.programming-challenges]
            [portfolio.pages.projects.text-editor :as projects.text-editor]
            [speclj.core :refer [before context describe it redefs-around
                                 should-have-invoked with-stubs]]
            [speclj.stub :refer [stub]]))

(describe "main" 
  (with-stubs)
  (redefs-around [spit (stub :spit)])
          
  (context "generate-page"
    (it "spits to file-name"
      (sut/generate-page! {:file-name "greg.html" :hiccup [:p "hi"]})
      (should-have-invoked :spit {:with ["greg.html" "<p>hi</p>"]})
      (sut/generate-page! {:file-name "other-file" :hiccup [:p "hi"]})
      (should-have-invoked :spit {:with ["other-file" "<p>hi</p>"]}))
    
    (it "spits html from hiccup"
      (sut/generate-page! {:file-name "other-file" :hiccup [:h1 "header"]})
      (should-have-invoked :spit {:with ["other-file" "<h1>header</h1>"]}) 
      (sut/generate-page! {:file-name "other-file" :hiccup [:span {:class "foo"} "bar"]})
      (should-have-invoked :spit {:with ["other-file" "<span class=\"foo\">bar</span>"]})))
  
  (context "generates pages"
    (before (sut/-main))

    (it "index.html"
      (should-have-invoked :spit {:with ["resources/public/index.html" (str (hiccup/html home/page))]}))

    (it "bezier-curve"
      (should-have-invoked :spit {:with ["resources/public/bezier-curve" (str (hiccup/html projects.bezier-curve/page))]}))

    (it "fourier-series"
      (should-have-invoked :spit {:with ["resources/public/fourier-series" (str (hiccup/html projects.fourier-series/page))]}))

    (it "graphing-calculator"
      (should-have-invoked :spit {:with ["resources/public/graphing-calculator" (str (hiccup/html projects.graphing-calculator/page))]}))

    (it "http-server"
      (should-have-invoked :spit {:with ["resources/public/http-server" (str (hiccup/html projects.http-server/page))]}))

    (it "isometric-engine"
      (should-have-invoked :spit {:with ["resources/public/isometric-engine" (str (hiccup/html projects.isometric-engine/page))]}))

    (it "multiplayer-game"
      (should-have-invoked :spit {:with ["resources/public/multiplayer-game" (str (hiccup/html projects.multiplayer-game/page))]}))

    (it "music-player"
      (should-have-invoked :spit {:with ["resources/public/music-player" (str (hiccup/html projects.music-player/page))]}))

    (it "programming-challenges"
      (should-have-invoked :spit {:with ["resources/public/programming-challenges" (str (hiccup/html projects.programming-challenges/page))]}))

    (it "text-editor"
      (should-have-invoked :spit {:with ["resources/public/text-editor" (str (hiccup/html projects.text-editor/page))]}))
    
    (it "text-editor"
      (should-have-invoked :spit {:with ["resources/public/math" (str (hiccup/html math/page))]}))))
    