package Ships;

public interface Command {
	public void execute();
	public void undo(int num);
}
