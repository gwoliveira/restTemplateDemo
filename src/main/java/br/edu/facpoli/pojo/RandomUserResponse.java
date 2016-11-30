
package br.edu.facpoli.pojo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RandomUserResponse {

	@JsonProperty("results")
	private List<RandomUser> randomUsers = new ArrayList<RandomUser>();
	private Info info;

	public List<RandomUser> getRandomUsers() {
		return randomUsers;
	}

	public void setRandomUsers(List<RandomUser> randomUsers) {
		this.randomUsers = randomUsers;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

}
