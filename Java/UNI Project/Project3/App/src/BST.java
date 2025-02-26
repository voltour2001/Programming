import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

import java.util.*;

public class BST extends WordCounter {
    private TreeNode head;
    private LinkedList stopWords = new LinkedList();
    // void insert(String w):αν το w δεν περιεχεται στη λιστα των stopWords τοτε
    // βρισκουμε τον κομβο του στο δεντρο
    // και αν υπηρχε ηδη απλα προσθετουμε 1 στην συχνοτητα του αλλιως χρησιμοποιουμε
    // την insert και ανανεωνουμε το δεντρο
    // μεσω της ανανεωσης των υποδεντρων της ριζας
    int countdist = 0;

    void insert(String w) {
        w = w.toLowerCase();

        if (!stopWordsContains(w)) {
            TreeNode exist = getNode(w);

            if (exist != null) {
                exist.item.addCount();
            } else {

                head = insertR(head, w);
                head.updateSubtreeSize();
                countdist++;
            }
        } else {
            return;
        }

    }

    // WordFrequency search(String w):εδω δεχομαστε το string w και βρισκουμε τον
    // κομβο που περιεχει την τιμη του string(λεξη)
    // αν δεν υπαρχει αυτος ο κομβος τοτε επιστρεφουμε null αλλιως αποθηκευοθμε την
    // συχνοτητα του στο freq.Αν το string περιεχεται
    // στη λιστα stopWords τοτε το αφαιρουμε τελειως και επιστρεφουμε null,αν η
    // συχνοτητα του αντικειμενου ειναι πανω απο τη μεση συχνοτητα
    // τοτε αφαιρουμε το αντικειμενο και κανουμε εισαγωγη απο τη ριζα μεσω της
    // insertT
    WordFrequency search(String w) {
        TreeNode found = getNode(w);
        if (found == null) {
            return null;
        }
        int freq = found.item.getCount();
        if (stopWordsContains(w)) {
            remove(w);
            head.updateSubtreeSize();
            return null;
        }
        if (found.item.getCount() > getMeanFrequency()) {
            remove(w);
            if (head != null) {
                head.updateSubtreeSize();
                head = insertT(head, w, freq);
            } else {
                head = new TreeNode(w);
                head.item.setCount(freq);
            }

        }
        return found.item;
    }

    // InsertT(TreeNode head,String w,int freq):κλασσικη περιπτωση εισαγωγης απο τη
    // ριζα περνωντας ομως την συχνοτητα ως argument
    private TreeNode insertT(TreeNode head, String w, int freq) {
        if (head == null) {
            countdist++;
            TreeNode newNode = new TreeNode(w);
            newNode.item.setCount(freq);
            return newNode;
        }

        if (w.compareTo(head.item.key()) < 0) {
            head.left = insertT(head.left, w, freq);
            head = rotR(head);
        } else {
            head.right = insertT(head.right, w, freq);
            head = rotL(head);
        }

        return head;

    }

    // rotR(TreeNode h):δεξια περιστροφη ανανεωνοντας και τα υποδεντρα των κομβων
    private TreeNode rotR(TreeNode h) {
        if (h == null || h.left == null)
            return h;
        TreeNode x = h.left;
        h.left = x.right;
        x.right = h;
        h.updateSubtreeSize();
        x.updateSubtreeSize();
        return x;
    }

    // rotL(TreeNode h):αριστερη περιστροφη ανανεωνοντας και τα υποδεντρα των κομβων
    private TreeNode rotL(TreeNode h) {
        if (h == null || h.right == null)
            return h;
        TreeNode x = h.right;
        h.right = x.left;
        x.left = h;
        h.updateSubtreeSize();
        x.updateSubtreeSize();
        return x;
    }

    void remove(String w) {

        head = removeR(head, w);

    }

