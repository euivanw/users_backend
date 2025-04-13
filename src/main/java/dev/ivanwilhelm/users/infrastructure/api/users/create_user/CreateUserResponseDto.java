package dev.ivanwilhelm.users.infrastructure.api.users.create_user;

import dev.ivanwilhelm.users.domain.users.UsersEntity;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class CreateUserResponseDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDateTime createdAt;

    public static CreateUserResponseDto fromEntity(UsersEntity entity) {
        return CreateUserResponseDto.builder()
                .id(entity.id())
                .firstName(entity.firstName())
                .lastName(entity.lastName())
                .email(entity.email())
                .createdAt(entity.createdAt())
                .build();
    }
}
