import java.util.*;

class udp{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Hex Dump : ");
        String hex = sc.next();
        System.out.println("SOURCE PORT NUMBER : "+Integer.parseInt(hex.substring(0,2),16));
        System.out.println("DESTINATION PORT NUMBER : "+Integer.parseInt(hex.substring(2,4),16));
        System.out.println("LENGTH : "+Integer.parseInt(hex.substring(4,6),16));
        System.out.println("CHECKSUM : "+Integer.parseInt(hex.substring(6,8),16));
    }
}