# Menambahkan Backsound (Musik Latar)

Rencana ini akan mengaktifkan `MusicService` yang telah kita perbaiki sebelumnya agar musik latar mulai dimainkan saat aplikasi dibuka.

## Perubahan yang Diusulkan

### [MainActivity](file:///C:/Users/Lenovo/StudioProjects/RumahTerbangkalai/app/src/main/java/com/example/rumahterbangkalai/MainActivity.kt)

#### [MODIFY] [MainActivity.kt](file:///C:/Users/Lenovo/StudioProjects/RumahTerbangkalai/app/src/main/java/com/example/rumahterbangkalai/MainActivity.kt)
- Menambahkan import `android.content.Intent`.
- Menjalankan `MusicService` menggunakan `startService()` di dalam `onCreate`.
- Menghentikan `MusicService` menggunakan `stopService()` di dalam `onDestroy` agar musik berhenti saat aplikasi benar-benar ditutup.
- Menghapus pemanggilan `setContentView` ganda yang tidak sengaja ada di `onCreate`.

## Langkah Verifikasi

### Verifikasi Manual
1. Jalankan aplikasi di emulator atau perangkat.
2. Pastikan musik latar (`backsound.mp3`) mulai diputar saat aplikasi masuk ke layar utama.
3. Pastikan musik berhenti saat aplikasi ditutup/dihancurkan.
