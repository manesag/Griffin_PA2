
public class Decrypter 
{
	public static int decrypt(int x)
	{
		double temp;
		double decrypt;
		double[] decArray = new double[4];
		
		for(int i = 3; i>=0; i--)
		{
			decArray[i] = x % 10;
			x = x / 10;
		}
		temp = decArray[2];
		decArray[2] = decArray[0];
		decArray[0] = temp;
		
		temp = decArray[3];
		decArray[3] = decArray[1];
		decArray[1] = temp;
		for(int i = 0; i < 4; i++)
		{
			decArray[i] += 13;
			decArray[i] %= 10;

		}

		decrypt = (decArray[0]*1000) + (decArray[1]*100) + (decArray[2]*10) + decArray[3];
		return (int)decrypt;
	}
}
