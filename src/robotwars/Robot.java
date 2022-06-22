/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotwars;

public class Robot extends Actor{
    private int energyNeeded;

    public Robot(Room room, int stamina, int energyNeeded){
        super(room,stamina);
        this.energyNeeded=energyNeeded;
    }
}