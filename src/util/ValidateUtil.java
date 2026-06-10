package util;

public class ValidateUtil {
	public static final String NOMBRES = "[A-Za-záéíóúÁÉÍÓÚñÑüÜ ]{2,40}";
	public static final String NOMBRE_MAYUSCULA = "[A-ZÁÉÍÓÚÑ][a-zA-ZáéíóúÁÉÍÓÚñÑ ]*";
	public static final String APELLIDOS = "[A-Za-záéíóúÁÉÍÓÚñÑüÜ ]{2,40}";
	public static final String DNI = "\\d{8}";
	public static final String DIRECCION = "[A-Za-z0-9áéíóúÁÉÍÓÚñÑ#.,\\- ]{5,100}";
	public static final String DATE_YYYY_MM_DD = "((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])";

}
