package kr.hs.dgsw.shopping_back.Service;

import kr.hs.dgsw.shopping_back.Domain.User;
import kr.hs.dgsw.shopping_back.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User Register(User user) {
        Optional<User> fu = userRepository.findByAccount(user.getAccount());

        if (fu.isPresent())
            return null;

        user.setPassword(user.getPassword());

        return userRepository.save(user);
    }

    @Override
    public User Login(User user) {

        user.setPassword(user.getPassword());

        Optional<User> fu = userRepository.findByAccountAndPassword(user.getAccount(), user.getPassword());

        if (!fu.isPresent())
            return null;

        return fu.get();
    }

    @Override
    public User Modify(User user, Long id) {
        return userRepository.findById(id)
                .map(fu -> {
                   if (user.getZip() != null)
                       fu.setZip(user.getZip());
                   if (user.getPassword() != null)
                       fu.setPassword(user.getPassword());
                   if (user.getAddr() != null)
                       fu.setAddr(user.getAddr());
                   if (user.getEmail() != null)
                       fu.setEmail(user.getEmail());
                   if (user.getTel() != null)
                       fu.setTel(user.getTel());
                   if (user.getName() != null)
                       fu.setName(user.getName());
                   if (user.getPhone() != null)
                       fu.setPhone(user.getPhone());

                   return userRepository.save(fu);
                })
                .orElse( null );
    }

    @Override
    public boolean Delete(Long id) {
        try {
            return this.userRepository.findById(id)
                    .map(fu -> {
                        this.userRepository.delete(fu);
                        System.out.println(fu);
                        return true;
                    })
                    .orElse(false);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByAccount(String account) {
        return userRepository.findByAccount(account).orElse(null);
    }
}
