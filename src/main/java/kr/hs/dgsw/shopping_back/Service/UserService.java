package kr.hs.dgsw.shopping_back.Service;

import kr.hs.dgsw.shopping_back.Domain.User;

import java.util.List;

public interface UserService {
    User Register(User user);

    User Login(User user);

    User Modify(User user, Long id);

    boolean Delete(Long id);

    List<User> getAllUsers();

    User getUserByAccount(String account);
}
