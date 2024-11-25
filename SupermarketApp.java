import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SupermarketApp {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean loginSuccess = false;

        // Proses login dengan validasi dan metode String
        while (!loginSuccess) {
            System.out.println("+-----------------------------------------------------+");
            System.out.print("Username : ");
            String username = scanner.nextLine().trim(); // Menghapus spasi tambahan pada input
            System.out.print("Password : ");
            String password = scanner.nextLine().trim(); // Menghapus spasi tambahan pada input
            System.out.print("Captcha (ketik '1234') : ");
            String captcha = scanner.nextLine().trim(); // Menghapus spasi tambahan pada input

            // Validasi login dengan equalsIgnoreCase dan equals
            if (username.equalsIgnoreCase("akurian") && password.equals("bro123") && captcha.equals("1234")) {
                // equalsIgnoreCase digunakan agar username tidak peka huruf besar/kecil
                // equals digunakan untuk validasi password dan captcha yang peka huruf besar/kecil
                loginSuccess = true;
                System.out.println("Login berhasil!");
            } else {
                System.out.println("Login gagal, silakan ulangi.\n");
            }
        }

        // Menampilkan informasi supermarket
        System.out.println("+-----------------------------------------------------+");
        System.out.println("Selamat Datang di Supermarket Budiyan!");

        // Menggunakan Date untuk mengambil waktu saat ini
        Date now = new Date();

        // SimpleDateFormat untuk memformat tanggal dan waktu
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, dd MMMM yyyy HH:mm:ss");
        // Format:
        // EEEE  : Hari dalam seminggu (contoh: Senin)
        // dd    : Tanggal (contoh: 25)
        // MMMM  : Nama bulan (contoh: November)
        // yyyy  : Tahun (contoh: 2024)
        // HH:mm:ss : Jam:Menit:Detik dalam format 24 jam
        System.out.println("Tanggal dan Waktu : " + formatter.format(now));
        System.out.println("+-----------------------------------------------------+");

        // Input data transaksi dengan validasi
        String noFaktur, kodeBarang, namaBarang;
        double hargaBarang = 0;
        int jumlahBeli = 0;

        try {
            System.out.print("No. Faktur      : ");
            noFaktur = scanner.nextLine().trim(); // Menghapus spasi tambahan pada input

            System.out.print("Kode Barang     : ");
            kodeBarang = scanner.nextLine().trim().toUpperCase(); 
            // toUpperCase digunakan untuk memastikan kode barang disimpan dalam huruf kapital

            System.out.print("Nama Barang     : ");
            namaBarang = scanner.nextLine().trim(); 
            // Menghapus spasi tambahan
            if (namaBarang.isEmpty()) {
                // isEmpty digunakan untuk memeriksa apakah input kosong
                throw new IllegalArgumentException("Nama barang tidak boleh kosong!");
            }

            System.out.print("Harga Barang    : ");
            hargaBarang = Double.parseDouble(scanner.nextLine().trim()); 
            // trim untuk menghapus spasi, Double.parseDouble untuk mengonversi input menjadi angka desimal

            System.out.print("Jumlah Beli     : ");
            jumlahBeli = Integer.parseInt(scanner.nextLine().trim()); 
            // trim untuk menghapus spasi, Integer.parseInt untuk mengonversi input menjadi bilangan bulat
        } catch (NumberFormatException e) {
            System.out.println("Input salah! Harap masukkan angka untuk harga dan jumlah beli.");
            System.out.println("Program dihentikan.");
            return;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("Program dihentikan.");
            return;
        }

        // Menghitung total
        double total = hargaBarang * jumlahBeli;

        // Menampilkan data faktur
        System.out.println("+-----------------------------------------------------+");
        System.out.println("No. Faktur      : " + noFaktur);
        System.out.println("Kode Barang     : " + kodeBarang);
        System.out.println("Nama Barang     : " + namaBarang);
        System.out.println("Harga Barang    : " + String.format("%.2f", hargaBarang)); 
        // String.format digunakan untuk memformat angka menjadi dua desimal
        System.out.println("Jumlah Beli     : " + jumlahBeli);
        System.out.println("TOTAL           : " + String.format("%.2f", total)); 
        // String.format digunakan untuk memformat angka menjadi dua desimal
        System.out.println("+-----------------------------------------------------+");

        // Input nama kasir
        System.out.print("Kasir           : ");
        String namaKasir = scanner.nextLine().trim(); 
        // trim untuk menghapus spasi tambahan
        if (namaKasir.isEmpty()) {
            // isEmpty untuk memeriksa apakah nama kasir kosong
            System.out.println("Nama kasir tidak boleh kosong.");
            return;
        }

        System.out.println("+-----------------------------------------------------+");
        System.out.println("Transaksi selesai. Terima kasih telah berbelanja!");
        System.out.println("Kasir : " + namaKasir);
        System.out.println("+-----------------------------------------------------+");

        scanner.close();
    }
}
