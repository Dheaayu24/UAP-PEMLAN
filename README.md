# ☕ Sistem Antrian Pesanan Café

Aplikasi **Sistem Antrian Pesanan Café** adalah aplikasi desktop berbasis **Java Swing** yang digunakan untuk membantu pengelolaan antrian dan pesanan pelanggan secara terstruktur, efisien, dan mudah digunakan.  
Aplikasi ini dikembangkan sebagai bagian dari **Ujian Akhir Praktikum Mata Kuliah Pemrograman Lanjut**.

---

## 📌 Gambaran Umum
Pengelolaan pesanan secara manual sering menimbulkan masalah seperti kesalahan pencatatan, antrian tidak teratur, serta kesulitan dalam rekap data transaksi.  
Oleh karena itu, aplikasi ini dibuat untuk mendukung proses pencatatan pesanan, pengelolaan status antrian, serta penyimpanan riwayat transaksi secara digital.

---

## 🎯 Tujuan Aplikasi
Aplikasi ini dikembangkan dengan tujuan:
- Mengimplementasikan konsep **Object Oriented Programming (OOP)**
- Menerapkan operasi **CRUD (Create, Read, Update, Delete)**
- Mengembangkan aplikasi desktop berbasis **Java GUI (Swing)**
- Menerapkan **file handling** untuk penyimpanan data
- Menggunakan **event handling** dan validasi input

---

## ✨ Fitur Aplikasi
- **Dashboard Utama**  
  Menyediakan navigasi ke seluruh menu aplikasi.

- **Input Pesanan**  
  Pengguna dapat mengisi nama pelanggan, memilih menu, menentukan jumlah pesanan, dan melihat total harga secara otomatis.

- **Manajemen Antrian**  
  Mengelola status pesanan dengan tahapan:
  - Menunggu
  - Diproses
  - Selesai

- **Riwayat Transaksi**  
  Menampilkan data transaksi yang telah disimpan sebelumnya.

---

## 🔄 Alur Sistem
1. Pengguna membuka aplikasi pada halaman **Dashboard**
2. Pengguna menambahkan pesanan melalui menu **Input Pesanan**
3. Data pesanan ditampilkan pada **Daftar Pesanan**
4. Status pesanan diperbarui sesuai proses
5. Data transaksi disimpan ke dalam file teks dan dapat dilihat kembali

---

## 🛠️ Teknologi yang Digunakan
- **Bahasa Pemrograman**: Java  
- **GUI**: Java Swing  
- **Layout Manager**: CardLayout  
- **Manajemen Data**: DefaultTableModel  
- **Penyimpanan Data**: File teks (`.txt`)  
- **API**: Java Date & SimpleDateFormat  

---

## 🧾 Implementasi CRUD
- **Create**: Menambahkan data pesanan
- **Read**: Menampilkan daftar pesanan dan riwayat transaksi
- **Update**: Mengubah status pesanan
- **Delete**: Menghapus atau mengurangi item pesanan

---

## 💾 Penyimpanan Data
Data riwayat transaksi disimpan secara permanen ke dalam file:
riwayat_transaksi.txt
Data disimpan dengan pemisah `|` agar mudah dibaca kembali saat aplikasi dijalankan.

---

## ⚠️ Exception Handling
Aplikasi menggunakan mekanisme **try-catch** untuk menangani error input/output saat proses pembacaan dan penulisan file, sehingga aplikasi tetap stabil.

---

## 👩‍🎓 Identitas Pengembang
- **Nama**: Dhea Ayu Angelia Putri  
- **NIM**: 202410370110182  
- **Program Studi**: Informatika  
- **Fakultas**: Teknik  
- **Universitas**: Universitas Muhammadiyah Malang  
- **Tahun**: 2025  

---

## ✅ Kesimpulan
Aplikasi Sistem Antrian Pesanan Café berhasil diimplementasikan dengan menerapkan konsep OOP, CRUD, Java Swing GUI, file handling, serta exception handling. Aplikasi ini membantu pengelolaan pesanan café menjadi lebih sistematis, rapi, dan efisien.

