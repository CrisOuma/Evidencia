package ventanas;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class login extends JFrame {
    private JButton BtnLgn;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JPanel pnLog;

    public login() {
        this.setTitle("Login");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana
        this.setContentPane(pnLog); // Asigna el diseño del panel al JFrame
        BtnLgn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                DoctorPage DrPgWindow = new DoctorPage();
                DrPgWindow.setVisible(true);
                setVisible(false);
            }
        });
    }
}
