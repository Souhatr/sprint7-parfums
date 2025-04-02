package com.souha.parfums;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.souha.parfums.entities.Parfum;
import com.souha.parfums.service.ParfumService;

@SpringBootApplication
public class ParfumsApplication implements CommandLineRunner {

	@Autowired
	ParfumService parfmService;

	public static void main(String[] args) {
		SpringApplication.run(ParfumsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		parfmService.saveParfum(new Parfum("coco channel", 300.0, new Date()));
		parfmService.saveParfum(new Parfum("kayali vanille", 200.0, new Date()));
		parfmService.saveParfum(new Parfum("Ambre nuit", 600.0, new Date()));
	}

}
