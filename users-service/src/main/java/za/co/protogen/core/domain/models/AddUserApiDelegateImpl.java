package za.co.protogen.core.domain.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import za.co.protogen.adapter.aUserMapperImpl;
import za.co.protogen.controller.model.controllerModel;
import za.co.protogen.core.domain.domainModel;
import za.co.protogen.core.domain.models.delegate.AddUserApiDelegate;
import za.co.protogen.persistence.entityModel;
import za.co.protogen.persistence.repository.UserRepository;

import java.time.LocalDate;

@Service
public class AddUserApiDelegateImpl implements AddUserApiDelegate {

    private final UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;

    // Spring will automatically inject ResRepository here
    @Autowired
    public AddUserApiDelegateImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    aUserMapperImpl userMapper = new aUserMapperImpl();

    @Override
    public ResponseEntity<String> createUser(Long id, String fName, String lName, LocalDate DOB, String rsaId) {
        //Create domain object
        domainModel newUser = new domainModel();
        newUser.setUserId(id);
        newUser.setFirstName(fName);
        newUser.setLastName(lName);
        newUser.setDateOfBirth(DOB);
        newUser.setRsaId(rsaId);

        //Map domain Object to entity then save
        entityModel entityModel = userMapper.domainToEntity(newUser);
        userRepository.save(entityModel);
        //Map entity back to domain then controller model to give the client
        domainModel domReturn = userMapper.entityToDomain(entityModel);
        controllerModel conReturn = userMapper.domainToCtrl(domReturn);

        return ResponseEntity.ok("Saved Successfully."+userRepository.findAll().size()+" user(s) in repository: <br/>"+conReturn);

    }
}