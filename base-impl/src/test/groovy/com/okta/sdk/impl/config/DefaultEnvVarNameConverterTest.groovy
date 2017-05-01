/*
 * Copyright 2017 Okta
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.okta.sdk.impl.config

import org.testng.annotations.Test

import static org.testng.Assert.assertEquals

class DefaultEnvVarNameConverterTest {

    @Test
    void testToEnvVarName() {
        def factory = new DefaultEnvVarNameConverter()

        def name = 'okta.client.apiKey.id'

        def envVarName = factory.toEnvVarName(name);

        assertEquals envVarName, 'OKTA_API_KEY_ID'
    }

    @Test
    void testPropNameForApiKeyIdEnvVar() {
        def factory = new DefaultEnvVarNameConverter()

        def name = 'OKTA_API_KEY_ID'

        def propName = factory.toDottedPropertyName(name);

        assertEquals propName, 'okta.client.apiKey.id'
    }

    @Test
    void testPropNameForApiKeySecretEnvVar() {
        def factory = new DefaultEnvVarNameConverter()

        def name = 'OKTA_API_KEY_SECRET'

        def propName = factory.toDottedPropertyName(name);

        assertEquals propName, 'okta.client.apiKey.secret'
    }

    @Test
    void testPropNameForApiKeyFileEnvVar() {
        def factory = new DefaultEnvVarNameConverter()

        def name = 'OKTA_API_KEY_FILE'

        def propName = factory.toDottedPropertyName(name);

        assertEquals propName, 'okta.client.apiKey.file'
    }

    @Test
    void testPropNameForNormalEnvVar() {
        def factory = new DefaultEnvVarNameConverter()

        def name = 'OKTA_AUTHENTICATION_SCHEME'

        def propName = factory.toDottedPropertyName(name);

        assertEquals propName, 'okta.client.authenticationScheme'
    }
}
