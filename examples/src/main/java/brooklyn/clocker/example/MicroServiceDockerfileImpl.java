/*
 * Copyright 2014-2015 by Cloudsoft Corporation Limited
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
package brooklyn.clocker.example;

import org.apache.brooklyn.api.entity.proxying.EntitySpec;

import brooklyn.entity.basic.AbstractApplication;
import brooklyn.entity.container.docker.application.VanillaDockerApplication;

public class MicroServiceDockerfileImpl extends AbstractApplication implements MicroServiceDockerfile {

    @Override
    public void initApp() {
        addChild(EntitySpec.create(VanillaDockerApplication.class)
                .configure("containerName", config().get(CONTAINER_NAME))
                .configure("dockerfileUrl", config().get(DOCKERFILE_URL))
                .configure("openPorts", config().get(OPEN_PORTS))
                .configure("directPorts", config().get(DIRECT_PORTS)));
    }

}