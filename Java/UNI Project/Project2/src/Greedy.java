import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Greedy {


    // Algorithm 1: Greedy without sorting
    public int GreedyWithoutSorting(String fileName) {
        try {
            // Step 1: Read input from file
            Scanner scanner = new Scanner(new File("./Data/" + fileName));

            int numProcessors = scanner.nextInt(); // Number of processors
            int numJobs = scanner.nextInt(); // Number of jobs

            // Initialize processors and MaxPQ
            MaxPQ pq = new MaxPQ(numProcessors);
            Processor[] processors = new Processor[numProcessors];
            for (int i = 0; i < numProcessors; i++) {
                processors[i] = new Processor();
                pq.insert(processors[i]); // Insert into priority queue
            }

            // Initialize jobs
            for (int i = 0; i < numJobs; i++) {
                int id = scanner.nextInt(); // Job ID (not used directly)
                int processingTime = scanner.nextInt(); // Processing time

                Job job = new Job(processingTime);

                // Assign job to the least loaded processor
                Processor minProcessor = pq.getmax();
                minProcessor.addJob(job);
                pq.insert(minProcessor); // Reinsert processor with updated load
            }

            // Output the results and calculate makespan
            return printResults(processors, numJobs);

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            return -1;
        }
    }


//! ============================================================================
public int GreedyAlgorithm(String fileName, int lastDigit, int lastDigit2, boolean printedSortMessage) {
    try {
        Scanner scanner = new Scanner(new File( "./Data/"+ fileName));

        int numProcessors = scanner.nextInt(); // Number of processors
        int numJobs = scanner.nextInt(); // Number of jobs

        MaxPQ pq = new MaxPQ(numProcessors);
        Processor[] processors = new Processor[numProcessors];
        for (int i = 0; i < numProcessors; i++) {
            processors[i] = new Processor();
            pq.insert(processors[i]); // Insert into priority queue
        }

        Job[] jobs = new Job[numJobs];
        for (int i = 0; i < numJobs; i++) {
            int id = scanner.nextInt();
            int processingTime = scanner.nextInt();
            jobs[i] = new Job(processingTime);
        }

        // Print sorting message only once per test set
        if (!printedSortMessage) {
            if (lastDigit % 2 == 0 && lastDigit2 % 2 == 0) {
                System.out.println("\nSorting using Heap Sort...");
            } else {
                System.out.println("\nSorting using Quick Sort...");
            }
        }

        // Perform sorting
        if (lastDigit % 2 == 0 && lastDigit2 % 2 == 0) {
            Sort.heapSort(jobs);
        } else {
            Sort.quickSort(jobs, 0, numJobs - 1);
        }

        // Assign jobs to processors
        for (Job job : jobs) {
            Processor minProcessor = pq.getmax();
            minProcessor.addJob(job);
            pq.insert(minProcessor); // Reinsert processor
        }

        // Return the makespan from printResults
        return printResults(processors, numJobs);

    } catch (FileNotFoundException e) {
        System.out.println("File not found.");
        return -1;
    }
}


    // Method to print results and calculate makespan
    private int printResults(Processor[] processors, int numJobs) {
        int makespan = 0;

        if (numJobs < 50) {
            for (Processor processor : processors) {
                System.out.print("id " + processor.getId() + ", load=" + processor.getTotalProcessingTime() + ": ");
                processor.printProcessedJobs();
            }
        }

        // Calculate makespan (maximum load among all processors)
        for (Processor processor : processors) {
            makespan = Math.max(makespan, processor.getTotalProcessingTime());
        }

        // System.out.println("Makespan=" + makespan);
        return makespan;
    }
}
