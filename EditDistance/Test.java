package EditDistance;

public class Test {

	public static void main(String[] args) {
		Edit_Distance e = new Edit_Distance();
		String a = "ALGORITHM";
		String b = "ALTRUISTIC";
		System.out.println("최소 변경횟수: "+ e.EditDistance(a, b));
	}

}
