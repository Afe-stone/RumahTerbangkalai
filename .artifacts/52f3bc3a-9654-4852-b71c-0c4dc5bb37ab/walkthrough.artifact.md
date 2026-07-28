# Walkthrough - Implementasi Fitur Save, Load, dan Continue

Saya telah berhasil mengimplementasikan sistem penyimpanan data untuk game "Rumah Terbangkalai". Pemain sekarang dapat menyimpan progres mereka dan melanjutkannya nanti.

## Fitur yang Ditambahkan

### 1. `SaveManager`
Kelas utilitas baru yang menangani penyimpanan status game ke `SharedPreferences`.
- Menyimpan kunci node cerita saat ini.
- Menyimpan indeks baris teks terakhir yang dibaca.

### 2. Menu Jeda (Pause Menu)
Tombol **Save** dan **Load** di dalam game sekarang sudah berfungsi:
- **Save**: Menyimpan posisi saat ini (node dan baris teks).
- **Load**: Memuat kembali data yang tersimpan secara instan tanpa harus keluar ke menu utama.

### 3. Menu Utama (Main Menu)
- **Continue**: Tombol ini akan otomatis aktif jika ada data permainan yang tersimpan. Klik tombol ini untuk langsung masuk ke posisi terakhir Anda.
- **Load**: Berfungsi sama seperti Continue untuk memuat data tersimpan.
- Tombol Continue akan terlihat sedikit transparan (setengah pudar) jika tidak ada data save yang tersedia.

## Teknis Implementasi
- Menggunakan `SharedPreferences` untuk persistensi data yang ringan.
- Komunikasi antar Activity menggunakan `Intent` extras (`LOAD_NODE` dan `LOAD_INDEX`).
- Sinkronisasi status tombol di `onResume` pada `MenuActivity` untuk memastikan tampilan selalu akurat setelah kembali dari permainan.

## Cara Mencoba
1. Jalankan aplikasi dan pilih **New Game**.
2. Mainkan beberapa baris teks atau pilih salah satu jalur.
3. Klik tombol **Pause** (atau tombol Back) lalu klik **Save**.
4. Kembali ke **Main Menu**.
5. Tombol **Continue** sekarang seharusnya aktif. Klik untuk melanjutkan dari posisi yang Anda simpan tadi.

> [!NOTE]
> Progress yang disimpan mencakup baris teks spesifik yang sedang Anda baca, sehingga Anda tidak akan kehilangan jejak dialog terakhir.
