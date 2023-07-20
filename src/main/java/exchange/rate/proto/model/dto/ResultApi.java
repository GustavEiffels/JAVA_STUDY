package exchange.rate.proto.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 *  FOR GETTING DATA FROM API INVOICE
 */
public class ResultApi 
{

    private Integer result;
    private String  cur_unit;
    private String  cur_nm;
    private String  ttb;
    private String  tts;
    private String  deal_bas_r;
    private String  bkpr;
    private String  yy_efee_r;
    private String  kftc_deal_bas_r;
    private String  kftc_bkpr;
    private String  ten_dd_efee_r;

}
