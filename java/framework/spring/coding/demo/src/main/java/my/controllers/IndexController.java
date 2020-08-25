package my.controllers;

import my.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import my.service.IndexService;

/**
 * Created by yueran.lyr on 2016/9/17.
 */
@Controller
public class IndexController {
    @Autowired
    private IndexService indexService;

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String index(){
        return indexService.getIndex();
    }

    @RequestMapping(value = "/student-transaction", method = RequestMethod.GET)
    @ResponseBody
    public String student(){
        studentService.testTransaction();
        return "ok";
    }
}
