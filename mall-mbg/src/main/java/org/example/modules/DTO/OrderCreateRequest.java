package org.example.modules.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderCreateRequest {

    private Long userId;

    private List<Long> products;
}
