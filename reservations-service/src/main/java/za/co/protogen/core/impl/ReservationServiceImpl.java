package za.co.protogen.core.impl;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.co.protogen.core.ReservationService;
import za.co.protogen.domain.reservation;
import za.co.protogen.persistence.Reservation;
import za.co.protogen.persistence.repository.ResRepository;
import za.co.protogen.utility.Constant;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class ReservationServiceImpl implements ReservationService { //port = 9103
    private final ResRepository resRepo;

    @Autowired
    public ReservationServiceImpl(ResRepository resRepo){
        this.resRepo=resRepo;
    }

    @Override
    public String addReservation(Reservation res) {
//        Constant.reservations.add(res);
        resRepo.save(res);
        return "Reservation added suceessfully <br/>"+getAllReservations();
    }

    @Override
    public String removeReservation(Reservation res) {
//        Constant.reservations.remove(res);
        resRepo.delete(res);
        return "Reservation Removed Successfully <br/>All Reservations:<br/>"+getAllReservations();
    }

    @Override
    public Reservation getReservationById(Long id) {
        return resRepo.findAll().stream().filter(a->a.getId()==id).findFirst().orElse(null);

    }

    @Override
    public List<Reservation> getAllReservations() {
//        return Constant.reservations;
        return resRepo.findAll();
    }

    @Override
    public String updateReservation(Reservation res, String ansUpdate, String ansUpdateTo) {

        switch (ansUpdate) {
            case "a" :
                res.setId(Long.parseLong(ansUpdateTo));
                break;
            case "b":
                res.setUserId(Long.parseLong(ansUpdateTo));
                break;
            case "c":
                res.setCarId(Long.parseLong(ansUpdateTo));
                break;
            case "d":
                res.setFromDate(LocalDate.parse(ansUpdateTo));
                break;
            case "e":
                res.setToDate(LocalDate.parse(ansUpdateTo));
                break;
            case "f":
                res.setDropoffLocation(ansUpdateTo);
                break;
        }
        resRepo.save(res);
        return "Updated successfully <br/>"+res;
    }

    @Override
    public List<Reservation> searchReservations(String criteria) {
        List<String> strListOfRes = new ArrayList<>();
        List<String> splitStringCriteria = new ArrayList<>();
        //stores the criteria split using " " as delimeter
        List<Reservation> ListToReturn = new ArrayList<>();

        splitStringCriteria = List.of(criteria.split(" ")); // split criteria into array

        strListOfRes=resRepo.findAll().stream().map(Reservation::toString).toList();
        //Transform car objects from Constant.cars list into List of String

        for (int i = 0; i < strListOfRes.size(); i++) {
            int iSuccess=0; //Counts number of criteria current row passed

            for (int j = 0; j < splitStringCriteria.size(); j++) {
                if (strListOfRes.get(i).contains(splitStringCriteria.get(j))){
                    iSuccess++;
                }
                if (iSuccess==splitStringCriteria.size()){
                    //Using their index, i, Find its Reservation object equivalent and Add to listToReturn
                    ListToReturn.add(resRepo.findAll().get(i));
                }
            }//Cycle through split string

        }//Cycle through string list of Reservations

        return ListToReturn;
    } //if multiple criteria match completely
}
