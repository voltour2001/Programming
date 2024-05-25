import java.text.DecimalFormat;
import java.util.Scanner;

class App3 {
	
	public static void main(String args[]){
		
		// Fill your code here
		 Scanner scanner = new Scanner(System.in);

        int total = 0;
        int count = 0;
        int positiveCount = 0;
        int negativeCount = 0;
        int maxNum = Integer.MIN_VALUE;
        int minNum = Integer.MAX_VALUE;

        while (true) {
            System.out.print("Give a number : ");
            int num = scanner.nextInt();
            if (num == 0) {
                break;
            }
            total += num;
            count++;
            if (num > 0) {
                positiveCount++;
            } else if (num < 0) {
                negativeCount++;
            }
            maxNum = Math.max(maxNum, num); // Compares maxNum with the current num and returns the max
            minNum = Math.min(minNum, num); // Compares minNum with the current num and returns the min
        }

        double average = count > 0 ? (double)total / count : 0.0;
		// Boolean condition ? true value : false value
		// (double) = makes sure it is in floating point format

        DecimalFormat decimalFormat = new DecimalFormat(".000");
		// ".000" = Always print 3 decimal places (0 if no numbers)
		// ".###" = Print 3 decimal places if they exist, if not dont display anything.

        String formattedAverage = decimalFormat.format(average);
        String formattedTotal = String.format("%,d", total); // % = Indicates the start of format specifier
        String formattedMax = String.format("%,d", maxNum); // , = Flag tha specifies number format with comma separator in thousands
        String formattedMin = String.format("%,d", minNum); // d = Number should be treated as decimal integer

        System.out.println("Items: " + count);
        System.out.println("Average: " + formattedAverage);
        System.out.println("Negative: " + negativeCount);
        System.out.println("Positive: " + positiveCount);
        System.out.println("Max: " + formattedMax);
        System.out.println("Min: " + formattedMin);

        scanner.close();
   	}

}

