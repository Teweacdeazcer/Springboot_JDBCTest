package kr.ac.kopo.kkssmm.springboot_jdbctest1.exam03Controller;

import kr.ac.kopo.kkssmm.springboot_jdbctest1.domain.Member;
import kr.ac.kopo.kkssmm.springboot_jdbctest1.repository.MemberRepository03;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam03")
public class Exam03Controller {
    @Autowired
    MemberRepository03 repository03;

    @GetMapping
    public String viewHomePage(Model model) {
        Iterable<Member> memberList = repository03.selectMethod();
        model.addAttribute("memberList", memberList);
        return "viewPage03";
    }
}
