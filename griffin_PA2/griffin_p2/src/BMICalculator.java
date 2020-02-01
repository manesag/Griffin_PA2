import java.util.Scanner;
import java.text.DecimalFormat;

public class BMICalculator 
{
	private static final Scanner kbd = new Scanner(System.in);
	private double height;
	private double weight;
	private double bmi;
	private String bmiCategory;
	private int unitType;
    private static DecimalFormat df = new DecimalFormat("#.##");
	

	public void readUserData()
	{
		System.out.println("BMI Calculator");
		readUnitType();
		readMeasurementData();
	}
	
	public void calculateBmi()												// does the calculation for BMI
	{
		if(this.unitType == 1)												// metric calculation
		{
			double tot1, weight1, height1;
			weight1 = this.weight;
			height1 = this.height;
			tot1 = (weight1 / (height1 * height1));
			this.bmi = tot1;
		}
		if(this.unitType == 2)												// imperial calculation
		{
			double tot2, weight2, height2;
			weight2 = this.weight;
			height2 = this.height;
			tot2 = ((703 * weight2) / (height2 * height2));
			this.bmi = tot2;
		}
		calculateBmiCategory();
	}
	
	public void displayBmi()
	{
		System.out.println("Your BMI is: " + df.format(getBmi()));
		System.out.println("Your BMI Category is: "+ this.bmiCategory);

	}
	
	private void readUnitType()
	{
		int s;
		
		System.out.println("Select a unit type: 1 for Metric or 2 Imperial. ");
		s = kbd.nextInt();
		while(s < 1 || s > 2)												// this set of code checks whether the
		{																	// unit type input is valid
			System.out.println("Select a valid unit type.");
			System.out.println("Select a unit type: 1 for Metric or 2 Imperial. ");
			s = kbd.nextInt();
		}
		this.unitType = s;
	}
	
	private void readMeasurementData()										// takes unit type and sets which 
	{																		// method should do the read and calculation
		if(this.unitType == 1)
		{
			readMetricData();
		}
		if(this.unitType == 2)
		{
			readImperialData();
		}
	}
	
	private void readMetricData()
	{
		double met1=0;
		double met2=0;
		System.out.println("Please enter weight in kilograms: ");
		met1 = kbd.nextDouble();
		if(met1<0)															// checks whether weight is negative
		{
			System.out.println("Negative weight, program closing.");
			System.exit(0);
		}
		setWeight(met1);
		System.out.println("Please enter height in meters: ");
		met2 = kbd.nextDouble();
		if(met2<0)															// checks whether height is negative
		{
			System.out.println("Negative height, program closing.");
			System.exit(0);
		}
		setHeight(met2);
		
	}
	
	private void readImperialData()
	{
		double imp1=0;
		double imp2=0;
		System.out.println("Please enter weight in pounds: ");
		imp1 = kbd.nextDouble();
		setWeight(imp1);
		System.out.println("Please enter height in inches: ");
		imp2 = kbd.nextDouble();
		setHeight(imp2);
	}
	
	private void calculateBmiCategory()
	{
		double bmi = this.bmi;
		
		if(bmi <= 18.5)
		{
			this.bmiCategory = "Underweight";
		}
		if(bmi > 18.5 && bmi < 24.9)
		{
			this.bmiCategory = "Normal Weight";
		}
		if(bmi > 25 && bmi < 29.9)
		{
			this.bmiCategory = "Overweight";
		}
		if(bmi > 30)
		{
			this.bmiCategory = "Obesity";
		}
	}
	
	private void setWeight(double n)
	{
		this.weight = n;
	}
	
	public double getWeight()
	{
		return this.weight;
	}
	
	public double getHeight()
	{
		return this.height;
	}
	
	private void setHeight(double n)
	{
		this.height = n;
	}
	
	public double getBmi()
	{
		return this.bmi;
	}
	
	public String getBmiCategory()
	{
		return this.bmiCategory;
	}
	
}

// readyUserData runs first to grab all the information
// Unit type runs to set what to use, imperial or metric
// then the specific unit type will collect info
// using setters and getters
// from there the BMI is calculated from calculateBmi()
// as well as its category
// before being displayed to the user.