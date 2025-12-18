public class Product {
    public enum Jenis { MAKANAN, MINUMAN, KOSMETIK }

    private String id;
    private String nama;
    private String produsen;
    private double berat;
    private Jenis jenis;
    private double harga;
    private String lokasiRak;
    private int stok;

    public Product(String id, String nama, String produsen, double berat, Jenis jenis, double harga, String lokasiRak, int stok) {
        this.id = id;
        this.nama = nama;
        this.produsen = produsen;
        this.berat = berat;
        this.jenis = jenis;
        this.harga = harga;
        this.lokasiRak = lokasiRak;
        this.stok = stok;
    }

    public String getId() { return id; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public String getProdusen() { return produsen; }
    public void setProdusen(String produsen) { this.produsen = produsen; }
    public double getBerat() { return berat; }
    public void setBerat(double berat) { this.berat = berat; }
    public Jenis getJenis() { return jenis; }
    public void setJenis(Jenis jenis) { this.jenis = jenis; }
    public double getHarga() { return harga; }
    public void setHarga(double harga) { this.harga = harga; }
    public String getLokasiRak() { return lokasiRak; }
    public void setLokasiRak(String lokasiRak) { this.lokasiRak = lokasiRak; }
    public int getStok() { return stok; }
    public void setStok(int stok) { this.stok = stok; }

    @Override
    public String toString() {
        return String.format("ID:%s | Nama:%s | Produsen:%s | Berat:%.1f g | Jenis:%s | Harga:Rp %.2f | Rak:%s | Stok:%d",
                id, nama, produsen, berat, jenis, harga, lokasiRak, stok);
    }
}
