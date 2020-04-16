package krenc.mirek.teaipracadomowa51.controller;

import krenc.mirek.teaipracadomowa51.service.DataGrabber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jokes")
public class JokesConttroller {

    private DataGrabber dataGrabber;

    public JokesConttroller(DataGrabber dataGrabber) {
        this.dataGrabber = dataGrabber;
    }

    @GetMapping
    public String getJokes(Model model)
    {
        model.addAttribute("jokes", dataGrabber.getJokes());
        return "jokes";
    }
}
