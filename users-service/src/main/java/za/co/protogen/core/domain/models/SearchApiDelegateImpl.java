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
import za.co.protogen.core.domain.models.delegate.SearchApiDelegate;
import za.co.protogen.persistence.entityModel;
import za.co.protogen.persistence.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchApiDelegateImpl implements SearchApiDelegate {

    private final UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(RemoveUserApiDelegateImpl.class);
    // Spring will automatically inject ResRepository here
    @Autowired
    public SearchApiDelegateImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    aUserMapperImpl userMapper = new aUserMapperImpl();

    @Override
    public ResponseEntity<String> searchUser(String criteria) {
        //Check if repository is not null
        if (userRepository == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Repository Empty: no user to return");
        }
        List<String> strListOfUsers = new ArrayList<>();
        List<String> splitStringCriteria = new ArrayList<>();//stores the criteria after it was split using " " as delimeter
        List<String> lstToReturn = new ArrayList<>();

        splitStringCriteria = List.of(criteria.split(" ")); // split criteria into array
        strListOfUsers=userRepository.findAll().stream().map(entityModel::toString).toList();
        //Transform user objects from Constant.users list into List of String

        domainModel domUser;
        controllerModel conUser;
        //Check every word in strListUsers and compare them to the criteria, 1 or multiple divided by " "
        for (int i = 0; i < strListOfUsers.size(); i++) {
            int iSuccess=0; //Counts number of criteria current row passed

            for (int j = 0; j < splitStringCriteria.size(); j++) {
                if (strListOfUsers.get(i).contains(splitStringCriteria.get(j))){
                    iSuccess++;
                }
                if (iSuccess==splitStringCriteria.size()){
                    try{
                        //Map current entity to domain object then to controller object to be added into lstToReturn
                        domUser = userMapper.entityToDomain(userRepository.findAll().get(i));
                        conUser = userMapper.domainToCtrl(domUser);
                        lstToReturn.add(conUser+"<br/>");
                    }
                     catch (Exception e) {
                        logger.error("Failed to delete User in {}. User not found?", RemoveUserApiDelegateImpl.class.getSimpleName(),e);
                        throw new RuntimeException(e);
                    }
                }
            }//Cycle through split string
        }//Cycle through string list of Cars

        if (lstToReturn.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No user matches criteria");
        }
        return ResponseEntity.ok("Search Successful <br/>"+lstToReturn);
    }
}