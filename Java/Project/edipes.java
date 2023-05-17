package Project;

public class edipes extends diafimisis{

    int First;
    int Middle;
    int Last;

    //Constructor
    public edipes(int ID, String description, long AFM, int First, int Middle, int Last){
        super(ID,description,AFM);
        this.First = First;
        this.Middle = Middle;
        this.Last = Last;
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