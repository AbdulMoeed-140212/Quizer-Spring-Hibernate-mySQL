package hello;

import hello.dao.HelloLogDao;
import hello.dao.QuestionsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class GreetingController {

    @Autowired
    private HelloLogDao helloLogDao;

    @Autowired
    private QuestionsDao questionsDao;

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        HelloLog log = new HelloLog(name);
        helloLogDao.save(log);
        return "greeting";
    }
    @RequestMapping("/log")
    public String log(Model model){
        List<HelloLog> logs = helloLogDao.findAll();
        model.addAttribute("logs" , logs);
        return  "log";
    }
    @RequestMapping("/questions")
    public String adduser(Model model){
        List<Questions> questions = questionsDao.findAll();
        model.addAttribute("questions" ,questions);
        return  "questions";
    }
    @RequestMapping(value="/addquestion")
    public String addquestion(Questions questions) {
        return "addquestion";
    }
    @RequestMapping(value = "/savequestion", method = RequestMethod.POST)
    public String addNewPost(@Valid Questions questions, BindingResult bindingResult, Model model) {
        questionsDao.save(questions);
        return "redirect:/questions";
    }
}
