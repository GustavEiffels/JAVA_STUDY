package exchange.rate.proto.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import exchange.rate.proto.model.DailyData;

public interface DailyDataRepository extends JpaRepository<DailyData, UUID> 
{
    DailyData findByDateCodeAndCountryName(String dateCode, String countryName);
}
