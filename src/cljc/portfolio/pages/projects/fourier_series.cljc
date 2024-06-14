(ns portfolio.pages.projects.fourier-series 
  (:require [portfolio.page :as page]))

(def page
  (list
   [:html {:lang "en"}]
   (page/head "Greg Jensen")
   [:body
    page/nav-bar
    [:div.center
     [:h1 "Fourier Series"]]
    [:div.center
     [:h4.subtitle "Written in C++"]]
    [:div.center
     [:br]
     [:div.description
      [:ul
       [:li "This is a visualization of a Fourier Series using rotating vectors to represent the sinusoidal waves. The values are randomized in the animations, but the concept would stay the same for real a Fourier Series."]
       [:br]
       [:iframe
        {:width "600"
         :height "300"
         :src "https://www.youtube.com/embed/cfCInjO9rbM"}]
       [:br]
       [:li
        [:a {:href "https://github.com/g-jensen/FourierSeries"} "Repo Link"]]]]]]))