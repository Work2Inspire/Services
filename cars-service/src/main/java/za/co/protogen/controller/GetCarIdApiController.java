package za.co.protogen.controller;



import za.co.protogen.core.domain.models.delegate.GetCarIdApiDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import za.co.protogen.core.domain.api.GetCarIdApi;

import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-07T20:54:30.516515700+02:00[Africa/Johannesburg]", comments = "Generator version: 7.8.0")
@Controller
@RequestMapping("${openapi.carsService.base-path:}")
public class GetCarIdApiController implements GetCarIdApi {

    private final GetCarIdApiDelegate delegate;

    public GetCarIdApiController(@Autowired(required = false) GetCarIdApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new GetCarIdApiDelegate() {});
    }

    @Override
    public GetCarIdApiDelegate getDelegate() {
        return delegate;
    }

}