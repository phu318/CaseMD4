package com.codegym.minitest3.repo.user;

import com.codegym.minitest3.model.appuser.AppRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRoleRepo extends CrudRepository<AppRole, Long> {
}
