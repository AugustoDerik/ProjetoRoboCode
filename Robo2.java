package tecProg;

import robocode.AdvancedRobot;

public class Robo2 extends AdvancedRobot {

	public void run() {
		int cont = 10;
		while (true) {
			ahead(cont);
			turnLeft(50);
			cont += 5;
		}
	}
}
