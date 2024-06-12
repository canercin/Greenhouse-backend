package dev.canercin.greenhouseiot.service.Greenhouse;

import dev.canercin.greenhouseiot.dao.GreenhouseRepository;
import dev.canercin.greenhouseiot.entities.Greenhouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GreenhouseServiceImp implements GreenhouseService {

    private GreenhouseRepository greenhouseRepository;

    @Autowired
    public GreenhouseServiceImp(GreenhouseRepository greenHouse) {
        this.greenhouseRepository = greenHouse;
    }

    @Override
    public void save(Greenhouse greenhouse) {
        greenhouse.setStateTime(LocalDateTime.now());
        this.greenhouseRepository.save(greenhouse);
    }

    @Override
    public List<Greenhouse> findAll() {
        return this.greenhouseRepository.findAll();
    }
<<<<<<< HEAD
=======

    @Override
    public List<Greenhouse> findTop10ByOrderByStateTimeAsc() {
        return this.greenhouseRepository.findTop10ByOrderByStateTimeDesc();
    }
>>>>>>> 6670f8a (get last 10 record added)
}
