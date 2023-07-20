package exchange.rate.proto.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import exchange.rate.proto.model.entity.DailyData;

public interface DailyDataRepository extends JpaRepository<DailyData, UUID> 
{
    DailyData findByDateCodeAndCountryName(String dateCode, String countryName);
}
