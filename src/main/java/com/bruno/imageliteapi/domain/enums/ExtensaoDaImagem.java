package com.bruno.imageliteapi.domain.enums;

import org.springframework.http.MediaType;

public enum ExtensaoDaImagem {
    PNG (MediaType.IMAGE_PNG),
    JPEG(MediaType.IMAGE_JPEG),
    GIF(MediaType.IMAGE_GIF);

    private MediaType mediaType;

    ExtensaoDaImagem(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public static ExtensaoDaImagem pegarExtensao(MediaType mediaType){
        for (ExtensaoDaImagem i: ExtensaoDaImagem.values()){
            if (i.mediaType.equals(mediaType)){
                return i;
            }
        }
        return null;
    }
}
