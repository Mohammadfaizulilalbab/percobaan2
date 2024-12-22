# Aplikasi Rekapitulasi Nilai Mahasiswa

Aplikasi desktop Java untuk manajemen dan rekapitulasi nilai mahasiswa dengan antarmuka grafis menggunakan Swing.

## Fitur

- Input data mahasiswa termasuk foto
- Kalkulasi otomatis IPK dan predikat
- Tampilan tabel data mahasiswa
- Export data ke Excel
- Validasi input
- Preview foto mahasiswa
- Antarmuka grafis yang user-friendly

## Teknologi yang Digunakan

- Java
- Swing (GUI Framework)
- Apache POI (untuk export Excel)
- JUnit (untuk unit testing)

## Struktur Project

```
org.example/
├── MainFrame.java          # Frame utama aplikasi
├── RekapInputFrame.java    # Frame input data mahasiswa
├── RekapTabelFrame.java    # Frame tampilan tabel data
├── Mahasiswa.java          # Model data mahasiswa
├── ImageRenderer.java      # Renderer untuk menampilkan gambar di tabel
├── ExportToExcel.java      # Utilitas export ke Excel
└── MahasiswaTest.java      # Unit test untuk class Mahasiswa
```

## Komponen Utama

### MainFrame
- Frame utama dengan tiga tombol navigasi:
    - Rekap Nilai: Membuka form input data
    - Hasil Rekap Nilai: Menampilkan tabel data
    - Keluar: Menutup aplikasi

### RekapInputFrame
- Form input data mahasiswa dengan field:
    - Nama Mahasiswa
    - NIM
    - Mata Kuliah
    - SKS
    - Nilai (0-100)
    - Upload Foto
- Validasi input untuk memastikan semua field terisi
- Preview foto yang diupload
- Tombol simpan dan kembali

### RekapTabelFrame
- Menampilkan data dalam format tabel
- Kolom yang ditampilkan:
    - Nomor Urut
    - Nama
    - NIM
    - Mata Kuliah
    - SKS
    - Nilai
    - IPK
    - Predikat
    - Status
    - Foto
- Fitur export ke Excel

### Class Mahasiswa
- Model data dengan atribut:
    - Nomor Urut
    - Nama
    - NIM
    - Mata Kuliah
    - SKS
    - Nilai
    - IPK (dihitung otomatis)
    - Predikat (dihitung otomatis)
    - Status (dihitung otomatis)
    - Path Foto

#### Sistem Penilaian
| Nilai | IPK | Predikat |
|-------|-----|----------|
| ≥80   | 4.00| A        |
| ≥70   | 3.50| B+       |
| ≥60   | 3.00| B        |
| ≥50   | 2.50| C+       |
| ≥40   | 2.00| C        |
| <40   | 1.50| D        |

Status kelulusan:
- IPK ≥ 2.00: Lulus
- IPK < 2.00: Tidak Lulus

## Cara Penggunaan

1. Jalankan aplikasi melalui MainFrame
2. Untuk input data:
    - Klik "Rekap Nilai"
    - Isi semua field yang diperlukan
    - Upload foto mahasiswa
    - Klik "Simpan"
3. Untuk melihat data:
    - Klik "Hasil Rekap Nilai"
    - Data akan ditampilkan dalam bentuk tabel
    - Gunakan tombol "Simpan ke Excel" untuk export data

## Unit Testing

Unit test tersedia untuk class Mahasiswa, mencakup:
- Konstruktor dan getter
- Kalkulasi IPK
- Kalkulasi predikat
- Penentuan status kelulusan
- Edge case untuk nilai batas

## Dependensi

- Java Development Kit (JDK) 8 atau lebih tinggi
- Apache POI Library untuk export Excel
- JUnit 5 untuk testing

## Catatan Pengembangan

- Aplikasi menggunakan GridBagLayout untuk tata letak yang responsif
- Implementasi singleton pattern untuk pengelolaan data mahasiswa
- Validasi input mencegah data tidak valid
- Penanganan error untuk operasi file dan input/output