    // private TreeNode removeR:αναδρομικα ψαχνουμε τον κομβο που εχει την τιμη ιση
    // με το w και οταν το βρισκουμε διαγραφουμε-αφαιρουμε
    // τον κομβο και θετουμε την συχνοτητα του ιση με 0,στο τελος επιστρεφουμε την
    // τιμη και ανανεωνουμε τα υποδεντρα
    private TreeNode removeR(TreeNode h, String w) {

        if (h == null) {
            return null;
        }

        if (w.compareTo(h.item.key()) < 0) {
            h.left = removeR(h.left, w); // Go left
        } else if (w.compareTo(h.item.key()) > 0) {
            h.right = removeR(h.right, w); // Go right
        } else { // Found node to remove
            h.item.setCount(0); // Set the frequency to 0
            countdist--;
            // Now remove the node completely
            return deleteNode(h);

        }
        h.updateSubtreeSize();
        return h;
    }

    // private TreeNode deleteNode(TreeNode h):κοιταμε αν καποιο απο τα υποδεντρα
    // ειναι αδεια αρχικα οπου σε αυτες τις
    // περιπτωσεις επιστρεφουμε το υποδεντρο που δεν ειναι αδειο η αν και τα δυο
    // ειναι αδεια null.Αν ο κομβος εχει δυο υποδεντρα τοτε ο μικροτερος κομβοσ απο
    // το δεξι υποδεντρο του θα παρει την θεση του
    // οταν διαγραφει-αφαιρεθει
    private TreeNode deleteNode(TreeNode h) {
        if (h.left == null) {
            return h.right;
        }
        if (h.right == null) {
            return h.left;
        }

        TreeNode minRight = findMin(h.right);
        h.item = minRight.item;
        h.right = removeR(h.right, minRight.item.key()); // αφαιρουμε τον κομβο του στοιχειου h.right το οποιο θα παρει
                                                         // την θεση του κομβου
        // που αφαιρουμε
        h.updateSubtreeSize();
        return h;
    }

    // ευρεση του αριστεροτερου κομβου του υποδεντρου του h(μικροτερο στοιχειο)
    private TreeNode findMin(TreeNode h) {
        while (h.left != null)
            h = h.left;
        return h;
    }

    void load(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String w : words) {
                    w = w.replaceAll("[^a-zA-Z']+", "");// αγνοουμε οτι δεν ειναι γραμμα η αποστροφος μεσα στη λεξη

                    w = w.toLowerCase();
                    if (w.matches(".*\\d.*")) {// αγνοουμε τους αριθμους
                        continue;
                    }
                    if (stopWordsContains(w)) {
                        continue;
                    }
                    if (!w.isEmpty())
                        insert(w);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

    }

    // συνολο λεξεων
    int getNumTotalWords() {

        return getNumTot(head);
    }

    // συνολο διαφορετικων λεξεων
    int getNumDistinctWords() {
        return countdist;

    }

    // int getFrequency(String w):απο το getWordFrequency παιρνουμε τη συχνοτητα και
    // την εμφανιζουμε αν το g δεν ειναι αδειο
    int getFrequency(String w) {
        WordFrequency g = getWordFrequency(w);
        if (g != null) {
            return g.getCount();
        }
        return 0;
    }

    // private WordFrequency traverseR(TreeNode h):αρχικα ελεγχουμε αν το δεντρο
    // ειναι αδειο,αν δεν ειναι τοτε βαζουμε στο
    // Wordfrequency max το περιεχομενο της κεφαλης.Μετα συγκρινουμε αναδρομικα καθε
    // αντικειμενο του δεντρου(εκτος απο την κεφαλη)
    // οσων αφορα τις συχνοτητες τους και οταν βρισκουμε συχνοτητα μεγαλυτερη απο το
    // max τοτε το αντικειμενο παιρνει την θεση του max.
    // Στο τελος επιστρεφουμε το max
    private WordFrequency traverseR(TreeNode h) {
        if (h == null)
            return null;
        WordFrequency max = h.item;

        System.out.println(h.item);

        WordFrequency leftmax = traverseR(h.left);
        WordFrequency rightmax = traverseR(h.right);
        if (leftmax != null && leftmax.getCount() > max.getCount()) {
            max = leftmax;
        }
        if (rightmax != null && rightmax.getCount() > max.getCount()) {
            max = rightmax;
        }
        return max;
    }

