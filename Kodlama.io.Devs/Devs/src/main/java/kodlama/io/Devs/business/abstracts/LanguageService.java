package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.entities.concretes.Language;

public interface LanguageService {
	List<Language> getAll();
	void add(Language language) throws  Exception;
	void delete(int Id) throws Exception;
	void update(int id , Language language) throws Exception;
	Language getById(int id) throws Exception;
	
	
	

}
