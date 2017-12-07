package Quizer.springBoot.service.controller;

import Quizer.springBoot.service.dao.*;
import Quizer.springBoot.service.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.crypto.Data;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {
    // Data access objects automatic initilization with spring bean system
    @Autowired
        quizDao quizdao ;
    @Autowired
        questionDao questiondao;
    @Autowired
        instructorDao instructordao;
    @Autowired
        userDao userdao;
    @Autowired
        studentDao studentdao;
    @Autowired
    totalscoreDao totalscoredao;
    //---------------------------------------
    int quizID=0;       // current quizid
    int teacherID =0;   // current teacher
    int studentID =0;   // current student
    //---------------------------------------
    // Teacher Part
    // Page 1
    @RequestMapping(value="/teacher") // route to teacher selection
    public String teacherInit(Model model){
        return "teacher";
    }
    // Page 2
    @RequestMapping(value = "/quizofteacher" , method = RequestMethod.GET) // Show List of quizes of  a teacher
    // if teacher not present create new teacher
    public String quizOfTeacher(@RequestParam("name")String name, Model model){
        List<instructor> teachers = instructordao.findByName(name);
        if(teachers.isEmpty() || teachers == null){
            instructor teacher = new instructor();
            teacher.setName(name);
            instructordao.save(teacher);
        }
        teachers = instructordao.findByName(name);
        teacherID = teachers.get(0).getUid();
        model.addAttribute("teachers", teachers);
        return "quizezofteacher";
    }

    // Page 3.1
    @RequestMapping(value = "/viewquiz",method = RequestMethod.GET)// View  full quiz
    public String viewQuiz(@RequestParam("quizid")Integer quizid , Model model){
        model.addAttribute("quiz",quizdao.findByQuizid(quizid));
        return "viewquiz";
    }
    // Page 3.2.1
    @RequestMapping(value = "/addquiz",method = RequestMethod.GET)// Add a new quiz to the list of instructor
    public String addQuiz(@RequestParam("tid")Integer uid , Model model){
        teacherID = uid;
        instructor teacher = instructordao.findByUid(uid);
        List<quiz> q = teacher.getQuizes();
        q.add(new quiz());
        teacher.setQuizes(q);
        instructordao.save(teacher);
        int length = instructordao.findByUid(uid).getQuizes().size();
        return "redirect:/addquestion?qid="+instructordao.findByUid(uid).getQuizes().get(length-1).getQuizid();
    }
    // Page 3.2.2
    @RequestMapping(value = "/addquestion",method = RequestMethod.GET) // Add a question take input from a Form(cyclic)
    public String addQuestion(@RequestParam("qid")Integer qid , Model model) {
        model.addAttribute("q",new question());
        quizID=qid;
        return "addquestion";
    }
    // Page 3.2.3
    @RequestMapping(value = "/savequestion",method = RequestMethod.POST)// save data recieced from Form and add next question
    public String saveQuestion(@Valid question Question , BindingResult bindingResult, Model model) {
        quiz q=quizdao.findByQuizid(quizID);
        List<question> ques = q.getQuestions();
        ques.add(Question);
        q.setQuestions(ques);
        questiondao.save(Question);
        quizdao.save(q);
        return "redirect:/addquestion?qid="+quizID;
    }

    // Student Part

    // Page 1
    @RequestMapping(value="/student")// view student form to choose student or create a new one
    public String studentInit(Model model){
        return "student";
    }

    @RequestMapping(value="/record", method = RequestMethod.GET)// get name if not exists create a new entery
    public String showRecord(@RequestParam("name")String name , Model model){
        List<student> students = studentdao.findByName(name);
        if(students.isEmpty() || students == null){
            student Student = new student();
            Student.setName(name);
            studentdao.save(Student);
        }
        students = studentdao.findByName(name);
        studentID = students.get(0).getUid();
        model.addAttribute("name" , students.get(0).getName());
        model.addAttribute("students", students.get(0).getScores());
        return "viewRecord";
    }
    @RequestMapping("/quizList") // view list of avaliable quiz to attempt
    public String viewAllQuiz(Model model){
        List<quiz> list = quizdao.findAll();
        model.addAttribute("quizes" , list);
        return "quizList";
    }
    @RequestMapping(value = "/attempt" , method = RequestMethod.GET)// load attepting form to answer questions and submit results
    public String attemptQuiz(@RequestParam("qid")Integer qid , Model model){
        quiz q = quizdao.findByQuizid(qid);
        model.addAttribute("questions" , q.getQuestions());
        model.addAttribute("answers" , new ArrayList<String>());
        return "attemptquiz";
    }

    @RequestMapping(value = "/saveMarks" , method = RequestMethod.GET)// save results
   public String saveMarks(@RequestParam("total")int total,@RequestParam("max")int max , Model model){
        totalscore t = new totalscore();
        t.setOutof(max);
        t.setTotal(total);
        totalscore score = new totalscore();
        score.setTotal(total);
        score.setOutof(max);
        score.setTime(new Date(System.currentTimeMillis()));
        student s = studentdao.findByUid(studentID);
        List<totalscore>listScore = s.getScores();
        listScore.add(score);
        s.setScores(listScore);
        totalscoredao.save(score);
        studentdao.save(s);
        model.addAttribute("name" , s.getName());
        model.addAttribute("students", s.getScores());
        return "viewRecord";
    }
}
