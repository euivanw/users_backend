package dev.ivanwilhelm.users.infrastructure.api.users.get_all_users;

import lombok.Builder;

import java.util.ArrayList;

@Builder
public class GetAllUsersResponseDto extends ArrayList<GetAllUsersUserResponseDto> {
}
