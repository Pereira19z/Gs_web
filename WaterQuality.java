import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WaterQuality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String location;
    private double ph;
    private double turbidez;
    private double oxigenio;
    private double nitratos;
    private double fosfatos;
    private double coliformes;

    // Getters and setters
}
