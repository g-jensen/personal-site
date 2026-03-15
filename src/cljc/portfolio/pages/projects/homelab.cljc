(ns portfolio.pages.projects.homelab
  (:require [portfolio.page :as page]))

(def page
  (list
   [:html {:lang "en"}]
   (page/head "Greg Jensen")
   [:body
    page/nav-bar
    [:div.center
     [:h1 "Homelab"]]
    [:div.center
     [:h4.subtitle "My self-hosting setup for fun & to work towards digital sovereignty"]]
    [:div.center
     [:br]
     [:div.description
      [:ul
       [:li [:a {:href "/blog/2026-03-13-homelab.html"} "Full Blog Post"]]
       [:li "Old Mac Mini refashioned into a home server."]
       [:li "This website (gregjensen.dev) is hosted on the server."
        [:ul
         [:li "Custom workflow for remote development & deployment."]]]
       [:li "Custom DNS server with " [:a {:href "https://www.powerdns.com/" :target "_blank"} "PowerDNS"] " hosted on cheap VPS. This is my only real cost and dependence."]
       [:li [:a {:href "https://grafana.com/" :target "_blank"} "Grafana"] " + " [:a {:href "https://prometheus.io/" :target "_blank"} "Prometheus"] " setup for centralized server telemetry."
        [:ul
         [:li [:img {:src "/images/grafana.png" :alt "Grafana Graphs" :style "width: 120%;"}]]]]
       [:li "Cloud storage with " [:a {:href "https://nextcloud.com/" :target "_blank"} "NextCloud"] " to replace Google Drive."]
       [:li "Various gaming servers for my friends."]]]]]))