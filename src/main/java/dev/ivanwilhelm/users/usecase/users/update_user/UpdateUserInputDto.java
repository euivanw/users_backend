package dev.ivanwilhelm.users.usecase.users.update_user;

import java.util.UUID;

public record UpdateUserInputDto(
        UUID id,
        String firstName,
        String lastName,
        String email
) {
}
