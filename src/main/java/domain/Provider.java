package domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "provider")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Provider {

    @Id
    private String id;

    private String cpf;

    private String senha;

    private String userName;

    private String rg;

    private LocalDate CreatedDate;

    private UserStatus Status;

    private String contact;

}
