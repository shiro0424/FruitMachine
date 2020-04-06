
public class FruitMachine {
	public static void main(String[] args) {
		Model model = new Model();
		View view = new View();
		Controller controller = new Controller(view, model);
	}
}
