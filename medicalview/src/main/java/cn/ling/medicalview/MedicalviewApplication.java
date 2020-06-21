package cn.ling.medicalview;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.ling.medicaldb.mapper")
public class MedicalviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicalviewApplication.class, args);
	}

}
