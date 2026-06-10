package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidad.Docente;
import model.DocenteModel;
import util.ValidateUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.util.List;
import java.awt.event.KeyEvent;

public class FrmConsultaDocente extends JFrame implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtDNI;
	private JTextField txtDireccion;
	private JTable table;
	private JButton btnFiltrar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultaDocente frame = new FrmConsultaDocente();
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
	public FrmConsultaDocente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Consulta de Docente");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(248, 31, 211, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setBounds(37, 73, 57, 14);
		contentPane.add(lblNombre);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDni.setBounds(248, 74, 57, 14);
		contentPane.add(lblDni);
		
		JLabel lblDireccion = new JLabel("Dirección:");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDireccion.setBounds(430, 74, 70, 14);
		contentPane.add(lblDireccion);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(90, 71, 148, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtDNI = new JTextField();
		txtDNI.addKeyListener(this);
		txtDNI.setColumns(10);
		txtDNI.setBounds(283, 71, 137, 20);
		contentPane.add(txtDNI);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(500, 71, 148, 20);
		contentPane.add(txtDireccion);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(this);
		btnFiltrar.setBounds(231, 178, 89, 23);
		contentPane.add(btnFiltrar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(350, 178, 89, 23);
		contentPane.add(btnCancelar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 215, 650, 183);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				    "Código", "Nombres", "Apellidos", "DNI", "Dirección", "Estado"
				}
		));
		scrollPane.setViewportView(table);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			do_btnCancelar_actionPerformed(e);
		}
		if (e.getSource() == btnFiltrar) {
			do_btnFiltrar_actionPerformed(e);
		}
	}
	protected void do_btnFiltrar_actionPerformed(ActionEvent e) {

	    String nombre = txtNombre.getText().trim();
	    String dni = txtDNI.getText().trim();
	    String direccion = txtDireccion.getText().trim();

	    // Validar nombre antes de consultar
	    if (!nombre.isEmpty() &&
	        !nombre.matches(ValidateUtil.NOMBRE_MAYUSCULA)) {

	        JOptionPane.showMessageDialog(this,
	                "El nombre debe iniciar con mayúscula y contener solo letras");

	        txtNombre.requestFocus();
	        return;
	    }

	    DocenteModel objDocenteModel = new DocenteModel();

	    List<Docente> lista =
	            objDocenteModel.listaDocente(
	                    nombre,
	                    dni,
	                    direccion);

	    DefaultTableModel model =
	            (DefaultTableModel) table.getModel();

	    model.setRowCount(0);

	    if(lista.isEmpty()) {

	        if(!direccion.isEmpty()) {
	            JOptionPane.showMessageDialog(this,
	                    "No existe ningún docente con esa dirección");
	        }
	        else if(!dni.isEmpty()) {
	            JOptionPane.showMessageDialog(this,
	                    "No existe ningún docente con ese DNI");
	        }
	        else if(!nombre.isEmpty()) {
	            JOptionPane.showMessageDialog(this,
	                    "No existe ningún docente con ese nombre");
	        }
	        else {
	            JOptionPane.showMessageDialog(this,
	                    "No se encontraron registros");
	        }

	        return;
	    }

	    for (Docente d : lista) {

	        Object[] rowData = {
	                d.getIdDocente(),
	                d.getNombres(),
	                d.getApellidos(),
	                d.getDni(),
	                d.getDireccion(),
	                d.getEstado()
	        };

	        model.addRow(rowData);
	    }

	    JOptionPane.showMessageDialog(this,
	            "Se encontraron " + lista.size() + " docente(s)");
	}
	protected void do_btnCancelar_actionPerformed(ActionEvent e) {

	    txtNombre.setText("");
	    txtDNI.setText("");
	    txtDireccion.setText("");

	    DefaultTableModel model =
	            (DefaultTableModel) table.getModel();

	    model.setRowCount(0);
	}
			public void keyPressed(KeyEvent e) {

			}
			public void keyReleased(KeyEvent e) {
				if (e.getSource() == txtDNI) {
					do_txtDni_keyReleased(e);
				}
			}
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				System.out.println("Tecla presionada: keyPressed " + c);
				//Si es letra no ingresa
				if (Character.isLetter(c)) {
					e.consume(); // Ignorar la letra
				}
				//Si se ingresa más 8 dígitos digitos
				if (Character.isDigit(c) && txtDNI.getText().length() >= 8) {
					e.consume(); // Ignorar el dígito si ya hay 8
				}
			}
			protected void do_txtDni_keyReleased(KeyEvent e) {
			}
		}