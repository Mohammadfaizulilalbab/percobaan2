package org.example;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class RekapInputFrame extends JFrame {
    private static final ArrayList<Mahasiswa> mahasiswaList = new ArrayList<>();

    public RekapInputFrame() {
        setTitle("Input Nilai Mahasiswa");
        setSize(500, 700); // Ukuran frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Margin antar komponen
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font labelFont = new Font("Arial", Font.BOLD, 16); // Font label lebih besar
        Font fieldFont = new Font("Arial", Font.PLAIN, 16); // Font field lebih besar

        // Komponen input
        JLabel namaLabel = new JLabel("Nama Mahasiswa:");
        namaLabel.setFont(labelFont);
        JTextField namaField = new JTextField();
        namaField.setFont(fieldFont);

        JLabel nimLabel = new JLabel("NIM:");
        nimLabel.setFont(labelFont);
        JTextField nimField = new JTextField();
        nimField.setFont(fieldFont);

        JLabel mataKuliahLabel = new JLabel("Mata Kuliah:");
        mataKuliahLabel.setFont(labelFont);
        JTextField mataKuliahField = new JTextField();
        mataKuliahField.setFont(fieldFont);

        JLabel sksLabel = new JLabel("SKS:");
        sksLabel.setFont(labelFont);
        JTextField sksField = new JTextField();
        sksField.setFont(fieldFont);

        JLabel nilaiLabel = new JLabel("Nilai (0-100):");
        nilaiLabel.setFont(labelFont);
        JTextField nilaiField = new JTextField();
        nilaiField.setFont(fieldFont);

        JLabel fotoLabel = new JLabel("Foto:");
        fotoLabel.setFont(labelFont);
        JTextField fotoField = new JTextField();
        fotoField.setFont(fieldFont);
        fotoField.setEditable(false);

        JLabel previewLabel = new JLabel(); // Untuk menampilkan preview gambar
        previewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        previewLabel.setPreferredSize(new Dimension(200, 200));
        previewLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JButton pilihFotoButton = new JButton("Pilih Foto");
        pilihFotoButton.setFont(labelFont);

        // Action untuk memilih file dan menampilkan gambar
        pilihFotoButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Pilih Foto Mahasiswa");
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                fotoField.setText(selectedFile.getAbsolutePath());
                ImageIcon icon = new ImageIcon(selectedFile.getAbsolutePath());

                // Resize image agar sesuai dengan ukuran preview
                Image image = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                previewLabel.setIcon(new ImageIcon(image));
            }
        });

        // Penempatan komponen dalam GridBagLayout
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(namaLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        inputPanel.add(namaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(nimLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        inputPanel.add(nimField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(mataKuliahLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        inputPanel.add(mataKuliahField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        inputPanel.add(sksLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        inputPanel.add(sksField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        inputPanel.add(nilaiLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        inputPanel.add(nilaiField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        inputPanel.add(fotoLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 5;
        inputPanel.add(fotoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        inputPanel.add(previewLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        inputPanel.add(pilihFotoButton, gbc);

        // Tombol Simpan dan Kembali
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton saveButton = new JButton("Simpan");
        saveButton.setFont(labelFont);

        JButton backButton = new JButton("Kembali");
        backButton.setFont(labelFont);

        saveButton.addActionListener(e -> {
            try {
                String nama = namaField.getText().trim();
                String nim = nimField.getText().trim();
                String mataKuliah = mataKuliahField.getText().trim();
                int sks = Integer.parseInt(sksField.getText().trim());
                int nilai = Integer.parseInt(nilaiField.getText().trim());
                String fotoPath = fotoField.getText().trim();

                if (nama.isEmpty() || nim.isEmpty() || mataKuliah.isEmpty() || fotoPath.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Semua field harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                mahasiswaList.add(new Mahasiswa(mahasiswaList.size() + 1, nama, nim, mataKuliah, sks, nilai, fotoPath));
                JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);

                namaField.setText("");
                nimField.setText("");
                mataKuliahField.setText("");
                sksField.setText("");
                nilaiField.setText("");
                fotoField.setText("");
                previewLabel.setIcon(null);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Nilai dan SKS harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        backButton.addActionListener(e -> {
            dispose();
            new MainFrame();
        });

        buttonPanel.add(saveButton);
        buttonPanel.add(backButton);

        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static ArrayList<Mahasiswa> getMahasiswaList() {
        return mahasiswaList;
    }
}
