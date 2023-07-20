package exchange.rate.proto.model;

import javax.persistence.Entity;

@Entity
public class DailyData extends BaseEntity
{
   private String                   dateCode;
   private String                   countryName;
   private String                   othersToWon;
   private String                   wonToOthers;
   private String                   tradingStandardRate;
}
