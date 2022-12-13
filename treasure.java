import java.util.*;
public class treasure{
    int size;
    int treasure[];
    int position;
    int property;
    boolean inRoom;
    int count;
    Scanner input=new Scanner(System.in);
    public treasure(int size,int treasure[],int property){
        this.position=0;
        this.inRoom=true;
        this.treasure=treasure;
        this.property=property;
        this.count=5;
        this.size=size;
    }
    public void explore(){
        while(this.inRoom&&this.count>0){
            int a=input.nextInt();
            input.nextLine();
            if(a<this.size&&a>=0){
                this.position=a;
                this.count--;
                if(treasure[this.position]>0){
                    this.property=this.property+20*treasure[this.position];
                    System.out.println("Hurray! There are some treasure here! Go pick them up!");
                    System.out.println("Yay, you just picked up these treasure. Now you have "+this.property+" dollars of assets!");
                }
                else{
                    System.out.println("Sorry, there's nothing here!");
                }
                if(this.count>0){
                    System.out.println("Let's go to the next position! Where would like to go next?");
                }
                else{
                    System.out.println("Sorry, you already moved five times in this room! You cannot go anywhere else.");
                    System.out.println("You are done with the journey in the haunted house!");
                    System.out.println("You successfully escaped from here!");
                }
            }
        }
    }
    public int getproperty(){
        return this.property;
    }
    public static void main(String[] args) {

    }
}