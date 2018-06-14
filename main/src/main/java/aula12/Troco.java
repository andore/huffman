package aula12;

public class Troco {
	public static void main(String[] args)
	{
		int n = 5;
		int m[] = {1, 5, 10, 25, 50 ,100};
		
		System.out.println(num_moedas(n, m.length, m));
		
	}
	
	public static int num_moedas(int n, int M, int[]m) 
	{
		int dp[] = new int [n+1];
		
		dp[0] = 0;
		
		for(int i=1; i<=n; i++) 
		{
			dp[i] = Integer.MAX_VALUE;
			for(int j=0; j<M; j++) 
			{
				if(i - m[j] >=0) 
				{
					dp[i] = Math.min(dp[i], dp[i-m[j]] + 1);
				}
			}
		}
		
		return dp[n];
	}
}
