package dev.ivanwilhelm.users.usecase.users.get_all_users;

import java.util.List;

public record GetAllUsersOutputDto(
        List<GetAllUsersOutputUserDto> users
) {
}
