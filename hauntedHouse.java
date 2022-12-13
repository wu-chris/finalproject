import java.util.*;
public class hauntedHouse {
    public static void main(String[] args) {
        int room1Size=20;
        int room2Size=20;
        int tsize=20;
        int ghostposition[]=new int[]{0,1,0,0,0,1,0,1,0,0,0,1,0,1,0,0,1,0,1,0};
        boolean[] restingSites=new boolean[]{false,true,false,false,false,true,true,false,true,true,false,true,false,false,true,false,false,true,true,false};
        int life=100;
        int treasure1[]=new int[]{0,1,0,1,0,0,1,0,1,0,0,0,0,1,0,0,1,0,0,1};
        int treasure3[]=new int[]{0,0,3,0,0,2,0,5,0,0,4,0,1,0,0,0,1,0,1,2};
        int property=0;
        int position=0;
        int killer[]=new int[]{0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0};
        int window[]=new int[]{0,1,0,1,0,0,0,1,0,0,0,1,0,0,0,1,1,0,0,0};
        int unknowncreatureposition[]=new int[]{0,1,0,0,0,1,0,1,0,0,0,1,0,1,0,0,1,0,1,0};
        boolean inRoom1=false;
        boolean inRoom2=false;
        boolean Gameover=false;
        room1 room1=new room1(room1Size,ghostposition,restingSites,treasure1,life,property);
        Scanner input=new Scanner(System.in);
        System.out.println("Welcome to the haunted house game!");
        System.out.println("In this game, you should try to escape the haunted house and collect as many treasure as possible!");
        System.out.println("-----------------------------------------");
        System.out.println("Please enter 'start' to start the game.");
        String s=input.nextLine();
        if(s.equals("start")){
            System.out.println("Welcome to the game! You are at the first room in the haunted house right now. Good luck!");
            System.out.println("Welcome to the first room in the house! You are at the entrance! Noted that you cannot get out of the room unless you found the exit! Enjoy your time here!");
            System.out.println("Where do you want to visit first? The room has "+room1Size+" sites. Where would you like to explore first?");    
            int a=input.nextInt();
            input.nextLine();
            room1.explore(a);
            if(room1.getRoom()==2&&room1.isGameOver()==false){
                room2 room2=new room2(room2Size,unknowncreatureposition,killer,window,room1.getlife());  
                System.out.println("Welcome, you are at the second room right now! There are "+room2Size+" sites. Where would you like to go first?");
                int b=input.nextInt();
                input.nextLine();
                room2.explore(b);
                if(room2.getRoom()==3&&room2.isGameOver()==false){
                    treasure treasure=new treasure(tsize,treasure3,room1.getproperty());
                    System.out.println("Welcome to the treasure room! There is no harm in this room! There are only treasures here! Feel free to collect anything!");
                    System.out.println("In this room, you can go anywhere you want without a limit on steps you could take at once. But you can only visit five sites in this room.");
                    System.out.println("The room has "+tsize+" sites. Where would you like to explore first?");
                    treasure.explore();
                    System.out.println("You have "+room2.getlife()+" life remains and "+ treasure.getproperty()+" dollars as your asset.");
                    System.out.println("Congrats!!!");
                    System.out.println("End of Game--------------------------------------");
                }
                }

            
        }

    }
}
