Feature: De-Register Taxtype

  Scenario Outline: Organization_taxtype DeRegister
    Given Browser is opened and Maximized
    Then Open Application URL
    When Enter the Org Username and password "<password>"
    Then click on login

    Examples: 
      | password |  |
      | Passw0rd |  |
