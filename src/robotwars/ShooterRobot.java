/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotwars;

public class ShooterRobot extends Robot{
    public ShooterRobot(Room room, int stamina, int energyNeeded, int curr_round){
        super(room, 1, 4);
        setlastRound(curr_round);
    }
    
    private int lastRound;
    public void setlastRound(int lastRound)
    {
        this.lastRound=lastRound;
    }

    public int getlastRound()
    {
        return lastRound;
    }

    @Override
    public void act(Colony colony)
    {
        final int DAMAGE =1;
        if(super.getRound()+3>=getlastRound())
        {
            if(super.getRoom().getSoldier()!=null)
            {
                for(Soldier x: super.getRoom().getSoldier())
                {
                    x.reduceStamina(DAMAGE);
                    break;
                }
                setlastRound(super.getRound());
            }
        }
    }

}