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
    int room;
    Scanner input=new Scanner(System.in);
    public room1(int roomSize,int ghostposition[],boolean restingSites[],int treasure[],int life){
        this.roomSize=roomSize;
        this.ghostposition=ghostposition;
        this.restingSites=restingSites;
        this.life=life;
        this.treasure=treasure;
        this.property=property;
        this.position=0;
        this.inRoom=true;
        this.Gameover=false;
        this.room=1;
    }
    public void explore(int gotoposition){
        gotoposition=gotoposition-1;
        if(inRoom){
            if(gotoposition<0||gotoposition>roomSize-1){
                System.out.println("Sorry, please put in a valid position!");
                int a=input.nextInt();
                input.nextLine();
                explore(a);
             }
            else if(gotoposition>this.position+2||gotoposition<this.position-2){
                System.out.println("Sorry, you cannot get to that postion! It is to far away! You are not able to jump there!");
                System.out.println("Sorry, please put in a valid position!");
                int a=input.nextInt();
                input.nextLine();
                explore(a);
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
            else if(gotoposition==this.position){
                System.out.println("You are at this position right now! Where do you want to go next?");
                int a=input.nextInt();
                input.nextLine();
                explore(a);
            }
        }
        else if(isGameOver()){
            System.out.println("GAME OVER! Sorry, you just died!");
        }
    }
    public void remind(){
        if(treasure[this.position]>0){
            System.out.println("There are some treasures here!");
            this.property+=10;
            System.out.println("Yay, you just picked up these treasure. Now you have "+this.property+" dollars of assets!");
        }
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
        if(restingSites[this.position]==true){
            System.out.println("You are at the resting spot! Would you like to take a rest?");
            System.out.println("Please enter 'yes' or 'no'.");
            String str=input.nextLine();
            if(str.equals("Yes")||str.equals("yes")){
                rest();
                System.out.println("You just got a recharge! You have "+this.life+" life now!");
            }
            else{
                System.out.println("You missed a chance to take rest! Keep going!");
            }
        }
        if(this.position==roomSize-1){
            System.out.println("You are at the end of the room! Would you like to exit the room?");
            System.out.println("Please enter 'yes' or 'no'.");
            String str=input.nextLine();
            if(str.equals("Yes")||str.equals("yes")){
                this.inRoom=false;
                this.room=2;
                System.out.println("You just exited the first room!");
            }
            else{
                System.out.println("Okay! Let's explore more!");
            }
        }
        if(this.Gameover==false&&this.inRoom==true){
            System.out.println("Where would you like to go next?");
            int a=input.nextInt();
            input.nextLine();
            explore(a);
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
    public boolean isGameOver(){
        if(this.life<=0){
            this.Gameover=true;
        }
        return this.Gameover;
    }
    public int getRoom(){
        return this.room;
    }
    public int getlife(){
        return this.life;
    }
    public int getproperty(){
        return this.property;
    }
    public static void main(String[] args) {

    }
}

