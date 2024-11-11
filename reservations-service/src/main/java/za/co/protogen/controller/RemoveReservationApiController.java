package za.co.protogen.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import za.co.protogen.core.domain.api.RemoveReservationApi;
import za.co.protogen.core.domain.models.delegate.RemoveReservationApiDelegate;

import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-09T22:39:47.538713500+02:00[Africa/Johannesburg]", comments = "Generator version: 7.8.0")
@Controller
@RequestMapping("${openapi.reservationService.base-path:}")
public class RemoveReservationApiController implements RemoveReservationApi {

    private final RemoveReservationApiDelegate delegate;

    public RemoveReservationApiController(@Autowired(required = false) RemoveReservationApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new RemoveReservationApiDelegate() {});
    }

    @Override
    public RemoveReservationApiDelegate getDelegate() {
        return delegate;
    }

}
