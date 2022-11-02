package kodlama.io.Devs.dataAcces.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.Devs.dataAcces.abstracts.LanguageRepository;
import kodlama.io.Devs.entities.concretes.Language;

@Repository
public class İnMmoryLanguageRepository implements LanguageRepository {

	private List<Language> languages;

	public İnMmoryLanguageRepository() {
		languages = new ArrayList<Language>();
		languages.add(new Language("Java", 0));
		languages.add(new Language("C+", 1));
		languages.add(new Language("Python", 2));
	}

	@Override
	public List<Language> getall() {
		return languages;
	}

	@Override
	public void add(Language language) {
		languages.add(language);

	}

	@Override
	public void delete(int Id) {
		languages.remove(Id);

	}

	@Override
	public void update(int id, Language language) {
		Language language2 = getById(id);
		language2.setName(language.getName());

	}

	@Override
	public Language getById(int id) {
		for (Language language : languages) {
			if (language.getId() == id)
				return language;
		}
		return null;

	}
}
