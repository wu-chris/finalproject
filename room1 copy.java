import java.util.*;
public class room1{
    int roomSize;
    int ghostposition[];
    boolean restingSites[];
    int life;
    int treasure[];
    int property;
    int position;
    boolean inRoom;
    boolean Gameover;
    Scanner input=new Scanner(System.in);
    public room1(int roomSize,int ghostposition[],boolean restingSites[],int treasure[],int life,int property){
        this.roomSize=roomSize;
        this.ghostposition=ghostposition;
        this.restingSites=restingSites;
        this.life=life;
        this.treasure=treasure;
        this.property=property;
        this.position=0;
        this.inRoom=true;
        this.Gameover=false;
    }
    public void explore(int gotoposition){
        if(gotoposition<0||gotoposition>roomSize-1){
            System.out.println("Sorry, please put in a valid position!");
        }
        else if(gotoposition>this.position+2||gotoposition>this.position-2){
            System.out.println("Sorry, you cannot get to that postion! It is to far away! You are not able to jump there!");
        }
        else if(gotoposition==this.position+2||gotoposition==this.position-2){
            System.out.println("Yay, you just jumped to that position!");
            this.position=gotoposition;
            remind();
        }
        else if(gotoposition==this.position+1||gotoposition==this.position-1){
            System.out.println("Yay, you just walked to that position!");
            this.position=gotoposition;
            remind();
        }
    }
    public void remind(){
        if(ghostposition[this.position]>0){
            System.out.println("Oops! There is something there!"+"You are attacked by "+ghostposition[this.position]+" ghosts!");
            int life=this.life-ghostposition[this.position]*10;
            if(life>0){
                this.life=life;
                System.out.println("You have "+this.life+" life remains!");
            }
            else{
                System.out.println("Sorry, you are attacked to death! Gameover!");
                this.Gameover=true;
            }
        }
        if(treasure[this.position]>0){
            System.out.println("There are some treasures here!");
            this.property+=10;
            System.out.println("Yay, you just picked up these treasure. Now you have "+this.property+" dollars of assets!");
        }
        if(restingSites[this.position]==true){
            System.out.println("You are at the resting spot! Would you like to take a rest?");
            String str=input.nextLine();
            if(str.equals("Yes")||str.equals("yes")){
                rest();
            }
            else{
                System.out.println("You missed a chance to take rest! Keep going!");
            }
        }
        if(this.position==roomSize-1){
            System.out.println("You are at the end of the room! Would you like to exit the room?");
            String str=input.nextLine();
            if(str.equals("Yes")||str.equals("yes")){
                this.inRoom=false;
            }
            else{
                System.out.println("Okay! Let's explore more! Where do you wanna go?");
                int s=input.nextInt();
                explore(s);
            }
        }
    }
    public void rest(){
        if(this.life+15<=100){
            this.life+=15;
        }
        else{
            this.life=100;
        }
    }
    public static void main(String[] args) {
        int roomSize=20;
        int ghostposition[]=new int[]{0,1,0,0,0,1,0,1,0,0,0,1,0,1,0,0,1,0,1,0};
        boolean restingSites[]=new boolean[]{};
        int life=100;
        int treasure[];
        int property;
        int position;
        boolean inRoom;
        Scanner input=new Scanner(System.in);
        System.out.println("Welcome to the first room in the house! You are at the entrance! Noted that you cannot get out of the room unless you found the exit! Enjoy your time here!");
        System.out.println("Where do you want to visit first? The room has "+roomSize+" sites. Where would you like to visit first?");
       
    
    }
}

