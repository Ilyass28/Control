package ma.xproce.computerservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComputerDtoInput {
    private String proce;
    private String ram;
    private String hardDrive;
    private double price;
    private String macAddress;

}



