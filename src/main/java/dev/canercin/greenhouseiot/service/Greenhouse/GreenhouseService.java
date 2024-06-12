package dev.canercin.greenhouseiot.service.Greenhouse;

import dev.canercin.greenhouseiot.entities.Greenhouse;

import java.util.List;

public interface GreenhouseService {
    void save(Greenhouse greenhouse);
    List<Greenhouse> findAll();
<<<<<<< HEAD
=======
    List<Greenhouse> findTop10ByOrderByStateTimeAsc();
>>>>>>> 6670f8a (get last 10 record added)
}
