
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
         String username="yr96";
        System.out.println("Enter 1 For Codechef \nEnter 2 For Hackerrank \nEnter 3 For Spoj");
       
        int choice=sc.nextInt();
         
        if(choice==1){
          
            System.out.println("Enter the user id for codechef");
        // username=sc.nextLine();
            Codechef obj=new Codechef(username);
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
