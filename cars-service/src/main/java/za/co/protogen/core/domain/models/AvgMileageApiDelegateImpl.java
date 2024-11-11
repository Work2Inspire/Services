package za.co.protogen.core.domain.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import za.co.protogen.adapter.aCarMapperImpl;
import za.co.protogen.core.domain.models.delegate.AvgMileageApiDelegate;
import za.co.protogen.persistence.repository.CarRepository;

@Service
public class AvgMileageApiDelegateImpl implements AvgMileageApiDelegate {

    private final CarRepository carRepository;

    // Spring will automatically inject CarRepository here
    @Autowired
    public AvgMileageApiDelegateImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    private static final Logger logger = LoggerFactory.getLogger(AvgMileageApiDelegateImpl.class);
    aCarMapperImpl carMapper = new aCarMapperImpl();

    public ResponseEntity<String> getAvgMileage(){
        if (carRepository.findAll().isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Repository Empty: no cars to return");
        }//Check if repository is empty

        //Calculate average mileage through try-catch
        Long CarCount = carRepository.count();
        int MileageTotal=0;
        double totAvg = 0.00;
        try {
            for (int i = 0; i < carRepository.findAll().size() ; i++) {
                MileageTotal+=carRepository.findAll().get(i).getMileage();
            }
            totAvg= (double) MileageTotal /CarCount;
            logger.info("{} ran successfully", AvgMileageApiDelegateImpl.class.getSimpleName());
        } catch (Exception e) {
            logger.error("Failed to process total Average in {}",AvgMileageApiDelegateImpl.class.getSimpleName(),e);
            throw new RuntimeException(e);
        }


        return ResponseEntity.ok("Average = "+totAvg);

    }

}
