package dev.ivanwilhelm.users.usecase.users.delete_user;

import dev.ivanwilhelm.users.domain.users.UserNotFoundException;
import dev.ivanwilhelm.users.domain.users.UsersException;
import dev.ivanwilhelm.users.domain.users.UsersRepository;
import dev.ivanwilhelm.users.shared.CoreException;
import dev.ivanwilhelm.users.shared.Either;
import dev.ivanwilhelm.users.usecase.shared.Usecase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class DeleteUserUsecase implements Usecase<DeleteUserInputDto, DeleteUserOutputDto, UsersException> {
    private final UsersRepository repository;

    @Override
    public Either<UsersException, DeleteUserOutputDto> execute(DeleteUserInputDto input) throws CoreException {
        try {
            final var user = repository.deleteUser(input.id());

            log.info("Deleted user {}", user.id());

            return Either.right(
                    new DeleteUserOutputDto(
                            user.id(),
                            user.firstName(),
                            user.lastName(),
                            user.email(),
                            user.createdAt(),
                            user.updatedAt()
                    )
            );
        } catch (UserNotFoundException exception) {
            log.warn("User not found {}", input.id());
            return Either.left(exception);
        } catch (UsersException exception) {
            log.error("Error deleting user {}: {}", input.id(), exception.getMessage(), exception);
            return Either.left(exception);
        } catch (Exception exception) {
            log.error("Unexpected error deleting user {}: {}", input.id(), exception.getMessage(), exception);
            throw new CoreException("Unexpected error deleting user", exception);
        }
    }
}
