package dev.ivanwilhelm.users.infrastructure.api.users.get_user_by_id;

import dev.ivanwilhelm.users.domain.users.UsersEntity;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class GetUserByIdUserResponseDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static GetUserByIdUserResponseDto fromEntity(UsersEntity entity) {
        return GetUserByIdUserResponseDto.builder()
                .id(entity.id())
                .firstName(entity.firstName())
                .lastName(entity.lastName())
                .email(entity.email())
                .createdAt(entity.createdAt())
                .updatedAt(entity.updatedAt())
                .build();
    }
}
