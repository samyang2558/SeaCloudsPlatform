/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.brooklyn.entity.cloudfoundry.services.generic;

import org.apache.brooklyn.entity.cloudfoundry.services.CloudFoundryService;
import org.apache.brooklyn.api.entity.ImplementedBy;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.config.ConfigKeys;
import org.apache.brooklyn.util.core.flags.SetFromFlag;

/**
 * This Interface represent a generic and empty service.
 * It could be bound to any application but the operation it will be empty.
 * The ServiceType is not predefined and it should be defined for the service creation.
 */

@ImplementedBy(GenericServiceImpl.class)
public interface GenericService extends CloudFoundryService {

    @SetFromFlag("serviceType")
    public static final ConfigKey<String> SERVICE_TYPE = ConfigKeys
            .newStringConfigKey("service.type", "Type Of Service");

}
