package spos;
import java.util.Scanner;  
class spos1
{ 
    public static void main(String args[])
    {
        int burst_time[],process[],waiting_time[],tat[],i,j,n,total=0,pos,temp; 
        float wait_avg=0, TAT_avg=0; 
        Scanner s = new Scanner(System.in); 
        System.out.print("Enter number of process: "); 
        n = s.nextInt(); process = new int[n]; 
        burst_time = new int[n];
        waiting_time = new int[n]; 
        tat = new int[n];  
        System.out.println("\nEnter Burst time:"); 
        for(i=0;i<n;i++) 
        { 
            System.out.print("\nProcess["+(i+1)+"]: "); burst_time[i] = s.nextInt();
            process[i]=i+1; //Process Number 
            }  
            //First process has waiting time 
            waiting_time[0]=0;  
            //calculate waiting time  
            for(i=1;i<n;i++) 
            { 
                waiting_time[i]=0; 
                for(j=0;j<i;j++) 
                waiting_time[i]+=burst_time[j]; 
                total+=waiting_time[i];
                }  //Calculating Average waiting time 
                wait_avg=(float)total/n; 
                total=0;
                System.out.println("\nProcess\t Burst Time \tWaiting Time\tTurnaround Time"); 
                for(i=0;i<n;i++) 
                { 
                    tat[i]=burst_time[i]+waiting_time[i]; 
                    total+=tat[i];
                    //Calculating TurnaroundTime
                    //total+=tat[i]; 
        System.out.println("\n p"+process[i]+"\t\t\t"+burst_time[i]+"\t\t\t\t\t"+waiting_time[i]+"\t\t\t "+tat[i]); 
                    
                }  //Calculation of Average Turnaround Time 
                TAT_avg=(float)total/n; 
        System.out.println("\n\nAverage Waiting Time: "+wait_avg); 
        System.out.println("\nAverage Turnaround Time: "+TAT_avg); 
        
    } 
}
