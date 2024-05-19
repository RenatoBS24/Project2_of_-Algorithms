package Inicio.Menu;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class main_screen extends JFrame {

    private JLabel report;
    private JPanel xd;
    private JLabel d;
    private JLabel s;
    private JLabel sa;
    private JTable table1;

    public main_screen() {
        setContentPane(xd);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
        report.setTransferHandler(new TransferHandler("text"));
        d.setTransferHandler(new TransferHandler("text"));
        xd.setTransferHandler(new TransferHandler("text"));
        table1.setTransferHandler(new TransferHandler("text"));
        report.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                JComponent jc = (JComponent) e.getSource();
                TransferHandler th = jc.getTransferHandler();
                th.exportAsDrag(jc,e,TransferHandler.COPY);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
            }
        });
        s.addMouseListener(new MouseAdapter() {
        });
    }
    public static void main(String[] args) {
        new main_screen();
    }
}
