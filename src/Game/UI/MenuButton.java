package Game.UI;

import Game.Theme;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuButton extends JButton {

    private boolean selected = false;

    // Large button (Player vs Player, Player vs Computer, Play)
    public MenuButton(String text) {
        this(text, false);
    }

    // Small button (Difficulty buttons)
    public MenuButton(String text, boolean small) {

        super(text);

        if (small) {
            setFont(Theme.BUTTON_FONT.deriveFont(17f));

            setPreferredSize(new Dimension(115, 36));
            setMaximumSize(new Dimension(115, 36));
            setMinimumSize(new Dimension(115, 36));

            setMargin(new Insets(0, 0, 0, 0));
        } else {
            setFont(Theme.BUTTON_FONT);
            setPreferredSize(new Dimension(430, 80));
            setMaximumSize(new Dimension(430, 80));
            setMinimumSize(new Dimension(430, 80));
        }

        setFocusPainted(false);

        setCursor(new Cursor(Cursor.HAND_CURSOR));

        setBackground(Theme.BUTTON);

        setForeground(Theme.BUTTON_TEXT);

        setBorder(new LineBorder(Theme.BUTTON_BORDER, 4));

        setAlignmentX(Component.CENTER_ALIGNMENT);

        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {

                if (!selected) {
                    setBackground(Theme.BUTTON_HOVER);
                }

            }

            @Override
            public void mouseExited(MouseEvent e) {

                if (!selected) {
                    setBackground(Theme.BUTTON);
                }

            }

        });

    }

    public void setSelectedButton(boolean selected) {

        this.selected = selected;

        if (selected) {

            setBorder(new LineBorder(Theme.TITLE, 3));
            setBackground(Theme.BUTTON_HOVER);

        } else {

            setBorder(new LineBorder(Theme.TEXT, 2));
            setBackground(Theme.BUTTON);

        }

    }

}