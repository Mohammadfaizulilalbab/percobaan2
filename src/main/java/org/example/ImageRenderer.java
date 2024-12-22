package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class ImageRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus,
                                                   int row, int column) {
        JLabel label = new JLabel();
        if (value != null) {
            try {
                ImageIcon icon = new ImageIcon(value.toString());
                Image image = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                label.setIcon(new ImageIcon(image));
                label.setHorizontalAlignment(JLabel.CENTER);
            } catch (Exception e) {
                label.setText("Error loading image");
            }
        }
        return label;
    }
}