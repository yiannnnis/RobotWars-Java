package robotwars;


public class FighterRobot extends Robot{
    public FighterRobot(Room room, int stamina, int energyNeeded){
        super(room, 1, 4);
    }

    public void act(Colony colony)
    {
        final int DAMAGE=1;
        if(super.getRoom().getSoldier()!=null)
        {
            for(Soldier x: super.getRoom().getSoldier())
            {
                x.reduceStamina(DAMAGE);
                break;
            }
        }
    }
}