package kg.megacom.demotoken.service.impl;

import kg.megacom.demotoken.mapper.RoleMapper;
import kg.megacom.demotoken.model.dto.RoleDto;
import kg.megacom.demotoken.model.request.CreateRoleRequest;
import kg.megacom.demotoken.model.response.Response;
import kg.megacom.demotoken.repository.RoleRepository;
import kg.megacom.demotoken.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    final RoleRepository roleRepository;

    @Override
    public RoleDto create(CreateRoleRequest createRoleRequest) {
        RoleDto role = RoleDto.builder()
                .name(createRoleRequest.getName())
                .build();
        roleRepository.save(RoleMapper.INSTANCE.toEntity(role));
        return role;
    }

    @Override
    public List<RoleDto> findAllById(List<Long> ids) {
        return RoleMapper.INSTANCE.toDtoList(roleRepository.getAllByIsDeletedFalse()
                .map(roles -> roles.stream().filter(role -> ids.contains(role.getId())).collect(Collectors.toList()))
                .orElseThrow(() -> new RuntimeException("No roles found")));
    }

    @Override
    public RoleDto getOneByName(String name) {
        return RoleMapper.INSTANCE.toDto(roleRepository.findByNameAndIsDeletedFalse(name).orElseThrow(() -> new RuntimeException("User not found or deleted")));
    }

    @Override
    public List<RoleDto> getAll() {
        return RoleMapper.INSTANCE.toDtoList(roleRepository.findAll());
    }

    @Override
    public RoleDto getOneById(Long id) {
        return RoleMapper.INSTANCE.toDto(roleRepository.findByIdAndIsDeletedFalse(id).orElseThrow(() -> new RuntimeException("User not found or deleted")));
    }

    @Override
    public Response delete(Long id) {
        return roleRepository.findByIdAndIsDeletedFalse(id)
                .map(role -> {
                    role.setIsDeleted(true);
                    roleRepository.save(role);
                    return new Response("User deleted");
                }).orElseThrow(() -> new RuntimeException("User not found or already deleted"));
    }
}
