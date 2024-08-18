(ns portfolio.pages.math 
  (:require [portfolio.page :as page]))

(def page
  (list
   [:html {:lang "en"}]
   (page/head "Greg Jensen")
   [:body
    page/nav-bar
    [:div.center
     [:h1 "Math"]]
    [:div.center
     [:h4.subtitle "Some of my excursions into mathematics"]]
    [:div.center
     [:br]
     [:ul
      [:li
       [:a {:href "https://science.iupui.edu/math/about/math-contest/index.html"} "IUPUI Highschool Math Contest 2023"] " (2nd place)"
       [:ul
        [:li "We were given about 2 months to solve 4 problems and write an essay about fractals."]
        [:li [:a {:href "https://drive.google.com/file/d/1xMQfGd_iKgDw_Y0OKBFuYF3Wmn37sJMp/view"} "Contest poster with list of problems"]]
        [:li [:a {:href "documents/2023 INDIVIDUAL PROBLEMS-1.pdf"} "My solutions"]]]]
      [:li
       [:a {:href "documents/Set.pdf"} "Article on the mathematics behind the card game Set"]
       [:ul
        [:li "Assignment for college English class"]]]
      [:li "Mathy Blog Posts"
       [:ul
        [:li [:a {:href "https://blog.gregjensen.dev/2023-05-19-modular-exponentiation"} "Modular Exponentiation"]]
        [:li [:a {:href "https://blog.gregjensen.dev/2023-06-07-discrete-cantor-set"} "Discrete Cantor Set"]]
        [:li [:a {:href "https://blog.gregjensen.dev/2023-06-20-sqrt-construction"} "Square Root Construction"]]
        [:li [:a {:href "https://blog.gregjensen.dev/2023-06-28-tau-day"} "Tau Day"]]
        [:li [:a {:href "https://blog.gregjensen.dev/2023-06-30-1729"} "1729"]]
        [:li [:a {:href "https://blog.gregjensen.dev/2023-07-07-mathematical-bridge"} "Mathematical Bridge"]]
        [:li [:a {:href "https://blog.gregjensen.dev/2023-07-10-oeis"} "OEIS"]]
        [:li [:a {:href "https://blog.gregjensen.dev/2024-07-11-math-apology"} "A Mathematician's Apology"]]]]]]]))