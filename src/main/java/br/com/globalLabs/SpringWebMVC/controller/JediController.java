package br.com.globalLabs.SpringWebMVC.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.globalLabs.SpringWebMVC.model.Jedi;
import br.com.globalLabs.SpringWebMVC.repository.JediRepository;

@Controller
public class JediController {

	@Autowired
	private JediRepository jediRepository;

	@GetMapping("/jedi")
	public ModelAndView jedi() {
		final ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jedi");
		List<Jedi> allJedi = jediRepository.allJedi();
		modelAndView.addObject("allJedi", allJedi);
		return modelAndView;
	}

	@GetMapping("/new-jedi")
	public ModelAndView newJedi() {
		final ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("new-jedi");
		modelAndView.addObject("jedi", new Jedi());
		return modelAndView;
	}

	@PostMapping("/jedi")
	public String createJedi(@Valid @ModelAttribute Jedi jedi , BindingResult result) {
		Boolean isError =result.hasErrors();
		
		if (isError) {
			return "new-jedi";
		}else {
			jediRepository.add(jedi);

			return "redirect:jedi";
		}
		
	}

}
