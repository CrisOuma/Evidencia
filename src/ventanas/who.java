package ventanas;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class who extends JFrame {
    private JButton btnadmin;
    private JButton btndoc;
    private JButton btnpaci;
    private JPanel pnwho;

    public who() {
        this.setTitle("Ventana Principal");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnwho);

        // Evento para abrir la ventana de login
        btndoc.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                login loginWindow = new login(); // Crear instancia de login
                loginWindow.setVisible(true);   // Mostrar la ventana de login
            }
        });
        btnpaci.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Codigo CodigoWindow = new Codigo();
                CodigoWindow.setVisible(true);
            }
        });
        btnadmin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                loginADM login2Window = new loginADM(); // Crear instancia de login
                login2Window.setVisible(true);   // Mostrar la ventana de login
            }
        });
    }

    public static void main(String[] args) {
        who ventanaPrincipal = new who();
        ventanaPrincipal.setVisible(true);
    }
}
