package dev.ivanwilhelm.users.domain.users;

import java.time.LocalDateTime;
import java.util.UUID;

public record UsersEntity(UUID id, String firstName, String lastName, String email, LocalDateTime createdAt, LocalDateTime updatedAt) {
}
