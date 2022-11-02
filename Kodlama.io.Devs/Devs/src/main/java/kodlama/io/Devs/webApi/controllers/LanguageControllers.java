package kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguageControllers {

	private LanguageService languageService;

	public LanguageControllers(LanguageService languageService) {
		this.languageService = languageService;
	}

	@GetMapping("/getall")
	public List<Language> getAll() {
		return languageService.getAll();

	}

	@PostMapping("/add")
	public void add(@RequestBody Language language) throws Exception {
		languageService.add(language);

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int  id) throws Exception {
		languageService.delete(id);
	}
	@PutMapping("/{id}")
	public void update(@PathVariable int  id ,@RequestBody Language language) throws Exception {
		languageService.update(id , language);
	}
	
	@GetMapping("/{id}")
	public Language getId(@PathVariable int id) throws Exception{
		return languageService.getById(id);
	}
}
