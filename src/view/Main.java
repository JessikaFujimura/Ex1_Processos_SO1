package view;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		String name = System.getProperty("os.name");
			
		RedesController test = new RedesController();
//		String result = test.ping(name);
		String result = test.ip(name);
		System.out.println(result);
	}

}

//.substring(result.indexOf("a") + 3