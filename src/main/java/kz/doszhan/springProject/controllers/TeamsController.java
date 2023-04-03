package kz.doszhan.springProject.controllers;

import kz.doszhan.springProject.DAOs.TeamsDAO;
import kz.doszhan.springProject.models.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/teams")
public class TeamsController {

    @Autowired
    TeamsDAO teamsDAO = new TeamsDAO();

    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("teams",teamsDAO.list());
        return "/teams/teams";
    }

    @GetMapping("/{id}")
    public String id(Model model , @PathVariable("id") int id) {
        model.addAttribute("team" , teamsDAO.getTeam(id));
        return "/teams/id";
    }

    @GetMapping("/new")
    public String createTeam(Model model) {
        model.addAttribute("team",new Team());
        return "/teams/create";
    }

    @PostMapping("")
    public String create(@ModelAttribute("team") Team team ) {
        teamsDAO.addTeam(team);
        return "redirect:/teams";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model , @PathVariable("id") int id){
        model.addAttribute("team" , teamsDAO.getTeam(id));
        return "teams/edit";
    }

    @PatchMapping("/{id}")
    public String editTeam(@ModelAttribute("team") Team team , @PathVariable("id") int id){
        teamsDAO.editTeam(team,id);
        return "redirect:/teams";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        teamsDAO.deleteTeam(id);
        return "redirect:/teams";
    }
}
