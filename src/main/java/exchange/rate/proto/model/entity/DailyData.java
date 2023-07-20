package exchange.rate.proto.model.entity;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DailyData extends BaseEntity
{
   private String                   dateCode;
   private String                   countryName;
   private String                   othersToWon;
   private String                   wonToOthers;
   private String                   tradingStandardRate;
}
