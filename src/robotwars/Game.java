package robotwars;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.Random;

public class Game {
    private Colony colony;
    private Scanner input;
    private Soldier[] soldier ;
    private MasterRobot masterRobot;
    private int round=0;
    private Random rand = new Random();
    private Round startround = new Round();
    private int ans1,ans2;
    
    public Game()
    {

    }
    
    public void play()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Καλωσήρθες στο παιχνίδι Robot Wars !");
        System.out.println("Δώσε το πλήθος των σηράγγων:");
        int nmrooms=input.nextInt();
        System.out.println("Δώσε το μήκος των σηράγγων(σε δωμάτια):");
        int nmtunnels=input.nextInt();
        System.out.println("Δώσε την ενέργεια του παίχτη:");
        int energy=input.nextInt();
        colony = new Colony(nmrooms ,nmtunnels, energy);
        System.out.println("Δώσε το πλήθος των στρατιωτών:");
        int nmsoldiers = input.nextInt();
        System.out.println("Δημιουργία παιχνιδιού ...");
        Room temp;
        for(int j=0 ; j<colony.numTunnels() ; j++)
           {
               temp=colony.entryRooms[j];
               int rand1 = rand.nextInt(nmsoldiers);
               if (rand1==0)
                   continue;
               else
               {
                   for(int k=0 ; k<rand1 ; k++)
                       temp.addSoldier(new Soldier(temp,1));
               }
               if(nmsoldiers>=rand1)
                   nmsoldiers -= rand1;
               else
                   nmsoldiers=0;
           }
        do
        {
           Room temp2;
           int tun;
           int room;
           System.out.println("Επίλεξε ενέργεια :\n1-Προσθήκη ρομπότ\n2-Επόμενος γύρος\n3-Εμφάνιση περιεχομένων στα δωμάτια\n4-Αποθήκευση Παιχνιδίου\n5-Φόρτωση Παιχνιδίου\n0-Τερματισμός");
           ans1=input.nextInt();
            switch(ans1){
                    case 1:
                        System.out.println("Επίλεξε τύπο: \n1-Energy Robot\n2-Fighter Robot\n3-Fire Robot\n4-Shooter Robot\n5-Armored Robot");
                        ans2=input.nextInt();
                        switch(ans2){
                            case 1:
                                if(colony.getEnergy()<=3){
                                    System.out.println("Δεν έχεις αρκετή ζωή");
                                    break;
                                }
                                System.out.println("Δώσε σήραγγα:");
                                tun=input.nextInt();
                                System.out.println("Δώσε δωμάτιο:");
                                room = input.nextInt();
                                temp2=colony.entryRooms[tun];
                                for (int j=2 ; j<=room; j++) //Δωμάτιο
                                {
                                temp2=temp2.getExit();
                                }
                                if(temp2.getRobot()==null){
                                EnergyProducerRobot energyrobot = new EnergyProducerRobot(temp2, 1 , 3);
                                temp2.setRobotRoom(energyrobot);
                                colony.setEnergy(colony.getEnergy()-3);
                                System.out.println("Το ρομπότ μπήκε επιτυχώς");
                                }
                                break;
                            case 2:
                                if(colony.getEnergy()<=4){
                                    System.out.println("Δεν έχεις αρκετή ζωή");
                                    break;
                                }
                                System.out.println("Δώσε σήραγγα:");
                                tun=input.nextInt();
                                System.out.println("Δώσε δωμάτιο:");
                                room = input.nextInt();
                                temp2=colony.entryRooms[tun];
                                for (int j=2 ; j<=room; j++) //Δωμάτιο
                                {
                                temp2=temp2.getExit();
                                }
                                if(temp2.getRobot()==null){
                                FighterRobot fighterrobot = new FighterRobot(temp2, 1 , 4);
                                temp2.setRobotRoom(fighterrobot);
                                colony.setEnergy(colony.getEnergy()-4);
                                System.out.println("Το ρομπότ μπήκε επιτυχώς");
                                }
                                break;
                             case 3:
                                if(colony.getEnergy()<=4){
                                    System.out.println("Δεν έχεις αρκετή ζωή");
                                    break;
                                }
                                System.out.println("Δώσε σήραγγα:");
                                tun=input.nextInt();
                                System.out.println("Δώσε δωμάτιο:");
                                room = input.nextInt();
                                temp2=colony.entryRooms[tun];
                                for (int j=2 ; j<=room; j++) //Δωμάτιο
                                {
                                temp2=temp2.getExit();
                                }
                                if(temp2.getRobot()==null){
                                    FireRobot firerobot = new FireRobot(temp2, 1 , 4);
                                    temp2.setRobotRoom(firerobot);
                                    colony.setEnergy(colony.getEnergy()-4);
                                    System.out.println("Το ρομπότ μπήκε επιτυχώς");
                                }
                                break;
                            case 4:
                                if(colony.getEnergy()<=4){
                                    System.out.println("Δεν έχεις αρκετή ζωή");
                                    break;
                                }
                                System.out.println("Δώσε σήραγγα:");
                                tun=input.nextInt();
                                System.out.println("Δώσε δωμάτιο:");
                                room = input.nextInt();
                                temp2=colony.entryRooms[tun];
                                for (int j=2 ; j<=room; j++) //Δωμάτιο
                                {
                                temp2=temp2.getExit();
                                }
                                if(temp2.getRobot()==null){
                                    ShooterRobot shooterrobot = new ShooterRobot(temp2, 1 , 4, 0);
                                    temp2.setRobotRoom(shooterrobot);
                                    colony.setEnergy(colony.getEnergy()-4);
                                    System.out.println("Το ρομπότ μπήκε επιτυχώς");
                                }
                                break;
                            case 5:
                                if(colony.getEnergy()<=3)
                                {
                                    System.out.println("Δεν έχεις αρκετή ζωή");
                                    break;
                                }
                                System.out.println("Δώσε σήραγγα:");
                                tun=input.nextInt();
                                System.out.println("Δώσε δωμάτιο:");
                                room = input.nextInt();
                                temp2=colony.entryRooms[tun];
                                for (int j=2 ; j<=room; j++) //Δωμάτιο
                                {
                                    temp2=temp2.getExit();
                                }
                                if(temp2.getRobot()==null){
                                    ArmoredRobot armoredrobot = new ArmoredRobot(temp2, 4 , 3);
                                    temp2.setRobotRoom(armoredrobot);
                                    colony.setEnergy(colony.getEnergy()-4);
                                    System.out.println("Το ρομπότ μπήκε επιτυχώς");
                                }
                                break;
                                }
                        break;
                        case 2:
                            for(int k=0; k<colony.numTunnels() ; k++)
                            {
                                temp=colony.entryRooms[k];
                                for (int j=1 ; j<colony.tunnelLength(); j++) //Δωμάτιο
                                {
                                    if(temp.getRobot()!=null)
                                    {   
                                        temp.getRobot().act(colony);
                                    }  
                                }
                                for (int j=1 ; j<colony.tunnelLength(); j++){
                                    if(temp.getSoldier().isEmpty()== false)
                                    {
                                        for (Soldier x : temp.getSoldier()){
                                            x.act(colony);
                                        }
                                    }
                                }
                            }
                        break;
                        case 3:
                            for(int k=0; k<colony.numTunnels() ; k++) //Σήραγγα
                            {
                                temp=colony.entryRooms[k];
                                for ( int j=1 ; j<colony.tunnelLength(); j++) //Δωμάτιο
                                {
                                    if(temp.getRobot()!=null)
                                    {   
                                        System.out.println("Βρέθηκε " + temp.getRobot().getClass().getSimpleName() + " με ζωή: "+ temp.getRobot().getStamina() +" στο δωμάτιο " + j + " της σήραγγας " + k); 
                                    }
                                    if(temp.getSoldier().isEmpty()== false)
                                    {
                                        System.out.println("Βρέθηκαν "+ temp.getSoldier().size() + " στρατιώτες στο δωμάτιο " + j + " της σήραγγας " + k);
                                    }
                                    temp=temp.getExit();
                                }
                            }

                            System.out.println("Η ζωή είναι : " + colony.getEnergy());
                        break;                            
                        case 4:
                            try {
                                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("save.bin"));

                                out.writeObject(colony);
                                out.close();
                            }catch (IOException e) {
                                System.out.print("Error: " + e);
                                System.exit(1);
                              }
                            System.out.println("Επιτυχής Αποθήκευση");
                        break;
                        case 5:
                            try {
                                ObjectInputStream in = new ObjectInputStream(new FileInputStream("save.bin"));
                                try {
                                    Colony c=(Colony)in.readObject();
                                    colony=c;

                                }catch (ClassNotFoundException e) {
                                    System.out.println("Error: " + e);
                                    System.exit(1);
                                }
                            }catch (IOException e) {
                                System.out.println("Error: " + e);
                                System.exit(1);
                            }
                         System.out.println("Επιτυχής Ανάγνωση");
                         break;
                            
                            
                            
                }
       
        }while(ans1!=0);
    }
        
    
    public void setRound(int round)
    {
        this.round=round;
    }
    
    public int getRound()
    {
        return round;
    }
    
    
    
}
