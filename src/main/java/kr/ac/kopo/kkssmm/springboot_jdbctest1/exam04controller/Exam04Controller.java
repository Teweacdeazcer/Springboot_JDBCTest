package kr.ac.kopo.kkssmm.springboot_jdbctest1.exam04controller;

import kr.ac.kopo.kkssmm.springboot_jdbctest1.domain.Member;
import kr.ac.kopo.kkssmm.springboot_jdbctest1.repository.MemberRepository04;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/exam04")
public class Exam04Controller {
    @Autowired
    MemberRepository04 repository04;

    @GetMapping
    public String ViewHomePage(Model model) {
        Iterable<Member> memberList = repository04.selectMethod();
        model.addAttribute("memberList", memberList);
        return "viewPage04";
    }

    @GetMapping("/new")
    public String newMethod(Model model) {
        Member member = new Member();
        model.addAttribute("member", member);
        return "viewPage04_new";
    }

    @PostMapping("/insert")
    public String insertMethod(@ModelAttribute("member") Member member) {
        repository04.insertMethod(member);
        return "redirect:/exam04";
    }

    @GetMapping("/edit/{id}")
    public String editMethod(@PathVariable(name = "id") int id, Model model) {
        Member member = repository04.selectMethodById(id);
        model.addAttribute("member", member);
        return "viewPage04_edit";
    }

    @PostMapping("/update")
    public String updateMethod(@ModelAttribute("member") Member member) {
        repository04.updateMethod(member);
        return "redirect:/exam04";
    }

    @GetMapping("/delete/{id}")
    public String deleteMethod(@PathVariable(name = "id") int id) {
        repository04.deleteMethod(id);
        return "redirect:/exam04";
    }
}
