package com.bruno.imageliteapi.application.images;

import com.bruno.imageliteapi.domain.entity.Image;
import com.bruno.imageliteapi.domain.enums.ExtensaoDaImagem;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/v1/images")
@Slf4j
@RequiredArgsConstructor
public class ImageController {

    @Autowired
    private ImageServiceImpl imageService;

    @PostMapping()
    @Transactional
    public ResponseEntity save(
            @RequestParam("file") MultipartFile file,
            @RequestParam("name") String name,
            @RequestParam("tags") List<String> tag) throws IOException {



        Image image = Image.builder()
                .name(name)
                .tags(String.join(",",tag))
                .size(file.getSize())
                .extension(ExtensaoDaImagem.pegarExtensao(MediaType.valueOf(file.getContentType())))
                .file(file.getBytes())
                .build();

        imageService.save(image);


        return ResponseEntity.ok().build();
    }

}
