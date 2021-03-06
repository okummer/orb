/*
 * Copyright (c) 1997, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

package com.sun.corba.ee.impl.protocol ;

import org.omg.CORBA.portable.ServantObject ;

import com.sun.corba.ee.spi.protocol.LocalClientRequestDispatcherFactory ;
import com.sun.corba.ee.spi.protocol.LocalClientRequestDispatcher ;

import com.sun.corba.ee.spi.ior.IOR ;

import com.sun.corba.ee.spi.oa.OAInvocationInfo ;
import com.sun.corba.ee.spi.oa.OADestroyed;

import com.sun.corba.ee.spi.orb.ORB ;

public class MinimalServantCacheLocalCRDImpl extends ServantCacheLocalCRDBase
{
    public MinimalServantCacheLocalCRDImpl( ORB orb, int scid, IOR ior ) 
    {
        super( (com.sun.corba.ee.spi.orb.ORB)orb, scid, ior ) ;
    }

    public ServantObject internalPreinvoke( org.omg.CORBA.Object self,
        String operation, Class expectedType ) throws OADestroyed
    {
        OAInvocationInfo cachedInfo = getCachedInfo() ;
        if (checkForCompatibleServant( cachedInfo, expectedType ))
            return cachedInfo ;
        else
            return null ;
    }

    public void servant_postinvoke(org.omg.CORBA.Object self,
                                   ServantObject servantobj) 
    {
    }
}
