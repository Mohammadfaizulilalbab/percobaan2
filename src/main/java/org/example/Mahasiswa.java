package org.example;


public class Mahasiswa {
    // Atribut kelas
    private int nomorUrut; // Nomor urut mahasiswa
    private String nama; // Nama mahasiswa
    private String nim; // Nomor Induk Mahasiswa
    private String mataKuliah; // Mata kuliah yang diambil
    private int sks; // Jumlah SKS mata kuliah
    private int nilai; // Nilai mata kuliah
    private double ipk; // IPK yang dihitung berdasarkan nilai
    private String predikat; // Predikat nilai berdasarkan IPK
    private String status; // Status kelulusan (Lulus/Tidak Lulus)
    private String fotoPath; // Path file foto mahasiswa

    // Constructor
    public Mahasiswa(int nomorUrut, String nama, String nim, String mataKuliah, int sks, int nilai, String fotoPath) {
        this.nomorUrut = nomorUrut; // Inisialisasi nomor urut
        this.nama = nama; // Inisialisasi nama
        this.nim = nim; // Inisialisasi NIM
        this.mataKuliah = mataKuliah; // Inisialisasi mata kuliah
        this.sks = sks; // Inisialisasi jumlah SKS
        this.nilai = nilai; // Inisialisasi nilai
        this.ipk = hitungIPK(nilai); // Hitung IPK berdasarkan nilai
        this.predikat = hitungPredikat(this.ipk); // Tentukan predikat berdasarkan IPK
        this.status = this.ipk >= 2.00 ? "Lulus" : "Tidak Lulus"; // Status kelulusan berdasarkan IPK
        this.fotoPath = fotoPath; // Inisialisasi path file foto
    }

    // Metode untuk menghitung IPK berdasarkan nilai
    private double hitungIPK(int nilai) {
        // Menggunakan rentang nilai untuk menentukan IPK
        if (nilai >= 80) return 4.00; // Nilai >= 80 menghasilkan IPK 4.00
        else if (nilai >= 70) return 3.50; // Nilai >= 70 menghasilkan IPK 3.50
        else if (nilai >= 60) return 3.00; // Nilai >= 60 menghasilkan IPK 3.00
        else if (nilai >= 50) return 2.50; // Nilai >= 50 menghasilkan IPK 2.50
        else if (nilai >= 40) return 2.00; // Nilai >= 40 menghasilkan IPK 2.00
        else return 1.50; // Nilai < 40 menghasilkan IPK 1.50
    }

    // Metode untuk menentukan predikat berdasarkan IPK
    private String hitungPredikat(double ipk) {
        // Menggunakan nilai IPK untuk menentukan predikat
        if (ipk == 4.00) return "A"; // IPK 4.00 mendapat predikat A
        else if (ipk == 3.50) return "B+"; // IPK 3.50 mendapat predikat B+
        else if (ipk == 3.00) return "B"; // IPK 3.00 mendapat predikat B
        else if (ipk == 2.50) return "C+"; // IPK 2.50 mendapat predikat C+
        else if (ipk == 2.00) return "C"; // IPK 2.00 mendapat predikat C
        else return "D"; // IPK < 2.00 mendapat predikat D
    }

    // Getter untuk nomor urut
    public int getNomorUrut() {
        return nomorUrut; // Mengembalikan nomor urut mahasiswa
    }

    // Getter untuk nama mahasiswa
    public String getNama() {
        return nama; // Mengembalikan nama mahasiswa
    }

    // Getter untuk NIM
    public String getNim() {
        return nim; // Mengembalikan NIM mahasiswa
    }

    // Getter untuk mata kuliah
    public String getMataKuliah() {
        return mataKuliah; // Mengembalikan mata kuliah yang diambil
    }

    // Getter untuk jumlah SKS
    public int getSks() {
        return sks; // Mengembalikan jumlah SKS mata kuliah
    }

    // Getter untuk nilai mata kuliah
    public int getNilai() {
        return nilai; // Mengembalikan nilai mata kuliah
    }

    // Getter untuk IPK
    public double getIpk() {
        return ipk; // Mengembalikan IPK yang dihitung
    }

    // Getter untuk predikat nilai
    public String getPredikat() {
        return predikat; // Mengembalikan predikat nilai berdasarkan IPK
    }

    // Getter untuk status kelulusan
    public String getStatus() {
        return status; // Mengembalikan status kelulusan (Lulus/Tidak Lulus)
    }

    // Getter untuk path file foto
    public String getFotoPath() {
        return fotoPath; // Mengembalikan path file foto mahasiswa
    }
}
