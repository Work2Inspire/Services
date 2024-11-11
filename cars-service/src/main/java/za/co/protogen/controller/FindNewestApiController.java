package za.co.protogen.controller;



import za.co.protogen.core.domain.models.delegate.FindNewestApiDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import za.co.protogen.core.domain.api.FindNewestApi;

import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-07T20:54:30.516515700+02:00[Africa/Johannesburg]", comments = "Generator version: 7.8.0")
@Controller
@RequestMapping("${openapi.carsService.base-path:}")
public class FindNewestApiController implements FindNewestApi {

    private final FindNewestApiDelegate delegate;

    public FindNewestApiController(@Autowired(required = false) FindNewestApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new FindNewestApiDelegate() {});
    }

    @Override
    public FindNewestApiDelegate getDelegate() {
        return delegate;
    }

}
