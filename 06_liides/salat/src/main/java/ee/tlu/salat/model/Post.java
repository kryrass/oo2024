package ee.tlu.salat.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    private int userId;
    private int id;
    private String title;
    private String body;
}
