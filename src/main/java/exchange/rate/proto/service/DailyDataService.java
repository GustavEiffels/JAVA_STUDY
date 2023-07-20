package exchange.rate.proto.service;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

import exchange.rate.proto.model.dto.ResultApi;
import exchange.rate.proto.model.entity.DailyData;
import exchange.rate.proto.repository.DailyDataRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DailyDataService 
{
    @Autowired
    private             DailyDataRepository                     dailyDataRepository;
    private             DailyData                               dailyData;
    private             SimpleDateFormat                        format                  = new SimpleDateFormat("yyyyMMdd"); 
    private             String                                  todayDateCode           = format.format(new Date());                



    private String mainLogic(List<ResultApi> dataList)
    {

        String              resultCode              =               "normal";
        try {

            for(ResultApi apiData : dataList)
            {
                if( apiData.getResult() != 1 )
                {
                    log.info("Error Emerge");
                    resultCode = "Data Error";
                    break;
                }

            if( ( dailyData = dailyDataRepository.findByDateCodeAndCountryName(todayDateCode, apiData.getCur_nm()) ) == null )
            {
                
                DailyData               newData             =   new DailyData();
                

                log.info(apiData.getCur_nm());
                log.info(apiData.getDeal_bas_r());
                log.info(apiData.getTtb());
                log.info(apiData.getTts());
                log.info(todayDateCode);


                newData.setCountryName          (       apiData.getCur_nm()        );
                newData.setDateCode             (       todayDateCode              );
                newData.setOthersToWon          (       apiData.getTtb()           );
                newData.setWonToOthers          (       apiData.getTts()           );
                newData.setTradingStandardRate  (       apiData.getDeal_bas_r()    );

                dailyDataRepository.save(newData);

            }
            // update
            else 
            {
                log.info(" dailyData : ",dailyData.getCountryName() );
                log.info("WILL BE UPDATE CODE : ",new Date().toString());
            }
        }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            resultCode                  =                   "ABNORMAL";

        }
        return resultCode;
        
    }

    public String InvoiceGetExchangeRateAPI()
    {
        String                      status                  = "DONE";
        String                      apiKey                  = "";
        String                      url                     = "https://www.koreaexim.go.kr/site/program/financial/exchangeJSON?authkey="+apiKey+"&searchdate="+todayDateCode+"&data=AP01";

        try 
            {
                URL                     apiUrl                  = new URL(url);
                HttpsURLConnection      connection              = (HttpsURLConnection) apiUrl.openConnection();
                connection.setRequestMethod("GET");    

                ObjectMapper            mapper                  = new ObjectMapper();
                List<ResultApi>         apiData                 = Arrays.asList(mapper.readValue(connection.getInputStream(), ResultApi[].class));
                
                return mainLogic(apiData);

            } 
        catch (Exception e) 
            {
                status = "FAIL";
                System.out.println(e.getMessage());
                System.out.println(e.getCause());
                e.getStackTrace();                
                return status;

            }

    }


}
