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
package brooklyn.networking.sdn.ibm;

import org.apache.brooklyn.api.entity.ImplementedBy;
import org.apache.brooklyn.api.sensor.AttributeSensor;
import org.apache.brooklyn.config.ConfigKey;
import org.apache.brooklyn.core.config.ConfigKeys;
import org.apache.brooklyn.core.sensor.BasicAttributeSensorAndConfigKey;
import org.apache.brooklyn.core.sensor.Sensors;
import org.apache.brooklyn.entity.software.base.SoftwareProcess;
import org.apache.brooklyn.util.core.flags.SetFromFlag;

import brooklyn.networking.sdn.SdnAgent;

/**
 * The IBM SDN VE agent.
 */
@ImplementedBy(SdnVeAgentImpl.class)
public interface SdnVeAgent extends SdnAgent {

    @SetFromFlag("version")
    ConfigKey<String> SUGGESTED_VERSION = ConfigKeys.newConfigKeyWithDefault(SoftwareProcess.SUGGESTED_VERSION, "1.1.90-06");

    @SetFromFlag("downloadUrl")
    BasicAttributeSensorAndConfigKey<String> DOWNLOAD_URL = new BasicAttributeSensorAndConfigKey<String>(
            SoftwareProcess.DOWNLOAD_URL, "https://s3-eu-west-1.amazonaws.com/brooklyn-clocker/DoveAgent-${version}.x86_64.rpm.docker.works.rpm");

    AttributeSensor<Integer> DOVE_BRIDGE_ID = Sensors.newIntegerSensor("sdn.ibm.bridgeId", "IBM SDN VE Dove Bridge ID");
    AttributeSensor<Integer> DOVE_DOMAIN_ID = Sensors.newIntegerSensor("sdn.ibm.domainId", "IBM SDN VE Dove Domain ID");

    String getDmcAddress();

    String getAgentAddress();

}
