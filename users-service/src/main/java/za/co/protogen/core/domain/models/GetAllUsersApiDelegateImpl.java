package za.co.protogen.core.domain.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import za.co.protogen.adapter.aUserMapperImpl;
import za.co.protogen.controller.model.controllerModel;
import za.co.protogen.core.domain.domainModel;
import za.co.protogen.core.domain.models.delegate.GetAllUsersApiDelegate;
import za.co.protogen.persistence.entityModel;
import za.co.protogen.persistence.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetAllUsersApiDelegateImpl implements GetAllUsersApiDelegate {

    private final UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;
    private static final Logger logger = LoggerFactory.getLogger(GetUserIdApiDelegateImpl.class);

    // Spring will automatically inject ResRepository here
    @Autowired
    public GetAllUsersApiDelegateImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    aUserMapperImpl userMapper = new aUserMapperImpl();

    @Override
    public ResponseEntity<String> getAllUsers() {
        //check if repository is null
        if (userRepository == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Repository Empty: no user to return");
        }
        List<String> lstToReturn = new ArrayList<>();
        List<entityModel> lstOfReservation = new ArrayList<>();
        //Add list of entity objects into List
        lstOfReservation.addAll(userRepository.findAll());

        domainModel domUser;
        controllerModel conUser;
        for (int i = 0; i < lstOfReservation.size(); i++) {
            try {//go over each item in List and convert each into domain then controller object and finally add to lstReturn List
                domUser = userMapper.entityToDomain(lstOfReservation.get(i));
                conUser = userMapper.domainToCtrl(domUser);
                lstToReturn.add(conUser + "<br/>");
            }
             catch (Exception e) {
                 logger.error("Failed to convert to DTO in {}. Null domain user?", GetUserIdApiDelegateImpl.class.getSimpleName(), e);
                 throw new RuntimeException(e);
             }
        }
        return ResponseEntity.ok("Returned All users: <br/>"+lstToReturn);
    }
}