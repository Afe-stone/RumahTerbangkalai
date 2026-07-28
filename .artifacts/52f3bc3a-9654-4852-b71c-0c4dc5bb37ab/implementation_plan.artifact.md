# Implementasi Pemisahan Nama Karakter dan Dialog

Rencana ini bertujuan untuk memindahkan nama karakter yang sedang berbicara ke area `tvSpeaker` (posisi narator) dan menampilkan dialognya saja di area `tvLine`. Jika tidak ada karakter yang berbicara (narasi), area nama akan dikosongkan.

## Perubahan yang Diusulkan

### [MainActivity](file:///C:/Users/Lenovo/StudioProjects/RumahTerbangkalai/app/src/main/java/com/example/rumahterbangkalai/view/MainActivity.kt)

#### [MODIFY] [MainActivity.kt](file:///C:/Users/Lenovo/StudioProjects/RumahTerbangkalai/app/src/main/java/com/example/rumahterbangkalai/view/MainActivity.kt)
- Memperbarui `goToNode`: Menghapus pengaturan teks `tvSpeaker` default karena sekarang akan diatur per baris.
- Memperbarui `displayCurrentLine`:
    - Mengambil baris teks mentah.
    - Melakukan penggantian nama dinamis `Kamu` menjadi `playerName`.
    - Menggunakan logika parsing untuk memisahkan nama pembicara:
        - Jika baris diawali dengan `Nama:`, maka `tvSpeaker` menampilkan `Nama` dan `tvLine` menampilkan sisa teksnya.
        - Jika baris tidak memiliki format `:` (seperti narasi dalam kurung), maka `tvSpeaker` dikosongkan dan `tvLine` menampilkan seluruh teks.
    - Menangani karakter khusus seperti tanda kutip agar tampilan lebih bersih jika diperlukan.

## Rencana Aksi

### 1. Riset Regex Parsing
Memastikan regex yang digunakan dapat menangani format:
- `Nama: "Dialog"`
- `Nama: (Aksi) "Dialog"`
- `(Narasi/Aksi)`

### 2. Modifikasi `MainActivity.kt`
- Ubah `displayCurrentLine` untuk menerapkan logika pemisahan.
- Bersihkan `tvSpeaker` di `goToNode`.

## Verifikasi
1. Jalankan aplikasi.
2. Periksa dialog awal: `Asko` harus muncul di atas kotak dialog, dan teksnya muncul di bawah tanpa `Asko:`.
3. Periksa dialog `Kamu`: Harus muncul nama pemain di atas.
4. Periksa narasi (dalam kurung): Area nama di atas harus kosong.
