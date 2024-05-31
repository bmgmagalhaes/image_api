package com.bruno.imageliteapi;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@SpringBootApplication
@EnableJpaAuditing //Habilita o Auditing usado na classe Image pra salvar data do upload do arquivo.
public class ImageliteapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImageliteapiApplication.class, args);
	}


}
