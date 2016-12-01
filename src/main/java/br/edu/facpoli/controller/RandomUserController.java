package br.edu.facpoli.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import br.edu.facpoli.entidade.User;
import br.edu.facpoli.pojo.RandomUser;
import br.edu.facpoli.pojo.RandomUserResponse;
import br.edu.facpoli.repositorio.UserRepository;

@Controller
public class RandomUserController {
	@Autowired
	UserRepository userRepository;

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "home";
	}

	@GetMapping("/import")
	public String importUsers(Model model) {
		RandomUserResponse randomUserResponse = generateRandomUserResponse();
		List<RandomUser> randomUsers = randomUserResponse.getRandomUsers();
		for (RandomUser randomUser : randomUsers) {
			userRepository.save(new User(randomUser));
		}
		return "redirect:/";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	private RandomUserResponse generateRandomUserResponse() {
		return new RestTemplate().getForObject("https://randomuser.me/api/?results=5&nat=br", RandomUserResponse.class);
	}

}
