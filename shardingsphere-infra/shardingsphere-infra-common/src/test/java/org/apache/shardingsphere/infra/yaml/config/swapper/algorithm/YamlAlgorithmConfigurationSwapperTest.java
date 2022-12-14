/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.infra.yaml.config.swapper.algorithm;

import org.apache.shardingsphere.infra.config.algorithm.AlgorithmConfiguration;
import org.apache.shardingsphere.infra.yaml.config.pojo.algorithm.YamlAlgorithmConfiguration;
import org.junit.Test;

import java.util.Properties;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public final class YamlAlgorithmConfigurationSwapperTest {
    
    @Test
    public void assertSwapToYaml() {
        YamlAlgorithmConfiguration actual = new YamlAlgorithmConfigurationSwapper().swapToYamlConfiguration(
                new AlgorithmConfiguration("TEST", createProps()));
        assertThat(actual.getType(), is("TEST"));
        assertThat(actual.getProps().getProperty("key"), is("value"));
    }
    
    @Test
    public void assertSwapToObject() {
        YamlAlgorithmConfiguration yamlConfig = new YamlAlgorithmConfiguration("TEST", createProps());
        AlgorithmConfiguration actual = new YamlAlgorithmConfigurationSwapper().swapToObject(yamlConfig);
        assertThat(actual.getType(), is("TEST"));
        assertThat(actual.getProps().getProperty("key"), is("value"));
    }
    
    private Properties createProps() {
        Properties result = new Properties();
        result.setProperty("key", "value");
        return result;
    }
}
