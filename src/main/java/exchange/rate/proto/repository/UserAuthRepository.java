package exchange.rate.proto.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import exchange.rate.proto.model.entity.UserAuth;

public interface UserAuthRepository extends JpaRepository<UserAuth,UUID>
{
    Optional<UserAuth> findByLoginEmail(String loginEmail);
}
