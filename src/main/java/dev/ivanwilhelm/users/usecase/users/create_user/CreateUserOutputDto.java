package dev.ivanwilhelm.users.usecase.users.create_user;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateUserOutputDto(
        UUID id,
        String firstName,
        String lastName,
        String email,
        LocalDateTime createdAt
) {
}
