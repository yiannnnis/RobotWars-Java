/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotwars;

/**
 *
 * @author John
 */
public class FireRobot extends Robot{
    public FireRobot(Room room, int stamina, int energyNeeded){
        super(room, 1, 4);
    }
    
    @Override
    public void act(Colony colony)
    {
        final int DAMAGE = 3;
        if(getStamina() == 0)
        {
            for(Soldier x: super.getRoom().getSoldier())
                x.reduceStamina(DAMAGE);
        }
    }
}