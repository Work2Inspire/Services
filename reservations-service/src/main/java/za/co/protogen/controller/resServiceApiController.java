package za.co.protogen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import za.co.protogen.core.ReservationService;
import za.co.protogen.core.impl.ReservationServiceImpl;
import za.co.protogen.domain.Reservation;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/ctrl/")
public class resServiceApiController {
    @Autowired
    private RestTemplate restTemplate;
    ReservationService resService = new ReservationServiceImpl();

    @RequestMapping("/add_res")
    public String Add_Res(@RequestParam Long id,@RequestParam Long userId, @RequestParam Long vin, @RequestParam LocalDate fromDate, @RequestParam LocalDate toDate, @RequestParam String pLocation, @RequestParam String dLocation) {
        String getCarURI = "http://localhost:9102/api/ctrl/getCar_id?vin="+vin;
        String carResponse = restTemplate.getForObject(getCarURI, String.class);

        if (!carResponse.equals("Error: No car found")){//if string returned is not "No car found"
            return "CarId already exists";
        }
        String getUserURI = "http://localhost:9101/api/ctrl/getuser_id?Id="+userId;
        String userResponse = restTemplate.getForObject(getUserURI, String.class);
        if (!userResponse.equals("Id not found/Empty Id")){
            return "UserId already exists";
        }
        Reservation newRes = new Reservation();
        newRes.setId(id);
        newRes.setUserId(userId);
        newRes.setCarId(vin);
        newRes.setFromDate(fromDate);
        newRes.setToDate(toDate);
        newRes.setPickUpLocation(pLocation);
        newRes.setDropoffLocation(dLocation);
        resService.addReservation(newRes);

        return "Reservation Added successfully";
    }

    @RequestMapping("/remove_res/{id}")
    public String Remove_Res(@PathVariable Long id) {
        return resService.removeReservation(resService.getReservationById(id));
    }

    @GetMapping("getAll_Res")
    public List<Reservation> getAll(){
        return resService.getAllReservations();
    }

    @RequestMapping("update/{Res}/{sWhat}/{sTo}")
    public String updateRes(@PathVariable Long Res,@PathVariable String sWhat, @PathVariable String sTo){
        //"sWhat" Options
        // a.ReservationId
        // b.UserId
        // c.CarId
        // d.From Date
        // e.To Date
        // f.DropoffLocation
        // g.PickUpLocation
        if (!(sWhat.length() == 1 && sWhat.charAt(0) >= 'a' && sWhat.charAt(0) <= 'k')) {
            return "Error: Option is invalid";
        }
        Reservation upRes = resService.getReservationById(Res);
        if (upRes==null){
            return "Error: Reservation not found";
        }

        return resService.updateReservation(upRes,sWhat,sTo);
    }

    @GetMapping("/search/{criteria}")
    public String searchRes(@PathVariable String criteria)
    {   List<Reservation> retrunedList=resService.searchReservations(criteria);
        String returnString="";

        if (retrunedList.isEmpty()){
            return "No Reservation match";
        }
        for (int i = 0; i < retrunedList.size(); i++) {
            returnString+=retrunedList.get(i).toString()+"<br/>";
        }
        return "Results are as follows: <br/>"+returnString;
    }

}
