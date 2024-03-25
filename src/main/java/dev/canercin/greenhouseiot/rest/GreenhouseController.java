package dev.canercin.greenhouseiot.rest;

import dev.canercin.greenhouseiot.entities.Greenhouse;
import dev.canercin.greenhouseiot.service.Greenhouse.GreenhouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/greenhouse")
public class GreenhouseController {
    private GreenhouseService greenHouseService;

   @Autowired
    public GreenhouseController(GreenhouseService greenHouseService) {
        this.greenHouseService = greenHouseService;
    }

    /**
     * @param greenhouse Veri tabanına kaydedilecek sera verisi
     * @return Kaydedilen verinin HTTP 200 durum kodu ile dönüşü
     * @apiNote id ve state_time alanları otomatik olarak eklenir.
     * @exampleRequest {
     *       "ambient_humidity": 65.2,
     *       "amount_of_light": 800.5,
     *       "operation_type": 1,
     *       "soil_moisture": 45.7,
     *       "ambient_temperature_asc": 25.6,
     *       "ambient_temperature_asf": 78.1,
     *       "water_level": 75.3
     *     }
     */
    @PostMapping("/save")
    public ResponseEntity<String> saveGreenHouseData(@RequestBody Greenhouse greenhouse) {
       this.greenHouseService.save(greenhouse);
       return new ResponseEntity<>(greenhouse.toString(), HttpStatus.OK);
    }

    /**
     * @return Tüm sera verilerini döndürür
     * @exampleResponse {
     *         "id": 4,
     *         "stateTime": "2024-03-25T19:56:28.617891",
     *         "lightAmount": 0.0,
     *         "temperatureAsC": 0.0,
     *         "temperatureAsF": 0.0,
     *         "humidity": 0.0,
     *         "waterLevel": 0.0,
     *         "soilMoisture": 0.0,
     *         "operationType": 0
     *     }
     */
    @GetMapping("/get")
    public List<Greenhouse> getGreenHouseData() {
        return this.greenHouseService.findAll();
    }
}