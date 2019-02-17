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
		return scripts.map(Scripts::getQuote).orElse(null);

	}

	@Override
	public Quote getQuoteByActor(String actor) {
		final List<Quote> quotes = repository.findByActor(actor);

		return quotes.get(new Random().nextInt(quotes.size()));
	}

}
