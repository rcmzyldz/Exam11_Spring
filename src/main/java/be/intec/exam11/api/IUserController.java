package be.intec.exam11.api;

import be.intec.exam11.models.User;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


public interface IUserController {

    // @ResponseBody means the returned String is the response, not a view name
// @RequestParam means it is a parameter from the GET or POST request
    @PostMapping ( path = "/params" )
// Map ONLY POST Requests
    String addNewUserUsingRequestParams( @RequestParam String name,
                                         @RequestParam String email );
    @PostMapping ( path = "/json" )
// Map ONLY POST Requests
    String addNewUserUsingJSONData( @RequestBody User user ) throws IOException;
    @GetMapping ( path = "/all" )
    List< User > getAllUsers();
    @GetMapping ( path = "/{user_id}" )
    Optional< User > getById( @PathVariable ( "user_id" ) Integer userId );

}