package screens;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import helpers.FontManager;

public class FrmLogin extends JFrame {

    JLabel lblTitulo, lblUsuario, lblContra;
    JTextField txtUsuario;
    JPasswordField txtContra;
    JButton cmdIniciar, cmdRegistrar;

    public FrmLogin() {
        // Ventana
        super("Inicia Sesión");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        Image icono = new ImageIcon(getClass().getResource("/images/login.png")).getImage();
        setIconImage(icono);
        controles();

        setVisible(true);
    }

    // Controles
    public void controles() {

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null); // diseño libre

        Font defaultFont = FontManager.getDefaultFont();
        lblTitulo = new JLabel("Iniciar Sesión", SwingConstants.CENTER);
        lblTitulo.setBounds(0, 12, 300, 20);
        lblTitulo.setFont(defaultFont);
        panel.add(lblTitulo);

        lblUsuario = new JLabel("Usuario:", SwingConstants.LEFT);
        lblUsuario.setBounds(45, 45, 300, 20);
        lblUsuario.setFont(defaultFont);
        panel.add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(110, 46, 150, 22);
        txtUsuario.setFont(defaultFont);
        panel.add(txtUsuario);

        txtUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtContra.requestFocus();
            }
        });

        lblContra = new JLabel("Contraseña:", SwingConstants.LEFT);
        lblContra.setBounds(20, 87, 300, 20);
        lblContra.setFont(defaultFont);
        panel.add(lblContra);

        txtContra = new JPasswordField();
        txtContra.setBounds(110, 87, 150, 22);
        txtContra.setFont(defaultFont);
        panel.add(txtContra);

        txtContra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!txtUsuario.getText().isEmpty() && txtContra.getPassword().length != 0) {
                    cmdIniciar.setEnabled(true);
                    cmdIniciar.requestFocus();
                }else {
                    JOptionPane.showMessageDialog(null, "Para iniciar sesión,\nambos campos son obligatorios", "Error de Captura!", JOptionPane.ERROR_MESSAGE);
                    txtUsuario.requestFocus();
                }
            }
        });

        cmdIniciar = new JButton("Iniciar");
        cmdIniciar.setBounds(5, 125, 130, 25);
        cmdIniciar.setFont(defaultFont);
        panel.add(cmdIniciar);
        cmdIniciar.setEnabled(false);

        cmdIniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FrmEmpleados fraEmpleados = new FrmEmpleados();
                fraEmpleados.setVisible(true);
                dispose();
            }
        });

        cmdRegistrar = new JButton("Registrar");
        cmdRegistrar.setBounds(145, 125, 130, 25);
        cmdRegistrar.setFont(defaultFont);
        panel.add(cmdRegistrar);

        cmdRegistrar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                FrmRegistro frmRegistro = new FrmRegistro();
                frmRegistro.setVisible(true);
                dispose();
            }
        });

    } // fin controles

}
