/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotwars;

import java.io.Serializable;


public class Colony implements Serializable{
    private int energy;
    private MasterRoom masterRoom;
    Room[] entryRooms;
    private int tunnels;
    private int length;
   
    public Colony(int nmtunnels, int tunnellength, int energy){
        tunnels=nmtunnels;
        length=tunnellength;
        entryRooms = new Room[tunnels];
        this.energy=energy;
        for(int i=0 ; i<tunnels ; i++)
        {
            entryRooms[i]=new Room(null, null); //Dhmiourgia prwtou dwmatiou
            Room temp= entryRooms[i]; //Το temp δίχνει στο πρώτο δωμάτιο
            

            for(int j=1 ; j<length ; j++)
            {
                temp.setExit(new Room(temp, null));
                temp=temp.getExit();
            }

            temp.setExit(masterRoom);
            MasterRobot masterRobot = new MasterRobot(masterRoom, 1, 0);
            }
        

    }
   

    public int numTunnels()
    {
        return tunnels;
    }

    public int tunnelLength()
    {
        return length;
    }

    public int getEnergy()
    {
        return energy;
    }

    public void setEnergy(int energy)
    {
        this.energy=energy;
    }
    
}
