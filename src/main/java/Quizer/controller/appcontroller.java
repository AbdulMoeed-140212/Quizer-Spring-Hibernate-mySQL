package Quizer.controller;

import Quizer.dao.QuestionsDao;
import Quizer.dao.marksDao;
import Quizer.model.Questions;
import Quizer.model.marks;
import Quizer.model.type.mcq;
import Quizer.model.type.truefalse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class appcontroller {
    @Autowired
    private QuestionsDao questionsDao;
    @Autowired
    private marksDao Marks;
    @RequestMapping("/view")
    public String adduser(Model model){
        List<Questions> questions = questionsDao.findAll();
        model.addAttribute("questions" ,questions);
        return  "questions";
    }
    @RequestMapping(value="/add")
    public String addquestion(Model model) {
        model.addAttribute("questions" , new mcq());
        return "qtype";
    }

    @RequestMapping(value = "/selectType" , method =  RequestMethod.GET)
    public String greeting(@RequestParam(value="optradio", required=true) int num, Model model) {
        //model.addAttribute("name", num);
        switch (num){
            case 1:
                model.addAttribute("questions" , new mcq());
                return "addmcq";
            case 2:
                model.addAttribute("questions" , new truefalse());
                return "addtf";
            case 3:
                model.addAttribute("questions" , new Questions());
                return "addsimple";
            default:
                return "redirect:/view";
        }
        //return "greeting";
    }
    @RequestMapping(value = "/savequestion", method = RequestMethod.POST)
    public String addNewPost(@Valid mcq questions, BindingResult bindingResult, Model model) {
        questionsDao.save(questions);
        return "redirect:/view";
    }

    @RequestMapping("/attempt")
    public String attempt(Model model){
        List<Questions> questions = questionsDao.findAll();
        List<String> answer = new ArrayList<String>();
        model.addAttribute("questions" ,questions);
        model.addAttribute("answer" , answer);
        return  "attemptquiz";
    }


    @RequestMapping("/saveMarks")
    public String saveMarks(@RequestParam("marks")int marks, Model model){
        marks m = new marks();
        m.setMarks(marks);
        List<marks> lmarks = new ArrayList<marks>();
        lmarks.add(m);
        Marks.save(lmarks);
        return "redirect:/viewMarks";
    }

    @RequestMapping("/viewMarks")
    public String viewMarks(Model model){
        List<marks> list = Marks.findAll();
        model.addAttribute("markList" , list);
        return "marksView";
    }
}
