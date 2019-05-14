package quotes;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public abstract class CQuoteIntegrationTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(wac)
                .build();
    }

    @Test
    public void testPost() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/addQuote")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n"
                                + "\t\"quote\" : \"The most dangerous phrase in the language is, 'We've always done it this way.'\",\n"
                                + "\t\"author\": \"Grace Hopper\"\n" + "}"))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/getQuotes"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("The most dangerous phrase in the language is, 'We've always done it this way.' - Grace Hopper"));
    }

}
