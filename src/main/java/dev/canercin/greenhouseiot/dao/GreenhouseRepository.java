package dev.canercin.greenhouseiot.dao;

import dev.canercin.greenhouseiot.entities.Greenhouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
@Repository
public interface GreenhouseRepository extends JpaRepository<Greenhouse, Long>{
=======
import java.util.List;

@Repository
public interface GreenhouseRepository extends JpaRepository<Greenhouse, Long>{
    List<Greenhouse> findTop10ByOrderByStateTimeDesc();
>>>>>>> 6670f8a (get last 10 record added)
}
