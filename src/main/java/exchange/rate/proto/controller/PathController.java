package exchange.rate.proto.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import exchange.rate.proto.service.DailyDataService;



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

    @GetMapping("/joinProc")
    public String joinForm() { return "joinForm.html"; }

    @GetMapping("/loginProc")
    public String loginForm() { return "loginForm.html"; }

}
