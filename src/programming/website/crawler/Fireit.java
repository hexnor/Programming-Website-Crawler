
package programming.website.crawler;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Document.OutputSettings;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;

/**
 * @author hexnor
 */
class Fireit extends Thread {
    String Foldername,ProblemName,url,dir="null";
    int count=0;
    
    
 Fireit(String foldername, String problemname, String url) {
    this.Foldername=foldername;
    this.ProblemName=problemname;
    this.url=url; 
    
   
    }
   
    public void run() {
        count++;
        dir="PWC-Created-by-Yokesh-Rana";
        dir=dir+"/" +Foldername+"/";
       File file = new File(dir);
       
       file.mkdirs();
       try {
        Document doc = Jsoup.connect(url).userAgent("Mozilla/17.0").get();
                
       Elements ele=doc.select("div[id=solutiondiv]");
       Elements header=ele.select("div[class=head]");
       Elements liele=ele.select("li");
       String sout="##########################################################################################################\n"
               +   "################ Programming Website Crawler (PWC) #######################################################\n"
               +   "##########################################################################################################\n\n\n";
          
      
    
       String sp = System.getProperty("line.separator");
          sout=sout.concat(sp+header.text()+""+sp);
         sp=sp+"\t";
           for (Element x : liele) {
            
             sout= sout.concat(sp+x.text()+"");
        
           }
           
        
            //System.out.println(text);
             sout+="\n\n##########################################################################################################\n"
               +   "################  FOR MORE INFO CONTACT ME AT yokeshrana@gmail.com  #######################################\n"
               +   "##########################################################################################################\n\n\n";
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dir+"/"+ProblemName+".txt")));
            out.write(sout);
            out.close();   
        } catch (FileNotFoundException ex) {
            System.out.println("File creation error");
            
        } catch (IOException ex) {
           System.out.println("!!!!!!||-- Server Down Trying Again After 500ms --||!!!!!!");
             if(count<5){try {
                
                Thread.sleep(1000);
                 run();
            } catch (InterruptedException ex1) {
                Logger.getLogger(Fireit.class.getName()).log(Level.SEVERE, null, ex1);
            }}
           
        }
        
     
    }

   
    
}
