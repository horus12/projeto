package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "requested_services")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequestedService {

    private String userCpf;

    private String providerCpf;

    private String serviceName;

    private String serviceDescription;

    private String category;

    private Float  value;
}
