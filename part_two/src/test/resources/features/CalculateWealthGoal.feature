Feature: Calculate Wealth Goal
Scenario: Calculate Wealth Goal

  Given Users are in build-wealth page
  When Fill out the form with "25","350000","20","60","Stability"
  Then Verify that Goal Value is computed to "$1,297,989.52"

