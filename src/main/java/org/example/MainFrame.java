package org.example;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        // Konfigurasi JFrame
        setTitle("Aplikasi Rekapitulasi Nilai Mahasiswa");
        setSize(829, 598);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Bagian Label Judul
        JLabel titleLabel = new JLabel("Aplikasi Rekapitulasi Nilai Mahasiswa", SwingConstants.CENTER);
        titleLabel.setFont(new Font("System", Font.BOLD, 24));
        titleLabel.setPreferredSize(new Dimension(829, 98));
        add(titleLabel, BorderLayout.NORTH);

        // Panel Tengah (HBox) untuk tombol
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 80, 50)); // Margin horizontal dan vertical

        // Tombol Rekap Nilai
        JButton rekapButton = new JButton("Rekap Nilai");
        rekapButton.setPreferredSize(new Dimension(206, 184));
        rekapButton.setFont(new Font("System", Font.BOLD, 24));

        // Tombol Hasil Rekap Nilai
        JButton hasilButton = new JButton("<html><center>Hasil Rekap<br>Nilai</center></html>");
        hasilButton.setPreferredSize(new Dimension(194, 190));
        hasilButton.setFont(new Font("System", Font.BOLD, 25));

        // Tombol Keluar
        JButton exitButton = new JButton("Keluar");
        exitButton.setPreferredSize(new Dimension(218, 192));
        exitButton.setFont(new Font("System", Font.BOLD, 29));

        // Menambahkan tombol ke panel
        buttonPanel.add(rekapButton);
        buttonPanel.add(hasilButton);
        buttonPanel.add(exitButton);

        add(buttonPanel, BorderLayout.CENTER);

        // Action Listener untuk tombol
        rekapButton.addActionListener(e -> {
            dispose();
            new RekapInputFrame();
        });

        hasilButton.addActionListener(e -> {
            dispose();
            new RekapTabelFrame();
        });

        exitButton.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}
