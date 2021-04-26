package programers;


public class Trit {

	public String trit(int n, String f) {
		
		int q = 0;
		int r = 0;
		
		if (n < 3) {
			f += Integer.toString(n);
			return f;
		}
		
		q = n / 3;
		r = n % 3;
		f += Integer.toString(r);
		f = trit(q, f);
		return f;
	}
	
	public int solution(int n) {
        int answer = 0;
        
        String t = "";
        t = trit(n, t);
        for (int i = t.length()-1; i >= 0; i--) {
        	int g = Character.getNumericValue(t.charAt(i));
        	answer += (Math.pow(3, t.length()-(i+1))*g);
        }
        return answer;
    }
	
	public static void main(String[] args) {
		//solution(45);
	}
}
