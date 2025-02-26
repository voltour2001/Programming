import java.util.Scanner;

public class Comparisons {
    public static void main(String[] args) {
        Greedy greedy = new Greedy();
        int[] jobCounts = {100, 250, 500};
        int numTests = 10;

        System.out.println("Starting Experimental Evaluation...");

        // Ask for University ID only once
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your student ID: ");
        int studentId = Integer.parseInt(scanner.nextLine()) % 10;

        System.out.print("Enter your student ID: ");
        int studentId2 = Integer.parseInt(scanner.nextLine()) % 10;
        scanner.close(); // Close scanner after use

        // Loop through each N value
        for (int n : jobCounts) {
            System.out.println("\n=====================================");
            System.out.printf("Testing for N = %-4d\n", n);
            System.out.println("=====================================");

            int totalGreedyMakespan = 0;
            int totalGreedyDecreasingMakespan = 0;
            boolean printedSortMessage = false; // To ensure sorting message is printed only once per N

            for (int i = 1; i <= numTests; i++) {
                String fileName = "test_" + n + "_" + i + ".txt";
                System.out.printf("\nRunning on %-30s\n", fileName);

                //* Run Greedy Algorithm (Algorithm 1 - No Sorting)
                int greedyMakespan = greedy.GreedyWithoutSorting(fileName);
                System.out.printf("%-35s %5d\n", "Makespan for Greedy:", greedyMakespan);
                totalGreedyMakespan += greedyMakespan;

                //* Run Algorithm 2: Greedy-Decreasing with sorting
                int greedyDecreasingMakespan = greedy.GreedyAlgorithm(fileName, studentId, studentId2, printedSortMessage);
                System.out.printf("%-35s %5d\n", "Makespan for Greedy-Decreasing:", greedyDecreasingMakespan);
                totalGreedyDecreasingMakespan += greedyDecreasingMakespan;

                printedSortMessage = true; // Ensures sorting message is printed only once
            }

            // Calculate and print averages
            double avgGreedy = totalGreedyMakespan / (double) numTests;
            double avgGreedyDecreasing = totalGreedyDecreasingMakespan / (double) numTests;

            System.out.println("\nResults for N = " + n);
            System.out.printf("%-35s %.2f\n", "Average Makespan (Greedy):", avgGreedy);
            System.out.printf("%-35s %.2f\n", "Average Makespan (Greedy-Decreasing):", avgGreedyDecreasing);
            System.out.println("=====================================");
        }
    }
}
