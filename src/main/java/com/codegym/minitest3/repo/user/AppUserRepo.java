package com.codegym.minitest3.repo.user;

import com.codegym.minitest3.model.appuser.AppRole;
import com.codegym.minitest3.model.appuser.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepo extends CrudRepository<AppUser, Long> {
    AppUser findByName(String name);
}
