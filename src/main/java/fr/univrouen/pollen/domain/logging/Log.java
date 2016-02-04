package fr.univrouen.pollen.domain.logging;

import fr.univrouen.pollen.domain.Identifiable;
import fr.univrouen.pollen.dto.social.LogDto;
import fr.univrouen.pollen.repositories.social.LogRepository;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Log implements Identifiable {

    // Constructors
    public Log() {
    }

    public Log(LogDto dto){
        this.id = dto.getId();
        this.type = dto.getType();
        this.message = dto.getMessage();
        this.callstack = dto.getCallstack();
        this.date = dto.getDate();
    }

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="logId")
    private long id;

    @Enumerated(EnumType.STRING)
    private LogType type;

    private String message;
    private String callstack;
    private Timestamp date;


    // Getters & Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LogType getType() {
        return type;
    }

    public void setType(LogType type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCallstack() {
        return callstack;
    }

    public void setCallstack(String callstack) {
        this.callstack = callstack;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    // Utilities Methods
    public LogDto toDto() {
        LogDto dto = new LogDto();
        dto.setCallstack(callstack);
        dto.setDate(date);
        dto.setId(id);
        dto.setMessage(message);
        dto.setType(type);

        return dto;
    }

    public static List<Log> dtosToEntities (List<LogDto> dtos){
        LogRepository userRepository = new LogRepository();

        List<Log> entities = new ArrayList<>();

        for(LogDto dto : dtos){
            entities.add(new Log(dto));
        }
        return entities;
    }

    public static List<LogDto> entitiesToDtos (List<Log> entities){
        List<LogDto> dtos = new ArrayList<>();

        for(Log entity : entities){
            dtos.add(entity.toDto());
        }
        return dtos;
    }
}
