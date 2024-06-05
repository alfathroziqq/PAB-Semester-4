// Nama : Alfath Roziq Widhayaka
// NIM  : L0122012

import java.time.LocalDate
import java.util.Scanner

// Interface untuk kendaraan
interface Kendaraan {
    val merek: String
    val model: String
    val tahunProduksi: Int
    
    fun info(): String
}

// Induk Kelas
open class KendaraanRoda4(
    override val merek: String,
    override val model: String,
    override val tahunProduksi: Int
) : Kendaraan {
    override fun info(): String {
        return "Kendaraan roda 4 $merek $model tahun $tahunProduksi"
    }
}

// Class untuk mobil (Inheritances)
class Mobil(
    merek: String,
    model: String,
    tahunProduksi: Int,
    val jumlahPintu: Int
) : KendaraanRoda4(merek, model, tahunProduksi) {
    
    // Lateinit
    lateinit var nomorMesin: String
    
    // Lazy Property
    val usiaMobil: Int by lazy {
        LocalDate.now().year - tahunProduksi
    }

    override fun info(): String {
        return "Mobil $merek $model tahun $tahunProduksi dengan $jumlahPintu pintu, nomor Mesin : $nomorMesin, usia Mobil  : $usiaMobil tahun"
    }
}

fun main() {
    val scanner = Scanner(System.`in`)

    // Collections (mutable list)
    val mobilList = mutableListOf<Mobil>()

    println("\nSelamat datang Admin, di Showroom Pratama")

    var isRunning = true

    while (isRunning) {
        println("\nMenu:")
        println("1. Tambahkan stok mobil")
        println("2. Tampilkan stok mobil")
        println("3. Cari Mobil")
        println("4. Keluar")
        print("Pilih menu : ")

        // Control flow (when expression)
        when (scanner.nextInt()) {
            1 -> {
                println("\nTambahkan stok mobil:")
                print("Merek            : ")
                val merek = scanner.next()
                print("Model            : ")
                val model = scanner.next()
                print("Tahun Produksi   : ")
                val tahun = scanner.nextInt()
                print("Jumlah Pintu     : ")
                val pintu = scanner.nextInt()
                print("Nomor Mesin      : ")
                val nomorMesin = scanner.next()

                val mobil = Mobil(merek, model, tahun, pintu)
                mobil.nomorMesin = nomorMesin 

                mobilList.add(mobil)

                println("\n!!Mobil berhasil ditambahkan!!")
            }
            2 -> {
                println("\nDaftar Mobil di Dealer:")
                if (mobilList.isEmpty()) {
                    println("Stok mobil kosong.")
                } else {
                    println("-----------------------------------------------------------------------------------------------------")
                    println("| No |    Merek     |       Model       | Tahun Produksi  | Jml Pintu  |  Nomor Mesin  | Usia Mobil |")
                    println("-----------------------------------------------------------------------------------------------------")
                    mobilList.forEachIndexed { index, mobil ->
                        println("| ${index + 1}  | ${mobil.merek.padEnd(12)} | ${mobil.model.padEnd(17)} | ${mobil.tahunProduksi.toString().padEnd(15)} | ${mobil.jumlahPintu.toString().padEnd(10)} | ${mobil.nomorMesin.padEnd(13)} | ${mobil.usiaMobil.toString().padEnd(10)} |")
                    }
                    println("-----------------------------------------------------------------------------------------------------")
                }
            }
            3 -> {
                println("\nCari mobil berdasarkan tahun produksi:")
                print("Masukkan tahun produksi awal  : ")
                val tahunAwal = scanner.nextInt()
                print("Masukkan tahun produksi akhir : ")
                val tahunAkhir = scanner.nextInt()
            
                // Control Flow (Range & For Loop) dan Lambda Expression
                println("\nMobil-mobil dari tahun $tahunAwal hingga $tahunAkhir:")
                val mobilFiltered = mobilList.filter { it.tahunProduksi in tahunAwal..tahunAkhir }
                if (mobilFiltered.isEmpty()) {
                    println("Tidak ada mobil yang memenuhi kriteria tersebut.")
                } else {
                    mobilFiltered.forEachIndexed { index, mobil ->
                        println("${index + 1}. ${mobil.info()}")
                    }
                }
            }       
            4 -> {
                println("\nKeluar dari program...")
                isRunning = false
            }     
            else -> {
                println("\nPilih sesuai angka!")
            }
        }
    }
}