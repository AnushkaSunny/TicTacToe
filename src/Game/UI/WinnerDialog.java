package Game.UI;

import Game.Theme;

import javax.swing.*;
import java.awt.*;

public class WinnerDialog extends JDialog {

    public WinnerDialog(JFrame parent, String message) {

        super(parent, "Game Over", true);

        setSize(450,220);

        setLocationRelativeTo(parent);

        getContentPane().setBackground(Theme.BACKGROUND);

        setLayout(new BorderLayout());

        JLabel label = new JLabel(message);

        label.setHorizontalAlignment(SwingConstants.CENTER);

        label.setFont(Theme.TITLE_FONT);

        label.setForeground(Theme.TITLE);

        add(label, BorderLayout.CENTER);

        JButton okButton = new JButton("OK");

        okButton.setFont(Theme.BUTTON_FONT);

        okButton.setBackground(Theme.BUTTON);

        okButton.setForeground(Theme.TEXT);

        okButton.setFocusPainted(false);

        okButton.addActionListener(e -> dispose());

        JPanel panel = new JPanel();

        panel.setBackground(Theme.BACKGROUND);

        panel.add(okButton);

        add(panel, BorderLayout.SOUTH);

    }

}