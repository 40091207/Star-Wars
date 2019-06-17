package Ships;

import java.util.List;

public class DefensiveModeStrategy implements OperationalModeStrategy {

	public String getStrategy(int MasterPOS) {
		int Total = 0;
		List<ShipsParent> EnemyShipsList = StarWarsJFrame.EnemyShipsList;
		//EnemyShipsList.remove(0);
		
		for(ShipsParent i : EnemyShipsList)  {
			if(i.getPosition() == MasterPOS){
				Total = Total +1;
			}
		}
		if (Total > 2){
			return "loss";
		}
		return "survive";
	}

}
