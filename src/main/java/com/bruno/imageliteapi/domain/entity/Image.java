package com.bruno.imageliteapi.domain.entity;

import com.bruno.imageliteapi.domain.enums.ExtensaoDaImagem;
import jakarta.persistence.*;
import lombok.*;
import lombok.Builder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import java.time.LocalDateTime;

@Entity
@Table(name = "tb_images")
@EntityListeners(AuditingEntityListener.class) //USADO PELO @CREATEDDATE PRA PEGAR A DATA DO UPLOAD. PRECISA HABILITAR O SERVIÇO NA CLASSE MAIN
@Data // Anotações do Lombok pra criar construtores e getters and setter em tempo de execução
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column
    private String name;
    @Column
    private Long size;
    @Enumerated (EnumType.STRING)
    private ExtensaoDaImagem extension;
    @Column
    @CreatedDate
    private LocalDateTime uploadDate;
    @Column
    private String tags;
    @Column
    @Lob //Informa que é upload de arquivo
    private byte[] file;

}
