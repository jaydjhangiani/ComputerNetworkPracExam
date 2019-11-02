import java.util.*;

class hamming{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);	
        int i,count1=0,count2=0,count4=0,count8=0,j=0,y=11;
        int db [] = new int[7];
        System.out.println("Enter Data Bits : ");
        for(i=0;i<7;i++)
            db[i]=sc.nextInt();

        int hc [] = new int[11];
        for(i=10;i>=0;i--){
            if(i!=7 && i!=3 && i!=1 && i!=0)
                hc[i]=db[j++];
        }
        
        for(i=0;i<11;i++){
            if(i%2==0){
                if (hc[i]==1)
                    count1++;
            }

            if(i==1 || i==2 || i==5 || i==6 || i==9 || i==10){
                if (hc[i]==1)
                    count2++;
            }

            if(i>=3 && i<=6){
                if (hc[i]==1)
                    count4++;
            }

            if(i>=7 && i<=10){
                if (hc[i]==1)
                    count8++;
            }               
        
        }

        hc[0] = setBit(count1);
        hc[1] = setBit(count2);
        hc[3] = setBit(count4);
        hc[7] = setBit(count8);

        for(i=10;i>=0;i--){
            System.out.print(hc[i]);
        }

        System.out.println("");

        int rd [] = new int [11];
        System.out.println("Enter Recieved Bits : ");
        for(i=0;i<11;i++){
            rd[i] = sc.nextInt();
        }
        i=10;
        for(j=0;j<11;j++){
            if (rd[j] != hc[i--]){
                System.out.println("Error at position "+(i+2));
                y--;
            }
        }

        if(y==11)
            System.out.println("Data Recieved Correctly!!");
        
    
    }

       public static int setBit(int c){
            if(c%2==0)
                return 0;
            else  
                return 1;
        }	
}