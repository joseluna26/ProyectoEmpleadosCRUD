package helpers;

import org.mindrot.jbcrypt.BCrypt;

public class Password {

    public static String encriptar(String pass) {

        String passencriptada = BCrypt.hashpw(pass, BCrypt.gensalt());

        return passencriptada;
    }


    public boolean checapass(String cadena, String passencriptada) {

        if (BCrypt.checkpw(cadena, passencriptada)) {

            System.out.println("Coincidencia exacta!");
            return true;
        } else {
            System.out.println("No son iguales");
            return false;
        }
    }

}
