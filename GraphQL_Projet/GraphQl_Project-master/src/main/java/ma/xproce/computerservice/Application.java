package ma.xproce.computerservice;

import ma.xproce.computerservice.entities.Computer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ma.xproce.computerservice.repositories.ComputerRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	ComputerRepository computerRepository;


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {

		Computer computer1 = new Computer();
		computer1.setRam("Introduction to Spring Boot");
		computer1.setProce("intel i7");
		computer1.setHardDrive("SSD");
		computer1.setMacAddress("XXXXXXXX");
		computerRepository.save(computer1);
	}

}
