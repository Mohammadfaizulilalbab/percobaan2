package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MahasiswaTest {

    @Test
    void testConstructorAndGetters() {
        // Arrange
        Mahasiswa mahasiswa = new Mahasiswa(1, "John Doe", "12345", "Matematika", 3, 85, "path/to/foto.jpg");

        // Assert
        assertEquals(1, mahasiswa.getNomorUrut());
        assertEquals("John Doe", mahasiswa.getNama());
        assertEquals("12345", mahasiswa.getNim());
        assertEquals("Matematika", mahasiswa.getMataKuliah());
        assertEquals(3, mahasiswa.getSks());
        assertEquals(85, mahasiswa.getNilai());
        assertEquals(4.00, mahasiswa.getIpk(), 0.01); // Delta digunakan untuk double
        assertEquals("A", mahasiswa.getPredikat());
        assertEquals("Lulus", mahasiswa.getStatus());
        assertEquals("path/to/foto.jpg", mahasiswa.getFotoPath());
    }

    @Test
    void testIpkCalculation() {
        // Arrange
        Mahasiswa mahasiswa = new Mahasiswa(2, "Jane Doe", "67890", "Fisika", 3, 75, "path/to/foto2.jpg");

        // Assert
        assertEquals(3.50, mahasiswa.getIpk(), 0.01);
    }

    @Test
    void testPredikatCalculation() {
        // Arrange
        Mahasiswa mahasiswa = new Mahasiswa(3, "Alice", "54321", "Kimia", 3, 60, "path/to/foto3.jpg");

        // Assert
        assertEquals("B", mahasiswa.getPredikat());
    }

    @Test
    void testStatusKelulusanLulus() {
        // Arrange
        Mahasiswa mahasiswa = new Mahasiswa(4, "Bob", "98765", "Biologi", 3, 50, "path/to/foto4.jpg");

        // Assert
        assertEquals("Lulus", mahasiswa.getStatus());
    }

    @Test
    void testStatusKelulusanTidakLulus() {
        // Arrange
        Mahasiswa mahasiswa = new Mahasiswa(5, "Charlie", "11223", "Sejarah", 3, 35, "path/to/foto5.jpg");

        // Assert
        assertEquals("Tidak Lulus", mahasiswa.getStatus());
    }

    @Test
    void testEdgeCaseNilai() {
        // Arrange
        Mahasiswa mahasiswa1 = new Mahasiswa(6, "David", "99887", "Sosiologi", 3, 40, "path/to/foto6.jpg");
        Mahasiswa mahasiswa2 = new Mahasiswa(7, "Eve", "77665", "Statistik", 3, 39, "path/to/foto7.jpg");

        // Assert
        assertEquals(2.00, mahasiswa1.getIpk(), 0.01);
        assertEquals("C", mahasiswa1.getPredikat());

        assertEquals(1.50, mahasiswa2.getIpk(), 0.01);
        assertEquals("D", mahasiswa2.getPredikat());
    }
}
