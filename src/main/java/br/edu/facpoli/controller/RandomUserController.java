package br.edu.facpoli.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.facpoli.pojo.Login;
import br.edu.facpoli.pojo.Name;
import br.edu.facpoli.pojo.Picture;
import br.edu.facpoli.pojo.RandomUser;
import br.edu.facpoli.pojo.RandomUserResponse;

@Controller
public class RandomUserController {
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("RandomUserResponse", generateRandomUserResponse());
		return "home";
	}

	private RandomUserResponse generateRandomUserResponse() {
		List<RandomUser> randomUsers = new ArrayList<>();
		randomUsers.add(generateRandomUser("ms","Sara","Cox"));
		randomUsers.add(generateRandomUser("ms","Maria","Rosa"));
		
		
		RandomUserResponse randomUserResponse = new RandomUserResponse();
		randomUserResponse.setRandomUsers(randomUsers);
		return randomUserResponse;
	}

	private RandomUser generateRandomUser(String title, String first, String last) {
		RandomUser randomUser = new RandomUser();
		randomUser.setName(new Name(title, first, last));
		randomUser.setLogin(new Login());
		randomUser.setPhone("(400)-321-1962");
		randomUser.setEmail("sara.cox47@example.com");
		randomUser.setNat("7/2/1970");
		
		Picture picture = new Picture();
		picture.setLarge("https://randomuser.me/api/portraits/women/39.jpg");
		picture.setMedium("https://randomuser.me/api/portraits/med/women/39.jpg");
		picture.setThumbnail("https://randomuser.me/api/portraits/thumb/women/39.jpg");
		randomUser.setPicture(picture);
		return randomUser;
	}
}
