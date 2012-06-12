package ch.zhaw.inf_project;

public class Test {
	public Test(){
		Calculation calc = new Calculation();
		Missile missile1 = new Missile(45, 45);
		Missile missile2 = new Missile(45, 45);
		missile2.setAngle(45);
		missile1.setAngle(45);
		missile2.setStartTime(12);
		missile2.setBurnRate(7);
		missile2.setTank(45);
		boolean test = calc.newton(45, 45, 12, 7, missile1, missile2);
		System.out.println(test);
	}
	
	public static void main(String[] args) {
		new Test();
	}
}
