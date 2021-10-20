Feature: Click Build Wealth Submenu to go Build Wealth page

Scenario: Visit Build Wealth Scenario
  Given User is on the home page
  When They click Product menu
  Then Verify that Build Wealth submenu is in the submenu list
  And They click Build Menu submenu
  Then Verify that all Heading One tags are captured an their text are printed
  