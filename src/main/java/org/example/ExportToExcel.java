package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
//import org.apache.poi.xssf.usermodel.XSSFPatriarch;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

public class ExportToExcel {
    public static void exportData(ArrayList<Mahasiswa> mahasiswaList, String filePath) {
        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            XSSFSheet sheet = workbook.createSheet("Data Mahasiswa");

            // Header
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("No");
            headerRow.createCell(1).setCellValue("Nama");
            headerRow.createCell(2).setCellValue("NIM");
            headerRow.createCell(3).setCellValue("Mata Kuliah");
            headerRow.createCell(4).setCellValue("SKS");
            headerRow.createCell(5).setCellValue("Nilai");
            headerRow.createCell(6).setCellValue("Foto");

            // Isi data
            int rowIdx = 1;
            for (Mahasiswa mhs : mahasiswaList) {
                Row row = sheet.createRow(rowIdx);

                row.createCell(0).setCellValue(mhs.getNomorUrut());
                row.createCell(1).setCellValue(mhs.getNama());
                row.createCell(2).setCellValue(mhs.getNim());
                row.createCell(3).setCellValue(mhs.getMataKuliah());
                row.createCell(4).setCellValue(mhs.getSks());
                row.createCell(5).setCellValue(mhs.getNilai());

                // Menambahkan gambar ke kolom ke-7
                if (mhs.getFotoPath() != null && !mhs.getFotoPath().isEmpty()) {
                    InputStream inputStream = new FileInputStream(mhs.getFotoPath());
                    byte[] bytes = inputStream.readAllBytes();
                    int pictureIdx = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
                    inputStream.close();

                    XSSFDrawing drawing = sheet.createDrawingPatriarch();
                    CreationHelper helper = workbook.getCreationHelper();
                    ClientAnchor anchor = helper.createClientAnchor();
                    anchor.setCol1(6); // Kolom G
                    anchor.setRow1(rowIdx); // Baris ke-n
                    anchor.setCol2(7); // Kolom H
                    anchor.setRow2(rowIdx + 1); // Baris berikutnya

                    drawing.createPicture(anchor, pictureIdx);
                }

                rowIdx++;
            }

            // Resize kolom agar pas
            for (int i = 0; i <= 6; i++) {
                sheet.autoSizeColumn(i);
            }

            // Simpan ke file
            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }

            System.out.println("Data berhasil diekspor ke " + filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
