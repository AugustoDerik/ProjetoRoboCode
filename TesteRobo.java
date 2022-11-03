package tecProg;
import robocode.AdvancedRobot;
import robocode.ScannedRobotEvent;

public class TesteRobo extends AdvancedRobot{

	public void run() {
		while(true) {
		 this.setAhead(50);	
		 this.setTurnGunLeft(10);
		 this.execute();
		}
	}
	
	public void onScannedRobot(ScannedRobotEvent event) {
		fire(3);
	}
}
