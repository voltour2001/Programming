package Project;

public class diafimisis{

    protected int ID;
    protected String description;
    protected long AFM;

    // Constructor
    public diafimisis(int ID, long AFM, String description) {
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
