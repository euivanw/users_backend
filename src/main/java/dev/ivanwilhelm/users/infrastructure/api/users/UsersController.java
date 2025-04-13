package dev.ivanwilhelm.users.infrastructure.api.users;

import dev.ivanwilhelm.users.domain.users.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
@AllArgsConstructor
public class UsersController {
    protected final UsersRepository repository;
}
