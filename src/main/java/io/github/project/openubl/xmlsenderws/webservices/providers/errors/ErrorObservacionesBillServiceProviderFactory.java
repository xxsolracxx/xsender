/**
 * Copyright 2019 Project OpenUBL, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Eclipse Public License - v 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.project.openubl.xmlsenderws.webservices.providers.errors;

import io.github.project.openubl.xmlsenderws.webservices.providers.BillServiceModel;
import io.github.project.openubl.xmlsenderws.webservices.providers.ErrorBillServiceProvider;
import io.github.project.openubl.xmlsenderws.webservices.providers.ErrorBillServiceProviderFactory;
import io.github.project.openubl.xmlsenderws.webservices.utils.Utils;

import javax.xml.ws.soap.SOAPFaultException;

public class ErrorObservacionesBillServiceProviderFactory implements ErrorBillServiceProviderFactory {

    static final int MIN_ERROR_CODE = 4_000;

    @Override
    public ErrorBillServiceProvider create(Integer exceptionCode) {
        return new ErrorObservacionesBillServiceProvider(exceptionCode);
    }

    @Override
    public ErrorBillServiceProvider create(Integer exceptionCode, BillServiceModel previousResult) {
        return new ErrorObservacionesBillServiceProvider(exceptionCode, previousResult);
    }

    @Override
    public boolean isSupported(int errorCode) {
        return errorCode >= MIN_ERROR_CODE;
    }

    @Override
    public boolean isSupported(SOAPFaultException exception) {
        return isSupported(Utils.getErrorCode(exception).orElse(-1));
    }

    @Override
    public int getPriority() {
        return 0;
    }

}
