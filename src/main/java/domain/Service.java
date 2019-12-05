package domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "services")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Service {

    @Id
    private String id;

    private String providerCpf;

    private String providerName;

    private String serviceName;

    private String serviceDescription;

    private String category;

    private Float  value;

}
