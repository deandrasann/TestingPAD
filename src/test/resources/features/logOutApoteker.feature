Feature: Apoteker Log Out

  Background:
    Given apoteker berada di halaman pasien

  Scenario: Apoteker log out dari halaman tambah pasien
    When Apoteker menekan tombol log out
    Then Apoteker berada di halaman login