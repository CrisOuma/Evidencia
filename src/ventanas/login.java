package ventanas;
import metodos.DoctorCRUD;
import entidades.Doctor;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class login extends JFrame {
    private JButton BtnLgn;
    private JTextField txtuss;
    private JPasswordField txtpass;
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
                String username = txtuss.getText();
                String password = String.valueOf(txtpass.getPassword());

                // Instancia de DoctorCRUD para acceder a la base de datos
                DoctorCRUD doctorCRUD = new DoctorCRUD();

                // Cargar la lista de doctores
                List<Doctor> doctores = doctorCRUD.listarDoctores();

                for (Doctor doctor : doctores) {
                    System.out.println("ID: " + doctor.getID());
                    System.out.println("Correo: " + doctor.getCorreo());
                    System.out.println("Contraseña: " + doctor.getContrasena());
                }

                boolean encontrado = false;
                for (Doctor doctor : doctores) {
                    if (doctor.getCorreo() != null && doctor.getCorreo().equals(username) &&
                            doctor.getContrasena() != null && doctor.getContrasena().equals(password)) {
                        encontrado = true;
                        DoctorPage drPageWindow = new DoctorPage();
                        drPageWindow.setVisible(true);
                        setVisible(false);
                        break;
                    }
                }

                if (!encontrado) {
                    JOptionPane.showMessageDialog(null, "Credenciales inválidas. Intenta de nuevo.");
                }
            }
        });
    }
}
