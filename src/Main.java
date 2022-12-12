import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    static ArrayList<String> myArrList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean finished;
        String Menu;
        int delete;
        String add;
        myArrList.add(" ");
        myArrList.add(1,"Current list:");
        do{
            int size = myArrList.size();
            display();
            Menu=SafeInput.getRegExString(in,"Would you like to Add, Delete, Print, or Quit", "[AaDdPpQq]");
            switch(Menu){
                case "A":
                case"a":
                    add = SafeInput.getNonZeroLenString(in,"What would you like to add?");
                    isAdded(add);
                    break;
                case "D":
                case "d":
                    delete = SafeInput.getRangedInt(in, "Enter the number of the item you want deleted ", 1, size);
                    isDeleted(delete);
                    break;
                case "P":
                case "p":
                    System.out.println("Displaying...");
                    display();
                    break;
                case "q":
                case "Q":
                    System.out.println("Quitting...");
                    break;
            }
            if(Menu.equalsIgnoreCase("Q")){
                break;
            }
            finished = SafeInput.getYNConfirm(in, "Enter another item? [Y/N]");
        }while (finished);
    }private static void isDeleted(int location){
        int deleteSpot = location+1;
        myArrList.set(deleteSpot, " ");
    }private static void display(){
        for(int i = 1; i< myArrList.size(); i++) {
            String var = myArrList.get(i);
            if (i > 1) {
                System.out.println((i - 1) + ". " + var);
            }else {
                System.out.println(var);
            }
        }
    }private static void isAdded(String add) {
        myArrList.add(add);
    }
}