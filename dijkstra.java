import java.util.*;

class dijkstra{
    int[][] read_graph(int n,int a[][]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Matrix : ");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                a[i][j]=sc.nextInt();
            }
        }
        return a;
    }
    void dijkstra(int n,int a[][]){
        Scanner sc = new Scanner(System.in);
        int[] dist = new int[n];
        int[] visited = new int[n];
        int[] path = new int[n];
        int j;
        for(int i=0;i<n;i++){
            path[i]=9999;
            dist[i]=9999;
            visited[i]=0;
        }
        System.out.println("Enter Source : ");
        int src = sc.nextInt();
        int current,dc,min,count=1;
        current=src;
        visited[current]=1;
        dist[current]=0;
        while(count<=n)
        {
            dc=dist[current];
            for(int i=0;i<n;i++){
                if(a[current][i]!=0 && visited[i]!=1){
                    if(a[current][i] + dc < dist[i]){
                        dist[i] = a[current][i] + dc ;
                        path[i] = current;
                    }
                }
            }
            min = 9999;
            for(int i=0;i<n;i++){
                if(visited[i]!=1 && dist[i]<min){
                    min=dist[i];
                    current=i;
                }
            }
            visited[current] =1;
            count++;
        }
        for(int i=1;i<n;i++){
            System.out.println("Distance from "+src+"to "+i+"is : "+dist[i]);
        }
        for(int i=1;i<n;i++){
            System.out.println("Path for "+i+"is : "+i);
            j=i;
            while(j!=src){
                j=path[j];
                System.out.print("<-"+j);
            }
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        dijkstra d = new dijkstra();
        int n;
        System.out.println("Enter N : ");
        n=sc.nextInt();
        int[][] a = new int[n][n];
        a=d.read_graph(n,a);
        d.dijkstra(n,a);
    }
}