package Ships;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class BattleStar extends ShipsParent implements Observer, DisplayElement {
	
	List<Integer> PosHistory = new ArrayList<Integer>();
	private int position;
	private int MasterShipPos;
	
	public BattleStar(){
		this.setPosition(0);
	}
	
	public void takeTurn(){ 
		int newPOS;
		PosHistory.add(0 , this.position);
		newPOS = StarWarsJFrame.MoveLogic(this.position);
		this.position = newPOS;
	}
	@Override
	public void UndoTurn(int num) {
		
		if(num >= this.PosHistory.size()){
			if(this.PosHistory.isEmpty()){
				return;
			} else {
				num = this.PosHistory.size();
			}
		}
		this.position = PosHistory.get(num -1);
	}
	
	@Override
	public String getDescription() {
		return "BattleStar";
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public void update(int masterShipPos) {
		// TODO Auto-generated method stub
		this.MasterShipPos = masterShipPos;
		if(this.position == this.MasterShipPos){
			StarWarsJFrame.RemoveShip(this);
			display();
		}
	}

	@Override
	public void display() {	}
	@Override
	public void setStrategy(OperationalModeStrategy strategy) {	}
	@Override
	public void registerObserver(ShipsParent ship) {}
	@Override
	public void removeObserver(ShipsParent enemyship){}
	@Override
	public void notifyObservers() {	}


}
