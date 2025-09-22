package kr.ac.kopo.kkssmm.springboot_jdbctest1.controller.exam05;

import kr.ac.kopo.kkssmm.springboot_jdbctest1.domain.Player;
import kr.ac.kopo.kkssmm.springboot_jdbctest1.domain.Team;
import kr.ac.kopo.kkssmm.springboot_jdbctest1.repository.PlayerRepository;
import kr.ac.kopo.kkssmm.springboot_jdbctest1.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/exam07")
public class exam07Controller {
    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    TeamRepository teamRepository;

    @GetMapping
    public String requestInsert(Model model) {
        Team team = new Team();
        team.setName("team01");
        teamRepository.save(team);

        Player player = new Player();
        player.setName("김폴리");
        player.setTeam(team);
        playerRepository.save(player);

        List<Player> playerList = playerRepository.findAll();
        List<Team> teamList = teamRepository.findAll();
        model.addAttribute("playerList", playerList);
        model.addAttribute("teamList", teamList);

        return "viewPage07";
    }
}
