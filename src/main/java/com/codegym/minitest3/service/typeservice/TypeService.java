package com.codegym.minitest3.service.typeservice;

import com.codegym.minitest3.model.entity.Type;
import com.codegym.minitest3.repo.type.ITypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class TypeService implements ITypeService {
    @Autowired
    private ITypeRepo iTypeRepo;
    @Override
    public Iterable<Type> findAll() {
        return iTypeRepo.findAll();

    }

    @Override
    public Optional<Type> findById(Long id) {
        return iTypeRepo.findById(id);
    }

    @Override
    public Type save(Type type) {
        return iTypeRepo.save(type);
    }

    @Override
    public void remove(Long id) {
        iTypeRepo.setNullAndDeleteTypeById(id);
    }
}
