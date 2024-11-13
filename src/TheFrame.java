import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TheFrame extends JFrame implements ActionListener {

    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("File");
    JMenu helpMenu = new JMenu("Help");
    JMenuItem newItem = new JMenuItem("Player vs Player");
    JMenuItem trainingItem = new JMenuItem("Player vs Computer");
    JMenuItem exitItem = new JMenuItem("Exit");
    JMenuItem helpItem = new JMenuItem("Help");
    TicTacToe ticTacToe;

    public TheFrame() {

        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        fileMenu.add(newItem);
        fileMenu.add(trainingItem);
        fileMenu.add(exitItem);
        helpMenu.add(helpItem);
        newItem.addActionListener(this);
        trainingItem.addActionListener(this);
        exitItem.addActionListener(this);
        helpItem.addActionListener(this);

        ticTacToe = new TicTacToe();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("TicTacToe The Game");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img.png")));
        this.add(ticTacToe);
        this.setSize(600, 600);
        this.setJMenuBar(menuBar);
        this.setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==newItem) {
            this.remove(ticTacToe);
            ticTacToe = new TicTacToe();
            ticTacToe.player_vs_player = true;
            this.add(ticTacToe);
            SwingUtilities.updateComponentTreeUI(this);
        }
        if(e.getSource()==trainingItem) {
            this.remove(ticTacToe);
            ticTacToe = new TicTacToe();
            ticTacToe.player_vs_player = false;
            this.add(ticTacToe);
            SwingUtilities.updateComponentTreeUI(this);
        }
        if(e.getSource()==exitItem) {
            System.exit(0);
        }
        if(e.getSource()==helpItem) {
            System.out.println("Help is on the way");
        }
    }
}
