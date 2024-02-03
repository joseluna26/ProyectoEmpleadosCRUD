package helpers;

import java.awt.Font;

public class FontManager {
    private static final Font DEFAULT_FONT = new Font("Arial", Font.PLAIN, 15); // Definir la fuente por defecto

    /***
     *  Establece el tpio de fuente del proyecto
     * @param fuente
     * @return la fuente el tamaño y si es negrita o normal
     */

    public static Font getDefaultFont() {
        return DEFAULT_FONT;
    }

    public static Font getCustomFont(int size) {
        return new Font("Arial", Font.PLAIN, size);
    }

    public static Font fontNeg(int size) {
        return new Font("Arial", Font.BOLD, size);
    }
}
