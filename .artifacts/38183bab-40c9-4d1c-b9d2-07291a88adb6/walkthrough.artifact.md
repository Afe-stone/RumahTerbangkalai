# Walkthrough - Implementasi Backsound

Saya telah mengaktifkan musik latar di aplikasi dengan menghubungkan `MainActivity` ke `MusicService`.

## Perubahan Utama

### 1. Memulai Musik Latar
Di `MainActivity.kt`, saya menambahkan kode untuk memulai `MusicService` segera setelah aplikasi dibuka.
```kotlin
// Di dalam onCreate
startService(Intent(this, MusicService::class.java))
```

### 2. Menghentikan Musik Latar
Musik akan berhenti secara otomatis saat aplikasi dihancurkan (`onDestroy`) untuk menghemat baterai dan memori.
```kotlin
override fun onDestroy() {
    super.onDestroy()
    stopService(Intent(this, MusicService::class.java))
}
```

### 3. Pembersihan Kode
Menghapus pemanggilan `setContentView` ganda dan memastikan `enableEdgeToEdge()` dipanggil di urutan yang benar.

## Hasil Verifikasi
- File `MainActivity.kt` telah diperiksa dan tidak memiliki error yang menghalangi build.
- `MusicService` telah terdaftar di `AndroidManifest.xml` (dilakukan di langkah sebelumnya).

> [!TIP]
> Pastikan file `backsound.mp3` ada di folder `res/raw/` agar tidak terjadi error saat runtime.
