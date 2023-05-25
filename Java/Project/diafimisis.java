package Project;

public class diafimisis{

    protected int ID;
    protected String description;
    protected int AFM;

    // Constructor
    public diafimisis(int ID, int AFM, String description) {
        this.ID = ID;
        this.AFM = AFM;
        this.description = description;
        
    }

    public int getID() {
        return ID;
    }
    
    public void setID(int id) {
        this.ID = id;
    }
      
}
