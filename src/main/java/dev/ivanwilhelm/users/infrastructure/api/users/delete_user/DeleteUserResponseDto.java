package dev.ivanwilhelm.users.infrastructure.api.users.delete_user;

import dev.ivanwilhelm.users.domain.users.UsersEntity;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class DeleteUserResponseDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static DeleteUserResponseDto fromEntity(UsersEntity entity) {
        return DeleteUserResponseDto.builder()
                .id(entity.id())
                .firstName(entity.firstName())
                .lastName(entity.lastName())
                .email(entity.email())
                .createdAt(entity.createdAt())
                .updatedAt(entity.updatedAt())
                .build();
    }
}
