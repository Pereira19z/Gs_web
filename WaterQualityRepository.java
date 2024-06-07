import org.springframework.data.jpa.repository.JpaRepository;

public interface WaterQualityRepository extends JpaRepository<WaterQuality, Long> {
    WaterQuality findByLocation(String location);
}
