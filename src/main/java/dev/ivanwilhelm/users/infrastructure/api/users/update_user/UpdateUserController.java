package dev.ivanwilhelm.users.infrastructure.api.users.update_user;

import dev.ivanwilhelm.users.domain.users.UsersException;
import dev.ivanwilhelm.users.domain.users.UsersRepository;
import dev.ivanwilhelm.users.infrastructure.api.users.UsersController;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class UpdateUserController extends UsersController {
    public UpdateUserController(UsersRepository repository) {
        super(repository);
    }

    @PutMapping(path = "/{userId}", consumes = {"application/json; charset=UTF-8"}, produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<UpdateUserResponseDto> updateUser(@PathVariable @NotNull UUID userId,
                                                            @Valid @RequestBody UpdateUserRequestDto request) throws UsersException {
        final var updatedUser = repository.updateUser(userId, request.getFirstName(), request.getLastName(), request.getEmail());
        final var updatedUserResponse = UpdateUserResponseDto.fromEntity(updatedUser);

        return ResponseEntity.status(HttpStatus.OK).body(updatedUserResponse);
    }
}
