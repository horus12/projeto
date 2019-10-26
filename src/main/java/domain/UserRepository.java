package domain;

public interface UserRepository {

    User save(final User user);

    User findByCpf(String cpf);

}
