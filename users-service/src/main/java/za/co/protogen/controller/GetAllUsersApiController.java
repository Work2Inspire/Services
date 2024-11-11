package za.co.protogen.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import za.co.protogen.core.domain.api.GetAllUsersApi;
import za.co.protogen.core.domain.models.delegate.GetAllUsersApiDelegate;

import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-10T10:21:23.805578500+02:00[Africa/Johannesburg]", comments = "Generator version: 7.8.0")
@Controller
@RequestMapping("${openapi.userService.base-path:}")
public class GetAllUsersApiController implements GetAllUsersApi {

    private final GetAllUsersApiDelegate delegate;

    public GetAllUsersApiController(@Autowired(required = false) GetAllUsersApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new GetAllUsersApiDelegate() {});
    }

    @Override
    public GetAllUsersApiDelegate getDelegate() {
        return delegate;
    }

}
