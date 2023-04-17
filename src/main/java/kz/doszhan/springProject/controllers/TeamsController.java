package kz.doszhan.springProject.controllers;

import kz.doszhan.springProject.DAOs.TeamsDAO;
import kz.doszhan.springProject.models.Player;
import kz.doszhan.springProject.models.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/teams")
public class TeamsController {
    private final TeamsDAO teamsDAO ;

    public TeamsController(TeamsDAO teamsDAO) {
        this.teamsDAO = teamsDAO;
    }

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

    @GetMapping("/{id}/addPlayer")
    public String addPlayer(Model model , @PathVariable("id") int id , @ModelAttribute("player") Player player) {
        model.addAttribute("team" , teamsDAO.getTeam(id));
        return "/teams/addPlayer";
    }
    @PostMapping("/{id}")
    public String newPlayer(@ModelAttribute("player") @Valid  Player player, BindingResult bindingResult
            , @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "/teams/addPlayer";
        if (player != null){
            teamsDAO.getTeam(id).addPlayer(player);
        }else {
            System.out.println("player is null");
        }
        return "redirect:/teams" ;
    }

    @GetMapping("/new")
    public String createTeam(@ModelAttribute("team") Team team) {
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
