public class Job {
    private static int idCounter = 0; // Static counter for unique IDs
    private final int id; // Unique ID for the job
    private final int processingTime; // Processing time for this job

    // Constructor
    public Job(int processingTime) {
        if (processingTime <= 0) {
            throw new IllegalArgumentException("Processing time must be positive");
        }
        this.id = ++idCounter; // Assign a unique ID
        this.processingTime = processingTime; // Set the processing time
    }

    // Get the unique ID of the job
    public int getId() {
        return id;
    }

    // Get the processing time of the job
    public int getProcessingTime() {
        return processingTime;
    }

    // toString method for debugging and output
    @Override
    public String toString() {
        return "Job{id=" + id + ", processingTime=" + processingTime + "}";
    }

}
