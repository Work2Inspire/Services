package za.co.protogen.controller;



import za.co.protogen.core.domain.models.delegate.FindExpensiveApiDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import za.co.protogen.core.domain.api.FindExpensiveApi;

import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-07T20:54:30.516515700+02:00[Africa/Johannesburg]", comments = "Generator version: 7.8.0")
@Controller
@RequestMapping("${openapi.carsService.base-path:}")
public class FindExpensiveApiController implements FindExpensiveApi {

    private final FindExpensiveApiDelegate delegate;

    public FindExpensiveApiController(@Autowired(required = false) FindExpensiveApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new FindExpensiveApiDelegate() {});
    }

    @Override
    public FindExpensiveApiDelegate getDelegate() {
        return delegate;
    }

}
