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
package com.sokeeper.rpc.transport.support;

import com.sokeeper.rpc.transport.RpcConnection;
import com.sokeeper.rpc.transport.RpcIoHandler;
import com.sokeeper.rpc.transport.RpcIoListener;
import com.sokeeper.util.RpcAddress;

/**
 * @author XiXi Dai (daizhixia@gmail.com)
 */
public class RpcIoListenerImpl implements RpcIoListener {
    private RpcConnection connection;
    private String        event;

    public void onConnectionClosed(RpcConnection connection, RpcIoHandler ioHandler) {
        this.connection = connection;
        this.event = "onConnectionClosed";
    }

    public void onConnectionCreated(RpcConnection connection, RpcIoHandler ioHandler) {
        this.connection = connection;
        this.event = "onConnectionCreated";
    }

    public RpcAddress getLocalAddress() {
        return connection != null ? connection.getLocalAddress() : null;
    }

    public RpcAddress getRemoteAddress() {
        return connection != null ? connection.getRemoteAddress() : null;
    }

    public void setConnection(RpcConnection connection) {
        this.connection = connection;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

}
