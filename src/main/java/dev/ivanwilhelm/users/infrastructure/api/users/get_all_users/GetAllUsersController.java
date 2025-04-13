package dev.ivanwilhelm.users.infrastructure.api.users.get_all_users;

import dev.ivanwilhelm.users.domain.users.UsersException;
import dev.ivanwilhelm.users.domain.users.UsersRepository;
import dev.ivanwilhelm.users.infrastructure.api.users.UsersController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetAllUsersController extends UsersController {
    public GetAllUsersController(UsersRepository repository) {
        super(repository);
    }

    @GetMapping(produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<GetAllUsersResponseDto> getAllUsers() throws UsersException {
        final var allUsers = repository.getAllUsers();

        final var allUsersResponse = new GetAllUsersResponseDto();
        allUsersResponse.addAll(allUsers.stream()
                .map(GetAllUsersUserResponseDto::fromEntity)
                .toList());

        return ResponseEntity.status(HttpStatus.OK).body(allUsersResponse);
    }
}
