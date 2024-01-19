package screens;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import db.repositorys.EmpleadoRepository;
import db.repositorys.GeneroRepository;
import helpers.FontManager;
import models.Empleado;
import models.Genero;

public class FraEmpleados extends JFrame {

    JLabel lblTitulo, lblEmpleados, lblNombre, lblDomicilio, lblTelefono, lblEmail, lblFechaNac, lblGenero;
    JTextField txtEmpleados, txtNombre, txtDomicilio, txtTelefono, txtEmail, txtFechaNac, txtGenero;
    JComboBox<Integer> cboNumEmp;
    JComboBox<String> cboGenero;
    JCalendar calFechaNac;
    JButton cmdBuscar, cmdGuardar, cmdModificar, cmdEliminar, cmdLimpiar;
    JDateChooser dateChooser;

    public FraEmpleados() {

        // Ventana
        super("Control de Empleados");
        setSize(600, 500);
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        EmpleadoRepository empleadoRepository = new EmpleadoRepository();
        List<Empleado> listaEmp = empleadoRepository.recuperarTodos();
        for (Empleado empleado : listaEmp) {
        cboNumEmp.addItem(empleado.getId());
        }

        cmdBuscar = new JButton("Buscar");
        cmdBuscar.setBounds(340, 63, 112, 30);
        cmdBuscar.setFont(customFont);
        panel.add(cmdBuscar);

        lblNombre = new JLabel("Nombre:", SwingConstants.LEFT);
        lblNombre.setBounds(125, 109, 300, 30);
        lblNombre.setFont(customFont);
        panel.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(210, 111, 245, 30);
        txtNombre.setFont(customFont);
        panel.add(txtNombre);

        // Agregar KeyListener a txtNombre
        txtNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarFoco("txtNombre");
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

        txtTelefono.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarFoco("txtTelefono");
            }
        });

        lblEmail = new JLabel("Email:", SwingConstants.LEFT);
        lblEmail.setBounds(144, 245, 300, 20);
        lblEmail.setFont(customFont);
        panel.add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(210, 243, 245, 28);
        txtEmail.setFont(customFont);
        panel.add(txtEmail);

        txtEmail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarFoco("txtEmail");
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

        GeneroRepository generoRepository = new GeneroRepository();
        List<Genero> listaGen = generoRepository.recuperarTodos();
        for (Genero genero : listaGen) {
        cboGenero.addItem(genero.getNombre());
        }

        cmdGuardar = new JButton("Guardar");
        cmdGuardar.setBounds(35, 383, 110, 35);
        cmdGuardar.setFont(customFont);
        panel.add(cmdGuardar);

        cmdGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmpleadoRepository empleadoRepository = new EmpleadoRepository();
                GeneroRepository generoRepository = new GeneroRepository();
                Genero g = generoRepository.recuperarId(1L);
                Empleado em = new Empleado(null, txtNombre.getText(), txtDomicilio.getText(), txtTelefono.getText(),
                        txtEmail.getText(), null, g);
                empleadoRepository.agregar(em);
            }
        });

        cmdModificar = new JButton("Modificar");
        cmdModificar.setBounds(165, 383, 110, 35);
        cmdModificar.setFont(customFont);
        panel.add(cmdModificar);

        cmdEliminar = new JButton("Eliminar");
        cmdEliminar.setBounds(295, 383, 110, 35);
        cmdEliminar.setFont(customFont);
        panel.add(cmdEliminar);

        cmdLimpiar = new JButton("Limpiar");
        cmdLimpiar.setBounds(427, 383, 110, 35);
        cmdLimpiar.setFont(customFont);
        panel.add(cmdLimpiar);

        // Limpiar todas las cajas de texto
        cmdLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JTextField caja;
                for (int i = 0; i < panel.getComponentCount(); i++) {
                    if (panel.getComponent(i).getClass().getName().equals("javax.swing.JTextField")) {
                        caja = (JTextField) panel.getComponent(i);
                        caja.setText(null);
                    }
                }
                txtNombre.requestFocus();
            }
        });

        // cmdGuardar.setEnabled(false);
        // cmdModificar.setEnabled(false);
        // cmdEliminar.setEnabled(false);

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
} // Fin fraEmpleados
