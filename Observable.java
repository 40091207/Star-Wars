package Ships;

public interface Observable {
	public void registerObserver(ShipsParent enemyship);
	public void removeObserver(ShipsParent enemyship);
	public void notifyObservers();
}
