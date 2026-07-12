package Game;

import java.awt.*;
import java.io.InputStream;

public class Theme {

    //==========================
    // COLORS
    //==========================

    // Main Background
    public static final Color BACKGROUND = new Color(5, 5, 5);

    // Panels
    public static final Color PANEL = new Color(10, 10, 10);

    // Tic Tac Toe Board
    public static final Color BOARD = new Color(15, 15, 15);

    // Buttons
    public static final Color BUTTON = new Color(20,20,20);

    public static final Color BUTTON_HOVER = new Color(255,20,147);

    public static final Color BUTTON_BORDER = new Color(255,20,147);

    public static final Color BUTTON_TEXT = Color.WHITE;

    // Text Fields
    public static final Color TEXTFIELD = new Color(0, 0, 0);

    // Text
    public static final Color TEXT = Color.WHITE;

    // Neon Colors
    public static final Color TITLE = new Color(0, 255, 255);

    public static final Color X_COLOR = new Color(57, 255, 20);

    public static final Color O_COLOR = new Color(255, 20, 147);

    public static final Color WIN_COLOR = new Color(255, 215, 0);

    //==========================
    // FONTS
    //==========================

    public static Font TITLE_FONT;

    public static Font BUTTON_FONT;

    public static Font CELL_FONT;

    public static Font STATUS_FONT;

    static {

        try {

            Font arcadeFont = Font.createFont(
                    Font.TRUETYPE_FONT,
                    new java.io.File("src/Game/assets/fonts/PressStart2P-Regular.ttf")
            );
            TITLE_FONT = arcadeFont.deriveFont(Font.PLAIN, 30f);

            BUTTON_FONT = arcadeFont.deriveFont(Font.PLAIN, 18f);

            STATUS_FONT = arcadeFont.deriveFont(Font.PLAIN, 18f);

            CELL_FONT = arcadeFont.deriveFont(Font.PLAIN, 58f);

        }

        catch (Exception e) {

            e.printStackTrace();

            TITLE_FONT = new Font("Arial Black", Font.BOLD, 30);

            BUTTON_FONT = new Font("Arial", Font.BOLD, 18);

            STATUS_FONT = new Font("Arial", Font.BOLD, 18);

            CELL_FONT = new Font("Arial Black", Font.BOLD, 70);

        }

    }

}