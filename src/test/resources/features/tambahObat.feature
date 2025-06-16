Feature: Menambah Obat
  Background:
    Given apoteker berada di beranda

  Scenario:Apoteker menambah obat dengan data yang benar
    When apoteker mengeklik tombol obat pada sidebar
    And apoteker mengeklik tombol tambah obat
    And apoteker mengisi seluruh field dengan valid
    And apoteker menekan tombol simpan
    Then obat berhasil disimpan

  Scenario:Apoteker menambah obat dengan data yang kosong
    When apoteker mengeklik tombol obat pada sidebar
    And apoteker mengeklik tombol tambah obat
    And apoteker mengkosongkan salah satu field
    And apoteker menekan tombol simpan
    Then tampil pesan error data kosong

  Scenario:Apoteker menambah obat dengan tipe data salah
    When apoteker mengeklik tombol obat pada sidebar
    And apoteker mengeklik tombol tambah obat
    And apoteker menginputkan kekuatan sediaan dengan tipe data string
    And apoteker menekan tombol simpan
    Then tampil pesan salah tipe data