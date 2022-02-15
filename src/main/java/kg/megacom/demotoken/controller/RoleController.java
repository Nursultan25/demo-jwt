package kg.megacom.demotoken.controller;

import kg.megacom.demotoken.model.request.CreateRoleRequest;
import kg.megacom.demotoken.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/role")
@Slf4j
public class RoleController {
    final RoleService roleService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateRoleRequest createRoleRequest) {
        try {
            return ResponseEntity.ok(roleService.create(createRoleRequest));
        } catch (Exception exception) {
            log.error(exception.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
        }
    }
}
