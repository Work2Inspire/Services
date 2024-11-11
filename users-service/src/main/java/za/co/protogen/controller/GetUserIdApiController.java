package za.co.protogen.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import za.co.protogen.core.domain.api.GetUserIdApi;
import za.co.protogen.core.domain.models.delegate.GetUserIdApiDelegate;

import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-10T10:21:23.805578500+02:00[Africa/Johannesburg]", comments = "Generator version: 7.8.0")
@Controller
@RequestMapping("${openapi.userService.base-path:}")
public class GetUserIdApiController implements GetUserIdApi {

    private final GetUserIdApiDelegate delegate;

    public GetUserIdApiController(@Autowired(required = false) GetUserIdApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new GetUserIdApiDelegate() {});
    }

    @Override
    public GetUserIdApiDelegate getDelegate() {
        return delegate;
    }

}
