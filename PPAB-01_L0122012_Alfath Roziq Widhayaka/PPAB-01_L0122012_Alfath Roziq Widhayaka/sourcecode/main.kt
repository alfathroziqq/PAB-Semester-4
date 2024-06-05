// Alfath Roziq Widhayaka
// L0122012
// A

fun main() {
    //Deklarasi variabel mobil
    val carModel: String = "Silvia S15"
    var carTahun: Int = 2010
    val carWarna: String = "Putih"
    val carTransmisi: String? = "Manual"
    val carKondisi: String? = null

    //Named Argument
    val totalHarga = hitungTotalHarga(hargaAwal = 300000000)

    val namaCustomer: String? = tampilkanCustomer()

    //Periksa apakah nama customer tidak null, lalu tampilkan pesan selamat datang
    if (namaCustomer != null) {
        println("\nSelamat datang, $namaCustomer di dealer Nissan!")
    } else {
        println("Selamat datang di dealer Nissan!")
    }

    displayMobilDijual()
    displayMobil(carModel, carTahun, carWarna, carTransmisi, carKondisi)
    displayMobilDibeli(totalHarga)

    //Raw String
    val terimakasih = """
        Terima kasih atas pembelian mobil di dealer Nissan.
        Kami mengucapkan terima kasih atas kepercayaan Anda.
        Semoga Anda puas dengan mobil baru Anda!
    """.trimIndent()

    println(terimakasih)
}

//Fungsi untuk menghitung total harga mobil dengan pajak
fun hitungTotalHarga(hargaAwal: Int, pajak: Double = 0.05): Int {
    val totalHarga = hargaAwal + (hargaAwal * pajak).toInt()
    return totalHarga
}

//Fungsi untuk menampilkan nama customer
fun tampilkanCustomer(): String? {
    return "Alfath"
}

//Fungsi untuk menampilkan daftar mobil yang dijual dealer
fun displayMobilDijual() {
    println("\nDaftar mobil yang terjual di dealer Nissan:")
    println("1. Model: Silvia S15, Tahun: 2010, Warna: Putih, Transmisi: Manual")
    println("2. Model: GTR R34, Tahun: 2009, Warna: Biru, Transmisi: Automatic")
    println("3. Model: Juke, Tahun: 2018, Warna: Hitam, Transmisi: Automatic")
}

//Fungsi untuk menampilkan detail mobil yang dibeli
fun displayMobil(model: String, tahun: Int, warna: String, transmisi: String?, kondisi: String?) {
    println("\nDetail mobil yang dibeli:")
    println("Model      : $model")
    println("Tahun      : $tahun")
    println("Warna      : $warna")
    println("Transmisi  : ${transmisi ?: "Informasi tidak tersedia"}")
    println("Kondisi    : ${kondisi?.toString() ?: "Informasi tidak tersedia"}")
}

//Fungsi untuk menampilkan total harga pembelian mobil
fun displayMobilDibeli(totalHarga: Int) {
    println("Total harga pembelian : Rp $totalHarga\n")
}