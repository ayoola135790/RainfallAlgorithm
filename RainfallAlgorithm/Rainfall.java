import java.util.Scanner;

public class Rainfall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = 0;
        double average = 0;
        double high = 0;
        double low = Double.MAX_VALUE;
        
        // Signify array of months
        double[] rainf = new double[12];
        String[] months = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };
        
        for (int i = 0; i < 12; i++) {
            double rain;
            do {
                System.out.print("Enter the rainfall for " + months[i] + ": ");
                rain = scanner.nextDouble();
                if (rain < 0) {
                    System.out.println("Invalid data (negative rainfall detected). Please, try again.");
                }
            } while (rain < 0);
            rainf[i] = rain;
            total += rain;
            if (rain > high) {
                high = rain;
            }
            if (rain < low) {
                low = rain;
            }
        }

        average = total / 12.0;
        int highestRainMonth = 0;
        int lowestRainMonth = 0;

        for (int i = 0; i < 12; i++) {
            if (rainf[i] == high) {
                highestRainMonth = i;
            }
            if (rainf[i] == low) {
                lowestRainMonth = i;
            }
        }

        System.out.println("Total rainfall for the year: " + total);
        System.out.println("Average monthly rainfall: " + average);
        System.out.println("Month with highest rainfall: " + months[highestRainMonth] + " (" + high + ")");
        System.out.println("Month with lowest rainfall: " + months[lowestRainMonth] + " (" + low + ")");
        System.out.println("\nMonths sorted by rainfall (highest to lowest):");

        double[] sortedRainf = rainf.clone();
        String[] sortedMonths = months.clone();

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11 - i; j++) {
                if (sortedRainf[j] < sortedRainf[j + 1]) {
                    double temp = sortedRainf[j];
                    sortedRainf[j] = sortedRainf[j + 1];
                    sortedRainf[j + 1] = temp;
                    
                    String tempMonth = sortedMonths[j];
                    sortedMonths[j] = sortedMonths[j + 1];
                    sortedMonths[j + 1] = tempMonth;
                }
            }
        }

        for (int i = 0; i < 12; i++) {
            System.out.println(sortedMonths[i] + ": " + sortedRainf[i]);
        }
    }
}
