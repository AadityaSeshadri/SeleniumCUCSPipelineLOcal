Feature: Login to Facebook and Check for Homepage

  Background:
    Given Login to Lazada with Facebook
      | Username                  | Password    |
      | aadityaapr5@gmail.com     | velayaparu |

  @Login
  Scenario: Lazada Add Products
    When Search for Product with Below Specs
      | Product                   | Brand    |Rating    | Color|    Service      |
      | Wireless Mouse            | Logitech |  5       |Black |Free Shipping    |
    Then Add Products into Cart






