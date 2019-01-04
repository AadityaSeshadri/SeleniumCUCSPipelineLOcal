Feature: Login to Facebook and Check for Homepage
@Login
  Scenario Outline: Facebook Login
    When User Logins Facebook with Username "<username>"  and Password "<password>"
    Then User should be able to view Homepage
    Examples:
    |username                  |password    |
    |aadityaapr5@gmail.com     |XXXXXXXXXXXX|
