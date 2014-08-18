/*
 * Copyright (c) 2014 Lijun Liao
 *
 * TO-BE-DEFINE
 *
 */

package org.xipki.ca.server.mgmt.shell;

import java.io.File;
import java.security.cert.X509Certificate;
import java.util.HashSet;
import java.util.Set;

import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.xipki.ca.api.CAStatus;
import org.xipki.ca.server.mgmt.api.DuplicationMode;
import org.xipki.ca.server.mgmt.api.Permission;
import org.xipki.ca.server.mgmt.api.ValidityMode;
import org.xipki.security.common.ConfigurationException;

/**
 * @author Lijun Liao
 */

@Command(scope = "ca", name = "gen-rca", description="Generate selfsigned CA")
public class CaGenRootCACommand extends CaAddOrGenCommand
{
    @Option(name = "-subject",
            description = "Required. Subject of the Root CA",
            required = true)
    protected String rcaSubject;

    @Option(name = "-profile",
            description = "Required. Profile of the Root CA",
            required = true)
    protected String rcaProfile;

    @Option(name = "-out",
            description = "Where to save the generated CA certificate")
    protected String rcaCertOutFile;

    @Override
    protected Object doExecute()
    throws Exception
    {
        if(numCrls == null)
        {
            numCrls = 30;
        }

        if(expirationPeriod == null)
        {
            expirationPeriod = 365;
        }

        CAStatus status = CAStatus.ACTIVE;
        if(caStatus != null)
        {
            status = CAStatus.getCAStatus(caStatus);
            if(status == null)
            {
                System.out.println("invalid status: " + caStatus);
                return null;
            }
        }

        DuplicationMode duplicateKey = getDuplicationMode(duplicateKeyI, DuplicationMode.FORBIDDEN_WITHIN_PROFILE);
        DuplicationMode duplicateSubject = getDuplicationMode(duplicateSubjectI, DuplicationMode.FORBIDDEN_WITHIN_PROFILE);

        ValidityMode validityMode = null;
        if(validityModeS != null)
        {
            validityMode = ValidityMode.getInstance(validityModeS);
        }
        if(validityMode == null)
        {
            validityMode = ValidityMode.STRICT;
        }

        Set<Permission> _permissions = new HashSet<>();
        for(String permission : permissions)
        {
            Permission _permission = Permission.getPermission(permission);
            if(_permission == null)
            {
                throw new ConfigurationException("Invalid permission: " + permission);
            }
            _permissions.add(_permission);
        }

        X509Certificate rcaCert = caManager.generateSelfSignedCA(caName,
                rcaProfile,
                rcaSubject,
                status,
                nextSerial,
                crlUris,
                deltaCrlUris,
                ocspUris,
                maxValidity,
                signerType,
                signerConf,
                crlSignerName,
                duplicateKey,
                duplicateSubject,
                _permissions,
                numCrls,
                expirationPeriod,
                validityMode);

        if(rcaCertOutFile != null)
        {
            saveVerbose("Saved root certificate to file", new File(rcaCertOutFile), rcaCert.getEncoded());
        }

        return null;
    }

}
