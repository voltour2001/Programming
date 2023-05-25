package Project;

public class edipes extends diafimisis{

    int First;
    int Middle;
    int Last;

    //Constructor
    public edipes(int ID, int AFM, String description, int First, int Middle, int Last){
        super(ID,AFM,description);
        this.First = First;
        this.Middle = Middle;
        this.Last = Last;
    }

    public void print(){
        System.out.println("\nYour Add\n==========");
        System.out.println("ID          : " + ID);
        System.out.println("AFM         : " + AFM);
        System.out.println("Discreption : " + description);
        System.out.println("Price 1     : " + First);
        System.out.println("Price 2     : " + Middle);
        System.out.println("Price 3     : " + Last);
    }
    public int getAFM(){
        return AFM;
    }
    public int getFirst() {
        return First;
    }
    public int getMiddle() {
        return Middle;
    }
    public int getLast() {
        return Last;
    }

}