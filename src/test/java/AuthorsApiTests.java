import com.bookstore.clients.AuthorsClient;
import com.bookstore.models.AuthorModel;
import com.bookstore.models.ErrorModel;
import com.bookstore.utils.TestDataGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.lang.Long.parseLong;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.assertj.core.api.Assertions.assertThat;

public class AuthorsApiTests {

    private static final String AUTHOR_ID = "1";

    @Test
    @DisplayName("Fetch a list of authors")
    public void testFetchAuthors() {
        List<AuthorModel> response = AuthorsClient.fetchAuthors();
        assertThat(response).isNotEmpty();
    }

    @Test
    @DisplayName("Fetch existing author by id")
    public void testFetchExistingAuthorById() {
        AuthorModel response = AuthorsClient.fetchAuthor(AUTHOR_ID);
        assertThat(response.getId()).isEqualTo(parseLong(AUTHOR_ID));
    }

    @Test
    @DisplayName("Fetch non-existing author by id")
    public void testFetchNonExistingAuthorById() {
        ErrorModel response = AuthorsClient.fetchAuthor("9999", SC_NOT_FOUND, ErrorModel.class);
        assertThat(response.getTitle()).isEqualTo("Not Found");
    }

    @Test
    @DisplayName("Create author")
    public void testCreateAuthor() {
        AuthorModel request = TestDataGenerator.getAuthorModel();
        AuthorModel response = AuthorsClient.createAuthor(request);
        assertThat(response).isEqualTo(request);
    }

    @Test
    @DisplayName("Update author")
    public void testUpdateAuthor() {
        AuthorModel request = TestDataGenerator.getAuthorModel();
        AuthorModel response = AuthorsClient.updateAuthor(AUTHOR_ID, request);
        assertThat(response).isEqualTo(request);
    }

    @Test
    @DisplayName("Delete author")
    public void testDeleteAuthor() {
        String response = AuthorsClient.deleteAuthor(AUTHOR_ID);
        assertThat(response).isEmpty();
    }
}
