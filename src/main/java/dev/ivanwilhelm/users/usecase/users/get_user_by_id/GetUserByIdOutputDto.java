package dev.ivanwilhelm.users.usecase.users.get_user_by_id;

import java.time.LocalDateTime;
import java.util.UUID;

public record GetUserByIdOutputDto(
        UUID id,
        String firstName,
        String lastName,
        String email,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
