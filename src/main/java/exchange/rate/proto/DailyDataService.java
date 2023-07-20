package exchange.rate.proto;

import java.net.URL;
import java.util.Arrays;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import exchange.rate.proto.model.ResultApi;
import exchange.rate.proto.repository.DailyDataRepository;

@Service
public class DailyDataService 
{
    @Autowired
    private             DailyDataRepository                     dailyDataRepository;

    public String InvoiceGetExchangeRateAPI()
    {
        String                      status                  = "DONE";
        String                      url                     = "";

        try 
        {
            URL                     apiUrl                  = new URL(url);
            HttpsURLConnection      connection              = (HttpsURLConnection) apiUrl.openConnection();
            connection.setRequestMethod("GET");    

            ObjectMapper            mapper                  = new ObjectMapper();
            List<ResultApi>         apiData                 = Arrays.asList(mapper.readValue(connection.getInputStream(), ResultApi[].class));
            
            for(ResultApi data : apiData)                 System.out.println(data.getCur_nm());

            

        } 
        catch (Exception e) 
        {
            status = "FAIL";
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.getStackTrace();
        }
        finally
        {
            return status;
        }
    }
}
