
package labjava.pkg400loc;


public class Category {
    public String ID;
    public String name;

    public Category( String ID, String name ) {
        this.ID = ID;
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID( String ID ) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    @Override
    public String toString() {
        return ID+"/"+name;
    }
}

