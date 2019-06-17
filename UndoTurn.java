package Ships;

public class UndoTurn implements Command {
	ShipsParent theShip;

	
	public UndoTurn(ShipsParent newShip){
		theShip = newShip;
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
