package controller;

import entity.PesertaEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import repository.PesertaRepository;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping
public class PesertaController {

    PesertaRepository pesertaRepository;

    @RequestMapping("/list")
    public String listPeserta(ModelMap modelMap) { //ModelMap juga digunakan untuk meneruskan value  untuk membuat tampilan.
        modelMap.put("peserta", pesertaRepository.findAll());
        return "/peserta/list";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public void showForm(
            @RequestParam(required = false, name = "id") PesertaEntity peserta, ModelMap mm) {
        if(peserta !=null) {
            mm.addAttribute("Peserta", peserta);
        }else {
            mm.addAttribute("Peserta", new PesertaEntity());
        }
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String processForm(
            @ModelAttribute @Valid PesertaEntity p, BindingResult hasilValidasi) {
        if (hasilValidasi.hasErrors()) {
            return "/peserta/form";
        }
        pesertaRepository.save(p);
        return "redirect:list";
    }

    @RequestMapping(value = "/delete")
    public String deletePeserta(
            @RequestParam(name = "id") String id, ModelMap modelMap) {
        Optional<PesertaEntity> optionalPesertaEntity = pesertaRepository.findById(id);
        PesertaEntity pesetaEntity = new PesertaEntity();

        String result = "";
        pesertaRepository.delete(id);
        return "redirect:list";
    }
}
