package hellocucumber.repository;

import hellocucumber.entity.StepEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StepRepository extends JpaRepository<StepEntity, UUID> {
}
