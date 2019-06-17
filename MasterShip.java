package Ships;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class MasterShip extends ShipsParent implements Observable{

	List<ShipsParent> EnemyShipsList = new ArrayList<ShipsParent>();
	
	List<Integer> PosHistory = new ArrayList<Integer>();
	
	private static int position;
	private static MasterShip instance = null;
	private OperationalModeStrategy strategy;
	private String news;
	
	private MasterShip(int position, OperationalModeStrategy strategy) {
		this.setPosition(position);
		this.setStrategy(strategy);
	}

	public static synchronized MasterShip getInstance(int position, OperationalModeStrategy strategy) {
		if(instance == null) instance = new MasterShip(position, strategy);
		return instance;
	}
	
	public void takeTurn(){
		int newPOS;
		PosHistory.add(0 , this.position);
		newPOS = StarWarsJFrame.MoveLogic(MasterShip.position);
		MasterShip.position = newPOS;
		String WinLoss = strategy.getStrategy(MasterShip.position);
		
		if(WinLoss == "loss"){
			StarWarsJFrame.ClearList();
			JOptionPane.showMessageDialog(null, "The MasterShip has been destroyed");
		}
		
	}
	
	public OperationalModeStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(OperationalModeStrategy strategy) {
		this.strategy = strategy;
	}

	public String getDescription() 
	{
		return "MasterShip";
	}


	public int getPosition() {
		return position;
	}


	public void setPosition(int position) {
		MasterShip.position = position;
	}


	@Override
	public void UndoTurn(int num) {
		
		if(num >= this.PosHistory.size()){
			num = this.PosHistory.size();
		}
		this.position = PosHistory.get(num -1);
	}

	@Override
	public void registerObserver(ShipsParent enemyship) {
		this.EnemyShipsList.add(enemyship);
	}

	@Override
	public void removeObserver(ShipsParent enemyship) {
		this.EnemyShipsList.remove(enemyship);
	}

	@Override
	public void notifyObservers() {
		for(ShipsParent enemyship : this.EnemyShipsList) {
			enemyship.update(this.position);
		}
	}
	

	@Override
	public void update(int position) {
		// TODO Auto-generated method stub
		
	}

}
