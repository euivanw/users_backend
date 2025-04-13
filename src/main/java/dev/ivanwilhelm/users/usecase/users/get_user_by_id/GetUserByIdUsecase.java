package dev.ivanwilhelm.users.usecase.users.get_user_by_id;

import dev.ivanwilhelm.users.domain.users.UserNotFoundException;
import dev.ivanwilhelm.users.domain.users.UsersException;
import dev.ivanwilhelm.users.domain.users.UsersRepository;
import dev.ivanwilhelm.users.shared.Either;
import dev.ivanwilhelm.users.usecase.shared.Usecase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class GetUserByIdUsecase implements Usecase<GetUserByIdInputDto, GetUserByIdOutputDto, UsersException> {
    private final UsersRepository repository;

    @Override
    public Either<UsersException, GetUserByIdOutputDto> execute(GetUserByIdInputDto input) {
        try {
            final var user = repository.getUserById(input.id());

            log.info("User found: {}", user.id());

            return Either.right(
                    new GetUserByIdOutputDto(
                            user.id(),
                            user.firstName(),
                            user.lastName(),
                            user.email(),
                            user.createdAt(),
                            user.updatedAt()
                    )
            );
        } catch (UserNotFoundException exception) {
            log.warn("User not found: {}", input.id());
            return Either.left(exception);
        } catch (UsersException exception) {
            log.error("Error getting user by id {}: {}", input.id(), exception.getMessage(), exception);
            return Either.left(exception);
        } catch (Exception exception) {
            log.error("Unexpected error getting user by id {}: {}", input.id(), exception.getMessage(), exception);
            return Either.left(new UsersException("Unexpected error", exception));
        }
    }
}
