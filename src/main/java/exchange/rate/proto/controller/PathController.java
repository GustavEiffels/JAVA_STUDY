package exchange.rate.proto.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PathController 
{

   
    @GetMapping("/invoice")
    public @ResponseBody String invoiceAPI()
    {
        String                      status                  = "DONE";
        String                      url                     = "API";
        String                      defaultLine             ;
        try 
        {
            URL                     apiUrl                  = new URL(url);
            HttpsURLConnection      connection              = (HttpsURLConnection) apiUrl.openConnection();
            connection.setRequestMethod("GET");    

            BufferedReader          bReader                 = new BufferedReader(new InputStreamReader( connection.getInputStream() ));
            
            while(true)
            {
                                    defaultLine             = bReader.readLine();
                if(defaultLine == null ) break;
                else
                {
                    System.out.println(defaultLine);
                }
            }

        } 
        catch (Exception e) 
        {
            status = "FAIL";
            e.getStackTrace();
        }
        finally
        {
            return status;
        }
        
    }

}
