package third_class;

public class PepperoniPizza implements Pizza{

	@Override
	public void prepare() {
		// TODO Auto-generated method stub
		System.out.println("Preparing PepperoniPizza's raw material...");
	}

	@Override
	public void bake() {
		// TODO Auto-generated method stub
		System.out.println("Baking PepperoniPizza...");
	}

	@Override
	public void cut() {
		// TODO Auto-generated method stub
		System.out.println("Cutting PepperoniPizza...");
	}

	@Override
	public void box() {
		// TODO Auto-generated method stub
		System.out.println("Boxing PepperoniPizza...");
	}

}
