package za.co.protogen.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import za.co.protogen.core.domain.api.RemoveUserApi;
import za.co.protogen.core.domain.models.delegate.RemoveUserApiDelegate;

import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-10T10:21:23.805578500+02:00[Africa/Johannesburg]", comments = "Generator version: 7.8.0")
@Controller
@RequestMapping("${openapi.userService.base-path:}")
public class RemoveUserApiController implements RemoveUserApi {

    private final RemoveUserApiDelegate delegate;

    public RemoveUserApiController(@Autowired(required = false) RemoveUserApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new RemoveUserApiDelegate() {});
    }

    @Override
    public RemoveUserApiDelegate getDelegate() {
        return delegate;
    }

}
