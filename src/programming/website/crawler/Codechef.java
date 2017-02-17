
package programming.website.crawler;


import java.util.LinkedList;
import java.util.List;


import static jdk.nashorn.internal.objects.NativeRegExp.exec;
import static jdk.nashorn.internal.runtime.ScriptingFunctions.exec;

import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author hexnor
 */
class Codechef extends Thread  {

    private  String username;
  
   private List<String> problem= new LinkedList<String>();
    Codechef(String username) {
       this.username=username;
    }
    

   
    public void run() {
        try {
          //  System.out.println("inside codechef");
           Document doc = Jsoup.connect("http://codechef.com/users/"+username).userAgent("Mozilla/17.0").get();
           Elements all = doc.select("a[href]");
           for(Element x: all){
				if(x.attr("href").contains("/status/"))
                                {
                                    problem.add(x.toString());
                                 //   System.out.println(x.toString());
                                makefolder l=new makefolder(x);
                                l.start();
                               // System.out.println(x);
                                }
			}
           
           int length=problem.toArray().length;
            System.out.println("Total no of Problems Solved == "+length); 
            
            
        } catch (Exception e) {
        }
         
    }

    
    
    
    
    
    
}
