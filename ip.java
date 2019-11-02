import java.util.*;

class ip
{
    public static void main(String args[])
    {
        System.out.println("Enter Hexadeicmal Dump : ");
        Scanner sc = new Scanner(System.in);
        String hex = sc.next();
        System.out.println("Version : IPV"+Integer.parseInt(hex.substring(0,1),16));
        int hlen = Integer.parseInt(hex.substring(1,2),16);
        hlen=hlen*4;
        System.out.println("Header Length : "+ hlen +" bytes");
        int service = Integer.parseInt(hex.substring(2,4),16);
        System.out.println("Service Type :  ");
        System.out.println("X   X   X   D   T   R   C   X ");
        for(int i=7;i>=0;i--) {
			System.out.print(((service>>i)&1)+"   ");
		}
        System.out.println("");
        System.out.println("Total Length : "+Integer.parseInt(hex.substring(4,8),16)+"");
        System.out.println("ID : "+Integer.parseInt(hex.substring(8,12),16));
        int decimal = Integer.parseInt(hex.substring(12,16), 16);
        String binary = Integer.toBinaryString(decimal);
        System.out.println("Flag Bits : XDM");
        System.out.println("Flag Bits : 0"+(binary.substring(0,2)));
        int offset = Integer.parseInt(binary.substring(2,15),2);
        System.out.println("Fragmentation Offset : "+offset);
        System.out.println("Time To Live : "+Integer.parseInt(hex.substring(16,18),16));
        int protocol = Integer.parseInt(hex.substring(18,20),16);
        System.out.println(protocol);
        if (protocol == 17)
        {
            System.out.println("Protocol : UDP");
        }
        else
        {
            System.out.println("Protocol : TCP");
        }
        
        System.out.println("Checksum : "+Integer.parseInt(hex.substring(20,24),16));
        System.out.println("Source IP Address : "+Integer.parseInt(hex.substring(24,26),16)+"."+Integer.parseInt(hex.substring(26,28),16)+"."+Integer.parseInt(hex.substring(28,30),16)+"."+Integer.parseInt(hex.substring(30,32),16));
        System.out.println("Destination IP Address : "+Integer.parseInt(hex.substring(32,34),16)+"."+Integer.parseInt(hex.substring(34,36),16)+"."+Integer.parseInt(hex.substring(36,38),16)+"."+Integer.parseInt(hex.substring(38,40),16));

    }
}