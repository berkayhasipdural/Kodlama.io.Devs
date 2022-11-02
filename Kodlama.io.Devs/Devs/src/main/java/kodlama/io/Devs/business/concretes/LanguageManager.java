package kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.dataAcces.abstracts.LanguageRepository;
import kodlama.io.Devs.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService{
	private LanguageRepository languageRepository;
	
	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
	this.languageRepository = languageRepository;
	}
	@Override
	public List<Language> getAll() {
		return languageRepository.getall();
	}

	@Override
	public void add(Language language) throws Exception {
		if(isIdExist(language.getId())) {
			throw new Exception("Id önceden kayıt edilmiştir.");
		}
		if(isNameValid(language.getName())) {
			languageRepository.add(language);
		}
			}
		
	

	@Override
	public void update(int id ,Language language) throws Exception{
		if(!isIdExist(id)) {
			throw new Exception("İd bulunamadı.");
		}
		if(isNameValid(language.getName())) {
			languageRepository.update(id, language);
		}
	}

	@Override
	public Language getById(int id) throws Exception{
		if(!isIdExist(id)) {
			throw new Exception("İd bulunamadı.");
		}
		return languageRepository.getById(id);
	}
	@Override
	public void delete(int Id) throws Exception{
		if(!isIdExist(Id)) {
			throw new Exception("İd bulunamadı.");
		}
		languageRepository.delete(Id);
		
	}
	public LanguageRepository getLanguageRepository() {
		return languageRepository;
	}
	
	public boolean isIdExist(int id)throws Exception{
		for(Language lang : getAll()) {
			if(lang.getId()==id) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isNameValid(String language)throws Exception{
		if(language.isBlank()) {
			throw new Exception("Bu isim alanı boş geçilemez.");
		}
		for(Language language2 : getAll()) {
			if(language2.getName().equalsIgnoreCase(language)) {
				throw new Exception("Bu isim kullanılmış.");
			}
		}
		return true;
	}
	
}
