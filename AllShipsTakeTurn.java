package Ships;

import java.util.List;

public class AllShipsTakeTurn implements Command {

	List<ShipsParent> theShips;
	
	public AllShipsTakeTurn(List<ShipsParent> enemyShipsList){
		theShips = enemyShipsList;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		for(ShipsParent ship : theShips ){
			ship.takeTurn();
		}
	}

	@Override
	public void undo(int num) {
		// TODO Auto-generated method stub
		for(ShipsParent ship : theShips ){
			ship.UndoTurn(num);
		}
	}

}
