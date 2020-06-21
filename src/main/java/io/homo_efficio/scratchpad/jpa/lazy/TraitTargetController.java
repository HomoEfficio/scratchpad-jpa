package io.homo_efficio.scratchpad.jpa.lazy;

import io.homo_efficio.scratchpad.jpa.lazy.model.TraitTarget;
import io.homo_efficio.scratchpad.jpa.lazy.model.TraitTargetOut;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author homo.efficio@gmail.com
 * created on 2020-06-19
 */
@RequestMapping("/trait-targets")
@RestController
@RequiredArgsConstructor
public class TraitTargetController {

    private final TraitTargetService traitTargetService;

    @PostMapping
    public ResponseEntity<TraitTarget> create(@RequestBody TraitTarget traitTarget) {
        return ResponseEntity.ok(traitTargetService.save(traitTarget));
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Container> findById(@PathVariable Long id) {
//        Container container = containerService.findById(id);
//        return ResponseEntity.ok(container);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<TraitTargetOut> findOutById(@PathVariable Long id) {
        TraitTargetOut traitTargetOut = traitTargetService.findOutById(id);
        return ResponseEntity.ok(traitTargetOut);
    }
}
