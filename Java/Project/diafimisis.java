package Project;

public class diafimisis{

    private int ID;
    private String description;
    private long AFM;

    // Constructor
    public diafimisis(int ID, String description, long AFM) {
        this.ID = ID;
        this.description = description;
        this.AFM = AFM;
    }
    public int getID() {
        return ID;
    }
    
    public void setID(int id) {
        this.ID = id;
    }
      
}
