package br.com.globalLabs.SpringWebMVC.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.globalLabs.SpringWebMVC.model.Jedi;

@Repository
public class JediRepository {
	
	private List<Jedi> allJedi;


	public JediRepository() {
		allJedi = new ArrayList<>();

		allJedi.add(new Jedi("Luke", "Skywler"));
	}

	
	public List<Jedi> allJedi() {
		
		return this.allJedi;
	}

	public void add(Jedi jedi) {
		this.allJedi.add(jedi);
	}

}
