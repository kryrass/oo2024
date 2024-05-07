package ee.tlu.kontrolltoo2;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class RestTemplateController {

    @GetMapping("raamatud")
    public List<Book> getBooks() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.itbook.store/1.0/search/mongodb";
        ResponseEntity<Root> response = restTemplate.exchange(url, HttpMethod.GET, null, Root.class);
        return response.getBody().getBooks();
    }
    //Võimalda kolmest erinevast API otspunktist küsida nii kõiki raamatuid nagu originaalis tuleb, - tehtud
    // API otspunkt milles on Stringide List: kõik raamatute pealkirjad loeteluna jac - tehtud
    // kolmas, milles sisestatakse raamatu nimi ning leitakse üles õige raamat. -

    @GetMapping("raamatud/pealkirjad")
    public List<String> getBookTitles() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.itbook.store/1.0/search/mongodb";
        ResponseEntity<Root> response = restTemplate.exchange(url, HttpMethod.GET, null, Root.class);

        List<String> bookTitles = new ArrayList<>();
        if (response.getBody() != null && response.getBody().getBooks() != null) {
            for (Book book : response.getBody().getBooks()) {
                if (book.getTitle() != null) {
                    bookTitles.add(book.getTitle());
                }
            }
        }

        return bookTitles;
    }

    @GetMapping("raamatud/{title}")
    public List<Book> getBookByTitle(@PathVariable String title) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.itbook.store/1.0/search/mongodb";
        ResponseEntity<Root> response = restTemplate.exchange(url, HttpMethod.GET, null, Root.class);

        List<Book> matchingBooks = new ArrayList<>();
        if (response.getBody() != null && response.getBody().getBooks() != null) {
            for (Book book : response.getBody().getBooks()) {
                if (book.getTitle() != null && book.getTitle().equalsIgnoreCase(title)) {
                    matchingBooks.add(book);
                }
            }
        }

        return matchingBooks;
    }

   // Tee RestTemplate päring siia API otspunkti: https://freetestapi.com/api/v1/books
   // Näita eraldi API otspunktides kõige vanemat raamatut, - tehtud
    // kõik raamatud uuemad kui sisestatud aasta, - tehtud
    // kõik raamatud sisestatud aastate vahemikus (kokku 3tk). - tehtud

    /*@GetMapping("books")
    public List<Root2> getBrookss(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://freetestapi.com/api/v1/books";
        ResponseEntity<Root2[]> response = restTemplate.exchange(url, HttpMethod.GET, null, Root2[].class);
        return List.of(response.getBody());
    }*/


    @GetMapping("vanim-raamat")
    public ResponseEntity<Root2> getOldestBook() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://freetestapi.com/api/v1/books";
        ResponseEntity<Root2[]> response = restTemplate.exchange(url, HttpMethod.GET, null, Root2[].class);
        Root2[] books = response.getBody();
        if (books != null && books.length > 0) {
            Root2 oldestBook = null;
            Integer oldestYear = Integer.MAX_VALUE;
            for (Root2 book : books) {
                if (book.getPublication_year() != null) {
                    try {
                        Integer year = Integer.parseInt(book.getPublication_year().toString());
                        if (year < oldestYear) {
                            oldestYear = year;
                            oldestBook = book;
                        }
                    } catch (NumberFormatException e) {
                        //
                    }
                }
            }
            if (oldestBook != null) {
                return ResponseEntity.ok(oldestBook);
            }
        }
        return ResponseEntity.notFound().build();
    }


    @GetMapping("uuemad-raamatud/{aasta}")
    public ResponseEntity<List<Root2>> getNewerBooks(@PathVariable("aasta") int aasta) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://freetestapi.com/api/v1/books";
        ResponseEntity<Root2[]> response = restTemplate.exchange(url, HttpMethod.GET, null, Root2[].class);
        Root2[] books = response.getBody();
        if (books != null) {
            List<Root2> newerBooks = Arrays.stream(books)
                    .filter(book -> {
                        Object publicationYear = book.getPublication_year();
                        if (publicationYear instanceof Integer) {
                            return (int) publicationYear >= aasta;
                        }
                        return false;
                    })
                    .collect(Collectors.toList());
            return ResponseEntity.ok(newerBooks);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("vahemik/{aasta1}/{aasta2}")
    public ResponseEntity<List<Root2>> getBooksInRange(@PathVariable("aasta1") int aasta1, @PathVariable("aasta2") int aasta2) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://freetestapi.com/api/v1/books";
        ResponseEntity<Root2[]> response = restTemplate.exchange(url, HttpMethod.GET, null, Root2[].class);
        Root2[] books = response.getBody();
        if (books != null) {
            List<Root2> booksInRange = Arrays.stream(books)
                    .filter(book -> {
                        Object publicationYear = book.getPublication_year();
                        if (publicationYear instanceof Integer) {
                            int year = (int) publicationYear;
                            return year >= aasta1 && year <= aasta2;
                        }
                        return false;
                    })
                    .collect(Collectors.toList());
            return ResponseEntity.ok(booksInRange);
        }
        return ResponseEntity.notFound().build();
    }


}

