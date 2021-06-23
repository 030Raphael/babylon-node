/*
 * (C) Copyright 2021 Radix DLT Ltd
 *
 * Radix DLT Ltd licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of the
 * License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied.  See the License for the specific
 * language governing permissions and limitations under the License.
 */

package com.radixdlt.api.module;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.ProvidesIntoMap;
import com.google.inject.multibindings.StringMapKey;
import com.radixdlt.api.Controller;
import com.radixdlt.api.controller.HealthController;
import com.radixdlt.api.qualifier.NodeServer;
import com.radixdlt.api.service.ForkVoteStatusService;
import com.radixdlt.api.service.NetworkInfoService;

public class HealthEndpointModule extends AbstractModule {
	@NodeServer
	@ProvidesIntoMap
	@StringMapKey("/health")
	public Controller healthController(NetworkInfoService networkInfoService, ForkVoteStatusService forkVoteStatusService) {
		return new HealthController(networkInfoService, forkVoteStatusService);
	}
}
