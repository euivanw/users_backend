package dev.ivanwilhelm.users.infrastructure.api.users.get_user_by_id;

import dev.ivanwilhelm.users.domain.users.UsersException;
import dev.ivanwilhelm.users.domain.users.UsersRepository;
import dev.ivanwilhelm.users.infrastructure.api.users.UsersController;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class GetUserByIdController extends UsersController {
    public GetUserByIdController(UsersRepository repository) {
        super(repository);
    }

    @GetMapping(path = "/{userId}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<GetUserByIdUserResponseDto> getUserById(@PathVariable @NotNull UUID userId) throws UsersException {
        final var user = repository.getUserById(userId);
        final var userResponse = GetUserByIdUserResponseDto.fromEntity(user);

        return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }
}
