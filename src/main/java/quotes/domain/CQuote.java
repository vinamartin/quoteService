package quotes.domain;

import com.datastax.driver.core.DataType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;


import java.io.Serializable;
import java.util.UUID;

@Table("quotes")
public class CQuote implements Serializable{

    private static final long serialVersionUID = 1L;
    @PrimaryKey
    @CassandraType(type = DataType.Name.UUID)
    private UUID id;
    private String text;
    private String author;

    public UUID getId() {
        return id;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    public void setId(UUID id) {
        this.id = id;
    }


    public CQuote() {
        id = UUID.randomUUID();
    }
}
