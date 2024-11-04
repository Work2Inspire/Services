package za.co.protogen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import za.co.protogen.core.impl.ReservationServiceImpl;
import za.co.protogen.domain.reservation;
import za.co.protogen.persistence.Reservation;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/ctrl/")
public class resServiceApiController {
    @Autowired
    private RestTemplate restTemplate;
//    ReservationService resService = new ReservationServiceImpl();

    private final ReservationServiceImpl resServiceImpl;
    @Autowired
    public resServiceApiController( ReservationServiceImpl resServiceImpl){
        this.resServiceImpl =resServiceImpl;
    }

    @RequestMapping("/add_res")
    public String Add_Res(@RequestParam Long id,@RequestParam Long userId, @RequestParam Long vin, @RequestParam LocalDate fromDate, @RequestParam LocalDate toDate, @RequestParam String pLocation, @RequestParam String dLocation) {
        String getCarURI = "http://localhost:9102/api/ctrl/getCar_id?vin="+vin;
        String carResponse = restTemplate.getForObject(getCarURI, String.class);
        if (!carResponse.equals("Error: No car found")){//if string returned is not "No car found"
            return "CarId already exists";
        }
        String getUserURI = "http://localhost:9101/api/ctrl/getuser_id?Id="+userId;
        String userResponse = restTemplate.getForObject(getUserURI, String.class);
        if (!userResponse.equals("Error: Id not found/Empty Id input")){
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
        return resServiceImpl.addReservation(newRes);
        //http://localhost:9103/api/ctrl/add_res?id=1&userId=101&vin=202&fromDate=2024-11-01&toDate=2024-11-10&pLocation=NewYork&dLocation=Boston
    }

    @RequestMapping("/remove_res/{id}")
    public String Remove_Res(@PathVariable Long id) {
        Reservation foundRes=resServiceImpl.getReservationById(id);
        if (foundRes==null){
            return "Error: ID not found";
        }
        return resServiceImpl.removeReservation(foundRes);
    }

    @GetMapping("getAll_Res")
    public String getAll(){
        return resServiceImpl.getAllReservations().toString();
    }

    @RequestMapping("update/{ResId}/{sWhat}/{sTo}")
    public String updateRes(@PathVariable Long ResId,@PathVariable String sWhat, @PathVariable String sTo){
        //"sWhat" Options
        // a.ReservationId
        // b.UserId
        // c.CarId
        // d.From Date
        // e.To Date
        // f.DropoffLocation
        // g.PickUpLocation
        if (!(sWhat.length() == 1 && sWhat.charAt(0) >= 'a' && sWhat.charAt(0) <= 'g')) {
            return "Error: Option is invalid";
        }
        Reservation upRes = resServiceImpl.getReservationById(ResId);
        if (upRes==null){
            return "Error: Reservation not found";
        }

        return resServiceImpl.updateReservation(upRes,sWhat,sTo);
    }

    @GetMapping("/search/{criteria}")
    public String searchRes(@PathVariable String criteria)
    {   List<Reservation> retrunedList= resServiceImpl.searchReservations(criteria);
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
