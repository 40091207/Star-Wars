package Ships;

import java.util.Random;

public class ShipFactory {
	public static ShipsParent getShip(String criteria)
	  {
	    if ( criteria.equals("MasterShip") )
	    {
	
	    	Random rand = new Random();
			int  n = rand.nextInt(15) + 2;
	      	return (ShipsParent) MasterShip.getInstance(n, new DefensiveModeStrategy() );
	    }
	    else if ( criteria.equals("BattleStar") )
	      return new BattleStar();
	    else if ( criteria.equals("BattleCruiser") )
	      return new BattleCruiser();
	    else if ( criteria.equals("BattleShooter") )
		      return new BattleShooter();

	    return null;
	  }
}
