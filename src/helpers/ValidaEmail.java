package helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidaEmail {

    public boolean verificaEmail(String correo) {
        Pattern patron = Pattern.compile("^[_a-z0-9-\\+]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9]+)*(\\.[a-z]{2,})$");

        Matcher mat = patron.matcher(correo);
        return mat.find();
    }
}

