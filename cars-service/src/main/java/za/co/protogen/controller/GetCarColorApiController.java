package za.co.protogen.controller;



import za.co.protogen.core.domain.models.delegate.GetCarColorApiDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import za.co.protogen.core.domain.api.GetCarColorApi;

import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-07T20:54:30.516515700+02:00[Africa/Johannesburg]", comments = "Generator version: 7.8.0")
@Controller
@RequestMapping("${openapi.carsService.base-path:}")
public class GetCarColorApiController implements GetCarColorApi {

    private final GetCarColorApiDelegate delegate;

    public GetCarColorApiController(@Autowired(required = false) GetCarColorApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new GetCarColorApiDelegate() {});
    }

    @Override
    public GetCarColorApiDelegate getDelegate() {
        return delegate;
    }

}
