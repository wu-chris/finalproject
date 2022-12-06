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
    Scanner input=new Scanner(System.in);
    public room2(int roomSize,int unknowncreatureposition[],int killer[],int window[]){
        this.roomSize=roomSize;
        this.unknowncreatureposition=unknowncreatureposition;
        this.killer=killer;
        this.window=window;
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
        if(unknowncreatureposition[this.position]>0){
            this.life-=20;
        }
        if(killer[this.position]>0&&window[this.position]>0){
            System.out.println("Oops! There's a serial killer here! But there's a window here! Go out from the window!");
            inRoom=false;
        }
        if(killer[this.position]>0&&window[this.position]==0){
            System.out.println("Oops! There's a serial killer here! There is nowhere else you could go. Sorry, you are killed!");
            this.Gameover=true;
            this.life=0;
        }
        if(window[this.position]>0){
            System.out.println("There's a window here. Would you like to get out of the room from the window?");
            String str=input.nextLine();
            if(str.equals("Yes")||str.equals("yes")){
                this.inRoom=false;
                System.out.println("You are out of the room!");
            }
            else{
                System.out.println("Ok! Keep exploring! Where do you want to go next?");
                int s=input.nextInt();
                explore(s);
            }
        }
    }
    public static void main(String[] args) {

    }
}