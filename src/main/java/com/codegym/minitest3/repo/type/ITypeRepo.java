package com.codegym.minitest3.repo.type;

import com.codegym.minitest3.model.entity.Type;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ITypeRepo extends CrudRepository<Type, Long> {
    @Modifying
    @Query(nativeQuery = true, value = "call setNullTypeInComputerListAndDelete(:id)")
    void setNullAndDeleteTypeById(@Param("id") Long id);
}
