package kg.megacom.demotoken.repository;

import kg.megacom.demotoken.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByNameAndIsDeletedFalse(String name);
    Optional<Role> findByIdAndIsDeletedFalse(Long id);
    Optional<List<Role>> getAllByIsDeletedFalse();
}
