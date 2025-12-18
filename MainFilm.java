public class MainFilm {
    public static void main(String[] args) {
        Film f1 = new Film("F001", "Bulan Merah", "Andi Sutradara", 2021);
        f1.tambahAktor("Aktor A");
        f1.tambahAktor("Aktor B");
        f1.tambahAktor("Aktor C");

        Film f2 = new Film("F002", "Mimpi Kota", "Sari Sutradara", 2019);
        f2.tambahAktor("Aktor X");
        f2.tambahAktor("Aktor Y");

        System.out.println(f1);
        System.out.println(f2);

        f1.hapusAktor("Aktor B");
        System.out.println("Setelah hapus aktor B dari F001:");
        System.out.println(f1);
    }
}
