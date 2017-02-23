
package programming.website.crawler;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
class makefolder extends Thread {
   String url;
   String originalurl1[];//for comp name
    String originalurl2[];//for url
   String problemname;
   String foldername;
   String newurl;

    public makefolder(Element x) {
        this.url=x.toString();
       this.originalurl1=x.toString().split("/");
       this.originalurl2=x.toString().split("\"");
       problemname=x.text();
       
    }

   
    public void run() {
      url=extracturl(originalurl2);
        foldername=extractcompetition(originalurl1);
       
       // System.out.println(foldername);
       try {
           Document doc = Jsoup.connect("http://codechef.com/"+url).userAgent("Mozilla/17.0").get();
          
              Elements all = doc.select("a[href]");
              Thread.sleep(500);
              int i=0;
              for(Element x: all){
                  i++;
				if(x.attr("href").contains("/viewsolution/"))
                                {
                                      String supply=problemname+"-"+i;
                                   newurl="http://codechef.com"+x.attr("href");
                                   // System.out.println(newurl);
                                  Fireit obj= new Fireit(foldername,supply,newurl) ;       //compname /problem url /problem name 
                                  obj.start();
                                    System.out.println("+++ Wrting file "+supply+" in Folder  "+ foldername + "++++");
                                }
			}
              
              
          // BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream()));
       } catch (IOException ex) {
           
           System.out.println("@ @ @   Server Down !!! Trying one more time  @ @ @");
           run();
       } catch (InterruptedException ex) {
           System.out.println("@ @ @   Server Down !!! Trying one more time  @ @ @");
           run();
       }
    }
    private String extractcompetition(String ori[]) {
        String comp="Practice";
        if(url.charAt(10)!='s')
        {
            comp=ori[1];
        }
        return comp;
    }

    private String extracturl(String ori[]) {
       return ori[1];
          
      }
    
}
