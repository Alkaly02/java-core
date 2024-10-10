package analysis;
// Analysis Algorithm
class FindSumOne{
	public static int findSum(int n) {
		return n*(n+1)/2;
	}
}
class findSumTwo{
	public static int findSum(int n) {
		int sum = 0;
		for(int i=0; i<=n; i++) {
			sum+=i;
		}
		return sum;
	}
}

public class FindSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("La somme est: "+FindSumOne.findSum(4));
		System.out.println("La somme est: "+findSumTwo.findSum(4));;
	}

}
