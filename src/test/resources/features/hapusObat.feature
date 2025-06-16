Feature: Menghapus data Obat

  Background:
    Given apoteker berada di beranda

  Scenario: Menghapus obat yang tersedia
    When apoteker mengeklik tombol obat pada sidebar
    And apoteker mencari nama obat yang akan dihapus
    And apoteker menekan tombol hapus obat
    And tekan ya pada modal hapus
    Then muncul pesan data berhasil dihapus

  Scenario: Tidak jadi menghapus obat yang tersedia
    When apoteker mengeklik tombol obat pada sidebar
    And apoteker mencari nama obat yang akan dihapus
    And apoteker menekan tombol hapus obat
    Then tekan tidak pada modal hapus
#    Then obat masih tersedia