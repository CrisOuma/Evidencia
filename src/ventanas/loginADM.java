package ventanas;
import entidades.Administrador;
import metodos.AdministradorCRUD;


import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

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
                String username = usrADM.getText();
                String password = String.valueOf(pswrdADM.getPassword());

                // Instancia de AdministradorCRUD para acceder a la base de datos
                AdministradorCRUD admCRUD = new AdministradorCRUD();

                // Cargar la lista de administradores
                List<Administrador> administradores = admCRUD.listarAdministradores();

                boolean encontrado = false;
                for (Administrador administrador : administradores) {
                    if (administrador.getUsuario() != null && administrador.getUsuario().equals(username) &&
                            administrador.getContraseña() != null && administrador.getContraseña().equals(password)) {
                        encontrado = true;
                        // Abrir la ventana de administrador
                        ADMpage adminPageWindow = new ADMpage();
                        adminPageWindow.setVisible(true);
                        setVisible(false);
                        break;
                    }
                }

                if (!encontrado) {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
                }
            }

        });
    }
}
