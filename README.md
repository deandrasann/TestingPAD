# 🧪 UI Automation Testing - Aplikasi Manajemen Obat & Pasien

Proyek ini merupakan implementasi **automated UI testing** untuk sistem manajemen obat dan pasien yang dikembangkan dengan menggunakan **Selenium WebDriver** dan **Cucumber BDD (Behavior Driven Development)**.

---

## 🚀 Tech Stack

![Java](https://img.shields.io/badge/-Java-007396?logo=java&logoColor=white)
![Selenium](https://img.shields.io/badge/-Selenium-43B02A?logo=selenium&logoColor=white)
![Cucumber](https://img.shields.io/badge/-Cucumber-23D96C?logo=cucumber&logoColor=white)
![JUnit5](https://img.shields.io/badge/-JUnit%205-25A162?logo=java&logoColor=white)
![ExtentReports](https://img.shields.io/badge/-ExtentReports-FF6F00?logo=report&logoColor=white)
![Maven](https://img.shields.io/badge/-Maven-C71A36?logo=apachemaven&logoColor=white)
![Chrome](https://img.shields.io/badge/-Chrome-4285F4?logo=googlechrome&logoColor=white)
![Gherkin](https://img.shields.io/badge/-Gherkin-5C2D91?logo=gherkin&logoColor=white)


---

## ✅ Fitur yang Diuji

1. **Login Apoteker**
   - Valid login menggunakan kredensial yang valid
   - Validasi field kosong & kesalahan login

2. **Manajemen Obat**
   - Menambahkan data obat baru
   - Mengedit informasi obat
   - Menghapus data obat dengan validasi konfirmasi
   - Pencarian obat berdasarkan nama
   - Validasi field kosong pada form tambah/edit

3. **Melihat Pasien**
   - Melihat data senmua pasien

4. **Pencarian & Navigasi**
   - Navigasi antar halaman melalui sidebar
   - Validasi input pencarian (search)

5. **Report Otomatis**
   - Generate file laporan hasil testing dalam format HTML:  
     ➤ `test-output/GeneratedExtentReport.html`

---

## 🛠️ Struktur Kode Utama

- `pages/` → Page Object Model untuk halaman login, dashboard, obat, pasien
- `steps/` → Step definitions untuk tiap skenario Cucumber
- `units/ExtendReportManager.java` → Konfigurasi report otomatis dengan Extent
- `utils/ScreenShootUtil.java` → Screenshot otomatis saat test gagal

---

## 🔗 Tautan Terkait
- 📊 **Projek PAD**:  
  [https://app.qase.io/project/UA](https://github.com/deandrasann/PAD1/tree/dea)

- 📊 **Qase Test Management**:  
  [https://app.qase.io/project/UA](https://app.qase.io/project/UA)

- 📋 **Spreadsheet Test Case & Bug Fixing**:  
  [Google Sheets - QA & Bugs Log](https://docs.google.com/spreadsheets/d/1_hPlRwzMhkrVM9dTc0bNTvMZwx-Yhyn1FBdtEe9LYeU/edit?gid=0#gid=0)

---

## 📎 Cara Menjalankan

1. Pastikan sudah install:
   - Java JDK 21
   - Maven
   - Google Chrome
   - Chromedriver versi 137 sesuai dengan browser

2. Jalankan test dengan perintah:

```bash
mvn test
