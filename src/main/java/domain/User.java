package domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    private String id;

    private String cpf;

    private String senha;

    private String userName;

    private String rg;

    private LocalDate CreatedDate;

    private UserStatus Status;

    @Override
    public String toString() {
        return "User{" +
                "id='" + cpf +
                "senha='" + senha + '\'' +
                "username='" + userName + '\'' +
                "rg='" + rg + '\'' +
                '}';
    }

}
