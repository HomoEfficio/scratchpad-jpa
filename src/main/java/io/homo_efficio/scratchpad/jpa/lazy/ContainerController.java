package io.homo_efficio.scratchpad.jpa.lazy;

import io.homo_efficio.scratchpad.jpa.lazy.model.Container;
import io.homo_efficio.scratchpad.jpa.lazy.model.ContainerOut;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author homo.efficio@gmail.com
 * created on 2020-06-19
 */
@RequestMapping("/containers")
@RestController
@RequiredArgsConstructor
public class ContainerController {

    private final ContainerService containerService;

    @PostMapping
    public ResponseEntity<Container> create(@RequestBody Container container) {
        return ResponseEntity.ok(containerService.save(container));
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Container> findById(@PathVariable Long id) {
//        Container container = containerService.findById(id);
//        return ResponseEntity.ok(container);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<ContainerOut> findOutById(@PathVariable Long id) {
        ContainerOut containerOut = containerService.findOutById(id);
        return ResponseEntity.ok(containerOut);
    }
}
