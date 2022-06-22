/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotwars;

public class EnergyProducerRobot extends Robot{
    public EnergyProducerRobot(Room room, int stamina, int energyNeeded){
        super(room, 1, 3);
    }
@Override
    public void act(Colony colony)
    {
        colony.setEnergy(colony.getEnergy()+1);
    }

}