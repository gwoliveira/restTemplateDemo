package br.edu.facpoli.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import br.edu.facpoli.pojo.RandomUserResponse;

@Controller
public class RandomUserController {
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("RandomUserResponse", generateRandomUserResponse());
		return "home";
	}

	private RandomUserResponse generateRandomUserResponse() {
		return new RestTemplate().getForObject("https://randomuser.me/api/?results=5&nat=br", RandomUserResponse.class);
	}

}
