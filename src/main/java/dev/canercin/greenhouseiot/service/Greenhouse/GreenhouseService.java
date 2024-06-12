package dev.canercin.greenhouseiot.service.Greenhouse;

import dev.canercin.greenhouseiot.entities.Greenhouse;

import java.util.List;

public interface GreenhouseService {
    void save(Greenhouse greenhouse);
    List<Greenhouse> findAll();
    List<Greenhouse> findTop10ByOrderByStateTimeAsc();
    Greenhouse findTopByOrderByStateTimeAsc();
}
