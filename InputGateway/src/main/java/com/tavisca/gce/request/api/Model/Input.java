package com.tavisca.gce.request.api.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="Input")
public class Input {
    @Column(name="input")
    private String input;
    @Id
    @Column(name="tid")
    private String tid;
    @Column(name="timeStamp")
    private Date timeStamp;
    @Column(name="serviceFrom")
    private String serviceFrom;
    @Column(name="serviceTo")
    private String serviceTo;

    @Column(name="status")
    private String status;
    public Input() {
    }

    public Input(String input,String tid, Date timeStamp, String serviceFrom, String serviceTo,String status) {
        this.input = input;
        this.tid = tid;
        this.timeStamp = timeStamp;
        this.serviceFrom = serviceFrom;
        this.serviceTo = serviceTo;
        this.status=status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getServiceFrom() {
        return serviceFrom;
    }

    public void setServiceFrom(String serviceFrom) {
        this.serviceFrom = serviceFrom;
    }

    public String getServiceTo() {
        return serviceTo;
    }

    public void setServiceTo(String serviceTo) {
        this.serviceTo = serviceTo;
    }
}
