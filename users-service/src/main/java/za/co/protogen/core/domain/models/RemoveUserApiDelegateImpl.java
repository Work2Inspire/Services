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
import za.co.protogen.core.domain.models.delegate.RemoveUserApiDelegate;
import za.co.protogen.persistence.entityModel;
import za.co.protogen.persistence.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class RemoveUserApiDelegateImpl implements RemoveUserApiDelegate {

    private final UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(RemoveUserApiDelegateImpl.class);

    // Spring will automatically inject ResRepository here
    @Autowired
    public RemoveUserApiDelegateImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    aUserMapperImpl userMapper = new aUserMapperImpl();

    @Override
    public ResponseEntity<String> deleteUser(Long id) {
        //Check if repository null
        if (userRepository == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Repository Empty: no user to return");
        }
        //Return entity object fitting criteria
        entityModel foundUser = userRepository.findAll().stream().filter(a->a.getId() == id).findFirst().orElse(null);

        try{
            if (foundUser==null){//Make sure entity object is not null before deleting
                throw new Exception();
            }
            userRepository.delete(foundUser);
        } catch (Exception e) {
            logger.error("Failed to delete User in {}. User not found?", RemoveUserApiDelegateImpl.class.getSimpleName(),e);
            throw new RuntimeException(e);
        }


        domainModel domUser;
        controllerModel conUser;
        List<controllerModel> lstToReturn = new ArrayList<>();
        //Returning All users but converting them from entity to domain then cnotroller object before adding to lstToReturn
        for (int i = 0; i < userRepository.findAll().size(); i++) {
            try {
                domUser = userMapper.entityToDomain(userRepository.findAll().get(i));
                conUser = userMapper.domainToCtrl(domUser);
                lstToReturn.add(conUser);
            }
             catch (Exception e) {
                 logger.error("Failed to convert to DTO in {}. Null domain user?", GetUserIdApiDelegateImpl.class.getSimpleName(), e);
                 throw new RuntimeException(e);
             }
        }
        return ResponseEntity.ok("User deleted Successfully: <br/>"+lstToReturn);

    }
}