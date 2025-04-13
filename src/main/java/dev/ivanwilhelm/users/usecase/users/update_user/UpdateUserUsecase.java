package dev.ivanwilhelm.users.usecase.users.update_user;

import dev.ivanwilhelm.users.domain.users.UserNotFoundException;
import dev.ivanwilhelm.users.domain.users.UsersException;
import dev.ivanwilhelm.users.domain.users.UsersRepository;
import dev.ivanwilhelm.users.shared.Either;
import dev.ivanwilhelm.users.usecase.shared.Usecase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class UpdateUserUsecase implements Usecase<UpdateUserInputDto, UpdateUserOutputDto, UsersException> {
    private final UsersRepository repository;

    @Override
    public Either<UsersException, UpdateUserOutputDto> execute(UpdateUserInputDto input) {
        try {
            final var user = repository.updateUser(
                    input.id(),
                    input.firstName(),
                    input.lastName(),
                    input.email()
            );

            log.info("User {} updated sucessfully.", user.id());

            return Either.right(
                    new UpdateUserOutputDto(
                            user.id(),
                            user.firstName(),
                            user.lastName(),
                            user.email(),
                            user.createdAt(),
                            user.updatedAt()
                    )
            );
        } catch (UserNotFoundException exception) {
            log.error("User {} not found: {}", input.id(), exception.getMessage());
            return Either.left(exception);
        } catch (UsersException exception) {
            log.error("Error updating user {}: {}", input.id(), exception.getMessage());
            return Either.left(exception);
        } catch (Exception exception) {
            log.error("Unexpected error updating user {}: {}", input.id(), exception.getMessage());
            return Either.left(new UsersException("Unexpected error", exception));
        }
    }
}
