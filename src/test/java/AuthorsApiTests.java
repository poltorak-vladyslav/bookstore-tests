import com.bookstore.clients.AuthorsClient;
import com.bookstore.models.AuthorModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AuthorsApiTests {

    @Test
    @DisplayName("Fetch a list of authors")
    public void testGetAuthors() {
        List<AuthorModel> authors = AuthorsClient.getAuthors();
        assertThat(authors).isNotEmpty();
    }

    @Test
    @DisplayName("Fetch author by id")
    public void testGetAuthorById() {
        AuthorModel author = AuthorsClient.getAuthor("1");
        assertThat(author.getId()).isEqualTo(1);
    }
}
