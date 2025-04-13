package dev.ivanwilhelm.users.infrastructure.api.users.delete_user;

import dev.ivanwilhelm.users.domain.users.UsersException;
import dev.ivanwilhelm.users.domain.users.UsersRepository;
import dev.ivanwilhelm.users.infrastructure.api.users.UsersController;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class DeleteUserController extends UsersController {
    public DeleteUserController(UsersRepository repository) {
        super(repository);
    }

    @DeleteMapping(path = "/{userId}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<DeleteUserResponseDto> deleteUser(@PathVariable @NotNull UUID userId) throws UsersException {
        final var deletedUser = repository.deleteUser(userId);
        final var deletedUserResponse = DeleteUserResponseDto.fromEntity(deletedUser);

        return ResponseEntity.status(HttpStatus.OK).body(deletedUserResponse);
    }
}
