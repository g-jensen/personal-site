(ns portfolio.config
  (:require [c3kit.apron.env :as env]))

(def host (if (= "production" (env/env "PORTFOLIO_ENV")) "https://gregjensen.dev" "http://127.0.0.1:5501"))