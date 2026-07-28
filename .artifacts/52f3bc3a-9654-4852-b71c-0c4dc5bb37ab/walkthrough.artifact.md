# Walkthrough - Pemisahan Nama Karakter dan Dialog

Saya telah memperbarui antarmuka dialog agar nama karakter yang berbicara muncul di area khusus di atas baris dialog, sementara narasi tetap bersih tanpa nama di atasnya.

## Perubahan yang Dilakukan

### 1. Pemisahan Visual Nama dan Dialog
[MainActivity.kt](file:///C:/Users/Lenovo/StudioProjects/RumahTerbangkalai/app/src/main/java/com/example/rumahterbangkalai/view/MainActivity.kt)
- **Parsing Cerdas**: Sistem sekarang secara otomatis memisahkan nama pembicara dari teks dialog dengan mencari tanda titik dua (`:`).
- **Speaker Area**: Jika karakter berbicara (misal: `Asko:`), nama "Asko" akan ditampilkan di label merah (`tvSpeaker`) di atas teks utama.
- **Narration Mode**: Jika baris teks adalah narasi (tanpa tanda titik dua), label pembicara akan dikosongkan secara otomatis sesuai permintaan.
- **Pembersihan Teks**: Teks dialog dibersihkan dari spasi berlebih dan tanda kutip pembungkus yang tidak perlu agar tampilan lebih rapi.

### 2. Integrasi Nama Dinamis
Sistem pemisahan ini bekerja secara harmonis dengan fitur nama pemain dinamis. Nama yang Anda masukkan di awal permainan akan dikenali sebagai pembicara dan diposisikan dengan benar di area nama.

## Hasil Verifikasi
- **Dialog Karakter**: Nama karakter (Asko, Raffa, dsb.) muncul di atas kotak dialog.
- **Dialog Pemain**: Nama pemain muncul di atas saat pemain berbicara.
- **Narasi**: Saat teks narasi muncul (misal: deskripsi suasana dalam kurung), area nama di atas kosong.
- **Typing Effect**: Animasi pengetikan tetap berjalan lancar pada teks dialog yang telah dipisahkan.

## Contoh Tampilan
- **Input**: `Asko: "Ide bagus!"`
  - Atas: `Asko`
  - Bawah: `Ide bagus!`
- **Input**: `(Angin berhembus dingin)`
  - Atas: (Kosong)
  - Bawah: `(Angin berhembus dingin)`

> [!TIP]
> Perubahan ini membuat teks dialog jauh lebih mudah dibaca dan memberikan kesan novel visual yang lebih profesional!
