package Ships;

public class Invoker {
	Command theCommand;
 
	public Invoker(Command newCommand){
		theCommand = newCommand;
	}
	
	public void press(){
		theCommand.execute();
	}
	
	public void pressUndo(int num){
		theCommand.undo(num);
	}
}
