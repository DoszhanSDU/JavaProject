package kz.doszhan.springProject.controllers;

import javax.validation.Valid;
import kz.doszhan.springProject.DAOs.PlayersDAO;
import kz.doszhan.springProject.models.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/players")
public class PlayersController {

    final PlayersDAO playersDAO;

    public PlayersController(PlayersDAO playersDAO) {
        this.playersDAO = playersDAO;
    }

    @GetMapping("")
    public String list(Model model){
        model.addAttribute("players" , playersDAO.list());
        return "/players/players";
    }

    @GetMapping("/{id}")
    public String id(@PathVariable("id") int id , Model model){
        model.addAttribute("player" , playersDAO.getPlayer(id));
        return "players/id";
    }

    @GetMapping("/new")
    public String createPlayer(@ModelAttribute("player") Player player) {
        return "players/create";
    }

    @PostMapping("")
    public String addPlayer(@ModelAttribute("player") @Valid Player player , BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "players/create";

        playersDAO.addPlayer(player);
        return "redirect:/players";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id , Model model){
        model.addAttribute("player" , playersDAO.getPlayer(id));
        return "players/edit";
    }

    @PatchMapping("/{id}")
    public String editPlayer(@ModelAttribute("player") @Valid Player player , BindingResult bindingResult , @PathVariable("id") int id){
       if (bindingResult.hasErrors())
           return "players/edit";
        playersDAO.updatePlayer(id,player);
        return "redirect:/players";
    }

    @DeleteMapping("/{id}")
    public String deletePlayer(@PathVariable("id") int id ){
        playersDAO.removePlayer(id);
        return "redirect:/players";
    }

}
