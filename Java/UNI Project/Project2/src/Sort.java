public class Sort {

    // HeapSort method for descending order
    public static void heapSort(Job[] jobs) {
        int n = jobs.length;

        // Build a max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(jobs, n, i);
        }

        // Extract elements one by one from the heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root (max element) to the end of the array
            Job temp = jobs[0];
            jobs[0] = jobs[i];
            jobs[i] = temp;

            // Call max heapify on the reduced heap
            heapify(jobs, i, 0);
        }

        // Reverse the array to get descending order
        reverseArray(jobs);

        // Print only once after sorting is fully complete
        // System.out.println("Jobs after HeapSort:");
        // printJobs(jobs);
    }

    // Helper function to maintain the max-heap property
    private static void heapify(Job[] jobs, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Check if left child exists and is greater than root
        if (left < n && jobs[left].getProcessingTime() > jobs[largest].getProcessingTime()) {
            largest = left;
        }

        // Check if right child exists and is greater than root
        if (right < n && jobs[right].getProcessingTime() > jobs[largest].getProcessingTime()) {
            largest = right;
        }

        // If largest is not root, swap it with the largest child and continue heapifying
        if (largest != i) {
            Job swap = jobs[i];
            jobs[i] = jobs[largest];
            jobs[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(jobs, n, largest);
        }
    }

    // QuickSort method for descending order
    public static void quickSort(Job[] jobs, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pi = partition(jobs, low, high);

            // Recursively sort the two halves
            quickSort(jobs, low, pi - 1);
            quickSort(jobs, pi + 1, high);
        }

        // Print only once after QuickSort is fully applied
        // if (low == 0 && high == jobs.length - 1) {
            // System.out.println("Jobs after QuickSort:");
            // printJobs(jobs);
        // }
    }

    // Partition method for QuickSort (descends into the largest processing time)
    private static int partition(Job[] jobs, int low, int high) {
        Job pivot = jobs[high];
        int i = low - 1;

        // Iterate over the array and rearrange the elements based on the pivot
        for (int j = low; j < high; j++) {
            if (jobs[j].getProcessingTime() >= pivot.getProcessingTime()) { // Compare for descending order
                i++;
                // Swap the elements at i and j
                Job temp = jobs[i];
                jobs[i] = jobs[j];
                jobs[j] = temp;
            }
        }

        // Swap the pivot element with the element at i+1
        Job temp = jobs[i + 1];
        jobs[i + 1] = jobs[high];
        jobs[high] = temp;

        return i + 1; // Return the partitioning index
    }

    // Reverse array to ensure descending order
    private static void reverseArray(Job[] jobs) {
        int left = 0, right = jobs.length - 1;
        while (left < right) {
            Job temp = jobs[left];
            jobs[left] = jobs[right];
            jobs[right] = temp;
            left++;
            right--;
        }
    }

    // Print method to display the job array (already given)
    public static void printJobs(Job[] jobs) {
        System.out.println("\n========================\n");
        for (Job job : jobs) {
            System.out.println(job);
        }
        System.out.println("\n========================\n");
    }
}
