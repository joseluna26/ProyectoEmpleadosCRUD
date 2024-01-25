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
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import db.repositorys.LoginRepository;
import helpers.FontManager;
import models.Login;

public class FrmRegistro extends JFrame {

    JLabel lblTitulo, lblNombre, lblEmail, lblUsuario, lblContra;
    JTextField txtNombre, txtEmail, txtUsuario;
    JPasswordField txtContra;
    JButton cmdRegistrar;
    JRadioButton radContra;

    public FrmRegistro() {

        // Ventana
        super("Registro");
        setSize(300, 310);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
        panel.setLayout(null);

        Font defaultFont = FontManager.getDefaultFont();
        lblTitulo = new JLabel("Registro", SwingConstants.CENTER);
        lblTitulo.setBounds(0, 12, 300, 20);
        lblTitulo.setFont(defaultFont);
        panel.add(lblTitulo);

        lblNombre = new JLabel("Nombre:", SwingConstants.LEFT);
        lblNombre.setBounds(45, 45, 300, 20);
        lblNombre.setFont(defaultFont);
        panel.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(110, 46, 150, 22);
        txtNombre.setFont(defaultFont);
        panel.add(txtNombre);

        txtNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validaCamposVacios();
                cambiarFoco("txtNombre");
            }
        });

        lblEmail = new JLabel("Email:", SwingConstants.LEFT);
        lblEmail.setBounds(61, 87, 300, 20);
        lblEmail.setFont(defaultFont);
        panel.add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(110, 87, 150, 22);
        txtEmail.setFont(defaultFont);
        panel.add(txtEmail);

        txtEmail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validaCamposVacios();
                cambiarFoco("txtEmail");
            }
        });

        lblUsuario = new JLabel("Usuario:", SwingConstants.LEFT);
        lblUsuario.setBounds(49, 128, 300, 20);
        lblUsuario.setFont(defaultFont);
        panel.add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(110, 128, 150, 22);
        txtUsuario.setFont(defaultFont);
        panel.add(txtUsuario);

        txtUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validaCamposVacios();
                cambiarFoco("txtUsuario");
            }
        });

        lblContra = new JLabel("Contraseña:", SwingConstants.LEFT);
        lblContra.setBounds(20, 169, 300, 20);
        lblContra.setFont(defaultFont);
        panel.add(lblContra);

        txtContra = new JPasswordField();
        txtContra.setBounds(150, 169, 110, 22);
        txtContra.setFont(defaultFont);
        panel.add(txtContra);

        txtContra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validaCamposVacios();
                cambiarFoco("txtContra");
            }
        });

        radContra = new JRadioButton();
        radContra.setBounds(110, 169, 20, 22);
        radContra.setFont(defaultFont);
        panel.add(radContra);

        cmdRegistrar = new JButton("Registrar");
        cmdRegistrar.setBounds(150, 231, 110, 25);
        cmdRegistrar.setFont(defaultFont);
        panel.add(cmdRegistrar);

        cmdRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (txtNombre.getText().isEmpty() || txtEmail.getText().isEmpty() || txtUsuario.getText().isEmpty() || txtContra.getPassword().length == 0) {
                    JOptionPane.showMessageDialog(null, "Campos vacíos, no se insertó el Registro", "Error de captura!", JOptionPane.ERROR_MESSAGE);
                    FrmLogin frmLogin = new FrmLogin();
                    frmLogin.setVisible(true);
                    dispose();
                } else {
                    
                    LoginRepository loginRepository = new LoginRepository();
                    char[] passwordChars = txtContra.getPassword();
                    String pass = new String(passwordChars);
                    Login reg = new Login(null, txtNombre.getText(), txtEmail.getText(), txtUsuario.getText(), pass);
                    loginRepository.agregar(reg);
                    FrmLogin frmLogin = new FrmLogin();
                    frmLogin.setVisible(true);
                    dispose();
                }
            }
        });

        if (txtNombre.getText().isEmpty() || txtEmail.getText().isEmpty() || txtUsuario.getText().isEmpty() || txtContra.getPassword().length == 0) {

            cmdRegistrar.setText("Salir");
        }
        
    }

    private void cambiarFoco(String nomcontrol) {
        switch (nomcontrol) {
            case "txtNombre":
                txtEmail.requestFocus();
                break;
            case "txtEmail":
                txtUsuario.requestFocus();
                break;
            case "txtUsuario":
                txtContra.requestFocus();
                break;
            case "txtContra":
                cmdRegistrar.requestFocus();
                break;
            default:
                break;
        }
    }

    private void validaCamposVacios(){
        if (txtNombre.getText().isEmpty() || txtEmail.getText().isEmpty() || txtUsuario.getText().isEmpty() || txtContra.getPassword().length == 0) {

            cmdRegistrar.setText("Salir");
        } else {
            cmdRegistrar.setText("Registrar");
        }
    }
}
