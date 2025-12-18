import java.util.ArrayList;
import java.util.Scanner;

public class MiniMarketApp {
    private static ArrayList<Product> produkList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        while (true) {
            System.out.println("\n=== APLIKASI MINI MARKET ===");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Edit Produk");
            System.out.println("3. Hapus Produk");
            System.out.println("4. Tampilkan Semua Produk");
            System.out.println("5. Tampilkan Produk Berdasarkan Jenis");
            System.out.println("6. Tampilkan Produk Berdasarkan Rentang Harga");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            String pilihan = sc.nextLine();

            switch (pilihan) {
                case "1": tambahProduk(); break;
                case "2": editProduk(); break;
                case "3": hapusProduk(); break;
                case "4": tampilSemua(); break;
                case "5": tampilBerdasarkanJenis(); break;
                case "6": tampilBerdasarkanRentangHarga(); break;
                case "0": System.out.println("Keluar. Terima kasih."); System.exit(0); break;
                default: System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void tambahProduk() {
        System.out.print("ID: "); String id = sc.nextLine().trim();
        if (findById(id) != null) { System.out.println("ID sudah ada."); return; }
        System.out.print("Nama: "); String nama = sc.nextLine();
        System.out.print("Produsen: "); String produsen = sc.nextLine();
        System.out.print("Berat (gram): "); double berat = parseDouble(sc.nextLine(), 0);
        System.out.print("Jenis (MAKANAN/MINUMAN/KOSMETIK): "); String j = sc.nextLine().toUpperCase();
        Product.Jenis jenis;
        try { jenis = Product.Jenis.valueOf(j); }
        catch (Exception e) { System.out.println("Jenis tidak valid."); return; }
        System.out.print("Harga: "); double harga = parseDouble(sc.nextLine(), 0);
        System.out.print("Lokasi Rak: "); String rak = sc.nextLine();
        System.out.print("Stok: "); int stok = parseInt(sc.nextLine(), 0);

        produkList.add(new Product(id, nama, produsen, berat, jenis, harga, rak, stok));
        System.out.println("Produk ditambahkan.");
    }

    private static void editProduk() {
        System.out.print("Masukkan ID produk yang ingin diedit: ");
        String id = sc.nextLine().trim();
        Product p = findById(id);
        if (p == null) { System.out.println("Produk tidak ditemukan."); return; }

        System.out.println("Kosongkan input untuk melewati field.");
        System.out.print("Nama ("+p.getNama()+"): "); String nama = sc.nextLine();
        if (!nama.isEmpty()) p.setNama(nama);

        System.out.print("Produsen ("+p.getProdusen()+"): "); String produsen = sc.nextLine();
        if (!produsen.isEmpty()) p.setProdusen(produsen);

        System.out.print("Berat ("+p.getBerat()+"): "); String beratS = sc.nextLine();
        if (!beratS.isEmpty()) p.setBerat(parseDouble(beratS, p.getBerat()));

        System.out.print("Jenis ("+p.getJenis()+") (MAKANAN/MINUMAN/KOSMETIK): "); String jenisS = sc.nextLine();
        if (!jenisS.isEmpty()) {
            try { p.setJenis(Product.Jenis.valueOf(jenisS.toUpperCase())); }
            catch (Exception e) { System.out.println("Jenis tidak valid, dilewati."); }
        }

        System.out.print("Harga ("+p.getHarga()+"): "); String hargaS = sc.nextLine();
        if (!hargaS.isEmpty()) p.setHarga(parseDouble(hargaS, p.getHarga()));

        System.out.print("Lokasi Rak ("+p.getLokasiRak()+"): "); String rak = sc.nextLine();
        if (!rak.isEmpty()) p.setLokasiRak(rak);

        System.out.print("Stok ("+p.getStok()+"): "); String stokS = sc.nextLine();
        if (!stokS.isEmpty()) p.setStok(parseInt(stokS, p.getStok()));

        System.out.println("Produk berhasil diperbarui.");
    }

    private static void hapusProduk() {
        System.out.print("Masukkan ID produk yang ingin dihapus: ");
        String id = sc.nextLine().trim();
        Product p = findById(id);
        if (p == null) { System.out.println("Produk tidak ditemukan."); return; }
        produkList.remove(p);
        System.out.println("Produk dihapus.");
    }

    private static void tampilSemua() {
        if (produkList.isEmpty()) { System.out.println("Belum ada produk."); return; }
        System.out.println("=== Daftar Produk ===");
        for (Product p : produkList) {
            System.out.println(p);
        }
    }

    private static void tampilBerdasarkanJenis() {
        System.out.print("Masukkan jenis (MAKANAN/MINUMAN/KOSMETIK): ");
        String j = sc.nextLine().toUpperCase();
        Product.Jenis jenis;
        try { jenis = Product.Jenis.valueOf(j); }
        catch (Exception e) { System.out.println("Jenis tidak valid."); return; }

        boolean found = false;
        for (Product p : produkList) {
            if (p.getJenis() == jenis) {
                if (!found) System.out.println("=== Produk Jenis: " + jenis + " ===");
                System.out.println(p);
                found = true;
            }
        }
        if (!found) System.out.println("Tidak ada produk dengan jenis tersebut.");
    }

    private static void tampilBerdasarkanRentangHarga() {
        System.out.print("Harga terendah: "); double low = parseDouble(sc.nextLine(), -1);
        System.out.print("Harga tertinggi: "); double high = parseDouble(sc.nextLine(), -1);
        if (low < 0 || high < 0 || high < low) { System.out.println("Rentang harga tidak valid."); return; }

        boolean found = false;
        for (Product p : produkList) {
            if (p.getHarga() >= low && p.getHarga() <= high) {
                if (!found) System.out.println("=== Produk Harga antara Rp " + low + " - Rp " + high + " ===");
                System.out.println(p);
                found = true;
            }
        }
        if (!found) System.out.println("Tidak ada produk dalam rentang harga tersebut.");
    }

    private static Product findById(String id) {
        for (Product p : produkList) if (p.getId().equalsIgnoreCase(id)) return p;
        return null;
    }

    private static double parseDouble(String s, double fallback) {
        try { return Double.parseDouble(s.trim()); } catch (Exception e) { return fallback; }
    }
    private static int parseInt(String s, int fallback) {
        try { return Integer.parseInt(s.trim()); } catch (Exception e) { return fallback; }
    }
}
