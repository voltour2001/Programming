public class MaxPQ implements PQInterface {

    private Processor[] heap; // Heap array (1-based indexing)
    private int N; // Number of elements

    public MaxPQ(int maxN) {
        heap = new Processor[maxN + 1]; // Indexing from 1
        N = 0;
    }

    private boolean less(int i, int j) {
        return heap[i].compareTo(heap[j]) > 0;

    }

    private void swap(int i, int j) {
        Processor temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) { // Swap with parent if necessary
            swap(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k; // Left child
            if (j < N && less(j, j + 1))
                j++; // Right child is larger
            if (!less(k, j))
                break; // No need to swap
            swap(k, j);
            k = j;
        }
    }

    private void resize(int capacity) {
        Processor[] temp = new Processor[capacity];
        for (int i = 1; i <= N; i++) {
            temp[i] = heap[i];
        }
        heap = temp;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public void insert(Processor v) {
        if (N >= heap.length * 0.75)
            resize(2 * heap.length); // Resize at 75% capacity
        heap[++N] = v;
        swim(N);
    }

    @Override
    public Processor max() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }
        return heap[1]; // Root of max heap
    }

    @Override
    public Processor getmax() {
        if (isEmpty())
            return null;
        Processor max = heap[1];
        swap(1, N--);
        sink(1);
        heap[N + 1] = null;
        return max;
    }
}
