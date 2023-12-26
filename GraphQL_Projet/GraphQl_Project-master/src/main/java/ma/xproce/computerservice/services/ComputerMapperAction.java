package ma.xproce.computerservice.services;

import ma.xproce.computerservice.dtos.ComputerDto;
import ma.xproce.computerservice.dtos.ComputerDtoInput;
import ma.xproce.computerservice.entities.Computer;
import ma.xproce.computerservice.exceptions.ComputerNotFoundException;
import ma.xproce.computerservice.mappers.ComputerMappers;
import ma.xproce.computerservice.repositories.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ComputerManagerAction implements ComputerManager {

    private final ComputerRepository computerRepository;
    private final ComputerMappers computerMapper;

    @Autowired
    public ComputerManagerAction(ComputerRepository computerRepository, ComputerMappers computerMapper) {
        this.computerRepository = computerRepository;
        this.computerMapper = computerMapper;
    }

    @Override
    public ComputerDto getComputerById(Long id) {
        Optional<Computer> computerOptional = computerRepository.findById(id);
        return computerOptional.map(computerMapper::mapToDto)
                .orElseThrow(() -> new ComputerNotFoundException("Computer not found with ID: " + id));
    }

    @Override
    public List<ComputerDto> getAllComputers() {
        List<Computer> computers = computerRepository.findAll();
        return computers.stream()
                .map(computerMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ComputerDto saveComputer(ComputerDtoInput computerDtoInput) {
        return null;
    }

    @Override
    public ComputerDto updateComputer(Long id, ComputerDtoInput computerDtoInput) {
        return null;
    }

    @Override
    public ComputerDto saveComputer(ComputerDtoInput computerDToInput) {
        Computer computer = computerMapper.mapToEntity(computerDToInput);
        Computer savedComputer = computerRepository.save(computer);
        return computerMapper.mapToDto(savedComputer);
    }

    @Override
    public ComputerDto updateComputer(Long id, ComputerDtoInput computerDTOInput) {
        Optional<Computer> computerOptional = computerRepository.findById(id);
        if (computerOptional.isPresent()) {
            Computer computer = computerOptional.get();
            computer.setProce(computerDTOInput.getProce());
            computer.setRam(computerDTOInput.getRam());
            computer.setHardDrive(computerDTOInput.getHardDrive());
            computer.setPrice(computerDTOInput.getPrice());
            Computer updatedComputer = computerRepository.save(computer);
            return computerMapper.mapToDto(updatedComputer);
        } else {
            throw new ComputerNotFoundException("Computer not found with ID: " + id);
        }
    }

    @Override
    public void deleteComputer(Long id) {
        if (computerRepository.existsById(id)) {
            computerRepository.deleteById(id);
        } else {
            throw new ComputerNotFoundException("Computer not found with ID: " + id);
        }
    }
}
