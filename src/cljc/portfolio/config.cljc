(ns portfolio.config
  (:require [c3kit.apron.env :as env]))

(def host (if (= "production" (env/env "PORTFOLIO_ENV")) "https://gregjensen.dev" "localhost:8125"))