☕ Cafe Queue App

Aplikasi Manajemen Antrian dan Pesanan Cafe Berbasis Java

 📌 Gambaran Umum

Cafe Queue App merupakan aplikasi desktop berbasis Java Swing yang digunakan untuk membantu pengelolaan antrian dan pesanan pada sebuah cafe.
Aplikasi ini memungkinkan pencatatan pesanan pelanggan, pengelolaan status pesanan, serta penyimpanan riwayat transaksi secara terstruktur dan mudah digunakan.

Antarmuka aplikasi dirancang sederhana dengan tema warna lembut agar nyaman digunakan dalam operasional sehari-hari.

 🎯 Tujuan Aplikasi

Aplikasi ini dikembangkan dengan tujuan:

* Membantu proses pencatatan pesanan pelanggan
* Mengelola alur antrian pesanan secara sistematis
* Menyimpan data transaksi sebagai arsip
* Mengimplementasikan konsep Java GUI dan file handling

 ✨ Fitur Aplikasi

* Dashboard Utama
  Menyediakan navigasi ke seluruh menu aplikasi.

* Input Pesanan
  Pengguna dapat mengisi nama pelanggan, memilih menu makanan atau minuman, menentukan jumlah pesanan, serta melihat total pembayaran secara otomatis.

* Manajemen Antrian
  Menampilkan daftar pesanan dengan status:

  * Menunggu
  * Diproses
  * Selesai

* Riwayat Transaksi
  Menyimpan dan menampilkan data transaksi yang telah selesai diproses.

* Penyimpanan Data Lokal
  Riwayat transaksi disimpan dalam file teks sehingga tetap tersedia saat aplikasi dijalankan kembali.

🧠 Konsep dan Cara Kerja

Setiap pesanan yang dimasukkan akan dicatat ke dalam sistem dan masuk ke daftar antrian.
Pesanan diproses secara bertahap sesuai statusnya hingga selesai.
Pesanan yang telah selesai akan otomatis dicatat ke dalam riwayat transaksi dan disimpan ke dalam file.

🧩 Arsitektur Program

* Menggunakan satu class utama berbasis JFrame
* Navigasi halaman menggunakan CardLayout
* Pengelolaan data tabel menggunakan DefaultTableModel
* Penyimpanan data dilakukan menggunakan mekanisme File I/O (.txt)

 🔄 Alur Penggunaan Aplikasi

1. Pengguna membuka aplikasi
2. Memilih menu input pesanan
3. Mengisi data pelanggan dan memilih menu
4. Menyimpan pesanan
5. Pesanan masuk ke daftar antrian
6. Status pesanan diperbarui hingga selesai
7. Data transaksi otomatis masuk ke riwayat

 📊 Contoh Penggunaan

Seorang pelanggan memesan beberapa menu makanan dan minuman.
Pesanan dicatat oleh sistem, diproses sesuai urutan antrian, dan setelah selesai akan disimpan sebagai riwayat transaksi.

 🧪 Pengujian Dasar

* Sistem menolak penyimpanan jika nama pelanggan kosong
* Pesanan tidak dapat disimpan tanpa menu
* Status pesanan hanya dapat diubah sesuai alur yang ditentukan
* Data riwayat tetap tersedia meskipun aplikasi ditutup

 ⚠️ Batasan Sistem

* Belum menggunakan database
* Tidak mendukung penggunaan oleh banyak pengguna secara bersamaan
* Belum tersedia fitur login atau otorisasi
* Laporan belum dapat diekspor ke format lain

 🚀 Rencana Pengembangan

* Integrasi database (MySQL / SQLite)
* Penambahan fitur login admin
* Pembuatan laporan transaksi
* Ekspor data ke PDF atau Excel
* Pengembangan ke versi web atau mobile

 ▶️ Cara Menjalankan Program

1. Pastikan Java Development Kit (JDK) sudah terpasang
2. Buka project menggunakan IDE Java
3. Jalankan file `CafeQueueApp.java`
4. Aplikasi siap digunakan


