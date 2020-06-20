Feature: De-Register Taxtype

  Scenario Outline: Indvidual_taxtype DeRegister
    Given Browser is opened and Maximized
    Then Open Application URL
    When Enter the username "<username>" and password "<password>"
    Then click on login

    Examples: 
      | username  | password |  |
      | tripsuser | Passw0rd |  |
