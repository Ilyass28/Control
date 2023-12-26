package ma.xproce.computerservice.entities;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Pc;
    private String proce;
    private String ram;
    private String hardDrive;
    private double price;
    private String macAddress;

}
