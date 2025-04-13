package dev.ivanwilhelm.users.usecase.users.update_user;

import java.time.LocalDateTime;
import java.util.UUID;

public record UpdateUserOutputDto(
        UUID id,
        String firstName,
        String lastName,
        String email,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
