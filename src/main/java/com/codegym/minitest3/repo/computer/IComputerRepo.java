package com.codegym.minitest3.repo.computer;

import com.codegym.minitest3.model.entity.Computer;
import org.springframework.data.repository.CrudRepository;

public interface IComputerRepo extends CrudRepository<Computer, Long> {
}
