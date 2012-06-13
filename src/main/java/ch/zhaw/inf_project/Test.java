package ch.zhaw.inf_project;

public class Test {
	public Test(){
		Calculation calc = new Calculation();
	/*	double[][] a = new double[3][3];
		double[] yAnfang = new double[3];
		a[0][0] = 1;
		a[0][1] = 5;
		a[0][2] = 6;
		a[1][0] = 7;
		a[1][1] = 9;
		a[1][2] = 6;
		a[2][0] = 0;
		a[2][1] = -7;
		a[2][2] = -8;
		yAnfang[0] = 29;
		yAnfang[1] = 43;
		yAnfang[2] = -38;*/
		Missile missile1 = new Missile(45, 45);
		Missile missile2 = new Missile(45, 45);
		missile2.setAngle(45);
		missile1.setAngle(45);
		missile2.setStartTime(12);
		missile2.setBurnRate(7);
		missile2.setTank(45);
		boolean test = calc.newton(missile1, missile2);
		System.out.println(test);
		
	}
	
	public static void main(String[] args) {
		new Test();
	}
}
