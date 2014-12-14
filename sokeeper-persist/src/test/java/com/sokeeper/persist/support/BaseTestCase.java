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
package com.sokeeper.persist.support;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientFactoryBean;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.sokeeper.domain.ResourceType;
import com.sokeeper.persist.service.ResourceTypeService;

/**
 * @author XiXi Dai (daizhixia@gmail.com)
 */
abstract public class BaseTestCase extends
//org.springframework.test.AbstractTransactionalDataSourceSpringContextTests {
        org.springframework.test.AbstractDependencyInjectionSpringContextTests {
    protected java.sql.Connection   connection;

    @Autowired
    protected ResourceTypeService   resourceTypeService;

    @Autowired
    private SqlMapClientFactoryBean sqlMapClient;

    protected String[] getConfigLocations() {
        return new String[] { "spring-persist.xml" };
    }

    public void onSetUp() {
        try {
            connection = ((SqlMapClient) sqlMapClient.getObject()).getDataSource().getConnection();
        } catch (SQLException e) {
        }
    }

    public void onTearDown() {
        cleanup();
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
            }
        }
    }

    protected int executeCountSQL(String sql) throws SQLException {
        ResultSet resultSet;
        resultSet = connection.prepareStatement(sql).executeQuery();
        resultSet.next();
        return resultSet.getInt(1);
    }

    protected ResultSet executeQuerySQL(String sql) throws SQLException {
        ResultSet resultSet;
        resultSet = connection.prepareStatement(sql).executeQuery();
        return resultSet;
    }

    protected int executeUpdateSQL(String sql) throws SQLException {
        return connection.prepareStatement(sql).executeUpdate();
    }

    protected void cleanupNodeOnlineStatusTable() throws SQLException {
        connection.prepareStatement("delete from node_online_status").execute();
    }

    protected void cleanupResourceSubscribeListTable() throws SQLException {
        connection.prepareStatement("delete from resource_subscribe").execute();
    }

    protected void cleanupResourceChangesTable() throws SQLException {
        connection.prepareStatement("delete from resource_changes").execute();
    }

    protected void cleanupResourceTypes() throws SQLException {
        connection.prepareStatement("delete from resource_types").execute();
    }

    protected void cleanupResources() throws SQLException {
        connection.prepareStatement("delete from resources").execute();
    }

    protected void cleanupAttributes() throws SQLException {
        connection.prepareStatement("delete from attributes").execute();
    }

    protected void cleanupAssociations() throws SQLException {
        connection.prepareStatement("delete from association").execute();
    }

    protected void cleanupAssociationChanges() throws SQLException {
        connection.prepareStatement("delete from association_changes").execute();
    }

    protected void resetResourceChangesSequence() throws SQLException {
        connection.prepareStatement(
                "update t_sequence set current_value='0' where name='resource_changes'").execute();
    }
    protected void registerResourceType(String typeName, boolean isOnlineResource)
            throws IllegalArgumentException {
        ResourceType resourceType = new ResourceType();
        resourceType.setTypeName(typeName);
        resourceType.setOnlineResource(isOnlineResource);
        resourceTypeService.registerResourceType(resourceType);
    }

    protected void registerResourceType(String typeName, boolean isOnlineResource,
                                        boolean keepHistoric) throws IllegalArgumentException {
        ResourceType resourceType = new ResourceType();
        resourceType.setTypeName(typeName);
        resourceType.setOnlineResource(isOnlineResource);
        resourceType.setKeepHistoric(keepHistoric);
        resourceTypeService.registerResourceType(resourceType);
    }

    protected void cleanup() {
        try {
            resourceTypeService.flushCachedResourceTypes();
        } catch (Throwable e) {
        }
        try {
            resetResourceChangesSequence();
        } catch (Throwable e) {
        }
        try {
            cleanupNodeOnlineStatusTable();
        } catch (Throwable e) {
        }
        try {
            cleanupResourceChangesTable();
        } catch (Throwable e) {
        }
        try {
            cleanupResourceSubscribeListTable();
        } catch (Throwable e) {
        }
        try {
            cleanupResourceTypes();
        } catch (Throwable e) {
        }
        try {
            cleanupResources();
        } catch (Throwable e) {
        }
        try {
            cleanupAttributes();
        } catch (Throwable e) {
        }
        try {
            cleanupAssociations();
        } catch (Throwable e) {
        }
        try{
            cleanupAssociationChanges();
        }catch (Throwable e) {
        }

    }
}
