package quotes.services;


import java.util.List;
import java.util.UUID;

import quotes.domain.CQuote;

public interface CQuoteService {

    List<CQuote> listAll();

    CQuote getById(UUID id);

    CQuote saveOrUpdate(CQuote cQuote);

    void delete(UUID id);
}
