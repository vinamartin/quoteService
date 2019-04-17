package quotes.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quotes.domain.CQuote;
import quotes.repositories.CQuoteRepository;

@Service
public class CQuoteServiceImpl implements CQuoteService {

    private CQuoteRepository cQuoteRepository;

    @Autowired
    public CQuoteServiceImpl(CQuoteRepository cQuoteRepository) {
        this.cQuoteRepository = cQuoteRepository;
    }

    @Override
    public List<CQuote> listAll() {
        List<CQuote> quotes = new ArrayList<>();
        cQuoteRepository.findAll().forEach(quotes::add);
        return quotes;
    }

    @Override
    public CQuote getById(UUID id) {
        return cQuoteRepository.findById(id).orElse(null);
    }

    @Override
    public CQuote saveOrUpdate(CQuote cQuote) {
        cQuoteRepository.save(cQuote);
        return cQuote;
    }

    @Override
    public void delete(UUID id) {
        cQuoteRepository.deleteById(id);
    }
}
