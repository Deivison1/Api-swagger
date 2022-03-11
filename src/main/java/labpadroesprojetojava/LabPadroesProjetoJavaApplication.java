package labpadroesprojetojava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class LabPadroesProjetoJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabPadroesProjetoJavaApplication.class, args);
	}

}
