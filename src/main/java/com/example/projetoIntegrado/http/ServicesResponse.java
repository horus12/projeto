package com.example.projetoIntegrado.http;

import domain.Service;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServicesResponse {
    List<Service> services;
}
