
public class Encrypter 
{
	public static int encrypt(int x)
	{
		double temp;
		double ret = 0;
		double[] encArray = new double[4];
		
		for(int i = 3; i>=0; i--)
		{
			encArray[i] = x % 10;
			x = x / 10;
		}
		for(int i = 0; i < 4; i++)
		{
			encArray[i] += 7;
			encArray[i] %= 10;
		}
		
		temp = encArray[2];
		encArray[2] = encArray[0];
		encArray[0] = temp;
		
		temp = encArray[3];
		encArray[3] = encArray[1];
		encArray[1] = temp;

		ret = (encArray[0]*1000) + (encArray[1]*100) + (encArray[2]*10) + encArray[3];
		return (int)ret;
	}
}
