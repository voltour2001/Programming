
public class Processor implements Comparable<Processor> {
    private static int idCounter = 0; // Static counter for unique IDs
    private final int id; // Unique ID for this processor
    private Jobnode head;
    private Jobnode tail;

    private static class Jobnode {
        Job job;
        Jobnode next;
        Jobnode prev;

        // Constructor for the JobNode
        public Jobnode(Job job) {
            this.job = job;
            this.next = null;
            this.prev = null;
        }
    }

    // Constructor
    public Processor() {
        this.id = ++idCounter; // Ανάθεση μοναδικού id
        this.head = null; // Αρχικά δεν υπάρχουν διεργασίες
        this.tail = null;
    }

    // Add a job to the processor's list of processed jobs
    public void addJob(Job job) {
        Jobnode newNode = new Jobnode(job);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

    }

    // Calculate the total processing time for this processor
    public int getTotalProcessingTime() {
        int totalProcessingTime = 0;
        Jobnode current = head; // Ξεκινάμε από την κεφαλή της λίστας
        while (current != null) {
            totalProcessingTime += current.job.getProcessingTime(); // Άθροισμα του χρόνου της διεργασίας
            current = current.next; // Μετακινούμαστε στον επόμενο κόμβο
        }
        return totalProcessingTime;
    }

    public void printProcessedJobs() {
        Jobnode current = head; // Start from the head of the list
        boolean first = true;
        while (current != null) {
            if (!first) {
                System.out.print("");
            }
            System.out.print(current.job.getProcessingTime() + " "); // Print the job
            current = current.next; // Move to the next node
            first = false;
        }
        System.out.println();
    }

    // Get the processor's unique ID
    public int getId() {
        return id;
    }

    // Get the list of processed jobs
    public Jobnode getProcessedJobs() {
        return head;
    }

    // Implement the compareTo method to compare processors based on total
    // processing time
    @Override
    public int compareTo(Processor other) {
        int timeComparison = Integer.compare(this.getTotalProcessingTime(), other.getTotalProcessingTime());
        if (timeComparison != 0) {
            return timeComparison;
        }
        return Integer.compare(this.id, other.id); // Resolve ties by ID
    }

    // toString method for debugging and output
    @Override
    public String toString() {
        return "Processor{id=" + id + ", totalProcessingTime=" + getTotalProcessingTime() + "}";
    }

}
