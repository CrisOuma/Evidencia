package ventanas;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class loginADM extends JFrame{
    private JPanel pnloginADM;
    private JButton btnlog;
    private JTextField usrADM;
    private JPasswordField pswrdADM;

    public loginADM() {
        this.setTitle("Login");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana
        this.setContentPane(pnloginADM); // Asigna el diseño del panel al JFrame
        btnlog.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ADMpage admWindow = new ADMpage();
                admWindow.setVisible(true);
                setVisible(false);
            }
        });
    }
}
