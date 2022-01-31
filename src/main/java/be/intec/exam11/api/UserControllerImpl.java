package be.intec.exam11.api;

import be.intec.exam11.models.User;
import be.intec.exam11.repositories.MessageRepository;
import be.intec.exam11.repositories.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.DataInput;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/users")
public class UserControllerImpl implements IUserController {


    private final UserRepository userRepository;


    @Override
    @PostMapping(path = "/params")
    public String addNewUserUsingRequestParams(@RequestParam String name,
                                               @RequestParam String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        User addedUser = userRepository.save(user);
        return addedUser.getName();
    }

    @Override
    @PostMapping(path = "/json")
    public String addNewUserUsingJSONData(@RequestBody User user) {

        if (user.getId() != null && userRepository.findById(user.getId()).isPresent()) {

            User addedUser = userRepository.save(user);
            return addedUser.getName();

        } else {
            return "The user is already added!";
        }


    }

    @Override
    @GetMapping(path = "/all")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @GetMapping(path = "/{user_id}")
    public Optional<User> getById(@PathVariable("user_id") Integer userId) {
        Optional<User> oUser = userRepository.findById(userId);
        return oUser;

    }
}
