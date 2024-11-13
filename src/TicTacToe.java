import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe extends JPanel implements ActionListener {

    Random random = new Random();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];

    boolean player1_turn;
    boolean player_vs_player = true;
    boolean win = false;

    public TicTacToe() {

        textfield.setBackground(new Color(255, 238, 190));
        textfield.setForeground(Color.BLACK);
        textfield.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);
        title_panel.add(textfield);

        button_panel.setLayout(new GridLayout(3,3));

        for(int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setBackground(Color.white);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        this.setLayout(new BorderLayout());
        this.add(title_panel, BorderLayout.NORTH);
        this.add(button_panel);
        setVisible(true);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i = 0; i < 9; i++) {
            if(e.getSource()==buttons[i]) {
                if(player1_turn) {
                    if(buttons[i].getText()=="") {
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        textfield.setText("O turn");
                        check();
                        if(!player_vs_player) {
                            boolean security = security();
                            if(security && !win) {
                                int temp = random.nextInt(9);
                                if((temp == i) || (buttons[temp].getText()!="")) {
                                    do {
                                        temp = random.nextInt(9);
                                    } while((temp == i) || (buttons[temp].getText()!=""));
                                }
                                buttons[temp].setForeground(new Color(0,0,255));
                                buttons[temp].setText("O");
                                player1_turn = true;
                                textfield.setText("X turn");
                            } else {
                                textfield.setText("draw");
                            }
                            check();
                        }
                    }
                }
                else {
                    if(buttons[i].getText()=="") {
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        player1_turn = true;
                        textfield.setText("X turn");
                        check();
                        if(!player_vs_player) {
                            boolean security = security();
                            if(security && !win) {

                                int temp = random.nextInt(9);
                                if((temp == i) || (buttons[temp].getText()!="")) {
                                    do {
                                        temp = random.nextInt(9);
                                    } while((temp == i) || (buttons[temp].getText()!=""));
                                }
                                buttons[temp].setForeground(new Color(255,0,0));
                                buttons[temp].setText("X");
                                player1_turn = false;
                                textfield.setText("O turn");
                            } else {
                                textfield.setText("draw");
                            }
                            check();
                        }
                    }
                }
            }
        }
    }

    public void firstTurn() {

        if(random.nextInt(2)==0) {
            player1_turn = true;
            textfield.setText("X turn");
        }
        else {
            player1_turn = false;
            textfield.setText("O turn");
        }
    }

    public void check() {
        //check for a draw
        boolean security = security();
        if(!security) {
            textfield.setText("draw");
            for(int i = 0; i < 9; i++) {
                buttons[i].setEnabled(false);
            }
        }
        //check X win conditions
        if((buttons[0].getText()=="X") && (buttons[1].getText()=="X") && (buttons[2].getText()=="X")) {
            xWins(0,1,2);
            win = true;
        }
        if((buttons[3].getText()=="X") && (buttons[4].getText()=="X") && (buttons[5].getText()=="X")) {
            xWins(3,4,5);
            win = true;
        }
        if((buttons[6].getText()=="X") && (buttons[7].getText()=="X") && (buttons[8].getText()=="X")) {
            xWins(6,7,8);
            win = true;
        }
        if((buttons[0].getText()=="X") && (buttons[3].getText()=="X") && (buttons[6].getText()=="X")) {
            xWins(0,3,6);
            win = true;
        }
        if((buttons[1].getText()=="X") && (buttons[4].getText()=="X") && (buttons[7].getText()=="X")) {
            xWins(1,4,7);
            win = true;
        }
        if((buttons[2].getText()=="X") && (buttons[5].getText()=="X") && (buttons[8].getText()=="X")) {
            xWins(2,5,8);
            win = true;
        }
        if((buttons[0].getText()=="X") && (buttons[4].getText()=="X") && (buttons[8].getText()=="X")) {
            xWins(0,4,8);
            win = true;
        }
        if((buttons[2].getText()=="X") && (buttons[4].getText()=="X") && (buttons[6].getText()=="X")) {
            xWins(2,4,6);
            win = true;
        }
        //check O win conditions
        if((buttons[0].getText()=="O") && (buttons[1].getText()=="O") && (buttons[2].getText()=="O")) {
            oWins(0,1,2);
            win = true;
        }
        if((buttons[3].getText()=="O") && (buttons[4].getText()=="O") && (buttons[5].getText()=="O")) {
            oWins(3,4,5);
            win = true;
        }
        if((buttons[6].getText()=="O") && (buttons[7].getText()=="O") && (buttons[8].getText()=="O")) {
            oWins(6,7,8);
            win = true;
        }
        if((buttons[0].getText()=="O") && (buttons[3].getText()=="O") && (buttons[6].getText()=="O")) {
            oWins(0,3,6);
            win = true;
        }
        if((buttons[1].getText()=="O") && (buttons[4].getText()=="O") && (buttons[7].getText()=="O")) {
            oWins(1,4,7);
            win = true;
        }
        if((buttons[2].getText()=="O") && (buttons[5].getText()=="O") && (buttons[8].getText()=="O")) {
            oWins(2,5,8);
            win = true;
        }
        if((buttons[0].getText()=="O") && (buttons[4].getText()=="O") && (buttons[8].getText()=="O")) {
            oWins(0,4,8);
            win = true;
        }
        if((buttons[2].getText()=="O") && (buttons[4].getText()=="O") && (buttons[6].getText()=="O")) {
            oWins(2,4,6);
            win = true;
        }
    }

    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(Color.ORANGE);
        buttons[b].setBackground(Color.ORANGE);
        buttons[c].setBackground(Color.ORANGE);

        for(int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }

        textfield.setText("X wins");
    }

    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(Color.ORANGE);
        buttons[b].setBackground(Color.ORANGE);
        buttons[c].setBackground(Color.ORANGE);

        for(int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }

        textfield.setText("O wins");
    }

    public boolean security() {
        boolean check = false;
        for(int i = 0; i < 9; i++) {
            if(buttons[i].getText()=="") {
                check = true;
            }
        }
        return check;
    }
}
