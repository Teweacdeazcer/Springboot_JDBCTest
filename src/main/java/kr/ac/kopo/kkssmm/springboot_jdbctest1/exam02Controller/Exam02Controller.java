package kr.ac.kopo.kkssmm.springboot_jdbctest1.exam02Controller;

import kr.ac.kopo.kkssmm.springboot_jdbctest1.domain.Member;
import kr.ac.kopo.kkssmm.springboot_jdbctest1.repository.MemberRepository02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/exam02")
public class Exam02Controller {
    @Autowired
    MemberRepository02 repository02;

    @GetMapping
    public String viewHomePage(Model model){
        Iterable<Member> memberList = repository02.findAll();  // select * from member
        model.addAttribute("memberList",memberList);
        return "viewPage02";
    }

    @GetMapping("/new")
    public String newMethod(Model model){
        Member member = new Member();
        model.addAttribute("member",member);
        return "viewPage02_new";
    }

    @PostMapping("/insert")
    public String insertMethod(@ModelAttribute("member") Member member){
        repository02.save(member);
        return "redirect:/exam02";
    }

    @GetMapping("/edit/{id}")
    public String editMethod(@PathVariable(name = "id") int id, Model model){
        // select * from member where id = ?
        Optional<Member> member = repository02.findById(id);
        model.addAttribute("member",member);
        return "viewPage02_edit";
    }

    @PostMapping("/update")
    public String updateMethod(@ModelAttribute("member") Member member){
        // update member set name = ?, age = ?, email = ? where id = ? where id = ?
        repository02.save(member);
        return "redirect:/exam02";
    }

    @GetMapping("/delete/{id}")
    public String deleteMethod(@PathVariable(name = "id") int id){
        repository02.deleteById(id);
        return "redirect:/exam02";
    }
}
