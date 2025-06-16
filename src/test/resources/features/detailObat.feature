Feature: Melihat Detail Obat

  Background:
    Given apoteker berada di beranda

  Scenario: Melihat detail obat yang tersedia
    When apoteker mengeklik tombol obat pada sidebar
    And apoteker mencari nama obat yang baru ditambahkan
    And apoteker menekan tombol detail obat
    Then tampil modal detail obat dengan informasi lengkap

  Scenario: Melihat detail obat yang tidak tersedia
    When apoteker mengeklik tombol obat pada sidebar
    And apoteker mencari nama obat yang tidak tersedia
    Then tampil pesan Tidak Ada Data