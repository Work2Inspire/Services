package za.co.protogen.persistence.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.protogen.persistence.Car;


@Repository
public interface CarRepository extends JpaRepository<Car, String> {
}
