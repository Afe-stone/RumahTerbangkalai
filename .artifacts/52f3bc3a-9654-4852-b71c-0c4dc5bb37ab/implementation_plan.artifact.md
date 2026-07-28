# Implementasi Save, Load, dan Continue

Dokumen ini menjelaskan rencana untuk menambahkan fitur simpan data (Save), muat data (Load), dan lanjut (Continue) menggunakan `SharedPreferences`.

## Perubahan Utama

### 1. Utilitas Penyimpanan (`SaveManager`)
Membuat kelas `SaveManager` untuk menangani operasi baca/tulis ke `SharedPreferences`.
- Menyimpan kunci node saat ini (`nodeKey`) dan indeks baris (`lineIndex`).
- Mengecek keberadaan data tersimpan.

### 2. Pembaruan `MainActivity`
- Menambahkan variabel `currentNodeKey` untuk melacak kunci node yang sedang aktif.
- Memperbarui fungsi `goToNode` agar bisa menerima parameter `lineIndex` opsional (berguna saat memuat game).
- Mengimplementasikan fungsi pada tombol **Save** dan **Load** di menu jeda (Pause Menu).
- Menangani data kiriman (Intent extras) dari menu utama untuk memulai game dari posisi tertentu.

### 3. Pembaruan `MenuActivity`
- Mengecek keberadaan save data saat aplikasi dibuka.
- Mengaktifkan/menonaktifkan tombol **Continue** berdasarkan status save data.
- Mengimplementasikan logika tombol **Continue** dan **Load** untuk berpindah ke `MainActivity` dengan status yang tersimpan.

## Rencana Aksi

### [NEW] [SaveManager.kt](file:///C:/Users/Lenovo/StudioProjects/RumahTerbangkalai/app/src/main/java/com/example/rumahterbangkalai/util/SaveManager.kt)
Membuat file baru di paket `util`.

### [MODIFY] [MainActivity.kt](file:///C:/Users/Lenovo/StudioProjects/RumahTerbangkalai/app/src/main/java/com/example/rumahterbangkalai/view/MainActivity.kt)
- Tambah `currentNodeKey`.
- Update `goToNode(key: String, lineIndex: Int = 0)`.
- Hubungkan tombol **Save** dan **Load** ke `SaveManager`.
- Di `onCreate`, cek apakah ada Intent extra untuk memuat posisi tertentu.

### [MODIFY] [MenuActivity.kt](file:///C:/Users/Lenovo/StudioProjects/RumahTerbangkalai/app/src/main/java/com/example/rumahterbangkalai/view/MenuActivity.kt)
- Update `onResume` untuk mengecek status save dan update tombol **Continue**.
- Hubungkan tombol **Continue** dan **Load** (sementara keduanya memuat save yang sama).

## Verifikasi
- Memulai game baru.
- Bermain sampai node tertentu.
- Klik Save di Pause Menu.
- Keluar ke Main Menu.
- Klik Continue dan pastikan kembali ke posisi terakhir (node dan baris teks yang sama).
- Klik Load di Pause Menu saat sedang bermain untuk memastikan data dimuat ulang.
