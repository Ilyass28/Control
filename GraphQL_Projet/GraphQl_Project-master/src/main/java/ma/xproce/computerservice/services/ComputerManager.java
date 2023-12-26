package ma.xproce.computerservice.services;

import ma.xproce.computerservice.dtos.ComputerDto;
import ma.xproce.computerservice.dtos.ComputerDtoInput;

import java.util.List;

public interface ComputerManager {

    ComputerDto getComputerById(Long id);

    List<ComputerDto> getAllComputers();

    ComputerDto saveComputer(ComputerDtoInput computerDTOInput);

    ComputerDto updateComputer(Long id, ComputerDtoInput computerDTOInput);

    void deleteComputer(Long id);
}
