package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidad.Docente;
import model.DocenteModel;
import util.ValidateUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class FrmRegistraDocente extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtFechaNacimiento;
	private JTextField txtFechaIngreso;
	private JTextField txtDNI;
	private JTextField txtDireccion;
	private JComboBox cmbEstado;
	private JButton btnRegistrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistraDocente frame = new FrmRegistraDocente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmRegistraDocente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 346, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistrarDocente = new JLabel("Registrar Docente");
		lblRegistrarDocente.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRegistrarDocente.setBounds(92, 28, 142, 27);
		contentPane.add(lblRegistrarDocente);
		
		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombres.setBounds(40, 77, 94, 20);
		contentPane.add(lblNombres);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblApellidos.setBounds(40, 108, 94, 20);
		contentPane.add(lblApellidos);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento:");
		lblFechaNacimiento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFechaNacimiento.setBounds(40, 139, 142, 20);
		contentPane.add(lblFechaNacimiento);
		
		JLabel lblFechaIngreso = new JLabel("Fecha Ingreso:");
		lblFechaIngreso.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFechaIngreso.setBounds(40, 174, 122, 20);
		contentPane.add(lblFechaIngreso);
		
		JLabel lblDireccion = new JLabel("Dirección:");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDireccion.setBounds(40, 236, 94, 20);
		contentPane.add(lblDireccion);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDni.setBounds(40, 205, 94, 20);
		contentPane.add(lblDni);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEstado.setBounds(40, 267, 94, 20);
		contentPane.add(lblEstado);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(125, 78, 167, 20);
		contentPane.add(txtNombres);
		txtNombres.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(125, 108, 167, 20);
		contentPane.add(txtApellidos);
		
		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setColumns(10);
		txtFechaNacimiento.setBounds(154, 140, 139, 20);
		contentPane.add(txtFechaNacimiento);
		
		txtFechaIngreso = new JTextField();
		txtFechaIngreso.setColumns(10);
		txtFechaIngreso.setBounds(154, 175, 139, 20);
		contentPane.add(txtFechaIngreso);
		
		txtDNI = new JTextField();
		txtDNI.setColumns(10);
		txtDNI.setBounds(92, 205, 122, 20);
		contentPane.add(txtDNI);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(111, 237, 182, 20);
		contentPane.add(txtDireccion);
		
		cmbEstado = new JComboBox();
		cmbEstado.setModel(new DefaultComboBoxModel(new String[] {"Activo", "Inactivo", "Suspendido"}));
		cmbEstado.setBounds(111, 267, 103, 22);
		contentPane.add(cmbEstado);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(198, 315, 94, 23);
		contentPane.add(btnRegistrar);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrar) {
			do_btnRegistrar_actionPerformed(e);
		}
	}
	protected void do_btnRegistrar_actionPerformed(ActionEvent e) {
		//1 Recibir los datos del formulario en String
		String nombres = txtNombres.getText().trim();
		String apellidos = txtApellidos.getText().trim();
		String fechaNacimiento = txtFechaNacimiento.getText().trim();
		String fechaIngreso = txtFechaIngreso.getText().trim();
		String dni = txtDNI.getText().trim();
		String direccion = txtDireccion.getText().trim();
		String estado = cmbEstado.getSelectedItem().toString();
		
		//2 Validar los datos (opcional)
		if (nombres.matches(ValidateUtil.NOMBRES) == false) {
			JOptionPane.showMessageDialog(this,
					"Los nombres deben tener entre 2 y 40 letras");
			return;
		}
		if (apellidos.matches(ValidateUtil.APELLIDOS) == false) {
			JOptionPane.showMessageDialog(this, "Los apellidos deben tener entre 2 y 40 letras");
			return;
		}
		if (dni.matches(ValidateUtil.DNI) == false) {
			JOptionPane.showMessageDialog(this, "El DNI debe tener 8 dígitos");
			return;
		}
		if (direccion.matches(ValidateUtil.DIRECCION) == false) {
			JOptionPane.showMessageDialog(this, "La dirección debe tener entre 5 y 100 caracteres");
			return;
		}
		if (fechaNacimiento.matches(ValidateUtil.DATE_YYYY_MM_DD) == false) {
			JOptionPane.showMessageDialog(this, "La fecha de nacimiento debe tener formato YYYY-MM-DD");
			return;
		}
		if (fechaIngreso.matches(ValidateUtil.DATE_YYYY_MM_DD) == false) {
			JOptionPane.showMessageDialog(this, "La fecha de ingreso debe tener formato YYYY-MM-DD");
			return;
		}
		LocalDate fn = LocalDate.parse(fechaNacimiento);
		LocalDate fi = LocalDate.parse(fechaIngreso);

		if(fn.isAfter(LocalDate.now())) {
			JOptionPane.showMessageDialog(this, "La fecha de nacimiento no puede ser futura");
			return;
		}
		if(fi.isAfter(LocalDate.now())) {
			JOptionPane.showMessageDialog(this, "La fecha de ingreso no puede ser futura");
			return;
		}

		if(fi.isBefore(fn)) {
			JOptionPane.showMessageDialog(this, "La fecha de ingreso no puede ser menor a la fecha de nacimiento");
			return;
		}
		//3 Crear el objeto Alumno
		Docente obj = new Docente();
		obj.setNombres(nombres);
		obj.setApellidos(apellidos);
		obj.setFechaNacimiento(java.time.LocalDate.parse(fechaNacimiento));
		obj.setFechaIngreso(java.time.LocalDate.parse(fechaIngreso));
		obj.setDni(dni);
		obj.setDireccion(direccion);
		obj.setEstado(estado);
		
		//4 Crear el objeto AlumnoModel
		DocenteModel model = new DocenteModel();
		int salida = model.insertaDocente(obj);
		
		//5 Mostrar el resultado
		if (salida > 0) {
			JOptionPane.showMessageDialog(this, "Docente registrado correctamente");
		} else {
			JOptionPane.showMessageDialog(this, "Error al registrar el docente");
		}
		
	
}
	
}
