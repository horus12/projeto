package domain;

import java.util.Optional;

public interface UserRepository {

    User save(final User user);

    User findByCpf(String cpf);

}
