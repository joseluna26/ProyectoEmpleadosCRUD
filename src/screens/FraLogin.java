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

import helpers.FontManager;

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
        Image icono = new ImageIcon(getClass().getResource("/images/login.png")).getImage();
        setIconImage(icono);
        setLayout(null); // diseño libre
        controles();

        setVisible(true);

    }

    // Controles
    public void controles() {

        Font defaultFont = FontManager.getDefaultFont();
        lblTitulo = new JLabel("Iniciar Sesión", SwingConstants.CENTER);
        lblTitulo.setBounds(0, 12, 300, 20);
        lblTitulo.setFont(defaultFont);
        add(lblTitulo);
        
        lblUsuario = new JLabel("Usuario:", SwingConstants.LEFT);
        lblUsuario.setBounds(45, 45, 300, 20);
        lblUsuario.setFont(defaultFont);
        add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(110, 46, 150, 22);
        txtUsuario.setFont(defaultFont);
        add(txtUsuario);
        
        lblContra = new JLabel("Contraseña:", SwingConstants.LEFT);
        lblContra.setBounds(20, 87, 300, 20);
        lblContra.setFont(defaultFont);
        add(lblContra);
        
        txtContra = new JPasswordField();
        txtContra.setBounds(110, 87, 150, 22);
        txtContra.setFont(defaultFont);
        add(txtContra);
        
        cmdIniciar = new JButton("Iniciar");
        cmdIniciar.setBounds(5, 125, 130, 25);
        cmdIniciar.setFont(defaultFont);
        add(cmdIniciar);
        
        cmdRegistrar = new JButton("Registrar");
        cmdRegistrar.setBounds(145, 125, 130, 25);
        cmdRegistrar.setFont(defaultFont);
        add(cmdRegistrar);

    }
}
