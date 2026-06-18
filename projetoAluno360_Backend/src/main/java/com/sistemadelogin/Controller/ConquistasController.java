package projeto_Aluno360.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.projeto_Aluno360.Entity.Conquistas;
import com.projeto_Aluno360.Service.ConquistaService;


import lombok.RequiredArgsConstructor;



	@RestController
	@RequestMapping("/conquistas")
	@RequiredArgsConstructor
	@CrossOrigin("*")
	public class ConquistasController {
		
		private final ConquistaService service;
		
		@PostMapping
		public Conquistas cadastrar(@RequestBody Conquistas conquistas) {
			return service.cadastrar(conquistas);
		}
		@GetMapping
		public List<Conquistas> listar() {
			return service.listar();
		}
		@GetMapping("{id}")
		public Conquistas buscarPorId(@PathVariable Long id) {
			return service.buscarPorId(id);
		}
		@PutMapping("{id}")
		public Conquistas atualizar(
				@PathVariable Long id,
				@RequestBody Conquistas conquistas) {
			return service.atualizar(id, conquistas);
		}
		@DeleteMapping("{id}")
		public String deletar(@PathVariable Long id) {
			service.deletar(id);
			
			return "Conquistas foram deletadas com sucesso";
		}

	}


