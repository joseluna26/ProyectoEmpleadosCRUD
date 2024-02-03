package screens;

import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import db.repositorys.EmpleadoRepository;
import db.repositorys.GeneroRepository;
import helpers.FontManager;
import helpers.ValidaEmail;
import models.Empleado;
import models.Genero;

public class FrmEmpleados extends JFrame {

    EmpleadoRepository empleadoRepository = new EmpleadoRepository();
    GeneroRepository generoRepository = new GeneroRepository();

    JLabel lblTitulo, lblEmpleados, lblNombre, lblDomicilio, lblTelefono, lblEmail, lblFechaNac, lblGenero, lblAviso;
    JTextField txtEmpleados, txtNombre, txtDomicilio, txtTelefono, txtEmail, txtFechaNac, txtGenero;
    JComboBox<Integer> cboNumEmp;
    JComboBox<String> cboGenero;
    JCalendar calFechaNac;
    JButton cmdBuscar, cmdGuardar, cmdModificar, cmdEliminar, cmdLimpiar;
    JDateChooser dateChooser;

    JMenuBar barraMenu;
    JMenu mnuArchivo;
    JMenuItem miSalir;

    public FrmEmpleados() {

        // Ventana
        super("Control de Empleados");
        setSize(600, 500);
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

        Font customFont = FontManager.getCustomFont(18);

        barraMenu = new JMenuBar();
        setJMenuBar(barraMenu);
        mnuArchivo = new JMenu("Arhivo");
        miSalir = new JMenuItem("Salir");
        barraMenu.add(mnuArchivo);
        mnuArchivo.add(miSalir);

        miSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == miSalir) {
                    FrmLogin frmLogin = new FrmLogin();
                    frmLogin.setVisible(true);
                    dispose();
                }
            }
        });

        lblTitulo = new JLabel("Empleados", SwingConstants.CENTER);
        lblTitulo.setBounds(0, 12, 600, 20);
        lblTitulo.setFont(customFont);
        panel.add(lblTitulo);

        lblEmpleados = new JLabel("# Empleado:", SwingConstants.LEFT);
        lblEmpleados.setBounds(93, 68, 300, 20);
        lblEmpleados.setFont(customFont);
        panel.add(lblEmpleados);

        cboNumEmp = new JComboBox<>();
        cboNumEmp.setBounds(210, 63, 120, 30);
        cboNumEmp.setFont(customFont);
        panel.add(cboNumEmp);
        // llenacombo();

        cmdBuscar = new JButton("Buscar");
        cmdBuscar.setBounds(340, 63, 112, 30);
        cmdBuscar.setFont(customFont);
        panel.add(cmdBuscar);
        
        cmdBuscar.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Empleado em = empleadoRepository.recuperarId(Long.parseLong(cboNumEmp.getSelectedItem().toString()));
                cmdModificar.setEnabled(true);
                cmdEliminar.setEnabled(true);
                cmdGuardar.setEnabled(false);
                llenarCamposEmpleado(em);
            }
        });

        lblNombre = new JLabel("Nombre:", SwingConstants.LEFT);
        lblNombre.setBounds(125, 109, 300, 30);
        lblNombre.setFont(customFont);
        panel.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(210, 111, 245, 30);
        txtNombre.setFont(customFont);
        panel.add(txtNombre);

        txtNombre.setToolTipText("Sólo letras");

        // Agregar KeyListener a txtNombre
        txtNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!validaNombre(txtNombre.getText().trim())){
                    JOptionPane.showMessageDialog(null, "El nombre solo\nDebe contener letras", "Error de Captura!", JOptionPane.ERROR_MESSAGE);
                } else{
                cambiarFoco("txtNombre");
                }
            }
        });

        lblDomicilio = new JLabel("Domicilio:", SwingConstants.LEFT);
        lblDomicilio.setBounds(115, 161, 300, 20);
        lblDomicilio.setFont(customFont);
        panel.add(lblDomicilio);

        txtDomicilio = new JTextField();
        txtDomicilio.setBounds(210, 158, 245, 28);
        txtDomicilio.setFont(customFont);
        panel.add(txtDomicilio);

        txtDomicilio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarFoco("txtDomicilio");
            }
        });

        lblTelefono = new JLabel("Teléfono:", SwingConstants.LEFT);
        lblTelefono.setBounds(116, 202, 300, 20);
        lblTelefono.setFont(customFont);
        panel.add(lblTelefono);
        
        txtTelefono = new JTextField();
        txtTelefono.setBounds(210, 200, 245, 28);
        txtTelefono.setFont(customFont);
        panel.add(txtTelefono);
        txtTelefono.setToolTipText("Sólo números");

        
        txtTelefono.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!validaTelefono(txtTelefono.getText().trim())){
                    JOptionPane.showMessageDialog(null, "Teléfono No Válido\nDeben ser 10 dígitos", "Error de Captura!", JOptionPane.ERROR_MESSAGE);
                } else{
                    cambiarFoco("txtTelefono");
                };
            }
        });

        lblEmail = new JLabel("Email:", SwingConstants.LEFT);
        lblEmail.setBounds(144, 245, 300, 20);
        lblEmail.setFont(customFont);
        panel.add(lblEmail);

        lblAviso = new JLabel("Email no Válido");
        lblAviso.setBounds(455, 245, 300, 20);
        lblAviso.setForeground(new java.awt.Color(255, 51, 51));
        Font fontMensaje = FontManager.getCustomFont(14);
        lblAviso.setFont(fontMensaje);
        lblAviso.setVisible(false);
        panel.add(lblAviso);

        txtEmail = new JTextField();
        txtEmail.setBounds(210, 243, 245, 28);
        txtEmail.setFont(customFont);
        panel.add(txtEmail);

        txtEmail.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                ValidaEmail checaemail = new ValidaEmail();
                if (e.getKeyChar() == '\n') {

                    if (checaemail.verificaEmail(txtEmail.getText())) {
                        lblAviso.setVisible(false);
                        dateChooser.requestFocus();
                    } else {
                        lblAviso.setVisible(true);
                        txtEmail.requestFocus();
                    }
                }
            }
        });

        lblFechaNac = new JLabel("Fecha de Nacimiento:", SwingConstants.LEFT);
        lblFechaNac.setBounds(19, 292, 300, 20);
        lblFechaNac.setFont(customFont);
        panel.add(lblFechaNac);

        dateChooser = new JDateChooser(new Date());
        dateChooser.setBounds(210, 288, 245, 30);
        dateChooser.setFont(customFont);
        panel.add(dateChooser);

        lblGenero = new JLabel("Género:", SwingConstants.LEFT);
        lblGenero.setBounds(129, 338, 300, 20);
        lblGenero.setFont(customFont);
        panel.add(lblGenero);

        cboGenero = new JComboBox<>();
        cboGenero.setBounds(210, 335, 245, 30);
        cboGenero.setFont(customFont);
        panel.add(cboGenero);

        cmdGuardar = new JButton("Guardar");
        cmdGuardar.setBounds(35, 383, 110, 35);
        cmdGuardar.setFont(customFont);
        panel.add(cmdGuardar);
        llenacombos();

        cmdGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (txtNombre.getText().isEmpty() || txtDomicilio.getText().isEmpty() || txtTelefono.getText().isEmpty() || txtEmail.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Hay campos vacíos, no se insertó el Registro", "Error de captura!",
                            JOptionPane.ERROR_MESSAGE);
                    txtNombre.requestFocus();
                } else {

                java.util.Date utilDate = dateChooser.getDate();
                java.sql.Date fecha = new java.sql.Date(utilDate.getTime());
                Genero g = generoRepository.recuperarId((long) cboGenero.getSelectedIndex() + 1);
                Empleado em = new Empleado(null, txtNombre.getText(), txtDomicilio.getText(), txtTelefono.getText(),
                        txtEmail.getText(), fecha, g);
                // System.out.println(em.getGenero().getNombre());
                empleadoRepository.agregar(em);
                llenacombos();
                }
            }
        });

        cmdModificar = new JButton("Modificar");
        cmdModificar.setBounds(165, 383, 110, 35);
        cmdModificar.setFont(customFont);
        panel.add(cmdModificar);

        cmdModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer idcombo = (cboNumEmp.getSelectedIndex() + 1);

                java.util.Date utilDate = dateChooser.getDate();
                java.sql.Date fecha = new java.sql.Date(utilDate.getTime());
                Genero g = generoRepository.recuperarId((long) cboGenero.getSelectedIndex() + 1);
                Empleado em = new Empleado(idcombo, txtNombre.getText(), txtDomicilio.getText(), txtTelefono.getText(),
                        txtEmail.getText(), fecha, g);
                empleadoRepository.modificar(em);
            }
        });

        cmdEliminar = new JButton("Eliminar");
        cmdEliminar.setBounds(295, 383, 110, 35);
        cmdEliminar.setFont(customFont);
        panel.add(cmdEliminar);

        cmdEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Empleado em = empleadoRepository.recuperarId(Long.parseLong(cboNumEmp.getSelectedItem().toString()));
                empleadoRepository.eliminar(em);
                llenacombos();
            }
        });

        cmdLimpiar = new JButton("Limpiar");
        cmdLimpiar.setBounds(427, 383, 110, 35);
        cmdLimpiar.setFont(customFont);
        panel.add(cmdLimpiar);

        // Limpiar todas las cajas de texto
        cmdLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarControles(panel);
                llenacombos(); // actualiza combo de numEmp

                cmdModificar.setEnabled(false);
                cmdEliminar.setEnabled(false);
                cmdGuardar.setEnabled(true);
                lblAviso.setVisible(false);
            }
        });

        cmdGuardar.setEnabled(true);
        cmdModificar.setEnabled(false);
        cmdEliminar.setEnabled(false);

    } // Fin controles

    private void cambiarFoco(String nomcontrol) {
        switch (nomcontrol) {
            case "txtNombre":
                txtDomicilio.requestFocus();
                break;
            case "txtDomicilio":
                txtTelefono.requestFocus();
                break;
            case "txtTelefono":
                txtEmail.requestFocus();
                break;
            case "txtEmail":
                dateChooser.requestFocus();
                break;
            case "dateChooser":
                cboGenero.requestFocus();
                break;
            default:
                break;
        }
    }

    private void llenarCamposEmpleado(Empleado em) {
        txtNombre.setText(em.getNombre());
        txtDomicilio.setText(em.getDomicilio());
        txtTelefono.setText(em.getTelefono());
        txtEmail.setText(em.getEmail());
        dateChooser.setDate(em.getFechaNacimiento());
    }

    private void limpiarControles(Container panel) {
        JTextField caja;
        // JDateChooser factual = new JDateChooser();
        for (int i = 0; i < panel.getComponentCount(); i++) {
            if (panel.getComponent(i).getClass().getName().equals("javax.swing.JTextField")) {
                caja = (JTextField) panel.getComponent(i);
                caja.setText(null);
            }
        }
        // Pone la fecha actual en el dateChooser
        LocalDate fechaActual = LocalDate.now();
        Date fechaActualDate = java.sql.Date.valueOf(fechaActual);
        dateChooser.setDate(fechaActualDate);
        cboGenero.setSelectedIndex(0);
        txtNombre.requestFocus();
    }

    private void llenacombos() {
        cboNumEmp.removeAllItems();
        List<Empleado> listaEmp = empleadoRepository.recuperarTodos();
        for (Empleado empleado : listaEmp) {
            cboNumEmp.addItem(empleado.getId());
        }

        cboGenero.removeAllItems();
        List<Genero> listaGen = generoRepository.recuperarTodos();
        for (Genero genero : listaGen) {
            cboGenero.addItem(genero.getNombre());
        }
    }

    public static boolean validaNombre(String nombre){
        return nombre.matches("^[A-Za-záéíóúÁÉÍÓÚñÑ ]*$");
    }

    public static boolean validaTelefono(String telefono){
        return telefono.matches("^[0-9]{10}$");
    }

} // Fin frmEmpleados
