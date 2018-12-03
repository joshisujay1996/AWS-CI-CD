package com.me.web.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.CollectionId;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "attachments")
public class Attachment {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id", unique = true, nullable = false, columnDefinition = "BINARY(16)")
    private UUID id;

    @ManyToOne()
    @JsonBackReference
    private Transaction transaction;

    @Column(name="path")
    private String url;

    public Attachment(){}

    public UUID getId(){ return id;}

    public Transaction getTransaction(){ return transaction;}

    public void setId(UUID id){ this.id = id;}

    public void setTransaction(Transaction transaction){ this.transaction = transaction;}

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
