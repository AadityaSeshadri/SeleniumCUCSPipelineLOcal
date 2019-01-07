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
    Then Validate Info of First Product in List
      |Name                                                           |Price      |
      |Logitech G Pro HERO Wireless Mouse + Powerplay wireless charger|299        |
    Then Add Products into Cart

    Scenario: Validate Added Products in Cart
      When Clicked on Cart
      Then Validate Products in cart
        |Name                                                           |Price      |
        |Logitech G Pro HERO Wireless Mouse + Powerplay wireless charger|299        |
      And Delete Product in Cart








