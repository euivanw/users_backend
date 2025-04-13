package dev.ivanwilhelm.users.usecase.users.create_user;

import dev.ivanwilhelm.users.domain.users.UsersException;
import dev.ivanwilhelm.users.domain.users.UsersRepository;
import dev.ivanwilhelm.users.shared.Either;
import dev.ivanwilhelm.users.usecase.shared.Usecase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class CreateUserUsecase implements Usecase<CreateUserInputDto, CreateUserOutputDto, UsersException> {
    private final UsersRepository repository;

    @Override
    public Either<UsersException, CreateUserOutputDto> execute(CreateUserInputDto input) {
        try {
            final var user = repository.createUser(
                    input.firstName(),
                    input.lastName(),
                    input.email()
            );

            log.info("User created successfully: {}", user.id());

            return Either.right(
                    new CreateUserOutputDto(
                            user.id(),
                            user.firstName(),
                            user.lastName(),
                            user.email(),
                            user.createdAt()
                    )
            );
        } catch (UsersException exception) {
            log.error("Error creating user: {}", exception.getMessage(), exception);
            return Either.left(exception);
        } catch (Exception exception) {
            log.error("Unexpected error creating user: {}", exception.getMessage(), exception);
            return Either.left(new UsersException("Unexpected error", exception));
        }
    }
}
