package br.com.alura.mvc.mudi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.dto.PedidoDto;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;
   
    @GetMapping("formulario")
    public String formulario(PedidoDto pedidoDto) {
        return "pedido/formulario";
    }

    @PostMapping("novo")
    public String novo(@Valid PedidoDto pedidoDto , BindingResult result) {
        if (result.hasErrors()) {
            return "pedido/formulario";
        }
        Pedido pedido = pedidoDto.toPedido();
        pedidoRepository.findAll();
        pedidoRepository.save(pedido);
        
        return "redirect:/home";
    }
}
