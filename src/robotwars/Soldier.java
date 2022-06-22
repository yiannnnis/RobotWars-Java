/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotwars;

import java.io.Serializable;

public class Soldier extends Actor implements Serializable{

    private final int DAMAGE = 1;

    public Soldier(Room room, int stamina)
    {
        super(room, stamina);
    }

    public void attack(Robot robot)
    {
        robot.reduceStamina(DAMAGE);
    }

    public void moveTo(Room room)
    {
        //this.getRoom().removeSoldier(this);
        super.leaveRoom(room);
        this.getRoom().addSoldier(this);
        
    }

    @Override
    public void act(Colony colony)
    {

                if(super.getRoom().getRobot()!=null)
            {
                this.attack(super.getRoom().getRobot());
            }
            else
            {
                this.moveTo(super.getRoom().getExit());
                //super.leaveRoom(null);
                //super.getRoom().getExit().setSoldierRoom(super.getRoom().getSoldier());
            }
            

    }
}