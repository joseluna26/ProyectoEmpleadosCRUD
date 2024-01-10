package screens;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FraLogin extends JFrame {

    JLabel lblTitulo, lblUsuario, lblContra;
    JTextField txtUsuario;
    JPasswordField txtContra;
    JButton cmdIniciar, cmdRegistrar;

    public FraLogin() {

        // Ventana
        super("Inicia Sesión");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        Image icono = new ImageIcon(getClass().getResource("/images/Java-icon.png")).getImage();
        setIconImage(icono);
        setLayout(null); // diseño libre
        controles();

        setVisible(true);

    }

    // Controles
    public void controles() {

        lblTitulo = new JLabel("Iniciar Sesión", SwingConstants.CENTER);
        lblTitulo.setBounds(0, 12, 300, 20);
        lblTitulo.setFont(new Font("Arial", Font.PLAIN, 15));
        // lblTitulo.setOpaque(true);
        add(lblTitulo);
        
        lblUsuario = new JLabel("Usuario:", SwingConstants.LEFT);
        lblUsuario.setBounds(45, 45, 300, 20);
        lblUsuario.setFont(new Font("Arial", Font.PLAIN, 15));
        // lblTitulo.setOpaque(true);
        add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(110, 47, 150, 22);
        txtUsuario.setFont(new Font("Arial", Font.PLAIN, 15));
        add(txtUsuario);
        
        lblContra = new JLabel("Contraseña:", SwingConstants.LEFT);
        lblContra.setBounds(20, 87, 300, 20);
        lblContra.setFont(new Font("Arial", Font.PLAIN, 15));
        // lblTitulo.setOpaque(true);
        add(lblContra);
        
        txtContra = new JPasswordField();
        txtContra.setBounds(110, 88, 150, 22);
        txtContra.setFont(new Font("Arial", Font.PLAIN, 15));
        add(txtContra);
        
        cmdIniciar = new JButton("Iniciar");
        cmdIniciar.setBounds(5, 125, 130, 25);
        cmdIniciar.setFont(new Font("Arial", Font.PLAIN, 15));
        add(cmdIniciar);
        
        cmdRegistrar = new JButton("Registrar");
        cmdRegistrar.setBounds(145, 125, 130, 25);
        cmdRegistrar.setFont(new Font("Arial", Font.PLAIN, 15));
        add(cmdRegistrar);

    }
}
