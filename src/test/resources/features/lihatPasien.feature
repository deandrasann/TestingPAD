Feature: Lihat data pasien

  Background:
    Given apoteker berada di beranda

  Scenario: Melihat list pasien yang ada
    When apoteker mengeklik tombol pasien di sidebar
    Then tampil data pasien