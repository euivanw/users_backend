package dev.ivanwilhelm.users.infrastructure.api.users.create_user;

import dev.ivanwilhelm.users.domain.users.UsersException;
import dev.ivanwilhelm.users.domain.users.UsersRepository;
import dev.ivanwilhelm.users.infrastructure.api.users.UsersController;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateUserController extends UsersController {
    public CreateUserController(UsersRepository repository) {
        super(repository);
    }

    @PostMapping(consumes = {"application/json; charset=UTF-8"}, produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<CreateUserResponseDto> createUser(@Valid @RequestBody CreateUserRequestDto request) throws UsersException {
        final var createdUser = repository.createUser(request.getFirstName(), request.getLastName(), request.getEmail());
        final var createdUserResponse = CreateUserResponseDto.fromEntity(createdUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdUserResponse);
    }
}
