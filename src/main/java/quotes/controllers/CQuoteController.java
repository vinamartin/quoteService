package quotes.controllers;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import quotes.domain.CQuote;
import quotes.services.CQuoteService;

@RestController
public class CQuoteController {

    private CQuoteService cQuoteService;

    @Autowired
    public void setcQuoteService(CQuoteService cQuoteService) {
        this.cQuoteService = cQuoteService;
    }

    @RequestMapping(
            value = "/addQuote",
            method = RequestMethod.POST)
    public String addQuote(@RequestBody Map<String, String> payload) {
        CQuote cQuote = new CQuote();
        cQuote.setText(payload.get("quote"));
        cQuote.setAuthor(payload.get("author"));
        cQuoteService.saveOrUpdate(cQuote);
        return payload.get("quote");
    }

    @RequestMapping(value = "/getQuotes")
    public String getQuote() {
        return randomizer(cQuoteService.listAll());
    }

    private String prettyPrint(CQuote cQuote) {
        return String.format("%s - %s", cQuote.getText(), cQuote.getAuthor());
    }

    private String randomizer(List<CQuote> quotes) {
        int index = new Random().nextInt(quotes.size());
        return prettyPrint(quotes.get(index));
    }
}
