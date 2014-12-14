/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 */
package com.sokeeper.util;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sokeeper.util.NetUtils;

/**
 * @author XiXi Dai (daizhixia@gmail.com)
 */
public class NetUtilsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test_getAllLocalAddresses() throws Throwable {
        assertNotNull(NetUtils.getAllLocalAddresses());
        assertTrue(NetUtils.selectAvailablePort(5000) > 0);
    }

    @Test
    public void test_selectAvailablePort() throws Throwable {
        ServerSocket ss = new ServerSocket();
        try {
            ss.bind(new InetSocketAddress(9090));
        } catch (IOException e) {
        }
        assertTrue(NetUtils.selectAvailablePort(9090) != 9090);
        ss.close();

    }
}
