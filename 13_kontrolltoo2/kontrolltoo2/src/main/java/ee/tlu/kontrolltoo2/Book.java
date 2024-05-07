package ee.tlu.kontrolltoo2;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
        public String title;
        public String subtitle;
        public String isbn13;
        public String price;
        public String image;
        public String url;
}
