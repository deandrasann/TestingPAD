Feature: Mengedit Obat

  Background:
    Given apoteker berada di beranda

  Scenario: Apoteker berhasil mengedit obat dengan data yang benar
    When apoteker mengeklik tombol obat pada sidebar
    And apoteker mencari nama obat yang baru ditambahkan
    And apoteker mengeklik tombol edit pada obat
    And apoteker mengubah field yang diinginkan
    And apoteker menekan tombol simpan pada modal edit
    Then data obat berhasil diperbarui

  Scenario: Apoteker gagal mengedit obat karena field kosong
    When apoteker mengeklik tombol obat pada sidebar
    And apoteker mencari nama obat yang baru ditambahkan
    And apoteker mengeklik tombol edit pada obat
    And apoteker mengkosongkan salah satu field saat edit
    And apoteker menekan tombol simpan pada modal edit
    Then tampil pesan error data kosong

  Scenario: Apoteker gagal mengedit obat karena tipe data salah
    When apoteker mengeklik tombol obat pada sidebar
    And apoteker mencari nama obat yang baru ditambahkan
    And apoteker mengeklik tombol edit pada obat
    And apoteker menginputkan kekuatan sediaan dengan tipe data string saat edit
    And apoteker menekan tombol simpan pada modal edit
    Then tampil pesan error data kosong

  Scenario: Melihat detail obat yang tidak tersedia
    When apoteker mengeklik tombol obat pada sidebar
    And apoteker mencari nama obat yang tidak tersedia
    Then tampil pesan Tidak Ada Data

