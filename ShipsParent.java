package Ships;

public abstract class ShipsParent {
	public abstract String getDescription();
	public abstract int getPosition();
	public abstract void takeTurn();
	public abstract void UndoTurn(int number);
	public abstract void setPosition(int i);
	public abstract void setStrategy(OperationalModeStrategy strategy);
	public abstract void update(int position);
	public abstract void registerObserver(ShipsParent ship);
	public abstract void removeObserver(ShipsParent enemyship);
	public abstract void notifyObservers();
	//public abstract void setNews();
	
	
}