    // παιρνουμε το max μεσω της traverseR(head)(η traverseR δεν ειναι αποκλειστικα
    // μεθοδος διασχισης αλλα βρισκει τον κομβο με την
    // μεγιστη συχνοτητα)
    WordFrequency getMaxFrequency() {

        WordFrequency maxfreq = traverseR(head);
        return maxfreq;

    }

    // double getMeanFrequency():θα διαρεσουμε τις συνολικες λεξεις/τις διαφορετικες
    // λεξεις
    double getMeanFrequency() {
        int distinctWords = getNumDistinctWords();
        if (distinctWords == 0)
            return 0;
        return (double) getNumTotalWords() / distinctWords;
    }

    // προσθεση StopWord
    void addStopWord(String w) {

        stopWords.insertAtFront(w);
        if ((search(w) != null)) {
            countdist--;
        }
    }

    // αφαιρεση StopWord
    void removeStopWord(String w) {
        stopWords.remove(w);
        if (search(w) != null) {
            countdist++;
        }
    }

    private void traverseInOrder(TreeNode h, PrintStream stream) {
        if (h == null)
            return;
        // μέθοδος που εξαρτάται από το τι
        // ακριβώς θέλουμε να κάνουμε στους κόμβους του δέντρου
        traverseInOrder(h.left, stream);
        stream.println(h.item);
        traverseInOrder(h.right, stream);
    }

    void printTreeByWord(PrintStream stream) {
        traverseInOrder(head, stream);
    }

    // βαζουμε τους κομβους σε πινακα για να μας βοηθησει στην συναρτηση
    // printTreeByFrequency(Printstream stream)
    private void NodeArray(TreeNode node, TreeNode[] arr, int[] index) {
        if (node == null)
            return;
        NodeArray(node.left, arr, index);
        arr[index[0]++] = node; // αποθηκευουμε τον κομβο και μετακινουμε το index
        NodeArray(node.right, arr, index);
    }

