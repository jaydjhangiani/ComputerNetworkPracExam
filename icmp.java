import java.util.*;

class icmp{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter hex dump : ");
        String hex = sc.next();
        System.out.println("");
        System.out.println("Type : "+(Integer.parseInt(hex.substring(0,2),16)));
        System.out.println("Code : "+(Integer.parseInt(hex.substring(2,4),16)));
        System.out.println("Checksum : "+(Integer.parseInt(hex.substring(4,8),16)));
        System.out.println("Rest of the header : "+(Integer.parseInt(hex.substring(8,16),16)));
        System.out.println("Data : "+(Integer.parseInt(hex.substring(16,24),16)));
    }
}