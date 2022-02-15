package kg.megacom.demotoken.service;

import kg.megacom.demotoken.model.dto.RoleDto;
import kg.megacom.demotoken.model.request.CreateRoleRequest;
import kg.megacom.demotoken.model.response.Response;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {
    RoleDto create(CreateRoleRequest createRoleRequest);
    List<RoleDto> findAllById(List<Long> ids);
    RoleDto getOneByName(String name);
    List<RoleDto> getAll();
    RoleDto getOneById(Long id);
    Response delete(Long id);
}
