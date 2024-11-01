package za.co.protogen.core.impl;

import za.co.protogen.core.ReservationService;
import za.co.protogen.domain.Reservation;
import za.co.protogen.utility.Constant;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservationServiceImpl implements ReservationService {
    @Override
    public void addReservation(Reservation res) {
        Constant.reservations.add(res);
    }

    @Override
    public void removeReservation(Reservation res) {
        Constant.reservations.remove(res);
    }

    @Override
    public Reservation getReservationById(Long id) {
        return Constant.reservations.stream().filter(a->a.getId()==id).findFirst().orElse(null);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return Constant.reservations;
    }

    @Override
    public void updateReservation(Reservation res,String ansUpdate,String ansUpdateTo) {


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
            case "g":
                res.setPickUpLocation(ansUpdateTo);
                break;
        }
    }

    @Override
    public List<Reservation> searchReservations(String criteria) {
        List<String> strListOfRes = new ArrayList<>();
        List<String> splitStringCriteria = new ArrayList<>();
        //stores the criteria split using " " as delimeter
        List<Reservation> ListToReturn = new ArrayList<>();

        splitStringCriteria = List.of(criteria.split(" ")); // split criteria into array

        strListOfRes=Constant.reservations.stream().map(Reservation::toString).toList();
        //Transform car objects from Constant.cars list into List of String

        for (int i = 0; i < strListOfRes.size(); i++) {
            int iSuccess=0; //Counts number of criteria current row passed

            for (int j = 0; j < splitStringCriteria.size(); j++) {
                if (strListOfRes.get(i).contains(splitStringCriteria.get(j))){
                    iSuccess++;
                }
                if (iSuccess==splitStringCriteria.size()){
                    //Using their index, i, Find its reservation object equivalent and Add to listToReturn
                    ListToReturn.add(Constant.reservations.get(i));
                }
            }//Cycle through split string

        }//Cycle through string list of Reservations

        return ListToReturn;
    } //if multiple criteria match completely
}
