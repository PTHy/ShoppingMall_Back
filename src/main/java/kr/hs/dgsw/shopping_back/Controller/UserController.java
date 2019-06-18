package kr.hs.dgsw.shopping_back.Controller;

import kr.hs.dgsw.shopping_back.Domain.User;
import kr.hs.dgsw.shopping_back.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/api/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/api/users/account/{account}")
    public User getUserByAccount(@PathVariable String account) { return userService.getUserByAccount(account); }

    @PostMapping("/api/users/register")
    public User Register(@RequestBody User user) {
        return userService.Register(user);
    }

    @PostMapping("/api/users/login")
    public User Login(@RequestBody User user) {
        return userService.Login(user);
    }

    @PutMapping("/api/users/{id}")
    public User ModifyUser(@RequestBody User user, @PathVariable Long id) {
        return userService.Modify(user, id);
    }

    @DeleteMapping("/api/users/{id}")
    public boolean DeleteUser(@PathVariable Long id) {
        return userService.Delete(id);
    }
}
