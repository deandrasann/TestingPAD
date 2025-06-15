Feature: Login Apoteker

  Scenario: Login berhasil sebagai apoteker
    Given Pengguna berada di halaman login
    When Pengguna memasukkan username "apoteker1" dan password "apoteker123"
    And Pengguna menekan tombol Login
    Then Pengguna diarahkan ke halaman dashboard apoteker

  Scenario: Login gagal karena password salah
    Given Pengguna berada di halaman login
    When Pengguna memasukkan username "apoteker1" dan password "salahpassword"
    And Pengguna menekan tombol Login
    Then Muncul pesan error login
