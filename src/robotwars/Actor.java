package robotwars;

import java.io.Serializable;

public abstract class Actor extends Game implements Serializable{
    private Room room;
    private int stamina;

    public Actor( Room room , int stamina)
    {
        this.room=room;
        this.stamina=stamina;
    }

    public void leaveRoom(Room room)
    {
        this.room=room;
    }

    public void reduceStamina(int ammount)
    {
        stamina-=ammount;
        if(stamina<=0)
        {
            leaveRoom(null);
        }
    }

    public void act(Colony colony)
    {
        
    }

    public Room getRoom()
    {
        return room;
    }

    public int getStamina()
    {
        return stamina;
    }
}
