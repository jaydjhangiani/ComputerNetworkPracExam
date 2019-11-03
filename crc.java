import java.util.*;

class testcrc{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter size of data : ");
        n = sc.nextInt();
        int data[] = new int[n];
        System.out.println("Enter data : ");
        for(int i=0;i<n;i++){
            data[i]=sc.nextInt();
        }

        System.out.println("Enter size of key : ");
        n = sc.nextInt();
        int divisor[] = new int[n];
        System.out.println("Enter divisor : ");
        for(int i=0;i<n;i++){
            divisor[i]=sc.nextInt();
        }

        System.out.println("Remainder is : ");
        int rem[]=divide(data,divisor);
        for(int i=0;i<rem.length-1;i++){
            System.out.print(rem[i]);
        }
        System.out.println("");

        System.out.println("CRC is : ");
        for(int i=0;i<data.length;i++){
            System.out.print(data[i]);
        }
        for(int i=0;i<rem.length-1;i++){
            System.out.print(rem[i]);
        }
        System.out.println("");

        System.out.println("Enter Recieved Data : ");
        int rec [] = new int[data.length + rem.length - 1];
        for(int i=0;i<rec.length;i++){
            rec[i] = sc.nextInt();
        }
        recieve(rec,divisor);
    }

    static int[] divide(int old_data[],int divisor[]){
        int data[] = new int[old_data.length + divisor.length];
        System.arraycopy(old_data,0,data,0,old_data.length);
        int rem[] = new int[divisor.length];
        System.arraycopy(data,0,rem,0,divisor.length);
        for(int i=0;i<old_data.length;i++){
            if(rem[0] == 1){
                for(int j=1;j<divisor.length;j++){
                    rem[j-1]=exor(rem[j],divisor[j]);
                }
            }
            else{
                for(int j=1;j<divisor.length;j++){
                    rem[j-1]=exor(rem[j],0);
                }
            }
            rem[divisor.length - 1] = data[divisor.length+i];
        }
        return rem;
    } 

    static int exor(int a,int b){
        if(a==b){
            return 0;
        }
        return 1;
    }

    static void recieve(int data[],int divisor[]){
        int rem[] = divide(data,divisor);
        for(int i=0;i<rem.length;i++){
            if(rem[i]!=0){
                System.out.println("ERROR!");
                return;
            }
        }
        System.out.println("Perf");
    }
}