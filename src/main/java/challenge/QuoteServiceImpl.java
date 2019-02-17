package challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class QuoteServiceImpl implements QuoteService {

	private final QuoteRepository repository;

	@Autowired
	public QuoteServiceImpl(QuoteRepository repository) {
		this.repository = repository;
	}

	@Override
	public Quote getQuote() {

		int random = new Random().nextInt(18307);
		final Optional<Scripts> scripts = repository.findById(random);
        final Quote quote = scripts.map(Scripts::getQuote).orElse(null);
        quote.setId(scripts.get().getId());
        return quote;

	}

	@Override
	public Quote getQuoteByActor(String actor) {
		final List<Scripts> scripts = repository.findByActor(actor);
        final Scripts script = scripts.get(new Random().nextInt(scripts.size()));
        Quote quote =script.getQuote();
        quote.setId(script.getId());

		return quote;
	}

}
