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

  Scenario: Apoteker gagal mengedit obat karena field wajib kosong
    When apoteker mengeklik tombol obat pada sidebar
    And apoteker mencari nama obat yang baru ditambahkan
    And apoteker mengeklik tombol edit pada obat
    And apoteker mengkosongkan salah satu field saat edit
    And apoteker menekan tombol simpan pada modal edit
    Then tampil pesan error data kosong

