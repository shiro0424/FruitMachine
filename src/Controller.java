import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
	private View view;
	private Model model;
	
	public Controller(View view, Model model) {
		this.view = view;
		this.model = model;
		
		initController();
	}
	
	public void initController() {
		view.getSpin().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				spin();
			}
		});
		
		view.getNewGame().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newGame();
			}
		});
	}
	
	public void spin() {
		String[] cards = model.getRandomCards();
		view.updateCards(cards);
		
		String info = model.getInfo(cards);
		view.setInfo(info);
		
		int balance = model.getBalance();
		String finishInfo = "";
		if(balance < 0) {
			finishInfo = "You lose";
			view.setSpinDisabled();
			view.setNewEnabled();
			view.updateFinfish(finishInfo);
		} else if(balance >= 150) {
			finishInfo = "You win!";
			view.setSpinDisabled();
			view.setNewEnabled();
			view.updateFinfish(finishInfo);
		}
		
		setBalanceInfo();
	}
	
	public void newGame() {
		model = new Model();
		view.initCards();
		setBalanceInfo();
		view.setSpinEnabled();
		view.setNewDisabled();
	}
	
	public void setBalanceInfo() {
		String balanceInfo = "balance is " + model.getBalance();
		view.updateBalance(balanceInfo);
	}
}
