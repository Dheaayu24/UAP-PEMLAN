☕ Sistem Antrian Pesanan Café

Aplikasi Sistem Antrian Pesanan Café merupakan aplikasi desktop berbasis Java Swing yang dikembangkan untuk membantu pengelolaan pesanan pelanggan secara terstruktur dan efisien. Aplikasi ini dibuat sebagai bagian dari Ujian Akhir Praktikum Mata Kuliah Pemrograman Lanjut.

📌 Latar Belakang

Pengelolaan pesanan café yang masih dilakukan secara manual berpotensi menimbulkan kesalahan pencatatan, ketidakteraturan antrian, serta kesulitan dalam rekap data transaksi. Oleh karena itu, aplikasi ini dikembangkan untuk mendukung proses pencatatan pesanan, pengelolaan status antrian, dan penyimpanan riwayat transaksi secara digital.

🎯 Tujuan

Aplikasi ini dibuat dengan tujuan:

Mengimplementasikan konsep Object Oriented Programming (OOP)

Menerapkan operasi CRUD (Create, Read, Update, Delete)

Mengembangkan aplikasi desktop berbasis Java Swing (GUI)

Mengelola data menggunakan file handling berbasis file teks

Menerapkan event handling, validasi input, dan exception handling

🧩 Deskripsi Sistem

Aplikasi Sistem Antrian Pesanan Café menyediakan fitur:

Input pesanan pelanggan

Pengelolaan status pesanan (Menunggu, Diproses, Selesai)

Perhitungan total harga pesanan

Penyimpanan riwayat transaksi ke file teks

Penampilan kembali data riwayat transaksi

🔄 Alur Sistem

Pengguna membuka Dashboard

Pengguna memilih menu:

Daftar Pesanan

Input Pesanan

Riwayat Transaksi

Data pesanan ditampilkan dalam tabel

Status pesanan dapat diperbarui

Data transaksi disimpan ke file riwayat_transaksi.txt

🛠️ Implementasi Teknis

Bahasa Pemrograman: Java

GUI: Java Swing

Layout: CardLayout

Manajemen Data: DefaultTableModel

File Handling: File teks (.txt)

API: Java Date & SimpleDateFormat

Exception Handling: try-catch (IOException)

Class Utama

CafeQueueApp
Berfungsi sebagai frame utama sekaligus pengendali seluruh alur aplikasi.

🧾 Implementasi CRUD

Create: Menambahkan pesanan baru

Read: Menampilkan daftar pesanan & riwayat transaksi

Update: Mengubah status pesanan

Delete: Menghapus atau mengurangi item pesanan

💾 Penyimpanan Data

Data riwayat transaksi disimpan secara permanen pada file:

riwayat_transaksi.txt


Data dipisahkan menggunakan tanda | agar mudah dibaca kembali.

⚠️ Exception Handling

Exception handling diterapkan untuk mencegah aplikasi crash saat terjadi error I/O pada proses baca dan tulis file.

✅ Hasil Code Review

Perbaikan yang dilakukan:

Penambahan validasi input nama pelanggan

Penambahan try-catch pada proses file handling

📷 Tampilan Aplikasi

Dashboard

Daftar Pesanan

Input Pesanan

Tabel Pesanan & Total Harga

Riwayat Transaksi

👩‍🎓 Identitas Pengembang

Nama: Dhea Ayu Angelia Putri
NIM: 202410370110182
Program Studi: Informatika
Fakultas: Teknik
Universitas: Universitas Muhammadiyah Malang
Tahun: 2025

📌 Kesimpulan

Aplikasi Sistem Antrian Pesanan Café berhasil dikembangkan dengan menerapkan OOP, CRUD, GUI Java Swing, file handling, API Java, serta exception handling. Aplikasi ini mampu membantu pengelolaan pesanan café secara lebih sistematis dan efisien.