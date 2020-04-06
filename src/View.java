// Tiancheng Dong (2471036)

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

// This is the main class contains the GUI and main method
public class View extends JFrame {
	private Model model;
	// add instance variables
	private JLabel balanceLabel;
	private JLabel info;
	private JLabel finish;
	private JPanel[] cards;
	private JLabel[] cardsLabel;
	private JButton spin;
	private JButton newGame;
	
	// main class that 
	public View() {
		// display the GUI
		initGUI();
	}
	
	// This method contains all components for FruitMachine
	private void initGUI() {
		// the standard JFrame information
		setTitle("Fruitmachine GUI");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(130, 50);
		setResizable(false);
		setLayout(null);
		// create a container object that can contain components
		Container c = getContentPane();
		
		// set font style
		Font f = new Font("Times New Roman", Font.PLAIN, 20);
		
		// create balance text with JLabel and set location
		balanceLabel = new JLabel("balance is 100");
		balanceLabel.setBounds(30, 20, 200, 30);
		balanceLabel.setFont(f);
		// add balance text to the container
		c.add(balanceLabel);
		
		// create information text with JLabel and set location
		info = new JLabel("welcome!");
		info.setBounds(30, 80, 300, 30);
		info.setFont(f);
		// add information text to the container
		c.add(info);
		
		// create finish text with JLabel and set location
		finish = new JLabel("");
		finish.setBounds(30, 140, 300, 30);
		finish.setFont(f);
		// add finish text to the container
		c.add(finish);
		
		// Create a black border object 
		Border blackLine = BorderFactory.createLineBorder(Color.BLACK);
		// initialize cards with JPanel and JLabel
		cards = new JPanel[3];
		cardsLabel = new JLabel[3];
		
		for (int i = 0; i < 3; i++) {
			cards[i] = new JPanel(new BorderLayout());
			cards[i].setBackground(Color.YELLOW);
			cards[i].setBounds(30 + i * 90, 200, 70, 120);
			cardsLabel[i] = new JLabel("", SwingConstants.CENTER);
			cardsLabel[i].setFont(f);
			cards[i].setBorder(blackLine);
			cards[i].add(cardsLabel[i]);
			c.add(cards[i]);
		}
		initCards();
		
		// Create spin button and set attributes
		spin = new JButton("spin");
		spin.setFont(f);
		spin.setBounds(360, 230, 140, 30);
		c.add(spin);
		
		// Create new game button and set attributes
		newGame = new JButton("new game");
		newGame.setFont(f);
		newGame.setBounds(360, 270, 140, 30);
		newGame.setEnabled(false);
		c.add(newGame);
		
		setVisible(true);
	}
	
	public void initCards() {
		String[] cardName = {"King", "Queen", "Jack"};
		for(int i = 0; i < 3; i++) {
			cardsLabel[i].setText(cardName[i]);
		}
	}
	
	public JButton getSpin() {
		return spin;
	}
	
	public JButton getNewGame() {
		return newGame;
	}
	
	public void updateBalance(String balanceInfo) {
		balanceLabel.setText(balanceInfo);
	}
	
	public void updateCards(String[] cards) {
		for (int i = 0; i < 3; i++) {
			cardsLabel[i].setText(cards[i]);
		}
	}
	
	public void updateFinfish(String finishInfo) {
		finish.setText(finishInfo);
	}
	
	public void setInfo(String infoText) {
		info.setText(infoText);
	}
	
	public void setSpinEnabled() {
		spin.setEnabled(true);
	}
	
	public void setSpinDisabled() {
		spin.setEnabled(false);
	}
	
	public void setNewEnabled() {
		newGame.setEnabled(true);
	}
	
	public void setNewDisabled() {
		newGame.setEnabled(false);
	}
}
