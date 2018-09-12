package io.github.carlosthe19916.webservices.exceptions;

import io.github.carlosthe19916.webservices.utils.Util;

import javax.xml.ws.soap.SOAPFaultException;
import java.util.Optional;

public class WebServiceExceptionFactory {

    private WebServiceExceptionFactory() {
        // Just static methods
    }

    public static AbstractWebServiceException createWebServiceException(SOAPFaultException e) {
        Optional<Integer> errorCode = Util.getErrorCode(e);
        if (errorCode.isPresent()) {
            return new ValidationWebServiceException(e);
        } else {
            return new UnknownWebServiceException(e);
        }
    }
}
