package za.co.protogen.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.protogen.persistence.entityModel;

@Repository
public interface UserRepository extends JpaRepository<entityModel,Long> {
}
