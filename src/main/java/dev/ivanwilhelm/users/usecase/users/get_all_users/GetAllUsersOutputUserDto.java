package dev.ivanwilhelm.users.usecase.users.get_all_users;

import java.time.LocalDateTime;
import java.util.UUID;

public record GetAllUsersOutputUserDto(
        UUID id,
        String firstName,
        String lastName,
        String email,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
