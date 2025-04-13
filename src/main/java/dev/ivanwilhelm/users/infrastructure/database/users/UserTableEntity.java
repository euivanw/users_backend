package dev.ivanwilhelm.users.infrastructure.database.users;

import dev.ivanwilhelm.users.domain.users.UsersEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "users")
@Builder
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
class UserTableEntity {
    @Id
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public UsersEntity toUsersEntity() {
        return new UsersEntity(id, firstName, lastName, email, createdAt, updatedAt);
    }
}
