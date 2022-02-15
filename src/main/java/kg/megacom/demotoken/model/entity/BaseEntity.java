package kg.megacom.demotoken.model.entity;

import kg.megacom.demotoken.model.enums.Status;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@MappedSuperclass
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    Long id;

    @Column(name = "is_deleted", nullable = false, columnDefinition = "DEFAULT BOOLEAN TRUE")
    Boolean isDeleted;

    @CreationTimestamp
    @Column(name = "date_created", nullable = false)
    LocalDateTime dateCreated;

    @UpdateTimestamp
    @Column(name = "date_updated", nullable = false)
    LocalDateTime dateUpdated;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    Status status;
}
