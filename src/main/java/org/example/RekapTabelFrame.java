package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class RekapTabelFrame extends JFrame {

    public RekapTabelFrame() {
        setTitle("Hasil Rekap Nilai Mahasiswa");
        setSize(800, 400);
        setLayout(new BorderLayout());

        // Kolom Tabel
        String[] columnNames = {"No", "Nama", "NIM", "Mata Kuliah", "SKS", "Nilai", "IPK", "Predikat", "Status", "Foto"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);

        // Set custom renderer untuk kolom foto
        table.getColumnModel().getColumn(9).setCellRenderer(new ImageRenderer());

        // Set preferredWidth untuk kolom foto
        table.getColumnModel().getColumn(9).setPreferredWidth(60);

        // Set row height untuk mengakomodasi gambar
        table.setRowHeight(50);

        // Mengisi Data ke Tabel
        for (Mahasiswa mhs : RekapInputFrame.getMahasiswaList()) {
            model.addRow(new Object[]{
                    mhs.getNomorUrut(),
                    mhs.getNama(),
                    mhs.getNim(),
                    mhs.getMataKuliah(),
                    mhs.getSks(),
                    mhs.getNilai(),
                    mhs.getIpk(),
                    mhs.getPredikat(),
                    mhs.getStatus(),
                    mhs.getFotoPath()
            });
        }

        // Tombol
        JButton backButton = new JButton("Kembali");
        backButton.addActionListener(e -> {
            dispose();
            new MainFrame();
        });

        JButton saveButton = new JButton("Simpan ke Excel");
        saveButton.addActionListener(e -> saveToExcel());

        JPanel bottomPanel = new JPanel(new FlowLayout());
        bottomPanel.add(saveButton);
        bottomPanel.add(backButton);

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void saveToExcel() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Pilih Lokasi Simpan File");
        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try (Workbook workbook = new XSSFWorkbook()) {
                Sheet sheet = workbook.createSheet("Rekap Nilai");
                Row headerRow = sheet.createRow(0);
                String[] columns = {"No", "Nama", "NIM", "Mata Kuliah", "SKS", "Nilai", "IPK", "Predikat", "Status", "Foto"};

                for (int i = 0; i < columns.length; i++) {
                    Cell cell = headerRow.createCell(i);
                    cell.setCellValue(columns[i]);
                }

                int rowNum = 1;
                for (Mahasiswa mhs : RekapInputFrame.getMahasiswaList()) {
                    Row row = sheet.createRow(rowNum++);
                    row.createCell(0).setCellValue(mhs.getNomorUrut());
                    row.createCell(1).setCellValue(mhs.getNama());
                    row.createCell(2).setCellValue(mhs.getNim());
                    row.createCell(3).setCellValue(mhs.getMataKuliah());
                    row.createCell(4).setCellValue(mhs.getSks());
                    row.createCell(5).setCellValue(mhs.getNilai());
                    row.createCell(6).setCellValue(mhs.getIpk());
                    row.createCell(7).setCellValue(mhs.getPredikat());
                    row.createCell(8).setCellValue(mhs.getStatus());
                    row.createCell(9).setCellValue(mhs.getFotoPath());
                }

                try (FileOutputStream fileOut = new FileOutputStream(fileToSave)) {
                    workbook.write(fileOut);
                }

                JOptionPane.showMessageDialog(this, "Data berhasil disimpan ke Excel!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menyimpan file.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}