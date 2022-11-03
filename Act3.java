package tecProg;

import java.awt.Color;

import robocode.AdvancedRobot;
//import robocode.BulletHitEvent;
import robocode.BulletMissedEvent;
//import robocode.DeathEvent;
import robocode.HitWallEvent;
import robocode.RobotDeathEvent;
import robocode.ScannedRobotEvent;
import robocode.WinEvent;

public class Act3 extends AdvancedRobot {

	public void run() {
		setColors(Color.green, Color.white, Color.white);

		while (true) {
			if (pertoParede()) {
				back(100);
			} else {
				ahead(100);
			}
			this.turnRight(30);
			//this.turnGunRight(50);
			this.turnRadarRight(360);
		}
	}

	public void onScannedRobot(ScannedRobotEvent e) {
		mira(e.getBearing());
		if (e.getEnergy() < 12) {
			tiroFatal(e.getEnergy());
		} else {
			fogo(e.getDistance());
		}
	}

	public void onWin(WinEvent e) {
		dancinha();
	}

	public void onHitWall(HitWallEvent event) {
		back(100);
		turnLeft(90);
	}

	public void onBulletMissed(BulletMissedEvent e) {
		System.out.println("S-H-*-T");
	}

	public void onRobotDeath(RobotDeathEvent e) {
		System.out.println("Okay, master! Let's kill da ho!");
	}

	public void mira(double Adv) {
		double A = getHeading() + Adv - getGunHeading();
		if (!(A > -180 && A <= 180)) {
			while (A <= -180) {
				A += 360;
			}
			while (A > 180) {
				A -= 360;
			}
		}
		turnGunRight(A);
	}

	public void dancinha() {
		setAhead(5);
		setTurnRight(360D);
		setTurnGunLeft(360D);
		setTurnRadarRight(30D);
	}

	public void fogo(double Distancia) {
		if (Distancia > 200 || getEnergy() < 15) {
			fire(1);
		} else if (Distancia > 50) {
			fire(2);
		} else {
			fire(3);
		}
	}

	public boolean pertoParede() {
		return (getX() < 50 || getX() > getBattleFieldWidth() - 50 || getY() < 50
				|| getY() > getBattleFieldHeight() - 50);
	}

	public void tiroFatal(double EnergiaIni) {
		double Tiro = (EnergiaIni / 4) + .1;
		fire(Tiro);
	}

}
