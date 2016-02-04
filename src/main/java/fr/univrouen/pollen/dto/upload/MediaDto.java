package fr.univrouen.pollen.dto.upload;

import fr.univrouen.pollen.domain.uploads.MediaType;
import fr.univrouen.pollen.dto.Dto;

public class MediaDto implements Dto {

    private long id;
    private String originalName;
    private String generatedName;
    private MediaType type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getGeneratedName() {
        return generatedName;
    }

    public void setGeneratedName(String generatedName) {
        this.generatedName = generatedName;
    }

    public MediaType getType() {
        return type;
    }

    public void setType(MediaType type) {
        this.type = type;
    }
}
