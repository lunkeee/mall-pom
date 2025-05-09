package org.example.common.config.feign;


import feign.Client;
import feign.Request;
import feign.Response;

import java.io.IOException;

public class AbstractClient implements Client {
    @Override
    public Response execute(Request request, Request.Options options) throws IOException {
        return null;
    }
}
