public class App {
    public static void main(String[] args) throws Exception {

        class Node {
            int key;
            Node next;
            Node(int x) { key = x; next = null; }
            
            
            
            int findK(int k){
                if (key == k){
                    return k;
                }
                else if (key !=k ){
                    findK(next.key);
                }
                return (Integer) null;
            }
        }
        
        Node l1 = new Node(10);
        Node l2 = new Node(20);

        System.out.println( l1.findK(20));
    }

}
