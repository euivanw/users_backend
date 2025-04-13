package dev.ivanwilhelm.users.usecase.users.create_user;

public record CreateUserInputDto(
        String firstName,
        String lastName,
        String email
) {
}
