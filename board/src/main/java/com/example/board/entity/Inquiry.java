package com.example.board.entity;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "inquiries")
public class Inquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    
    @Column(name="name")
    private String writer;
    
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    
    private String password;
    

	@PrePersist
	protected void onCreate() {
	    this.createdAt = LocalDateTime.now();
	}
	
	
    // 기본 생성자 (JPA 사용)
    public Inquiry() {}

    // 생성자 추가
    public Inquiry(String title, String content, String writer, String password) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.password = password;
    }

    
    public Long getId() { 
    	return id; 
    }
    
    public void setId(Long id) {
    	this.id = id; 
    }

    public String getTitle() {
    	return title; 
    }
    
    public void setTitle(String title) {
    	this.title = title; 
    }

    public String getContent() {
    	return content;
    }
    
    public void setContent(String content) { 
    	this.content = content; 
    }

    public String getWriter() {
    	return writer; 
    }
    
    public void setWriter(String writer) {
    	this.writer = writer; 
    }
    
    public String getPassword() {
        return password;
    }				
    
    public void setPassword(String password) {
    	this.password = password;
    }
    
   
    
    public void setCreatedAt(LocalDateTime createdAt) {
    	this.createdAt = createdAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

	
    
}
