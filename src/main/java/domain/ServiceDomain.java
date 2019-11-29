package domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ServiceDomain {

    String userName;
    String providerName;
    String serviceRequested;

}
