/*
 *
 * Copyright (c) 2013 - 2019 Lijun Liao
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

package org.xipki.ca.server;

/**
 * TODO.
 * @author Lijun Liao
 * @since 2.0.0
 */

public class SubjectKeyProfileBundle {

  private final int certId;

  private final long subjectFp;

  private final long keyFp;

  private final String profile;

  private final boolean revoked;

  public SubjectKeyProfileBundle(int certId, long subjectFp, long keyFp, String profile,
      boolean revoked) {
    this.certId = certId;
    this.subjectFp = subjectFp;
    this.keyFp = keyFp;
    this.profile = profile;
    this.revoked = revoked;
  }

  public int getCertId() {
    return certId;
  }

  public long getSubjectFp() {
    return subjectFp;
  }

  public long getKeyFp() {
    return keyFp;
  }

  public String getProfile() {
    return profile;
  }

  public boolean isRevoked() {
    return revoked;
  }
}
