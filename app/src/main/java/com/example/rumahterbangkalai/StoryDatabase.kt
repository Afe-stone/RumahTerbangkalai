package com.example.rumahterbengkalai

import com.example.rumahterbangkalai.R

val storyMap = mapOf(
    "intro" to StoryNode(
        label = "Misteri Rumah Terbengkalai - Project Sekolah", depth = 0,
        lines = listOf(
            "Asko: \"Gini, guys. Biar project sekolah kita beda dari kelompok lain, gimana kalau kita bikin penelitian di rumah tua terbengkalai yang ada di pinggir kota?\"",
            "Raffa: \"Rumah tua yang megah itu? Wah, ide gila sih, tapi keren!\"",
            "Abhi: \"Aku setuju. Pasti banyak hal menarik di sana.\"",
            "Chiquita: \"Aku ikut kalian aja deh, asal rame-rame.\"",
            "Kamu: \"Oke, deal ya. Nanti malam kita berkumpul di sana.\"",
            "(Malam harinya, kalian berlima berdiri di depan pagar besi tua yang terkunci rapat. Angin malam berhembus dingin membawa bau tanah basah).",
            "Chiquita: (Berbisik gemetar sambil merapatkan jaket) \"Cepat! Rasanya ada yang memperhatikan kita dari jendela atas...\"",
            "Abhi: (Menatap dua benda di dekat kakinya) \"Aduh, gemboknya karatan banget. Pakai apa ya buat membuka gemboknya?\""
        ),
        choices = listOf(
            Choice("Bhi, pakai BATU besar itu aja! Hantam gemboknya sekencang mungkin!", "batu"),
            Choice("Jangan bikin bising. Pakai KAYU itu, selipkan ke celah rantai terus dorong pakai prinsip tuas!", "kayu")
        ),
        backgroundRes = R.drawable.bg1fr
    ),
    "batu" to StoryNode(
        label = "Jalur Batu (Suara Bising)", depth = 1,
        lines = listOf(
            "(KRAKK! Suara benturan besi dan batu menggema keras. Pagar terbuka, tetapi pintu utama rumah tiba-tiba terbuka sendiri dengan derit memilukan!)",
            "Raffa: (Suara bergetar) \"Kurasa kita tidak diundang, tapi jalannya sudah terbuka...\"",
            "(Kalian melangkah masuk ke ruang tamu yang berdebu.)",
            "(BAM! Pintu belakang tertutup rapat dan terkunci otomatis. Dari lantai dua, terdengar suara langkah kaki berat mendekat).",
            "Chiquita: \"G-gimana ini?! Langkah kakinya mendekat!\""
        ),
        choices = listOf(
            Choice("Cepat semuanya, kita bersembunyi di bawah meja besar itu!", "meja"),
            Choice("Jangan cuma diam di sini! Lari naik ke lantai dua, cari jalan keluar lain!", "lantai_dua"),
            Choice("Awas! Aku bakal mendobrak pintu samping ini duluan!", "pintu_samping")
        ),
        backgroundColor = "#22140F"
    ),
    "kayu" to StoryNode(
        label = "Jalur Kayu (Senyap)", depth = 1,
        lines = listOf(
            "(Sreeet... Cklek! Rantai melorot tanpa suara bising).",
            "Asko: \"Kerja bagus. Setidaknya kita tidak mengundang perhatian.\"",
            "(Kalian menyelinap melewati halaman rimbun)",
            "(Di teras, Chiquita menemukan kunci kuno di atas keset)",
            "(Raffa menggunakannya untuk membuka pintu utama dengan mulus. Di dalam, ada dua lorong. Lorong kiri gelap ke dapur, Lorong kanan diterangi cahaya lilin ke perpustakaan).",
            "Asko: \"Ada dua jalur nih. Mau lewat mana?\""
        ),
        choices = listOf(
            Choice("Ayo kita telusuri Lorong Kiri (Dapur) yang gelap itu!", "dapur"),
            Choice("Lebih baik ikuti cahaya lilin ke Lorong Kanan (Perpustakaan)!", "perpustakaan"),
            Choice("Biar cepat selesai, kita bagi kelompok jadi dua aja!", "bagi_kelompok")
        ),
        backgroundColor = "#14181A"
    ),
    "meja" to StoryNode(
        label = "Terjebak di Bawah Meja", depth = 2,
        lines = listOf(
            "(Kalian meringkuk di bawah meja kayu)",
            "(Langkah kaki berhenti tepat di depan meja)",
            "(Dari sela taplak meja yang robek, muncul wajah pucat tanpa mata menjenguk ke bawah sambil tersenyum lebar! Senter mati total).",
            "Chiquita: (Menangis tanpa suara) \"Mmmph...\""
        ),
        choices = listOf(
            Choice("Rasakan ini! (Melempar tas sekolah ke wajah itu) Semua lari ke jendela sekarang!", "perlawanan_meja"),
            Choice("Raffa, Abhi, tahan dia! (Mendorong Raffa dan Abhi ke depan)", "pengorbanan_teman"),
            Choice("(Terpaku diam ketakutan setengah mati).", "ending1")
        ),
        backgroundColor = "#1A1A1A"
    ),
    "lantai_dua" to StoryNode(
        label = "Menuju Lantai Dua", depth = 2,
        lines = listOf(
            "(Kalian berlari menaiki tangga kayu yang berderit hingga sampai di balkon lantai dua)",
            "(Saat berbalik, sosok bayangan hitam tinggi besar sudah berdiri menghalangi jalan).",
            "Raffa: \"Tolooong!! Kita terkepung!\""
        ),
        choices = listOf(
            Choice("Semua pegangan tangan! Hitungan ketiga kita melompat bersama ke semak-semak!", "lompatan_bersama"),
            Choice("Maaf guys, aku duluan! (Melompat sendirian)", "lompat_sendiri"),
            Choice("Ambil kayu ini! Kita serang bayangan itu bersama-sama!", "ending4")
        ),
        backgroundColor = "#10151C"
    ),
    "pintu_samping" to StoryNode(
        label = "Panik dan Kabur Sendirian", depth = 2,
        lines = listOf(
            "(Kamu berhasil mendobrak pintu samping kayu yang rapuh dan keluar ke halaman samping, meninggalkan teman-temanmu di dalam).",
            "Chiquita: (Dari dalam) \"Tolong! Jangan tinggalkan kami!!\"",
            "Abhi: (Dari dalam) \"Buka pintunya dari luar!!\""
        ),
        choices = listOf(
            Choice("Aduh, aku bersalah banget... Aku harus cari cara buka pintu ini dari luar!", "kembali_menolong"),
            Choice("Maafkan aku, aku harus selamat! (Kabur)", "ending5")
        ),
        backgroundColor = "#1C1C1C"
    ),
    "dapur" to StoryNode(
        label = "Area Dapur", depth = 2,
        lines = listOf(
            "(Di dapur, kalian menemukan buku harian tua tentang sejarah mistis kota).",
            "Asko: \"Lihat! Ini bahan project yang sangat luar biasa!\"",
            "(Tiba-tiba bayangan putih melintas di belakang Raffa dan pintu dapur terkunci rapat).",
            "Raffa: \"S-sepertinya ada sesuatu di belakangku... Pintunya terkunci!\""
        ),
        choices = listOf(
            Choice("Asko, pegang bukunya! Aku ambil linggis buat mendobrak pintu belakang!", "dobrak_dapur"),
            Choice("Asko, lempar buku itu ke bayangan putih biar perhatiannya teralih!", "ending7"),
            Choice("Chiquita, ikut aku lewat jendela kecil dapur! Yang lain cari jalan sendiri!", "ending8")
        ),
        backgroundColor = "#1B1508"
    ),
    "perpustakaan" to StoryNode(
        label = "Area Perpustakaan", depth = 2,
        lines = listOf(
            "(Kalian masuk ke perpustakaan dengan cermin besar di tengah ruangan)",
            "(Saat Chiquita mendekat, cermin menampilkan sosok makhluk mengerikan di belakang kalian).",
            "Chiquita: (Berteriak histeris) \"Aaaaaaaaa! Di belakang kita!\"",
            "(Lilin-lilin mulai padam satu per satu)."
        ),
        choices = listOf(
            Choice("Hancurkan cerminnya! (Mengangkat kursi lalu menghantam cermin).", "hancurkan_cermin"),
            Choice("Tunggu, di meja ada tulisan mantra! Aku bakal baca mantranya!", "ending10"),
            Choice("Dorong Chiquita dan Asko (Menjadikan mereka tameng untuk keluar).", "tameng_hidup")
        ),
        backgroundColor = "#1A1420"
    ),
    "bagi_kelompok" to StoryNode(
        label = "Membagi Kelompok", depth = 2,
        lines = listOf(
            "(Kamu, Asko, Chiquita ke Lorong Kanan. Raffa dan Abhi ke Lorong Kiri. Beberapa menit kemudian...)",
            "Raffa & Abhi: (Berteriak histeris dari lorong kiri) \"TOLOOONG! ADA MAKHLUK HITAM!!\""
        ),
        choices = listOf(
            Choice("Asko, Chiquita! Raffa dan Abhi dalam bahaya, ayo tolong mereka!", "penyelamatan_lorong_kiri"),
            Choice("Biarkan saja, kita fokus cari dokumen project di perpustakaan ini.", "ending12"),
            Choice("Tempat ini nggak aman, aku lari duluan ke pintu keluar!", "ending13")
        ),
        backgroundColor = "#111111"
    ),
    "perlawanan_meja" to StoryNode(
        label = "Perlawanan Meja", depth = 3,
        lines = listOf(
            "(Tasmu mengenai makhluk itu hingga ia mengerang. Kamu berhasil membanting jendela kayu hingga terbuka).",
            "Kamu: \"Jendelanya terbuka! Ayo cepat keluar!\""
        ),
        choices = listOf(
            Choice("Asko, Raffa, Abhi, Chiquita, kalian keluar duluan! Aku yang terakhir!", "ending2"),
            Choice("Waktu mendesak! Aku lompat duluan, Chiquita dan Raffa cepat ikuti aku!", "ending3")
        ),
        backgroundColor = "#1A1A1A"
    ),
    "pengorbanan_teman" to StoryNode(
        label = "Pengorbanan Teman", depth = 3,
        lines = listOf(
            "(Raffa dan Abhi tertangkap. Jeritan mereka bergema saat Kamu, Asko, dan Chiquita berhasil mendobrak pintu samping).",
            "Chiquita: (Gemetar hebat) \"Raffa... Abhi... Gimana nasib mereka?!\""
        ),
        choices = listOf(
            Choice("Jangan tengok ke belakang!", "ending6"),
            Choice("Tunggu, aku salah langkah! Chiquita, Asko, kalian masuk lagi tolong mereka!", "ending9")
        ),
        backgroundColor = "#200C0C"
    ),
    "lompatan_bersama" to StoryNode(
        label = "Lompatan Bersama", depth = 3,
        lines = listOf(
            "(Kalian berlima melompat dari balkon dan mendarat di tumpukan semak tebal).",
            "Asko: \"Aduh... Semuanya aman?\""
        ),
        choices = listOf(
            Choice("Ayo periksa kondisi masing-masing, habis itu kita lari!", "ending2"),
            Choice("(Chiquita terkilir parah) Abhi, bantu aku bopong Chiquita!", "ending14")
        ),
        backgroundColor = "#10151C"
    ),
    "lompat_sendiri" to StoryNode(
        label = "Lompat Sendiri", depth = 3,
        lines = listOf(
            "(Kamu mendarat di semak-semak. Di atas balkon, Asko, Raffa, Abhi, dan Chiquita dikepung sosok hitam).",
            "Raffa: (Dari atas balkon) \"Tolong kami!!\""
        ),
        choices = listOf(
            Choice("HOI! MAKHLUK JELEK! KEJAR AKU DI SINI!!", "ending15"),
            Choice("(Lari sekencang mungkin menuju jalan raya).", "ending5")
        ),
        backgroundColor = "#10151C"
    ),
    "kembali_menolong" to StoryNode(
        label = "Kembali Menolong", depth = 3,
        lines = listOf(
            "(Kamu menemukan kunci cadangan di balik pot bunga dan membuka pintu dari luar).",
            "Kamu: \"SEMUANYA KELUAR! PINTUNYA SUDAH KUBUKA!\""
        ),
        choices = listOf(
            Choice("Semua keluar!", "ending2"),
            Choice("Hanya Raffa dan Chiquita yang mendengar sebelum pintu tertutup lagi.", "ending3")
        ),
        backgroundColor = "#1C1C1C"
    ),
    "dobrak_dapur" to StoryNode(
        label = "Dobrak Pintu Dapur", depth = 3,
        lines = listOf(
            "(Pintu belakang jebol dihantam linggis, cahaya bulan merembes masuk).",
            "Kamu: \"Kalian semua keluar duluan! Asko, amankan buku harian itu!\""
        ),
        choices = listOf(
            Choice("Keluar bersama!", "ending16"),
            Choice("Sini bukunya! (Merebut buku dari Asko lalu lari mendahului).", "ending17")
        ),
        backgroundColor = "#1B1508"
    ),
    "hancurkan_cermin" to StoryNode(
        label = "Hancurkan Cermin", depth = 3,
        lines = listOf(
            "(PRANG!! Cermin pecah berantakan)",
            "(Makhluk di dalamnya menjerit melengking dan ilusi menghilang. Pintu perpustakaan terbuka).",
            "Kamu: \"Bagus! Semua anggota kelompok, lari keluar rumah sekarang juga!\""
        ),
        choices = listOf(
            Choice("Lari keluar!", "ending2"),
            Choice("Tunggu! Ambil sisa dokumen kuno di bawah cermin ini baru lari!", "ending18")
        ),
        backgroundColor = "#1A1420"
    ),
    "tameng_hidup" to StoryNode(
        label = "Tameng Hidup", depth = 3,
        lines = listOf(
            "(Kamu mendorong Asko dan Chiquita hingga terjatuh menghalangi makhluk itu)",
            "(Kamu, Abhi, dan Raffa lolos dari perpustakaan).",
            "Raffa: \"Asko sama Chiquita gimana?!\""
        ),
        choices = listOf(
            Choice("Nggak ada waktu! Kita lari keluar rumah sekarang!", "ending19"),
            Choice("(Kabur sendirian dan meninggalkan Raffa dan Abhi).", "ending5")
        ),
        backgroundColor = "#1A1420"
    ),
    "penyelamatan_lorong_kiri" to StoryNode(
        label = "Penyelamatan Lorong Kiri", depth = 3,
        lines = listOf(
            "(Kamu, Asko, dan Chiquita tiba di dapur. Raffa dan Abhi terpojok. Kamu mengayunkan senter berat ke arah bayangan hitam).",
            "Kamu: \"Bikin barikade pakai meja ini! Semua ikut aku keluar lewat pintu service dapur!\""
        ),
        choices = listOf(
            Choice("Keluar bersama!", "ending2"),
            Choice("Abhi, Raffa, tarik tanganku! (Asko dan Chiquita tertinggal).", "ending20")
        ),
        backgroundColor = "#1B1508"
    ),
    "ending1" to StoryNode(
        label = "ENDING 1 (Terjebak dalam Gelap)", depth = 4, isEnding = true,
        lines = listOf(
            "Senter: (Mati total)",
            "Chiquita: \"T-tolong...\"",
            "(Kalian semua melipat diri di bawah meja. Senter mati total, dan kalian berlima menjadi korban penghuni rumah. Tak ada yang selamat, project sekolah tak pernah selesai)."
        ),
        backgroundColor = "#200C0C"
    ),
    "ending2" to StoryNode(
        label = "ENDING 2 (Penyelamatan Sempurna)", depth = 4, isEnding = true,
        lines = listOf(
            "Asko: \"Kita... kita berhasil keluar?!\"",
            "Raffa: \"Iya! Berkat keberanianmu!\"",
            "Kamu: \"Ayo kita pulang sekarang dan janji nggak akan pernah balik ke sini lagi.\"",
            "(Berkat kepemimpinan dan keberanianmu, Kamu, Asko, Raffa, Abhi, dan Chiquita berhasil selamat tanpa luka berarti. Meskipun shock, kalian berlima pulang bersama dan bersumpah tidak akan kembali)."
        ),
        backgroundColor = "#0C2010"
    ),
    "ending3" to StoryNode(
        label = "ENDING 3 (Penyelamatan Sebagian)", depth = 4, isEnding = true,
        lines = listOf(
            "Raffa: \"Gimana dengan Asko dan Abhi?!\"",
            "Kamu: \"Pintunya terkunci rapat dari dalam... kita harus cari bantuan.\"",
            "(Kamu, Chiquita, dan Raffa berhasil selamat, tetapi Asko dan Abhi tertinggal di dalam rumah yang terkunci rapat. Polisi yang menyisir lokasi keesokan harinya tidak menemukan keberadaan Asko dan Abhi)."
        ),
        backgroundColor = "#151515"
    ),
    "ending4" to StoryNode(
        label = "ENDING 4 (Terjebak di Balkon)", depth = 4, isEnding = true,
        lines = listOf(
            "Abhi: \"Serangan kita nggak berpengaruh ke dia!\"",
            "Sosok Hitam: (Menghempas kalian hingga jatuh)",
            "(Keputusan melawan bayangan hitam gagal total. Kalian berlima terlempar dari balkon dan terperangkap dalam ilusi rumah tua selamanya)."
        ),
        backgroundColor = "#200C0C"
    ),
    "ending5" to StoryNode(
        label = "ENDING 5 (Egois Murni)", depth = 4, isEnding = true,
        lines = listOf(
            "Kamu: (Napas terengah-engah di atas motor) \"Maafkan aku...\"",
            "(Hanya Kamu yang selamat. Kamu lari menggunakan kendaraan dan meninggalkan keempat temanmu. Keesokannya, Asko, Raffa, Abhi, dan Chiquita dinyatakan hilang misterius. Kamu hidup dalam kebohongan dan ketakutan seumur hidup)."
        ),
        backgroundColor = "#200C0C"
    ),
    "ending6" to StoryNode(
        label = "ENDING 6 (Penyesalan Seumur Hidup)", depth = 4, isEnding = true,
        lines = listOf(
            "Chiquita: (Menangis histeris) \"Kamu jahat! Kamu mengorbankan Raffa dan Abhi demi keselamatan kita!\"",
            "Asko: \"Aku nggak sanggup berteman sama kamu lagi...\"",
            "(Kamu, Chiquita, dan Asko selamat, tetapi mengorbankan Raffa dan Abhi. Chiquita dan Asko mengalami trauma berat dan membencimu karena Kamu mengorbankan teman-teman demi keselamatan kalian)."
        ),
        backgroundColor = "#151515"
    ),
    "ending7" to StoryNode(
        label = "ENDING 7 (Lautan Api)", depth = 4, isEnding = true,
        lines = listOf(
            "Asko: \"Apinya menyambar ke dinding kayu!!\"",
            "Raffa: \"Asapnya terlalu pekat, aku nggak bisa bernapas!\"",
            "(Buku yang dilempar mengenai lilin tua dan membakar dapur. Rumah terbakar cepat. Kalian berlima panik dan tidak berhasil menemukan jalan keluar)."
        ),
        backgroundColor = "#401010"
    ),
    "ending8" to StoryNode(
        label = "ENDING 8 (Pengorbanan Dapur)", depth = 4, isEnding = true,
        lines = listOf(
            "Chiquita: (Melihat ke belakang saat dipeluk warga) \"Tapi... Asko, Raffa, sama Abhi masih di dalam dapur...\"",
            "(Kamu dan Chiquita melarikan diri lewat jendela kecil. Asko, Raffa, dan Abhi terjebak di dapur. Kamu dipuji sebagai penyelamat Chiquita, namun dibayangi rasa bersalah)."
        ),
        backgroundColor = "#151515"
    ),
    "ending9" to StoryNode(
        label = "ENDING 9 (Langkah Konyol)", depth = 4, isEnding = true,
        lines = listOf(
            "Asko: (Terjerat bayangan) \"Kenapa kamu nyuruh kami masuk lagi?!\"",
            "(Kamu menyuruh Chiquita dan Asko kembali masuk. Akibatnya, Chiquita dan Asko ikut tertangkap bersama Raffa dan Abhi. Hanya Kamu yang berhasil meloloskan diri kembali)."
        ),
        backgroundColor = "#200C0C"
    ),
    "ending10" to StoryNode(
        label = "ENDING 10 (Mantra Terlarang)", depth = 4, isEnding = true,
        lines = listOf(
            "Kamu: (Membaca tulisan asing) \"Ia... Ia... Shuggoth...\"",
            "Makhluk Cermin: (Bisikan memenuhi kepala kalian) \"Terima kasih telah memanggilku...\"",
            "(Mantra yang Kamu baca bukannya mengusir, malah memanggil entitas yang lebih kuat. Kalian berlima terhipnotis menjadi penghuni baru rumah tersebut)."
        ),
        backgroundColor = "#1A1420"
    ),
    "ending11" to StoryNode(
        label = "ENDING 11 (Hilang Ingatan)", depth = 4, isEnding = true,
        lines = listOf(
            "Guru: \"Mana file laporan penelitian rumah tua kalian?\"",
            "Abhi: \"Rumah tua? Laporan? Kita... kita kemarin ke mana ya?\"",
            "(Lilin mati seketika. Kalian berlima terbangun keesokan harinya di tengah halaman rumah tanpa ingatan sedikit pun tentang apa yang terjadi, dan file project di ponsel kalian terhapus bersih)."
        ),
        backgroundColor = "#151515"
    ),
    "ending12" to StoryNode(
        label = "ENDING 12 (Keserakahan Berbuah Petaka)", depth = 4, isEnding = true,
        lines = listOf(
            "Asko: \"Buku sejarah kuno ini mahal banget nilainya kalau dijual—\"",
            "Pintu Perpustakaan: (BAM! Terkunci rapat)",
            "(Karena terlalu fokus mencari dokumen project saat temanmu menjerit, entitas rumah menyudutkan kalian di perpustakaan. Tak ada satu pun dari kalian berlima yang keluar dari ruangan itu)."
        ),
        backgroundColor = "#200C0C"
    ),
    "ending13" to StoryNode(
        label = "ENDING 13 (Pengkhianatan di Kegelapan)", depth = 4, isEnding = true,
        lines = listOf(
            "Bayangan Teman: (Dalam mimpi) \"Kenapa kamu meninggalkan kami...\"",
            "Kamu: (Tersentak bangun) \"Nggak! Jangan mendekat!\"",
            "(Kamu memanfaatkan kebingungan teman-temanmu untuk kabur sendirian. Kamu selamat tanpa luka, tetapi bayangan teman-temanmu terus menghantuimu di dalam mimpi setiap malam)."
        ),
        backgroundColor = "#151515"
    ),
    "ending14" to StoryNode(
        label = "ENDING 14 (Solidaritas Tanpa Batas)", depth = 4, isEnding = true,
        lines = listOf(
            "Chiquita: \"Makasih ya udah nggak ninggalin aku walaupun kakiku sakit.\"",
            "Abhi: \"Keluarga nggak boleh ada yang tertinggal!\"",
            "(Walaupun Chiquita terkilir, Kamu dan Abhi membopongnya bersama. Kalian berlima berhasil lolos dari pagar. Project diganti menjadi topik lain, tetapi ikatan persahabatan kalian menjadi sangat kuat)."
        ),
        backgroundColor = "#0C2010"
    ),
    "ending15" to StoryNode(
        label = "ENDING 15 (Umpan Berbahaya)", depth = 4, isEnding = true,
        lines = listOf(
            "Raffa: \"Lihat! Dia mengejar dia! Ayo cepat lari ke pagar!\"",
            "Warga: \"Nak! Bertahanlah, ambulans sedang datang!\"",
            "(Teriakanmu memancing makhluk itu melompat mengejarmu. Asko, Raffa, Abhi, dan Chiquita berhasil kabur, namun Kamu terluka parah terkena sabetan misterius sebelum akhirnya ditolong warga)."
        ),
        backgroundColor = "#401010"
    ),
    "ending16" to StoryNode(
        label = "ENDING 16 (Sukses Besar Berdampak Trauma)", depth = 4, isEnding = true,
        lines = listOf(
            "Guru: \"Laporan sejarah mistis dari buku harian ini sangat mendalam! Kelompok kalian dapat nilai A+!\"",
            "Kalian berlima: (Saling pandang dengan wajah pucat tanpa ekspresi)",
            "(Kalian berlima selamat lewat pintu belakang dapur membawa buku harian tua. Project sekolah kalian mendapat nilai A+ dan dipuji satu sekolah, meski kalian menyimpan trauma mendalam)."
        ),
        backgroundColor = "#0C2010"
    ),
    "ending17" to StoryNode(
        label = "ENDING 17 (Pencuri Hasil Project)", depth = 4, isEnding = true,
        lines = listOf(
            "Guru: \"Luar biasa! Kamu mengerjakan penelitian ini sendirian?\"",
            "Kamu: \"Iya Bu, teman-teman yang lain... mundur dari kelompok.\"",
            "(Kamu merebut buku harian dari Asko, mengunci mereka dari luar, and kabur sendirian. Kamu menyerahkan project itu sendirian dan mendapat nilai tertinggi, tetapi teman-temanmu tak pernah ditemukan lagi)."
        ),
        backgroundColor = "#151515"
    ),
    "ending18" to StoryNode(
        label = "ENDING 18 (Keberanian Berbuah Manis)", depth = 4, isEnding = true,
        lines = listOf(
            "Asko: \"Dokumen kuno di balik cermin ini menjelaskan asal-usul kutukan rumah ini secara detail!\"",
            "Chiquita: \"And kita semua berhasil selamat!\"",
            "(Setelah menghancurkan cermin misterius, kalian berlima melarikan diri sambil membawa dokumen sejarah tua. Semua selamat dan project kelompok kalian menjadi project terbaik tahun ini)."
        ),
        backgroundColor = "#0C2010"
    ),
    "ending19" to StoryNode(
        label = "ENDING 19 (Dua Pengelana)", depth = 4, isEnding = true,
        lines = listOf(
            "Raffa: \"Cuma kita bertiga yang tersisa...\"",
            "Kamu: \"Jangan tengok belakang. Lari!\"",
            "(Hanya Kamu, Abhi, and Raffa yang berhasil keluar rumah. Asko, and Chiquita hilang tanpa jejak di dalam perpustakaan tua)."
        ),
        backgroundColor = "#151515"
    ),
    "ending20" to StoryNode(
        label = "ENDING 20 (Takdir Terbelah)", depth = 4, isEnding = true,
        lines = listOf(
            "Abhi: \"Asko sama Chiquita mana?!\"",
            "Kamu: \"Lorong dapur mendadak bergeser dan menghilang... mereka terjebak di ruang waktu lain!\"",
            "(Kamu, Abhi, and Raffa berhasil lolos, namun Asko and Chiquita terjebak dalam lorong waktu di dalam dapur)."
        ),
        backgroundColor = "#151515"
    )
)
