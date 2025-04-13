package dev.ivanwilhelm.users.usecase.users.delete_user;

import java.time.LocalDateTime;
import java.util.UUID;

public record DeleteUserOutputDto(
        UUID id,
        String firstName,
        String lastName,
        String email,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
