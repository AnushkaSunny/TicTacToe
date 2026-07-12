package Game.UI;

import Game.Theme;
import Game.logic.Difficulty;
import Game.logic.GameMode;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PlayerSetupScreen extends JFrame {

    private JTextField player1Field;
    private JTextField player2Field;

    private MenuButton startButton;

    private GameMode gameMode;
    private Difficulty difficulty;

    public PlayerSetupScreen(GameMode mode, Difficulty difficulty) {

        this.gameMode = mode;
        this.difficulty = difficulty;

        initializeUI();

    }

    private void initializeUI() {

        setTitle("Player Setup");

        setSize(550,550);

        setResizable(false);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(Theme.BACKGROUND);

        JPanel mainPanel = new JPanel();

        mainPanel.setBackground(Theme.BACKGROUND);

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        mainPanel.setBorder(new EmptyBorder(30,40,30,40));



        //---------------- TITLE ----------------//

        JLabel title = new JLabel("PLAYER SETUP");

        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        title.setForeground(Theme.TITLE);

        title.setFont(Theme.TITLE_FONT);

        mainPanel.add(title);

        mainPanel.add(Box.createRigidArea(new Dimension(0,40)));



        //---------------- PLAYER 1 ----------------//

        JLabel p1 = new JLabel("Player 1");

        p1.setForeground(Theme.TEXT);

        p1.setFont(Theme.BUTTON_FONT);

        p1.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainPanel.add(p1);

        mainPanel.add(Box.createRigidArea(new Dimension(0,10)));



        player1Field = new JTextField();

        player1Field.setMaximumSize(new Dimension(300,40));

        player1Field.setFont(Theme.BUTTON_FONT);

        player1Field.setHorizontalAlignment(JTextField.CENTER);

        mainPanel.add(player1Field);

        mainPanel.add(Box.createRigidArea(new Dimension(0,30)));



        //---------------- PLAYER 2 ----------------//

        JLabel p2 = new JLabel();

        if(gameMode == GameMode.PLAYER_VS_PLAYER){

            p2.setText("Player 2");

        }
        else{

            p2.setText("Computer");

        }

        p2.setForeground(Theme.TEXT);

        p2.setFont(Theme.BUTTON_FONT);

        p2.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainPanel.add(p2);

        mainPanel.add(Box.createRigidArea(new Dimension(0,10)));



        player2Field = new JTextField();

        player2Field.setMaximumSize(new Dimension(300,40));

        player2Field.setFont(Theme.BUTTON_FONT);

        player2Field.setHorizontalAlignment(JTextField.CENTER);



        if(gameMode == GameMode.PLAYER_VS_COMPUTER){

            player2Field.setText("Computer");

            player2Field.setEditable(false);

        }

        mainPanel.add(player2Field);

        mainPanel.add(Box.createVerticalGlue());



        //---------------- START BUTTON ----------------//

        startButton = new MenuButton("START");

        startButton.addActionListener(e -> {

            String player1 = player1Field.getText().trim();

            String player2 = player2Field.getText().trim();

            if(player1.isEmpty()){

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter Player 1's name."
                );

                return;

            }

            if(gameMode == GameMode.PLAYER_VS_PLAYER && player2.isEmpty()){

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter Player 2's name."
                );

                return;

            }

            new GameScreen(
                    gameMode,
                    difficulty,
                    player1,
                    player2
            );

            dispose();

        });

        mainPanel.add(startButton);

        add(mainPanel);

        setVisible(true);

    }

}