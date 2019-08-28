package th.co.custodian.grouplease.custodian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import th.co.custodian.grouplease.custodian.upload.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class CustodianApplication {
	public static void main(String[] args) {
		SpringApplication.run(CustodianApplication.class, args);
	}

}
