package kodlama.io.Devs.dataAcces.abstracts;

import java.util.List;

import kodlama.io.Devs.entities.concretes.Language;

public interface LanguageRepository {
	List<Language> getall();
	void add(Language language);
	void delete (int Id) throws Exception;
	void update(int id , Language language)throws Exception;
	Language getById(int Id) throws Exception;
	
}