    // μεθοδος quicksort
    private void quickSort(TreeNode[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // partition για το quicksort
    private int partition(TreeNode[] arr, int low, int high) {
        int pivot = arr[high].getFrequency();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].getFrequency() < pivot) { // ταξινομηση σε αυξουσα σειρα
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    // swap
    private void swap(TreeNode[] arr, int i, int j) {
        TreeNode temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // void PrintTreeByFrequency(Printstream stream):δημιουργουμε πινακα,τον
    // γεμιζουμε μετα τον ταξινομουμε με τη χρηση του quicksort
    // και τελος εμφανιζουμε τις λεξεις με την συχνοτητα τους σε αυξουσα σειρα(ως
    // προς τη συχνοτητα) μεσω του stream
    void printΤreeByFrequency(PrintStream stream) {
        int n = countdist;
        TreeNode[] arr = new TreeNode[n];
        NodeArray(head, arr, new int[] { 0 });

        quickSort(arr, 0, n - 1);

        for (TreeNode node : arr) {
            stream.println(node.item);
        }
    }

    // private boolean stopWordsContains(String word):εδω διασχιζουμε τη λιστα
    // stopWords για να δουμε αν υπαρχει η λεξη string word
    // αν τη βρουμε επιστρεφουμε true αλλιως false
    private boolean stopWordsContains(String word) {
        Node current = stopWords.head;
        while (current != null) {
            if (current.item.equalsIgnoreCase(word)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // search(TreeNode node,String w):εδω περναμε το w σαν argument και ψαχνουμε
    // κομβο στο δεντρο με την τιμη του w
    // ,αν τον βρουμε τον επιστρεφουμε,δηλαδη μας επιτρεπει να περασουμε το string
    // και να επιστρεψοθμε κομβο
    public TreeNode search(TreeNode node, String w) {

        if (node == null) {
            return null;
        }
        if (node.item.key().equals(w)) {
            return node;
        }

        if (w.compareTo(node.item.key()) < 0) {
            return search(node.left, w);
        }

        return search(node.right, w);
    }

    public TreeNode getNode(String w) {
        return search(head, w);
    }

    // getNumTot(TreeNode node):αναδρομικη συναρτηση με τη οποια παιρνουμε την
    // συνολικη συχνοτητα απο ολουσ
    // τους κομβους η οποια ισουται με το συνολο των λεξεων στο αρχειο(εκτος των
    // stopwords)
    private int getNumTot(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (stopWordsContains(node.item.key())) {
            return getNumTot(node.left) + getNumTot(node.right);
        }
        return node.item.getCount() + getNumTot(node.left) + getNumTot(node.right);
    }

    // παιρνουμε το string βρισκουμε τον αντιστοιχο κομβο και επιστρεφουμε την
    // συχνοτητα του
    public WordFrequency getWordFrequency(String w) {
        TreeNode node = getNode(w);
        if (node != null) {
            return node.item;
        }
        return null;
    }

    public TreeNode getRoot() {
        return head;
    }

    // private Treenode insertR(TreeNode h,String x):βρισκουμε το σημειο μου πρεπει
    // να εισαχθει ο κομβος αναδρομικα
    // και πραγματοποιουμε εισαγωγη
    private TreeNode insertR(TreeNode h, String x) {
        if (h == null)
            return new TreeNode(x);
        if (x.compareTo(h.key()) < 0) {
            h.left = insertR(h.left, x);
        } else if (x.compareTo(h.key()) > 0) {
            h.right = insertR(h.right, x);
        }
        h.updateSubtreeSize();
        return h;
    }

    private class TreeNode {
        WordFrequency item;
        TreeNode left; // pointer to left subtree
        TreeNode right; // pointer to right subtree
        int subtreeSize;

        public TreeNode(String word) {
            this.item = new WordFrequency(word); // Δημιουργία αντικειμένου WordFrequency
            this.left = null;
            this.right = null;
            this.subtreeSize = 1;
        }

        public String key() {
            return item.key();
        }

        // ανανεωση των υποδεντρων
        public int updateSubtreeSize() {
            int leftSize;
            int rightSize;
            if (left != null) {
                leftSize = left.subtreeSize;
            } else {
                leftSize = 0;
            }
            if (right != null) {
                rightSize = right.subtreeSize;
            } else {
                rightSize = 0;
            }
            this.subtreeSize = 1 + leftSize + rightSize;
            return this.subtreeSize;
        }

        public int getFrequency() {
            return item.getCount();
        }

    };

    class Node {
        String item;
        Node next;

        Node(String v) {
            item = v;
            next = null;
        }

        Node(String item, Node next) {
            this.item = item;
            this.next = next;
        }

    }

    public class LinkedList {
        private Node head = null;
        private Node tail = null;

        public LinkedList() {
        }

        public boolean isEmpty() {
            return head == null;
        }

        // public void insertAtFront(String data):εισαγωγη στην κεφαλη της λιστας
        // stopWords
        public void insertAtFront(String data) {

            data = data.toLowerCase();
            Node n = new Node(data);

            if (isEmpty()) {
                head = n;
                tail = n;
            } else {
                n.next = head;
                head = n;
            }
        }

        // public boolean remove(String word):κοιταμε αν η λιστα ειναι αδεια,αν δεν
        // ειναι τοτε βλεπουμε αν το word ειναι ιδιο
        // με την τιμη της κεφαλης(head) και αν δεν ειναι ιδιο τοτε διασχιζουμε την
        // υπολοιπη λιστα και οταν το βρουμε το αφαιρουμε απο
        // τη λιστα
        public boolean remove(String word) {
            if (isEmpty()) {
                return false;
            }

            if (head.item.equals(word)) {
                if (head == tail) {// ενα αντικειμενο στη λιστα
                    head = tail = null;
                } else {
                    head = head.next; // μετακινουμε το head στον επομενο κομβο μετα το head
                }
                return true;
            }

            Node prev = head;
            Node curr = head.next;

            while (curr != null) {
                if (curr.item.equals(word)) {
                    prev.next = curr.next; // προσπερναμε τον τωρινο κομβο
                    if (curr == tail) {
                        tail = prev; // κανουμε update την ουρα αν ο τελευταιος κομβος αφαιρεθηκε
                    }
                    return true;
                }
                prev = curr;
                curr = curr.next;
            }

            return false; // δεν βρεθηκε η λεξη στη λιστα
        }

    };
}
