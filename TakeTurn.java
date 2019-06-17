package Ships;

public class TakeTurn implements Command {
	ShipsParent theShip;
	
	public TakeTurn(ShipsParent masterShip){
		theShip = masterShip;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		theShip.takeTurn();
	}
	@Override
	public void undo(int num) {
		// TODO Auto-generated method stub
		theShip.UndoTurn(num);
	}

}
