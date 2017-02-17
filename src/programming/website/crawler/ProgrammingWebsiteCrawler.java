
package programming.website.crawler;

import java.util.Scanner;

/**
 
 * @author hexnor
 */
public class ProgrammingWebsiteCrawler {

    public static void main(String[] args) {
    
        Scanner sc=new Scanner(System.in);
         try {
                 int p=0;
                 String logd="############################################\n Programming Website Solution Crawler ###### \n############################################ ";
                 
                 while(p<logd.length())
                 {  Thread.sleep(10);
                     System.out.print(logd.charAt(p));
                     p++;
                 }
} catch(InterruptedException ex) {
    
}
        String username="";
        System.out.println("");
        System.out.println("######      Enter 1 For Codechef      ######");
        System.out.println("######      Enter 2 For Hackerrank    ######");
        System.out.println("######      Enter 3 For Spoj          ######");
        System.out.println("############################################");
        int choice=sc.nextInt();
         
        if(choice==1){
          
          System.out.print("Enter the user id for codechef :::  ");
        while(username.contains("\n")||username.equals(""))
          username=sc.nextLine();
            Codechef obj=new Codechef(username);
            System.out.print("username");
            System.out.println("Now starting");
            obj.start();
           System.out.println("fininshed");
        }else
            if (choice==2){
                new Hackerrack();
            }else
                if(choice==3)
                    new Spoj();
         
                      }
    
}
