package Validacion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    /**
     * 
     * @param nif String Nif que vamoa a validar
     * @return true si el nif es válido
     *         false si el nif es inválido
     */
	public static boolean validarNIF(String nif) {

		final String NIFX = "[0-9]{8}[A-Za-z]";
		final String NIEX = "^[X-Zx-z][0-9]{7}[A-Za-z]$";

		char letra = nif.charAt(0);
		String[] NIF = { "T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H",
				"L", "C", "K", "E" };
		if (letra != 'x' && letra != 'y' && letra != 'z' && letra != 'X' && letra != 'Y' && letra != 'Z') {
			if (!nif.matches(NIFX)) {
				return false;
			}
			int num = Integer.parseInt(nif.substring(0, 8));
			String numF = nif.substring(8);
			if (NIF[num % 23].equals(numF.toUpperCase())) {
				return true;
			} else {
				return false;
			}
		} else if (letra == 'x' || letra == 'y' || letra == 'z' || letra == 'X' || letra == 'Y' || letra == 'Z') {
			if (!nif.matches(NIEX)) {
				return false;
			}
			int num = Integer.parseInt(nif.substring(1, 8));
			char LET1 = nif.charAt(0);
			String LET2 = nif.substring(8);
			if (LET1 == 'x' || LET1 == 'X') {
				if (NIF[num % 23].equals(LET2.toUpperCase())) {
					return true;
				} else {
					return false;
				}
			} else if (LET1 == 'y' || LET1 == 'Y') {
				num = num + 10000000;
				if (NIF[num % 23].equals(LET2.toUpperCase())) {
					return true;
				} else {
					return false;
				}
			} else if (LET1 == 'z' || LET1 == 'Z') {
				num = num + 20000000;
				if (NIF[num % 23].equals(LET2.toUpperCase())) {
					return true;
				} else {
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * 
	 * @param email String con el correo electrónico
	 * @return true si el correo es correcto y válido
	 *         false si el correo no es correcto o es inválido 
	 */
	public static boolean validateEmail(String email) {
	   final String EMAIL_REGEX = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b";
	   final Pattern pattern = Pattern.compile(EMAIL_REGEX);
		
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	/**
	 * 
	 * @param tfno Número de teléfono pasado como parámetro
	 * @return true si el teléfono es válido<br>
	 *         false si el teléfono no es correcto
	 */
	public static boolean validarTfno(String tfno) {
		final String TELEFONO= "^(\\+34|0034|34)?[89]\\d{8}$";
		Pattern pattern = Pattern.compile(TELEFONO);
		
		Matcher matcher=pattern.matcher(tfno);
		return matcher.matches();
	}
 
	/**
	 * 
	 * @param codigoOperario Número de operario formato OPXXXX 
	 * @return true si el codigo del operario es válido<br>
	 *         false si el código del operario no es correcto
	 */	
    public static boolean validarCodigoOperario(String codigoOperario) {
        Pattern pattern = Pattern.compile("OP\\d{4}");
        Matcher matcher = pattern.matcher(codigoOperario);
        return matcher.matches();
    }
}