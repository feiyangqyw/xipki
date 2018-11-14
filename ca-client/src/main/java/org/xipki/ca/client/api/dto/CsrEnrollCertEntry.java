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

package org.xipki.ca.client.api.dto;

import org.bouncycastle.asn1.pkcs.CertificationRequest;
import org.xipki.util.Args;

/**
 * TODO.
 * @author Lijun Liao
 * @since 2.0.0
 */

public class CsrEnrollCertEntry {

  private final CertificationRequest csr;

  private final String profile;

  public CsrEnrollCertEntry(CertificationRequest csr, String profile) {
    this.csr = Args.notNull(csr, "csr");
    this.profile = Args.notNull(profile, "profile");
  }

  public CertificationRequest getCsr() {
    return csr;
  }

  public String getProfile() {
    return profile;
  }

}
