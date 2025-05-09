package org.example.order.modules.Request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderCreateRequest {

    private int userId;

    private List<Long> products;
}
