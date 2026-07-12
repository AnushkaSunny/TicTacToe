package Game.UI;

import Game.*;
import Game.logic.Difficulty;
import Game.logic.GameEngine;
import Game.logic.GameMode;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GameScreen extends JFrame {

    private final GameEngine engine;

    private final String playerXName;
    private final String playerOName;

    private JLabel statusLabel;

    private JPanel boardPanel;

    private JPanel bottomPanel;

    private MenuButton restartButton;

    private MenuButton menuButton;

    private BoardCell[][] cells;

    public GameScreen(GameMode mode,
                      Difficulty difficulty,
                      String playerXName,
                      String playerOName) {

        this.playerXName = playerXName;
        this.playerOName = playerOName;

        engine = new GameEngine(mode, difficulty);

        initializeUI();

        registerListeners();

        updateStatus();

    }

    private void initializeUI() {

        setTitle("Tic Tac Toe");

        setSize(720, 720);

        setResizable(false);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(Theme.BACKGROUND);

        setLayout(new BorderLayout(15,15));

        //---------------- TITLE ----------------//

        JLabel title = new JLabel("TIC TAC TOE");

        title.setHorizontalAlignment(SwingConstants.CENTER);

        title.setFont(Theme.TITLE_FONT);

        title.setForeground(Theme.TITLE);

        title.setBorder(new EmptyBorder(20,0,10,0));

        add(title, BorderLayout.NORTH);

        //---------------- CENTER PANEL ----------------//

        JPanel centerPanel = new JPanel();

        centerPanel.setBackground(Theme.BACKGROUND);

        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        statusLabel = new JLabel();

        statusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        statusLabel.setForeground(Theme.TEXT);

        statusLabel.setFont(Theme.STATUS_FONT);

        centerPanel.add(statusLabel);

        centerPanel.add(Box.createRigidArea(new Dimension(0,20)));

        boardPanel = new JPanel();

        boardPanel.setBackground(Theme.BACKGROUND);

        boardPanel.setLayout(new GridLayout(3,3,10,10));

        cells = new BoardCell[3][3];

        for(int row=0; row<3; row++){

            for(int col=0; col<3; col++){

                cells[row][col] = new BoardCell();

                boardPanel.add(cells[row][col]);

            }

        }

        centerPanel.add(boardPanel);

        add(centerPanel, BorderLayout.CENTER);

        //---------------- BOTTOM PANEL ----------------//

        bottomPanel = new JPanel();

        bottomPanel.setBackground(Theme.BACKGROUND);

        bottomPanel.setBorder(new EmptyBorder(10,25,20,25));

        bottomPanel.setLayout(new GridLayout(1,2,20,0));

        restartButton = new MenuButton("RESTART");

        menuButton = new MenuButton("MAIN MENU");

        bottomPanel.add(restartButton);

        bottomPanel.add(menuButton);

        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);

    }

    private void registerListeners() {

        for (int row = 0; row < 3; row++) {

            for (int col = 0; col < 3; col++) {

                int r = row;
                int c = col;

                cells[row][col].addActionListener(e -> handleMove(r, c));

            }

        }

        restartButton.addActionListener(e -> restartGame());

        menuButton.addActionListener(e -> {

            int option = JOptionPane.showConfirmDialog(
                    this,
                    "Return to the Main Menu?\nCurrent game will be lost.",
                    "Main Menu",
                    JOptionPane.YES_NO_OPTION
            );

            if (option == JOptionPane.YES_OPTION) {

                new HomeScreen();

                dispose();

            }

        });

    }

    private void handleMove(int row, int col) {

        if (!engine.makeMove(row, col)) {

            return;

        }

        updateBoard();

        if (engine.getGameMode() == GameMode.PLAYER_VS_COMPUTER
                && engine.getWinner() == ' '
                && !engine.isBoardFull()
                && engine.getCurrentPlayer() == 'O') {

            engine.computerMove();

            updateBoard();

        }

        if (engine.isBoardFull()) {

            disableBoard();

            new WinnerDialog(this,"It's a Draw!").setVisible(true);

            return;

        }

        if (engine.getWinner() != ' ') {

            disableBoard();

            String winnerName =
                    engine.getWinner() == 'X'
                            ? playerXName
                            : playerOName;

            new WinnerDialog(
                    this,
                    winnerName + " Wins!"
            ).setVisible(true);

            return;

        }

        updateBoard();

        updateStatus();

    }

    private void updateBoard() {

        for (int row = 0; row < 3; row++) {

            for (int col = 0; col < 3; col++) {

                char value = engine.getCell(row,col);

                if(value==' ') continue;

                cells[row][col].setText(String.valueOf(value));

                cells[row][col].setEnabled(false);

                if(value=='X'){

                    cells[row][col].setForeground(Theme.X_COLOR);

                }else{

                    cells[row][col].setForeground(Theme.O_COLOR);

                }

            }

        }

    }

    private void updateStatus() {

        if(engine.getCurrentPlayer()=='X'){

            statusLabel.setText(playerXName + "'s Turn (X)");

        }else{

            statusLabel.setText(playerOName + "'s Turn (O)");

        }

    }

    private void disableBoard() {

        for(int row=0;row<3;row++){

            for(int col=0;col<3;col++){

                cells[row][col].setEnabled(false);

            }

        }

    }

    private void restartGame() {

        engine.resetGame();

        updateStatus();

        for(int row=0;row<3;row++){

            for(int col=0;col<3;col++){

                cells[row][col].setText("");

                cells[row][col].setEnabled(true);

                cells[row][col].setForeground(Theme.TEXT);

                cells[row][col].setBackground(Theme.BOARD);

            }

        }

    }

}