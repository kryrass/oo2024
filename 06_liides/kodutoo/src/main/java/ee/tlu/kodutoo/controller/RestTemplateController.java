package ee.tlu.kodutoo.controller;



import ee.tlu.kodutoo.Pildid;
import ee.tlu.kodutoo.Post;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RestTemplateController {

    @GetMapping("saa-postitused")
    public List<Post> getPosts() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jsonplaceholder.typicode.com/posts";
        ResponseEntity<Post[]> response = restTemplate.exchange(url, HttpMethod.GET, null, Post[].class);
        return List.of(response.getBody());
    }

    @GetMapping("saa-postitused/{kasutajaId}")
    public List<Post> getUserPosts(@PathVariable int kasutajaId) {

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jsonplaceholder.typicode.com/posts";
        // 1. aadress kuhu 2. meetod mida teeme (meie alati GET)
        // 3. Mida kaasa saadan (Body, Header) 4. mis objekti kujuna saame andmed
        ResponseEntity<Post[]> response = restTemplate.exchange(url, HttpMethod.GET, null, Post[].class);

        List<Post> kasutajaPostitused = new ArrayList<>();
        for (Post p : response.getBody()) {
            if (p.getUserId() == kasutajaId) {
                kasutajaPostitused.add(p);
            }
        }

        return kasutajaPostitused;
    }
    @GetMapping("pildid")
    public List<Pildid> getPildid(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jsonplaceholder.typicode.com/photos";
        ResponseEntity<Pildid[]> response = restTemplate.exchange(url, HttpMethod.GET, null, Pildid[].class);
        return List.of(response.getBody());
    }

    @GetMapping("pildid/{albumId}")
    public List<Pildid> getAlbumPhotos(@PathVariable int albumId) {

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jsonplaceholder.typicode.com/photos";

        ResponseEntity<Pildid[]> response = restTemplate.exchange(url, HttpMethod.GET, null, Pildid[].class);

        List<Pildid> albumiPildid = new ArrayList<>();
        for (Pildid p : response.getBody()) {
            if (p.getAlbumId() == albumId) {
                albumiPildid.add(p);
            }
        }

        return albumiPildid;
    }

   /* @GetMapping("omniva/{county}")
    public List<Omniva> getOmnivaPMsByCountry(@PathVariable String country){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.omniva.ee/locations.json";
        ResponseEntity<Omniva[]> response = restTemplate.exchange(url, HttpMethod.GET, null, Omniva[].class);

        List<Omniva> omnivaPakiautomaadid = new ArrayList<>();
        for (Omniva o : response.getBody()) {
            if (o.getA0_NAME().equals(country)) {
                omnivaPakiautomaadid.add(o);
            }
        }

        return List.of(response.getBody());
    }*/

}
