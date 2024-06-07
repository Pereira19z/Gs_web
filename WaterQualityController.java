import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WaterQualityController {

    @Autowired
    private WaterQualityRepository repository;

    @GetMapping("/api/water-quality")
    public WaterQuality getWaterQuality(@RequestParam String location) {
        return repository.findByLocation(location);
    }
}
