package com.example.board.service;

import com.example.board.entity.Inquiry;
import com.example.board.repository.InquiryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InquiryService {

	private final InquiryRepository repository;
	
	public InquiryService(InquiryRepository repository) {
        this.repository = repository;
    }
	
	public List<Inquiry> findAll() {
        return repository.findAll();
    }

    public Inquiry save(Inquiry inquiry) {
        return repository.save(inquiry);
    }

    public Optional<Inquiry> findById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    
    
    public boolean checkPassword(Long id, String password) {
        Inquiry inquiry = findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
        return password != null && password.equals(inquiry.getPassword());
    }
    
}

