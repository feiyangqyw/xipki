/*
 *
 * Copyright (c) 2013 - 2018 Lijun Liao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.xipki.ca.client;

import java.security.cert.X509Certificate;
import java.util.Set;

import org.xipki.ca.client.api.CertprofileInfo;
import org.xipki.util.Args;

/**
 * TODO.
 * @author Lijun Liao
 * @since 2.0.0
 */

class ClientCaInfo {

  private final X509Certificate cert;

  private final Set<CertprofileInfo> certprofiles;

  private final ClientCmpControl cmpControl;

  ClientCaInfo(X509Certificate cert, ClientCmpControl cmpControl,
      Set<CertprofileInfo> certprofiles) {
    this.cert = Args.notNull(cert, "cert");
    this.cmpControl = Args.notNull(cmpControl, "cmpControl");
    this.certprofiles = Args.notNull(certprofiles, "certprofiles");
  }

  X509Certificate getCert() {
    return cert;
  }

  ClientCmpControl getCmpControl() {
    return cmpControl;
  }

  Set<CertprofileInfo> getCertprofiles() {
    return certprofiles;
  }

}
