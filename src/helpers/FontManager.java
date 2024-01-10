package helpers;

import java.awt.Font;

public class FontManager {
    private static final Font DEFAULT_FONT = new Font("Arial", Font.PLAIN, 15); // Definir la fuente por defecto

    public static Font getDefaultFont() {
        return DEFAULT_FONT;
    }

    public static Font getCustomFont(int size) {
        return new Font("Arial", Font.PLAIN, size);
    }
}
