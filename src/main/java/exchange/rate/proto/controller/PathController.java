package exchange.rate.proto.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import exchange.rate.proto.DailyDataService;



@Controller
public class PathController 
{

    @Autowired
    private DailyDataService dailyDataService;
   
    @GetMapping("/invoice")
    public @ResponseBody String invoiceAPI()
    {
        return dailyDataService.InvoiceGetExchangeRateAPI();
    }

    @GetMapping("/today")
    public @ResponseBody String getToday()
    {

        return new Date().toString();
    }

}
