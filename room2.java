import java.util.*;
public class room2{
    int roomSize;
    int unknowncreatureposition[];
    int life;
    int killer[];
    int window[];
    int position;
    boolean inRoom;
    boolean Gameover;
    int room;
    Scanner input=new Scanner(System.in);
    public room2(int roomSize,int unknowncreatureposition[],int killer[],int window[],int life){
        this.roomSize=roomSize;
        this.unknowncreatureposition=unknowncreatureposition;
        this.killer=killer;
        this.window=window;
        this.life=life;
        this.position=0;
        this.inRoom=true;
        this.Gameover=false;
        this.room=2;
    }
    public void explore(int gotoposition){
        gotoposition=gotoposition-1;
        if(this.inRoom){
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
        else{
            System.out.println("You just exited the second room!");
        }
    }
    public void remind(){
        if(unknowncreatureposition[this.position]>0){
            this.life-=20;
        }
        if(killer[this.position]>0&&window[this.position]==0){
            System.out.println("Oops! There's a serial killer here! There is nowhere else you could go. Sorry, you are killed!");
            this.Gameover=true;
            this.life=0;
        }
        if(killer[this.position]>0&&window[this.position]>0){
            System.out.println("Oops! There's a serial killer here! But there's a window here! Go out from the window!");
            this.inRoom=false;
            hallway();
        }
        else if(window[this.position]>0){
            System.out.println("There's a window here. Would you like to get out of the room from the window?");
            System.out.println("Please enter 'yes' or 'no'.");
            String str=input.nextLine();
            if(str.equals("Yes")||str.equals("yes")){
                this.inRoom=false;
                hallway();
            }
            else{
                System.out.println("Ok! Keep exploring!");
            }
        }
        if(this.position==roomSize-1){
            System.out.println("You are at the end of the room! Would you like to exit the room?");
            System.out.println("Please enter 'yes' or 'no'.");
            String str=input.nextLine();
            if(str.equals("Yes")||str.equals("yes")){
                this.inRoom=false;
                this.room=3;
                System.out.println("You just exited the second room!");
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
    public void hallway(){
        System.out.println("You are out from the second room from window! Now you are in the hallway!");
        System.out.println("You need go on to the next room in order to escape from the haunted house!");
        System.out.println("There might be killers or ghosts in the hallway, be careful!");
        System.out.println("Killers and ghosts are randomly generated. Good Luck!");
        int a=(int)Math.random()*10;
        if(a==5){
            System.out.println("Oops! There's a serial killer here! There is nowhere else you could go. Sorry, you are killed!");
            this.Gameover=true;
            this.life=0;
        }
        if(a==1){
            System.out.println("Oops! There is a ghost here!");
            this.life-=10;
            if(this.life>0){
                System.out.println("You have "+this.life+" life remains!");
            }
            else{
                System.out.println("Sorry, you do not have any life values now. GAME OVER!!!");
                this.Gameover=true;
            }
        }
        if(this.Gameover==false&&this.life>0){
            System.out.println("You successfully passed the hall way without meeting anything scary! Congrats! You are going to visit the treasure room next!");
            this.room=3;
            this.inRoom=false;
        }
    }
    public int getRoom(){
        return this.room;
    }
    public boolean isGameOver(){
        if(this.life<=0){
            this.Gameover=true;
        }
        return this.Gameover;
    }
    public int getlife(){
        return this.life;
    }
    public static void main(String[] args) {

    }
}