package Ships;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.awt.event.ActionEvent;

public class StarWarsJFrame extends JFrame {

	private JPanel contentPane;
	//private static Image image = Toolkit.getDefaultToolkit().getImage("MasterShip.png");
	boolean imageDisplayed = false;
	int Turn = 1;
	static List<ShipsParent> EnemyShipsList = new ArrayList<ShipsParent>();
	
	
	
	ImageIcon BlankSky = new ImageIcon("Sky.png");
	ImageIcon BlackHole = new ImageIcon("BlackHole.png");
	ImageIcon MasterShipimg = new ImageIcon("MasterShip.png");
	ImageIcon BattleCruiserimg = new ImageIcon("BattleCruiser.png");
	ImageIcon BattleShooterimg = new ImageIcon("BattleShooter.png");
	ImageIcon BattleStarimg = new ImageIcon("BattleStar.png");
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public StarWarsJFrame() {
		ShipsParent MasterShip =  ShipFactory.getShip("MasterShip");
		EnemyShipsList.add(MasterShip);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(343, 24, 181, 283);
		contentPane.add(textPane);
		
		JLabel blackholelbl = new JLabel("");
		blackholelbl.setBounds(49, 107, 50, 50);
		contentPane.add(blackholelbl);
		blackholelbl.setIcon(BlackHole);
		
		JLabel lblPos1 = new JLabel("");
		lblPos1.setBounds(99, 107, 50, 50);
		contentPane.add(lblPos1);
		lblPos1.setIcon(BlankSky);
		
		JLabel lblPos2 = new JLabel("");
		lblPos2.setBounds(149, 107, 50, 50);
		contentPane.add(lblPos2);
		lblPos2.setIcon(BlankSky);
		
		JLabel lblPos3 = new JLabel("");
		lblPos3.setBounds(199, 107, 50, 50);
		contentPane.add(lblPos3);
		lblPos3.setIcon(BlankSky);
		
		JLabel lblPos4 = new JLabel("");
		lblPos4.setBounds(49, 157, 50, 50);
		contentPane.add(lblPos4);
		lblPos4.setIcon(BlankSky);
		
		JLabel lblPos5 = new JLabel("");
		lblPos5.setBounds(99, 157, 50, 50);
		contentPane.add(lblPos5);
		lblPos5.setIcon(BlankSky);
		
		JLabel lblPos6 = new JLabel("");
		lblPos6.setBounds(149, 157, 50, 50);
		contentPane.add(lblPos6);
		lblPos6.setIcon(BlankSky);
		
		JLabel lblPos7 = new JLabel("");
		lblPos7.setBounds(199, 157, 50, 50);
		contentPane.add(lblPos7);
		lblPos7.setIcon(BlankSky);
		
		JLabel lblPos8 = new JLabel("");
		lblPos8.setBounds(49, 207, 50, 50);
		contentPane.add(lblPos8);
		lblPos8.setIcon(BlankSky);
		
		JLabel lblPos9 = new JLabel("");
		lblPos9.setBounds(99, 207, 50, 50);
		contentPane.add(lblPos9);
		lblPos9.setIcon(BlankSky);
		
		JLabel lblPos10 = new JLabel("");
		lblPos10.setBounds(149, 207, 50, 50);
		contentPane.add(lblPos10);
		lblPos10.setIcon(BlankSky);
		
		JLabel lblPos11 = new JLabel("");
		lblPos11.setBounds(199, 207, 50, 50);
		contentPane.add(lblPos11);
		lblPos11.setIcon(BlankSky);
		
		JLabel lblPos12 = new JLabel("");
		lblPos12.setBounds(49, 257, 50, 50);
		contentPane.add(lblPos12);
		lblPos12.setIcon(BlankSky);
		
		JLabel lblPos13 = new JLabel("");
		lblPos13.setBounds(99, 257, 50, 50);
		contentPane.add(lblPos13);
		lblPos13.setIcon(BlankSky);
		
		JLabel lblPos14 = new JLabel("");
		lblPos14.setBounds(149, 257, 50, 50);
		contentPane.add(lblPos14);
		lblPos14.setIcon(BlankSky);
		
		JLabel lblPos15 = new JLabel("");
		lblPos15.setBounds(199, 257, 50, 50);
		contentPane.add(lblPos15);
		lblPos15.setIcon(BlankSky);
		
		JButton btnTakeTurn = new JButton("Take Turn");
		btnTakeTurn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				blackholelbl.setIcon(BlackHole);
				lblPos1.setIcon(BlankSky); lblPos2.setIcon(BlankSky); lblPos3.setIcon(BlankSky); lblPos4.setIcon(BlankSky); lblPos5.setIcon(BlankSky);lblPos6.setIcon(BlankSky);lblPos7.setIcon(BlankSky);lblPos8.setIcon(BlankSky);lblPos9.setIcon(BlankSky);lblPos10.setIcon(BlankSky);
				lblPos11.setIcon(BlankSky); lblPos12.setIcon(BlankSky); lblPos13.setIcon(BlankSky); lblPos14.setIcon(BlankSky); lblPos15.setIcon(BlankSky);
				 
				AllShipsTakeTurn EnemyshipsTakeTurn = new AllShipsTakeTurn(EnemyShipsList);
				Invoker onFullTurn = new Invoker(EnemyshipsTakeTurn);
				onFullTurn.press();
				
				
				
				Random rand = new Random();
				int  n = rand.nextInt(3) + 1;
				if(n == 1){
					int  nn = rand.nextInt(3) + 1;
					if(nn == 1){
						ShipsParent EnemyShip =  ShipFactory.getShip("BattleStar");
						EnemyShipsList.add(EnemyShip);
						MasterShip.registerObserver(EnemyShip);
					}else if(nn == 2 ){
						ShipsParent EnemyShip =  ShipFactory.getShip("BattleCruiser");
						EnemyShipsList.add(EnemyShip);
						MasterShip.registerObserver(EnemyShip);
					}else if (nn == 3){
						ShipsParent EnemyShip =  ShipFactory.getShip("BattleShooter");
						EnemyShipsList.add(EnemyShip);
						MasterShip.registerObserver(EnemyShip);
					}
				}
				
				MasterShip.notifyObservers();
				
				String enemyshipsdesc = "";
				textPane.setText(enemyshipsdesc);
				for(ShipsParent i : EnemyShipsList)  {
					ImageIcon currentshipimage = new ImageIcon("Sky.png");
					enemyshipsdesc = enemyshipsdesc + i.getDescription() + " Position: " + i.getPosition() + "\n";
					textPane.setText(enemyshipsdesc);
					if (i.getDescription() == "BattleStar"){currentshipimage = BattleStarimg;}else if(i.getDescription() == "BattleCruiser"){currentshipimage = BattleCruiserimg;}else if(i.getDescription() == "BattleShooter"){currentshipimage = BattleShooterimg;}else if(i.getDescription() == "MasterShip"){currentshipimage = MasterShipimg;}
					
					if (i.getPosition() == 0){blackholelbl.setIcon(currentshipimage);}else if(i.getPosition() == 1){lblPos1.setIcon(currentshipimage);}else if(i.getPosition() == 2){lblPos2.setIcon(currentshipimage);}else if(i.getPosition() == 3){lblPos3.setIcon(currentshipimage);}else if(i.getPosition() == 4){lblPos4.setIcon(currentshipimage);}else if(i.getPosition() == 5){lblPos5.setIcon(currentshipimage);}
					else if(i.getPosition() == 6){lblPos6.setIcon(currentshipimage);}else if(i.getPosition() == 7){lblPos7.setIcon(currentshipimage);}else if(i.getPosition() == 8){lblPos8.setIcon(currentshipimage);}else if(i.getPosition() == 9){lblPos9.setIcon(currentshipimage);}else if(i.getPosition() == 10){lblPos10.setIcon(currentshipimage);}else if(i.getPosition() == 11){lblPos11.setIcon(currentshipimage);}
					else if(i.getPosition() == 12){lblPos12.setIcon(currentshipimage);}else if(i.getPosition() == 13){lblPos13.setIcon(currentshipimage);}else if(i.getPosition() == 14){lblPos14.setIcon(currentshipimage);}else if(i.getPosition() == 15){lblPos15.setIcon(currentshipimage);}
					
					
				}
				
				if(MasterShip.getPosition() == 1){lblPos1.setIcon(MasterShipimg);}else if(MasterShip.getPosition() == 2){lblPos2.setIcon(MasterShipimg);}else if(MasterShip.getPosition() == 3){lblPos3.setIcon(MasterShipimg);}else if(MasterShip.getPosition() == 4){lblPos4.setIcon(MasterShipimg);}else if(MasterShip.getPosition() == 5){lblPos5.setIcon(MasterShipimg);}
				else if(MasterShip.getPosition() == 6){lblPos6.setIcon(MasterShipimg);}else if(MasterShip.getPosition() == 7){lblPos7.setIcon(MasterShipimg);}else if(MasterShip.getPosition() == 8){lblPos8.setIcon(MasterShipimg);}else if(MasterShip.getPosition() == 9){lblPos9.setIcon(MasterShipimg);}else if(MasterShip.getPosition() == 10){lblPos10.setIcon(MasterShipimg);}else if(MasterShip.getPosition() == 11){lblPos11.setIcon(MasterShipimg);}
				else if(MasterShip.getPosition() == 12){lblPos12.setIcon(MasterShipimg);}else if(MasterShip.getPosition() == 13){lblPos13.setIcon(MasterShipimg);}else if(MasterShip.getPosition() == 14){lblPos14.setIcon(MasterShipimg);}else if(MasterShip.getPosition() == 15){lblPos15.setIcon(MasterShipimg);}
				
				
				
				
			}
		});
		btnTakeTurn.setBounds(106, 25, 89, 23);
		contentPane.add(btnTakeTurn);
		
		JButton btnSwitchMode = new JButton("Offensive Mode");
		btnSwitchMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MasterShip.setStrategy(new OffensiveModeStrategy());
			}
		});
		btnSwitchMode.setBounds(10, 59, 130, 23);
		contentPane.add(btnSwitchMode);
		
		
		JButton button = new JButton("<");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AllShipsTakeTurn EnemyshipsTakeTurn = new AllShipsTakeTurn(EnemyShipsList);
				Invoker onFullTurn = new Invoker(EnemyshipsTakeTurn);
				onFullTurn.pressUndo(Turn);
				Turn++;
				
				blackholelbl.setIcon(BlackHole);lblPos1.setIcon(BlankSky); lblPos2.setIcon(BlankSky); lblPos3.setIcon(BlankSky); lblPos4.setIcon(BlankSky); lblPos5.setIcon(BlankSky);lblPos6.setIcon(BlankSky);lblPos7.setIcon(BlankSky);lblPos8.setIcon(BlankSky);lblPos9.setIcon(BlankSky);lblPos10.setIcon(BlankSky);lblPos11.setIcon(BlankSky); lblPos12.setIcon(BlankSky); lblPos13.setIcon(BlankSky); lblPos14.setIcon(BlankSky); lblPos15.setIcon(BlankSky);
				for(ShipsParent i : EnemyShipsList)  {
					ImageIcon currentshipimage = new ImageIcon("Sky.png");
					if (i.getDescription() == "BattleStar"){currentshipimage = BattleStarimg;}else if(i.getDescription() == "BattleCruiser"){currentshipimage = BattleCruiserimg;}else if(i.getDescription() == "BattleShooter"){currentshipimage = BattleShooterimg;}else if(i.getDescription() == "MasterShip"){currentshipimage = MasterShipimg;}
					
					if (i.getPosition() == 0){blackholelbl.setIcon(currentshipimage);}else if(i.getPosition() == 1){lblPos1.setIcon(currentshipimage);}else if(i.getPosition() == 2){lblPos2.setIcon(currentshipimage);}else if(i.getPosition() == 3){lblPos3.setIcon(currentshipimage);}else if(i.getPosition() == 4){lblPos4.setIcon(currentshipimage);}else if(i.getPosition() == 5){lblPos5.setIcon(currentshipimage);}
					else if(i.getPosition() == 6){lblPos6.setIcon(currentshipimage);}else if(i.getPosition() == 7){lblPos7.setIcon(currentshipimage);}else if(i.getPosition() == 8){lblPos8.setIcon(currentshipimage);}else if(i.getPosition() == 9){lblPos9.setIcon(currentshipimage);}else if(i.getPosition() == 10){lblPos10.setIcon(currentshipimage);}else if(i.getPosition() == 11){lblPos11.setIcon(currentshipimage);}
					else if(i.getPosition() == 12){lblPos12.setIcon(currentshipimage);}else if(i.getPosition() == 13){lblPos13.setIcon(currentshipimage);}else if(i.getPosition() == 14){lblPos14.setIcon(currentshipimage);}else if(i.getPosition() == 15){lblPos15.setIcon(currentshipimage);}
				}
				if(MasterShip.getPosition() == 1){lblPos1.setIcon(MasterShipimg);}else if(MasterShip.getPosition() == 2){lblPos2.setIcon(MasterShipimg);}else if(MasterShip.getPosition() == 3){lblPos3.setIcon(MasterShipimg);}else if(MasterShip.getPosition() == 4){lblPos4.setIcon(MasterShipimg);}else if(MasterShip.getPosition() == 5){lblPos5.setIcon(MasterShipimg);}
				else if(MasterShip.getPosition() == 6){lblPos6.setIcon(MasterShipimg);}else if(MasterShip.getPosition() == 7){lblPos7.setIcon(MasterShipimg);}else if(MasterShip.getPosition() == 8){lblPos8.setIcon(MasterShipimg);}else if(MasterShip.getPosition() == 9){lblPos9.setIcon(MasterShipimg);}else if(MasterShip.getPosition() == 10){lblPos10.setIcon(MasterShipimg);}else if(MasterShip.getPosition() == 11){lblPos11.setIcon(MasterShipimg);}
				else if(MasterShip.getPosition() == 12){lblPos12.setIcon(MasterShipimg);}else if(MasterShip.getPosition() == 13){lblPos13.setIcon(MasterShipimg);}else if(MasterShip.getPosition() == 14){lblPos14.setIcon(MasterShipimg);}else if(MasterShip.getPosition() == 15){lblPos15.setIcon(MasterShipimg);}
				blackholelbl.setIcon(BlackHole);
				List<ShipsParent> toRemove = new ArrayList<ShipsParent>();
				
				for(ShipsParent i : EnemyShipsList)  {
					if(i.getPosition() == 0){
						toRemove.add(i);
					}
				}
				
				EnemyShipsList.removeAll(toRemove);
			}
		});
		button.setBounds(45, 25, 41, 23);
		contentPane.add(button);
		
		JButton btnDefensiveMode = new JButton("Defensive Mode");
		btnDefensiveMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MasterShip.setStrategy(new DefensiveModeStrategy());
			}
		});
		btnDefensiveMode.setBounds(157, 59, 126, 23);
		contentPane.add(btnDefensiveMode);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StarWarsJFrame frame = new StarWarsJFrame();
					frame.setVisible(true);
					frame.setTitle("Star Wars");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void RemoveShip(ShipsParent ship){
		List<ShipsParent> toRemove = new ArrayList<ShipsParent>();
		
		for(ShipsParent i : EnemyShipsList)  {
			if(ship == i){
				toRemove.add(i);
			}
		}
		
		EnemyShipsList.removeAll(toRemove);
	}
	
	public static void ClearList(){
		EnemyShipsList.clear();
		ShipsParent MasterShip = ShipFactory.getShip("MasterShip");
		EnemyShipsList.add(MasterShip);
		
	}
	
	public static int MoveLogic(int currentPos){
		int currentposition  = currentPos;
		Random rand = new Random();
		
		if (currentposition == 6 || currentposition == 9 || currentposition == 10){
			int  n = rand.nextInt(8) + 1;

			if (currentposition == 6 ){if(n == 1){currentPos = 1;} if(n == 2){currentPos = 2;} if(n == 3){currentPos = 3;}if(n == 4){currentPos = 7;}if(n == 5){currentPos = 11;}if(n == 6){currentPos = 10;}if(n == 7){currentPos = 9;}if(n == 8){currentPos = 5;}}
			if (currentposition == 9 ){if(n == 1){currentPos = 4;} if(n == 2){currentPos = 5;} if(n == 3){currentPos = 6;}if(n == 4){currentPos = 8;}if(n == 5){currentPos = 10;}if(n == 6){currentPos = 12;}if(n == 7){currentPos = 13;}if(n == 8){currentPos = 14;}}
			if (currentposition == 10 ){if(n == 1){currentPos = 5;} if(n == 2){currentPos = 6;} if(n == 3){currentPos = 7;}if(n == 4){currentPos = 9;}if(n == 5){currentPos = 11;}if(n == 6){currentPos = 13;}if(n == 7){currentPos = 14;}if(n == 8){currentPos = 15;}}
			
		}else if(currentposition == 2 || currentposition == 7 || currentposition == 8 || currentposition == 11 || currentposition == 13 || currentposition == 14){
			int  n = rand.nextInt(5) + 1;
			
			if (currentposition == 2 ){if(n == 1){currentPos = 1;} if(n == 2){currentPos = 5;} if(n == 3){currentPos = 6;}if(n == 4){currentPos = 7;}if(n == 5){currentPos = 3;}}
			if (currentposition == 7 ){if(n == 1){currentPos = 3;} if(n == 2){currentPos = 2;} if(n == 3){currentPos = 6;}if(n == 4){currentPos = 10;}if(n == 5){currentPos = 11;}}
			if (currentposition == 8 ){if(n == 1){currentPos = 4;} if(n == 2){currentPos = 5;} if(n == 3){currentPos = 9;}if(n == 4){currentPos = 13;}if(n == 5){currentPos = 12;}}
			if (currentposition == 11 ){if(n == 1){currentPos = 7;} if(n == 2){currentPos = 6;} if(n == 3){currentPos = 10;}if(n == 4){currentPos = 14;}if(n == 5){currentPos = 15;}}
			if (currentposition == 13 ){if(n == 1){currentPos = 12;} if(n == 2){currentPos = 8;} if(n == 3){currentPos = 9;}if(n == 4){currentPos = 10;}if(n == 5){currentPos = 14;}}
			if (currentposition == 14 ){if(n == 1){currentPos = 13;} if(n == 2){currentPos = 9;} if(n == 3){currentPos = 10;}if(n == 4){currentPos = 11;}if(n == 5){currentPos = 15;}}
			
		}else if(currentposition == 0 || currentposition == 3 || currentposition == 12 || currentposition == 15){
			int  n = rand.nextInt(3) + 1;
			
			if (currentposition == 0 ){if(n == 1){currentPos = 1;} if(n == 2){currentPos = 5;} if(n == 3){currentPos = 4;}}
			if (currentposition == 3 ){if(n == 1){currentPos = 2;} if(n == 2){currentPos = 6;} if(n == 3){currentPos = 7;}}
			if (currentposition == 12 ){if(n == 1){currentPos = 8;} if(n == 2){currentPos = 9;} if(n == 3){currentPos = 13;}}
			if (currentposition == 15 ){if(n == 1){currentPos = 14;} if(n == 2){currentPos = 10;} if(n == 3){currentPos = 11;}}
			
		}else if(currentposition == 1 || currentposition == 4){
			int  n = rand.nextInt(4) + 1;
			
			if (currentposition == 1 ){if(n == 1){currentPos = 2;} if(n == 2){currentPos = 6;} if(n == 3){currentPos = 5;}if(n == 4){currentPos = 4;}}
			if (currentposition == 4 ){if(n == 1){currentPos = 1;} if(n == 2){currentPos = 5;} if(n == 3){currentPos = 9;}if(n == 4){currentPos = 8;}}
			
		}else if(currentposition == 5){
			int  n = rand.nextInt(7) + 1;
			if (currentposition == 5 ){if(n == 1){currentPos = 1;} if(n == 2){currentPos = 2;} if(n == 3){currentPos = 6;}if(n == 4){currentPos = 10;}if(n == 5){currentPos = 9;}if(n == 6){currentPos = 8;}if(n == 4){currentPos = 4;}}
		}
		
		return currentPos;
		
	}
}
