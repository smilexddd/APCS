import java.io.File;
import java.util.Scanner;

public class LowestTemperatureLocal {
	public static void main(String[] args) throws Exception {
		double[] temps;
		double lowest = 9999.99;

		// Read values from local file instead of URL
		Scanner fin = new Scanner(new File("avg-daily-temps-atx.txt"));
		temps = new double[fin.nextInt()];

		System.out.println( temps.length + " temperatures in database.");

		for ( int i=0; i<temps.length; i++ )
			temps[i] = fin.nextDouble();
		fin.close();

		for ( int i=0; i<temps.length; i++ )
			if ( temps[i] < lowest )
				lowest = temps[i];

		System.out.print( "The lowest average daily temperature was " );
		System.out.println( lowest + "F (" + fToC(lowest) + "C)" );
	}

	public static double fToC( double f ) { return (f-32)*5/9; }
}
