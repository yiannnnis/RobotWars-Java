package robotwars;
import java.io.Serializable;
import java.util.ArrayList;

public class Room implements Serializable{
    private Room entry,exit;
    private Robot robot;
    private ArrayList<Soldier> soldiers = new ArrayList<Soldier>();

    public Room(Room entry, Room exit){
        this.entry=entry;
        this.exit=exit;
    }

    public Room getEntry()
    {
        return entry;
    }

    public Room getExit()
    {
        return exit;
    }

    public void setEntry(Room entry)
    {
        this.entry=entry;
    }

    public void setExit(Room exit)
    {
        this.exit=exit;
    }

    public Robot getRobot()
    {
        return robot;
    }

    public ArrayList<Soldier> getSoldier()
    {
        return soldiers;
    }
    
    public void addSoldier(Soldier soldier)
    {
        this.soldiers.add(soldier);
    }
    
    public void removeSoldier(Soldier soldier){
    int i=0;                    //Position on the arraylist
    for(Soldier s: soldiers){
        if(s.equals(soldier)){
            soldiers.remove(i);
            break;
        }

        i++;
    }

    }
    
    public void setRobotRoom(Robot robot)
    {
        this.robot=robot;
    }
    
}
