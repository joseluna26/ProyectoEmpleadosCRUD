package screens;

import java.awt.Font;
import java.awt.Image;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import helpers.FontManager;

public class FraEmpleados extends JFrame{

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

        Font customFont = FontManager.getCustomFont(18);

        lblTitulo = new JLabel("Empleados", SwingConstants.CENTER);
        lblTitulo.setBounds(0, 12, 600, 20);
        lblTitulo.setFont(customFont);
        add(lblTitulo);

        lblEmpleados = new JLabel("# Empleado:", SwingConstants.LEFT);
        lblEmpleados.setBounds(93, 68, 300, 20);
        lblEmpleados.setFont(customFont);
        add(lblEmpleados);
        
        cboNumEmp = new JComboBox<>();
        cboNumEmp.setBounds(210, 63, 120, 30);
        cboNumEmp.setFont(customFont);
        add(cboNumEmp);
        
        cmdBuscar = new JButton("Buscar");
        cmdBuscar.setBounds(340, 63, 112, 30);
        cmdBuscar.setFont(customFont);
        add(cmdBuscar);

        lblNombre = new JLabel("Nombre:", SwingConstants.LEFT);
        lblNombre.setBounds(125, 109, 300, 30);
        lblNombre.setFont(customFont);
        add(lblNombre);
        
        txtNombre = new JTextField();
        txtNombre.setBounds(210, 111, 245, 30);
        txtNombre.setFont(customFont);
        add(txtNombre);

        lblDomicilio = new JLabel("Domicilio:", SwingConstants.LEFT);
        lblDomicilio.setBounds(115, 161, 300, 20);
        lblDomicilio.setFont(customFont);
        add(lblDomicilio);
        
        txtDomicilio = new JTextField();
        txtDomicilio.setBounds(210, 158, 245, 28);
        txtDomicilio.setFont(customFont);
        add(txtDomicilio);

        lblTelefono = new JLabel("Teléfono:", SwingConstants.LEFT);
        lblTelefono.setBounds(116, 202, 300, 20);
        lblTelefono.setFont(customFont);
        add(lblTelefono);
        
        txtTelefono = new JTextField();
        txtTelefono.setBounds(210, 200, 245, 28);
        txtTelefono.setFont(customFont);
        add(txtTelefono);

        lblEmail = new JLabel("Email:", SwingConstants.LEFT);
        lblEmail.setBounds(144, 245, 300, 20);
        lblEmail.setFont(customFont);
        add(lblEmail);
        
        txtEmail = new JTextField();
        txtEmail.setBounds(210, 243, 245, 28);
        txtEmail.setFont(customFont);
        add(txtEmail);
        
        lblFechaNac = new JLabel("Fecha de Nacimiento:", SwingConstants.LEFT);
        lblFechaNac.setBounds(19, 292, 300, 20);
        lblFechaNac.setFont(customFont);
        add(lblFechaNac);
        
        dateChooser = new JDateChooser(new Date());
        dateChooser.setBounds(210, 288, 245, 30);
        dateChooser.setFont(customFont);
        add(dateChooser);
        
        lblGenero = new JLabel("Género:", SwingConstants.LEFT);
        lblGenero.setBounds(129, 338, 300, 20);
        lblGenero.setFont(customFont);
        add(lblGenero);
        
        cboGenero = new JComboBox<>();
        cboGenero.setBounds(210, 335, 245, 30);
        cboGenero.setFont(customFont);
        add(cboGenero);

        cmdGuardar = new JButton("Guardar");
        cmdGuardar.setBounds(35, 383, 110, 35);
        cmdGuardar.setFont(customFont);
        add(cmdGuardar);
        
        cmdModificar = new JButton("Modificar");
        cmdModificar.setBounds(165, 383, 110, 35);
        cmdModificar.setFont(customFont);
        add(cmdModificar);
        
        cmdEliminar = new JButton("Eliminar");
        cmdEliminar.setBounds(295, 383, 110, 35);
        cmdEliminar.setFont(customFont);
        add(cmdEliminar);
        
        cmdLimpiar = new JButton("Limpiar");
        cmdLimpiar.setBounds(427, 383, 110, 35);
        cmdLimpiar.setFont(customFont);
        add(cmdLimpiar);




    }


}
