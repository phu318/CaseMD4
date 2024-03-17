package com.codegym.minitest3.service.computerservice;

import com.codegym.minitest3.model.entity.Computer;
import com.codegym.minitest3.repo.computer.IComputerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ComputerService implements IComputerService {

    @Autowired
    private IComputerRepo computerRepo;

    @Override
    public Iterable<Computer> findAll() {
        return computerRepo.findAll();
    }

    @Override
    public Optional<Computer> findById(Long id) {
        return computerRepo.findById(id);
    }

    @Override
    public Computer save(Computer computer) {
        return computerRepo.save(computer);
    }

    @Override
    public void remove(Long id) {
        computerRepo.deleteById(id);
    }
}
