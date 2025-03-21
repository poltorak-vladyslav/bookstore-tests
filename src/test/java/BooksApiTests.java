import com.bookstore.clients.BooksClient;
import com.bookstore.models.BookModel;
import com.bookstore.models.ErrorModel;
import com.bookstore.utils.TestDataGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.lang.Long.parseLong;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.assertj.core.api.Assertions.assertThat;

public class BooksApiTests {

    private static final String BOOK_ID = "1";

    @Test
    @DisplayName("Fetch a list of books")
    public void testFetchBooks() {
        List<BookModel> response = BooksClient.fetchBooks();
        assertThat(response).isNotEmpty();
    }

    @Test
    @DisplayName("Fetch existing book by id")
    public void testFetchExistingBookById() {
        BookModel response = BooksClient.fetchBook(BOOK_ID);
        assertThat(response.getId()).isEqualTo(parseLong(BOOK_ID));
    }

    @Test
    @DisplayName("Fetch non-existing book by id")
    public void testFetchNonExistingBookById() {
        ErrorModel response = BooksClient.fetchBook("9999", SC_NOT_FOUND, ErrorModel.class);
        assertThat(response.getTitle()).isEqualTo("Not Found");
    }

    @Test
    @DisplayName("Create book")
    public void testCreateBook() {
        BookModel request = TestDataGenerator.getBookModel();
        BookModel response = BooksClient.createBook(request);
        assertThat(response).isEqualTo(request);
    }

    @Test
    @DisplayName("Update book")
    public void testUpdateBook() {
        BookModel request = TestDataGenerator.getBookModel();
        BookModel response = BooksClient.updateBook(BOOK_ID, request);
        assertThat(response).isEqualTo(request);
    }

    @Test
    @DisplayName("Delete book")
    public void testDeleteBook() {
        String response = BooksClient.deleteBook(BOOK_ID);
        assertThat(response).isEmpty();
    }
}
