package Inicio.Menu;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class main_Screen2 extends JFrame {
    private static class JLabelRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            // Llamar al método padre para inicializar correctamente el renderizador por defecto
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Crear un JLabel para mostrar en la celda
            JLabel label = new JLabel((String) value); // Valor de la celda convertido a String

            // Establecer el fondo y el borde del JLabel según el estado de la celda
            if (isSelected) {
                label.setBackground(table.getSelectionBackground());
                label.setForeground(table.getSelectionForeground());
            } else {
                label.setBackground(table.getBackground());
                label.setForeground(table.getForeground());
            }
            label.setText("Prueba");
            // Devolver el JLabel como componente de la celda
            return label;
        }
    }
    private JPanel Panel;
    private JLabel Kanban;
    private JTable table;
    public main_Screen2() {
        setContentPane(Panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Menu");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Edad");
        table.setModel(model);
        table.getColumnModel().getColumn(2).setCellRenderer(new JLabelRenderer());
    }

    public static void main(String[] args) {
        new main_Screen2();
    }
}
