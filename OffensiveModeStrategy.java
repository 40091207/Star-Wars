package Ships;

import java.util.List;

public class OffensiveModeStrategy implements OperationalModeStrategy {

	@Override
	public String getStrategy(int MasterPOS) {
		int Total = 0;
		List<ShipsParent> EnemyShipsList2 = StarWarsJFrame.EnemyShipsList;
		//EnemyShipsList2.remove(0);
		
		for(ShipsParent i : EnemyShipsList2)  {
			if(i.getPosition() == MasterPOS){
				Total = Total +1;
			}
		}
		if (Total > 3){
			return "loss";
		}
		return "survive";
	}

}
