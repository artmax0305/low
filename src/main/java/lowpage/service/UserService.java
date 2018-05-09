package lowpage.service;

import lowpage.dao.RoleDao;
import lowpage.dao.UserDao;
import lowpage.model.Role;
import lowpage.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    public void save(User user){
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        Set<Role> roleSet =new HashSet<>();
        roleSet.add(new Role("ROLE_USER"));
        user.setRoles(roleSet);
        userDao.save(user);
    }
}
