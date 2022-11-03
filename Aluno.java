package tecProg;

import java.awt.Color;

import robocode.AdvancedRobot;
import robocode.HitWallEvent;
import robocode.ScannedRobotEvent;

public class Aluno extends AdvancedRobot {

	
	public void run() {
		setColors(Color.red, Color.red, Color.red);

		while (true) {
			ahead(100);
			turnLeft(20);
			turnGunRight(360);

		}
	}
	public void onScannedRobot(ScannedRobotEvent e) {
		fire(3);
		System.out.println(this.getName() + " - "+e.getDistance());
	}
	public void onHitWall(HitWallEvent event) {
		back(100);
		turnLeft(180);
	}



}
