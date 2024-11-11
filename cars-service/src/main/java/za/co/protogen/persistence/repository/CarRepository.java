package za.co.protogen.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.protogen.persistence.carEntity;


@Repository
public interface CarRepository extends JpaRepository<carEntity, String> {
}
