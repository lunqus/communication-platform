package com.protocols.communicationplatform.endpoint;

import com.protocols.communication_platforms.Customer;
import com.protocols.communication_platforms.GetCustomerRequest;
import com.protocols.communication_platforms.GetCustomerResponse;
import com.protocols.communicationplatform.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CustomerEndpoint {

    @Autowired
    private CustomerService customerService;

    @PayloadRoot(namespace = "http://protocols.com/communication-platforms",
            localPart = "getCustomerRequest")

    @ResponsePayload
    public GetCustomerResponse getCustomerRequest(@RequestPayload GetCustomerRequest request) {
        GetCustomerResponse response = new GetCustomerResponse();
        response.setCustomer(customerService.getCustomers(request.getName()));
        return response;
    }

}
