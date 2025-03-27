package resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Book;
import repository.BookRepository;

@Path("/book/")
public class BookResource {
    @Inject
    private BookRepository bookRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addBook")
    public Response createBook(Book b) {
        Book book = bookRepository.createBook(b);
        return Response.ok().entity(book).build();
    }
}
