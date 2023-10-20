Feature: Login ke Website saucedemo

  Scenario: User berhasil login ke website saucedemo
    Given User membuka browser
    When User menginput url login
    And User menginput username
    And User menginput password
    And User memilih Login Button
    Then User berhasil login
    And User diarahkan ke homepage


  Scenario: User gagal login ke website saucedemo
    Given User membuka browser
    When User menginput url login
    And User menginput username
    And User menginput invalid password
    And User memilih Login Button
    Then User mendapatkan error message
    And User tidak dapat masuk ke homepage



