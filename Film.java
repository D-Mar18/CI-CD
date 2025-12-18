import java.util.ArrayList;

public class Film {
    private String id;
    private String judul;
    private String sutradara;
    private int tahun;
    private ArrayList<String> aktor;

    public Film(String id, String judul, String sutradara, int tahun) {
        this.id = id;
        this.judul = judul;
        this.sutradara = sutradara;
        this.tahun = tahun;
        this.aktor = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getJudul() { return judul; }
    public String getSutradara() { return sutradara; }
    public int getTahun() { return tahun; }

    public void tambahAktor(String namaAktor) {
        if (!aktor.contains(namaAktor)) {
            aktor.add(namaAktor);
        }
    }

    public boolean hapusAktor(String namaAktor) {
        return aktor.remove(namaAktor);
    }

    public ArrayList<String> getAktor() {
        return new ArrayList<>(aktor);
    }

    @Override
    public String toString() {
        return "Film{" +
                "id='" + id + '\'' +
                ", judul='" + judul + '\'' +
                ", sutradara='" + sutradara + '\'' +
                ", tahun=" + tahun +
                ", aktor=" + aktor +
                '}';
    }
}
