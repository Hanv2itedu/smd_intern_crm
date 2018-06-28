package com.smartdev.crm.service.user;

import com.smartdev.user.dao.repository.RoleRepository;
import com.smartdev.user.dao.repository.SellerDetailRepository;
import com.smartdev.user.dao.repository.UserRepository;
import com.smartdev.user.entity.Role;
import com.smartdev.user.entity.SellerDetail;
import com.smartdev.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SellerDetailRepository sellerDetailRepository;

    @Override
    public boolean isUserExist(String userName) {

        User user = userRepository.findOne(userName);
        boolean result = user != null;
        return result;
    }



    @Override
    public void save(User user, String roleName) {

        user.setPassWord(bCryptPasswordEncoder.encode(user.getPassWord()));
        user.setIsDelete(0);

        Set<Role> roles = new HashSet<>();
        Role role = roleRepository.findByName(roleName);
        roles.add(role);
        user.setRoles(roles);

        SellerDetail sellerDetail = new SellerDetail();
        sellerDetail.setUserByUserName(user);
        sellerDetail.setUserName(user.getUserName());
        userRepository.save(user);
        sellerDetailRepository.save(sellerDetail);
    }

    @Override
    public User findOneUser(String username) {
        return userRepository.findOne(username);
    }
}
