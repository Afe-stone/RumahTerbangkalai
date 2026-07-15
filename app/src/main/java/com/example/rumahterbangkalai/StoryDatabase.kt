package com.example.rumahterbengkalai // Sesuaikan dengan package name proyek Anda

val storyMap = mapOf(
    "intro" to StoryNode(
        label = "Prolog", depth = 0,
        lines = listOf(
            "Pada suatu hari, empat orang siswa — Asko, Raffa, Abhi, dan Chiquita — mendapat tugas membuat sebuah project. Mereka berkumpul untuk berdiskusi.",
            "Asko punya ide: melakukan penelitian di sebuah rumah terbengkalai. Yang lain setuju.",
            "Malam itu juga mereka berangkat menuju rumah tua di pinggir kota. Dari luar, rumah itu tampak megah dan normal. Tapi di dalamnya, tersimpan banyak misteri.",
            "Saat mencoba membuka pagar, mereka kesulitan — gembok besi tua itu berkarat dan keras kepala.",
            "Abhi menatap dua benda di dekat kakinya. Di belakangnya, ketiga temannya menunggu dengan cemas. Angin malam berembus dingin, membawa bau tanah basah yang pekat.",
            "\"Cepat, Abhi! Rasanya ada yang memperhatikan kita dari jendela atas,\" bisik Chiquita sambil merapatkan jaketnya.",
            "Raffa mengangguk setuju, wajahnya pucat di bawah temaram sinar bulan.",
            "Abhi harus memilih alat untuk mencongkel gembok pagar besi itu."
        ),
        choices = listOf(
            Choice("Menghantam gembok dengan BATU", "batu"),
            Choice("Mencongkel celah pagar dengan KAYU", "kayu")
        ),
        backgroundColor = "#191C22"
    ),
    "batu" to StoryNode(
        label = "Jalan Batu", depth = 1,
        lines = listOf(
            "Abhi mengambil batu besar yang berat itu. Dengan sekuat tenaga, ia menghantamkannya ke gembok pagar.",
            "KRAKK! Suara benturan besi dan batu menggema keras, membelah kesunyian malam.",
            "Pagar akhirnya terbuka — namun suara bising itu memicu sesuatu di dalam rumah.",
            "Pintu utama tiba-tiba terbuka sendiri dengan derit yang memilukan.",
            "\"Kurasa kita tidak diundang, tapi jalannya sudah terbuka,\" gurau Raffa mencoba mencairkan suasana, meski suaranya bergetar.",
            "Mereka berempat melangkah masuk ke ruang tamu yang berdebu.",
            "Tiba-tiba, pintu di belakang mereka tertutup rapat dan terkunci otomatis!",
            "Di tengah kegelapan, terdengar suara langkah kaki berat dari lantai dua, berjalan mendekat ke arah tangga."
        ),
        choices = listOf(
            Choice("Bersembunyi di bawah meja ruang tamu", "ending1"),
            Choice("Berlari naik ke lantai dua mencari jalan keluar", "ending2")
        ),
        backgroundColor = "#22140F"
    ),
    "kayu" to StoryNode(
        label = "Jalan Kayu", depth = 1,
        lines = listOf(
            "Abhi memilih kayu yang kuat. Dengan hati-hati, ia menyelipkannya ke celah rantai pagar dan menekan sekuat tenaga menggunakan prinsip tuas.",
            "Sreeet... Cklek! Rantai pengikat pagar melorot tanpa menimbulkan suara bising. Pagar pun terbuka perlahan.",
            "\"Kerja bagus, Abhi. Setidaknya kita tidak mengundang perhatian,\" puji Asko lega.",
            "Mereka menyelinap masuk melewati halaman yang rimbun oleh ilalang.",
            "Di teras, Chiquita menemukan sebuah kunci kuno tergeletak di atas keset. Kunci itu terbuka dengan mulus di pintu utama.",
            "Di dalam, udara terasa sangat dingin. Ada dua lorong: lorong kiri yang gelap gulita menuju dapur, dan lorong kanan yang diterangi cahaya lilin samar menuju perpustakaan tua."
        ),
        choices = listOf(
            Choice("Menyelidiki lorong kiri yang gelap (Dapur)", "ending3"),
            Choice("Mengikuti cahaya lilin ke lorong kanan (Perpustakaan)", "ending4")
        ),
        backgroundColor = "#14181A"
    ),
    "ending1" to StoryNode(
        label = "Ending — Meja Ruang Tamu", depth = 2, isEnding = true,
        lines = listOf(
            "Mereka meringkuk di bawah meja kayu yang besar. Langkah kaki itu berhenti tepat di depan meja.",
            "Chiquita menutup mulutnya rapat-rapat agar tangisnya tidak terdengar.",
            "Tiba-tiba, dari sela-sela taplak meja yang robek, sebuah wajah pucat tanpa mata menjenguk ke bawah sambil tersenyum lebar.",
            "Cahaya senter mereka mati total.",
            "Malam itu menjadi malam terakhir bagi proyek sekolah mereka yang tak pernah selesai."
        ),
        backgroundColor = "#200C0C"
    ),
    "ending2" to StoryNode(
        label = "Ending — Balkon Lantai Dua", depth = 2, isEnding = true,
        lines = listOf(
            "Mereka nekat berlari menaiki tangga kayu yang berderit. Sesampainya di lantai dua, mereka menemukan sebuah balkon menghadap halaman luar.",
            "Raffa mencoba berteriak minta tolong — namun saat mereka berbalik, sosok bayangan hitam tinggi besar sudah berdiri menghalangi jalan kembali.",
            "Dengan panik, mereka terpaksa melompat dari balkon ke tumpukan semak di bawah.",
            "Mereka berhasil selamat dengan luka-luka ringan, lalu berlari sekencang mungkin meninggalkan rumah itu dan bersumpah tidak akan pernah kembali lagi."
        ),
        backgroundColor = "#10151C"
    ),
    "ending3" to StoryNode(
        label = "Ending — Dapur", depth = 2, isEnding = true,
        lines = listOf(
            "Menggunakan senter ponsel, mereka berjalan ke area dapur. Di sana, mereka menemukan sebuah buku harian tua milik pemilik rumah terdahulu — berisi catatan riset tentang sejarah mistis kota mereka.",
            "Asko kegirangan mendapat bahan project yang luar biasa.",
            "Tiba-tiba, bayangan putih melintas cepat di belakang Raffa.",
            "Sadar nyawa mereka terancam, mereka segera mengambil buku itu dan keluar lewat pintu belakang dapur yang ternyata tidak terkunci.",
            "Project mereka sukses besar — meski mereka harus mengalami trauma seumur hidup."
        ),
        backgroundColor = "#1B1508"
    ),
    "ending4" to StoryNode(
        label = "Ending — Perpustakaan", depth = 2, isEnding = true,
        lines = listOf(
            "Mereka melangkah menuju perpustakaan yang hangat oleh cahaya lilin. Di tengah ruangan, ada sebuah meja bundar dengan cermin besar di atasnya.",
            "Saat Chiquita mendekati cermin, ia berteriak histeris.",
            "Pantulan di cermin tidak menunjukkan wajah mereka berempat — melainkan sosok makhluk mengerikan yang berdiri tepat di belakang mereka.",
            "Sebelum mereka sempat berbalik, lilin-lilin mati seketika.",
            "Mereka terbangun keesokan harinya di tengah halaman rumah, tanpa ingatan sedikit pun tentang apa yang terjadi di dalam."
        ),
        backgroundColor = "#1A1420"
    )
)