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
package com.sokeeper.domain.resource;

import java.io.Serializable;

/**
 * @author XiXi Dai (daizhixia@gmail.com)
 */
public class ResourceAttributeDTO implements Serializable {
    private static final long serialVersionUID = -8374335044258027341L;
    private ResourceEntity    resource;
    private AttributeEntity   attribute;

    public ResourceAttributeDTO() {
        resource = new ResourceEntity();
        attribute = new AttributeEntity();
    }

    public AttributeEntity getAttribute() {
        return attribute;
    }

    public ResourceEntity getResource() {
        return resource;
    }

}
