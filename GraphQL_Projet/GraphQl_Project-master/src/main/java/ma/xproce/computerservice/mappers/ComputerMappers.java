package ma.xproce.computerservice.mappers;

import ma.xproce.computerservice.dtos.ComputerDto;
import ma.xproce.computerservice.dtos.ComputerDtoInput;
import ma.xproce.computerservice.entities.Computer;
import org.springframework.stereotype.Component;

@Component
public class ComputerMappers {

    public ComputerDto mapToDto(Computer computer) {
        ComputerDto computerDTO = new ComputerDto();
        computerDTO.setProce(computer.getProce());
        computerDTO.setRam(computer.getRam());
        computerDTO.setPrice(computer.getPrice());
        computerDTO.setHardDrive(computer.getHardDrive());
        return computerDTO;
    }

    public Computer mapToEntity(ComputerDtoInput computerDTO) {
        Computer computer = new Computer();
        computer.setProce(computerDTO.getProce());
        computer.setRam(computerDTO.getRam());
        computer.setPrice(computerDTO.getPrice());
        computer.setHardDrive(computerDTO.getHardDrive());
        return computer;
    }
}
