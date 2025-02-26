import java.io.*;
import java.util.Random;


public class GenerateTestCases {
    public static void main(String[] args) throws IOException{
        int[] jobCounts = {100, 250, 500};
        Random rand = new Random();
        String dataFolder = "./Data/";

        for (int n : jobCounts) {
            int m = (int)Math.sqrt(n);


            for (int i = 1; i <= 10; i++) {
                String fileName = dataFolder + "test_" + n + "_" + i +".txt";

                try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                    
                    writer.write(m + "\n" + n + "\n");

                    // Generate N jobs with random processing times
                    for (int jobId = 1; jobId <= n; jobId++) {
                        int processingTime = rand.nextInt(100) + 1; // Random time between 1-100
                        writer.write(jobId + " " + processingTime + "\n");  // Write job_id and processing_time
                    }

                    System.out.println("Generated: " + fileName);
                }
            }
        }
    }
}
