package fr.univrouen.pollen.dto.social;

import fr.univrouen.pollen.domain.logging.LogType;
import fr.univrouen.pollen.dto.Dto;

import javax.persistence.EnumType;
import java.sql.Timestamp;

public class LogDto implements Dto {

    // Attributes
    private long id;
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
}
