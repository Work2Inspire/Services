package za.co.protogen.core.domain.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import za.co.protogen.adapter.aUserMapperImpl;
import za.co.protogen.controller.model.controllerModel;
import za.co.protogen.core.domain.domainModel;
import za.co.protogen.core.domain.models.delegate.GetUserIdApiDelegate;
import za.co.protogen.persistence.entityModel;
import za.co.protogen.persistence.repository.UserRepository;

@Service
public class GetUserIdApiDelegateImpl implements GetUserIdApiDelegate {

    private final UserRepository userRepository;
    @Autowired
    private static final Logger logger = LoggerFactory.getLogger(GetUserIdApiDelegateImpl.class);

    // Spring will automatically inject ResRepository here
    @Autowired
    public GetUserIdApiDelegateImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    aUserMapperImpl userMapper = new aUserMapperImpl();

    @Override
    public ResponseEntity<String> getById(int userId) {
        //Check if repository is null
        if (userRepository == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Repository Empty: no user to return");
        }
        domainModel domUser;
        controllerModel conUser;

        try{
            //find entity object meeting id criteria
            entityModel foundUser = userRepository.findAll().stream().filter(a->a.getId() == userId).findFirst().orElse(null);
            if (foundUser==null){//Make sure entity object is not null
                throw new Exception();
            }
            //convert to domain then controller object
            domUser = userMapper.entityToDomain(foundUser);
            conUser = userMapper.domainToCtrl(domUser);
        } catch (Exception e) {
            logger.error("Failed to convert to DTO in {}. Null domain user?", GetUserIdApiDelegateImpl.class.getSimpleName(),e);
            return ResponseEntity.ok("Error: Id not found/Empty Id input");
        }
        return ResponseEntity.ok("User returned: <br/>"+conUser);
    }
}