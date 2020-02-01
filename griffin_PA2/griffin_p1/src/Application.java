import java.text.DecimalFormat;
import java.util.Scanner;

public class Application 
{

	public static void main(String[] args)
	{
	
		int number;
		int x;
		int y = 0;
		DecimalFormat df = new DecimalFormat("0000");					// make sure code always returns as 4 digits
		
		System.out.println("Press 1 to Encrypt and 2 to Decrypt: ");
		Scanner input = new Scanner(System.in);
		number = input.nextInt();
		
		switch(number)
		{
			case 1:
				System.out.println("Enter a four digit number to encrypt: ");
				x = input.nextInt();
				input.close();
				y = Encrypter.encrypt(x);
				System.out.println("Encrypted: " + df.format(y));
				break;
			case 2:
				System.out.println("Enter a four digit number to decrypt: ");
				x = input.nextInt();
				input.close();
				y = Decrypter.decrypt(x);
				System.out.println("Decrypted: " + df.format(y));
				break;
			default:
				System.out.println("Please enter a valid integer.");
				break;
		}
		input.close();

	}
}

// Application stars by asking the user
// what they would like, encryption or Decryption.
// From there it goes into the switch to break out
// into what the user wants.
