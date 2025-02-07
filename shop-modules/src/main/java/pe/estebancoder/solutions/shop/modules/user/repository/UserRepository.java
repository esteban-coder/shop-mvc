package pe.estebancoder.solutions.shop.modules.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.estebancoder.solutions.shop.modules.user.entity.UserEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    boolean existsByEmail(String email);

    List<UserEntity> findByActiveTrue();
    Optional<UserEntity> findByIdAndActiveTrue(Long id);


}
