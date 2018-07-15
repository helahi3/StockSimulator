
public class Application {

	public static void main(String[] args) {
		
		Portfolio p = new Portfolio();
		GUI g = new GUI();
		ViewController vc = new ViewController(g,p);
		
		vc.initController();
		
	}

}
