package mybatis.resource;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import mybatis.mapper.PlayerMapper;
import mybatis.model.Player;

@Controller
@RequestMapping("/players")

public class PlayerResource {

	private PlayerMapper playerMapper;
	
	public PlayerResource(PlayerMapper playerMapper) {
		this.playerMapper = playerMapper;
	}
	String listeUrl = "/players/all"; 
	
	@ModelAttribute("joueur")
	public Player construct() {
		return new Player();
	}
    
	//affiche la liste de tous les joueurs
	/*@RequestMapping("/all")
	public List<Player> getAll(){
		return playerMapper.findAll();
	}
	
	*/@RequestMapping(value = { "/all" }, method = RequestMethod.GET)
   public String viewPlayerList(Model model) {
 
       model.addAttribute("Players", playerMapper.findAll());
 
       return "ListePlayers";
    }
	
	//ajout d'un joueur en entrant les paramètres dans l'url
	/*@RequestMapping("/insert")
	List<Player> insertPlayer(@RequestParam("name") String nom, @RequestParam("nationality") String nat, @RequestParam("club") String leclub ){
		Player player = new Player(nom,nat,leclub);
		playerMapper.insert(player);
		
		return playerMapper.findAll();
	}*/
	
	@RequestMapping("/insert")
	public String showInsert() {
		return "AddPlayerForm";
	}
	
	@RequestMapping(value= {"/insert"}, method = RequestMethod.POST)
	public ModelAndView doInsert(@ModelAttribute("joueur") Player p) {
		playerMapper.insert(p);
		
		return new ModelAndView("redirect:" + listeUrl);
	}
	
	
	//Renvoie la liste des joueur appartenant au club donné en paramètre
	@RequestMapping("/all/{club}")
	public String viewGetByClub(@PathVariable("club") String leclub, Model model){
			model.addAttribute("Players",playerMapper.findAllClub(leclub));
			
			return "ListePlayers";
	}
	
	//Renvoie le joueur dont l'id est donné en paramètre
	@RequestMapping("{id}")
	public String viewfindOne(@PathVariable("id") int sonId, Model model) {
		model.addAttribute("Player", playerMapper.findById(sonId));
		
		return "OnePlayerSelect";
	}
	
	//Renvoie le joueur dont le nom est donné en paramètre
		@RequestMapping("/joueur/{name}")
		public String viewfindPlayer(@PathVariable("name") String nom, Model model) {
			model.addAttribute("Player",playerMapper.findByName(nom));
			 return "OnePlayerSelect";
		}
		
	
	@RequestMapping(value = {"/delete/{id}"})
	public ModelAndView SuppById(@PathVariable("id") int id){
		 playerMapper.deleteById(id);
		 return new ModelAndView("redirect:" + listeUrl);
	}
	
	//modification d'un joueur, marche pas ptdr
	@RequestMapping("/update/{id}")
	public String update(@PathVariable("id") int id, Model model) {
		model.addAttribute("Player",playerMapper.findById(id));
		return "UpdatePlayer";
	}
	
	@RequestMapping(value = {"/update/{id}/{club}"})
	public ModelAndView SuppById(@PathVariable("id") int i,@PathVariable("club") String c){
		 Player p =playerMapper.findById(i);
		 p.setClub(c);
		 playerMapper.updatePlayer(p);
		 return new ModelAndView("redirect:" + listeUrl);
	}
			
}
