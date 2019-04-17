package quotes.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import quotes.domain.CQuote;

public interface CQuoteRepository extends CrudRepository<CQuote, UUID> {
}
