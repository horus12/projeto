package domain;

public interface ProviderRepository {

    Provider save(final Provider user);

    Provider findByCpf(String cpf);

}
