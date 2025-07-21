package com.example.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontEndController {
	
	@GetMapping("/{path:^(?!api).*$}")
	public String forward() {
		
		return "forward:/index.html";
	}

}
