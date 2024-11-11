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
import za.co.protogen.core.domain.models.delegate.UpdateApiDelegate;
import za.co.protogen.persistence.entityModel;
import za.co.protogen.persistence.repository.UserRepository;

import java.time.LocalDate;

@Service
public class UpdateApiDelegateImpl implements UpdateApiDelegate {

    private final UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(UpdateApiDelegateImpl.class);

    // Spring will automatically inject ResRepository here
    @Autowired
    public UpdateApiDelegateImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    aUserMapperImpl userMapper = new aUserMapperImpl();

    @Override
    public ResponseEntity<String> updateUser(Long userId, String sWhat, String sTo) {
        //Check if repository is not null
        if (userRepository == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Repository Empty: no user to return");
        }
        //check if user's sWhat input is correct
        if (!(sWhat.length() == 1 && sWhat.charAt(0) >= 'a' && sWhat.charAt(0) <= 'e')) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Option is invalid");
        }
        //sWhat options----------
        //a.id
        //b.First Name
        //c.Last Name
        //d.DOB
        //e.RSAid

        //find the user to update using provided id
        entityModel entfoundUser = userRepository.findAll().stream().filter(a -> a.getId() == userId).findFirst().orElse(null);

        try {
            if (entfoundUser==null){//Make sure entity object is not null
                throw new Exception();
            }
            switch (sWhat) {
                case "a":
                    entfoundUser.setId(Long.parseLong(sTo));
                    break;
                case "b":
                    entfoundUser.setFirstName(sTo);
                    break;
                case "c":
                    entfoundUser.setLastName(sTo);
                    break;
                case "d":
                    entfoundUser.setDateOfBirth(LocalDate.parse(sTo));
                    break;
                case "e":
                    entfoundUser.setRsaId(sTo);
                    break;
            }
            userRepository.save(entfoundUser);
        } catch (Exception e) {
            logger.error("Failed to update entity in {}. entity user is null?", RemoveUserApiDelegateImpl.class.getSimpleName(), e);
            throw new RuntimeException(e);
        }

        domainModel domUser;
        controllerModel conUser;
        try{//convert entity object to domain then controller object to send back to client
            domUser = userMapper.entityToDomain(entfoundUser);
            conUser = userMapper.domainToCtrl(domUser);

            return ResponseEntity.ok("Update successful<br/>" + conUser);
        }
        catch (Exception e) {
            logger.error("Failed to convert user in {}. User not found?", RemoveUserApiDelegateImpl.class.getSimpleName(),e);
            throw new RuntimeException(e);
        }
    }
}