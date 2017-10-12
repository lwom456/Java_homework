package third_class;

public class CheesePizza extends Pizza{

	@Override
	public void prepare() {
		// TODO Auto-generated method stub
		System.out.println("Preparing CheesePizza's raw material...");
	}

	@Override
	public void bake() {
		// TODO Auto-generated method stub
		System.out.println("Baking CheesePizza...");
	}

	@Override
	public void cut() {
		// TODO Auto-generated method stub
		System.out.println("Cutting Cheesepizza...");
	}

	@Override
	public void box() {
		// TODO Auto-generated method stub
		System.out.println("Boxing Cheesepizza...");
	}
	
}
