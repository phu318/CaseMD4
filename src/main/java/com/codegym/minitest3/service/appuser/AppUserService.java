package com.codegym.minitest3.service.appuser;

import com.codegym.minitest3.model.appuser.AppUser;
import com.codegym.minitest3.repo.user.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppUserService implements IAppUserService, UserDetailsService {
    @Autowired
    private AppUserRepo userRepo;
    @Override
    public Iterable<AppUser> findAll() {
        return null;
    }

    @Override
    public Optional<AppUser> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public AppUser save(AppUser appUser) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = userRepo.findByName(username);
        var role = new ArrayList<SimpleGrantedAuthority>();
        role.add(new SimpleGrantedAuthority(appUser.getAppRole().getName()));

        UserDetails userDetails = new User(
                appUser.getName(),
                appUser.getPassword(),
                role
        );
        return userDetails;

    }
}
