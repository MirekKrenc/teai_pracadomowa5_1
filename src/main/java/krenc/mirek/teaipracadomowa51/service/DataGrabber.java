package krenc.mirek.teaipracadomowa51.service;

import krenc.mirek.teaipracadomowa51.model.ChuckNorrisJoke;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataGrabber {

    private RestTemplate restTemplate;
    private List<String> jokes;
    //3 random jokes about Chuck Norris
    private final String URL ="http://api.icndb.com/jokes/random/3";

    public DataGrabber() {
        this.restTemplate = new RestTemplate();
    }

    private void getData() {

        ChuckNorrisJoke chuckNorrisJokes = restTemplate.getForObject(URL, ChuckNorrisJoke.class);
        this.jokes = Arrays.asList(chuckNorrisJokes.getValue())
                .stream()
                .map(ch -> ch.getJoke())
                .collect(Collectors.toList());
    }

    public List<String> getJokes() {
        getData();
        return jokes;
    }
}
