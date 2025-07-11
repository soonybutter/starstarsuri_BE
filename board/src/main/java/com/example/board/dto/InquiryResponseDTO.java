package com.example.board.dto;

import java.time.LocalDateTime;

public class InquiryResponseDTO {
	 	private Long id;
	    private String title;
	    private String content;
	    private String writer;
	    private LocalDateTime createdAt;

	    public InquiryResponseDTO() {}

	    public InquiryResponseDTO(Long id, String title, String content, String writer, LocalDateTime createdAt) {
	        this.id = id;
	        this.title = title;
	        this.content = content;
	        this.writer = writer;
	        this.createdAt = createdAt;
	    }

	    public LocalDateTime getCreatedAt() {
	        return createdAt;
	    }

		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
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
	    
}
