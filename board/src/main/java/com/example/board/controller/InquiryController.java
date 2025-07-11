package com.example.board.controller;

import com.example.board.dto.InquiryRequestDTO;
import com.example.board.dto.InquiryResponseDTO;
import com.example.board.dto.PasswordCheckRequestDTO;
import com.example.board.entity.Inquiry;
import com.example.board.service.InquiryService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/inquiries")
@CrossOrigin(origins = "http://localhost:3000")  // React 개발서버 주소 교차 허용
public class InquiryController {

	private final InquiryService service;

    public InquiryController(InquiryService service) {
        this.service = service;
    }

    @GetMapping
    public List<InquiryResponseDTO> getAll() {
        return service.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public InquiryResponseDTO getById(@PathVariable("id") Long id) {
        Inquiry inquiry = service.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
        return convertToDTO(inquiry);
    }

    @PostMapping
    public InquiryResponseDTO create(@RequestBody InquiryRequestDTO dto) {
        Inquiry inquiry = convertToEntity(dto); 
        Inquiry saved = service.save(inquiry);
        return convertToDTO(saved);
    }

    @PutMapping("/{id}")
    public InquiryResponseDTO update(@PathVariable("id") Long id, @RequestBody InquiryRequestDTO dto) {
        Inquiry existing = service.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
        existing.setTitle(dto.getTitle());
        existing.setContent(dto.getContent());
        existing.setWriter(dto.getWriter());
        Inquiry updated = service.save(existing);
        return convertToDTO(updated);
    }

    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
    	service.deleteById(id);
    }
    
    // 변환 메서드
    private InquiryResponseDTO convertToDTO(Inquiry inquiry) {
    	return new InquiryResponseDTO(
    	        inquiry.getId(),
    	        inquiry.getTitle(),
    	        inquiry.getContent(),
    	        inquiry.getWriter(),
    	        inquiry.getCreatedAt() 
    	    );
    }

    private Inquiry convertToEntity(InquiryRequestDTO dto) {
        return new Inquiry(dto.getTitle(), dto.getContent(), dto.getWriter(), dto.getPassword());
    }
    
    
    
    @PostMapping("/{id}/check-password")
    public ResponseEntity<Boolean> checkPassword(@PathVariable("id") Long id,
                                                 @RequestBody PasswordCheckRequestDTO request) {
        boolean isMatch = service.checkPassword(id, request.getPassword());
        return ResponseEntity.ok(isMatch);
    }
    
    
    
}
