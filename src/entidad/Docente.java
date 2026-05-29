package entidad;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Docente {	
		private int idDocente;
		private String nombres;
		private String apellidos;
		private LocalDate fechaNacimiento;
		private LocalDate fechaIngreso;
		private String dni;
		private String direccion;
		private String estado;

	}

