package Game.UI;

import Game.Theme;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BoardCell extends JButton {

    public BoardCell() {

        setFont(Theme.CELL_FONT);

        setBackground(Theme.BOARD);

        setForeground(Theme.TEXT);

        setFocusPainted(false);

        setBorder(new LineBorder(Theme.TITLE, 3));

        setCursor(new Cursor(Cursor.HAND_CURSOR));

        setContentAreaFilled(true);

        setOpaque(true);

        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {

                if (isEnabled()) {

                    setBackground(Theme.BUTTON_HOVER);

                }

            }

            @Override
            public void mouseExited(MouseEvent e) {

                if (isEnabled()) {

                    setBackground(Theme.BOARD);

                }

            }

        });

    }

}