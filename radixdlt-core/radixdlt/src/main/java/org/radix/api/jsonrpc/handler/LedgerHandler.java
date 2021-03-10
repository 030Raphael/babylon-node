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

package org.radix.api.jsonrpc.handler;

import org.json.JSONObject;
import org.radix.api.services.LedgerService;

import static org.radix.api.jsonrpc.JsonRpcUtil.withNamedParameter;

public class LedgerHandler {
	private final LedgerService ledgerService;

	public LedgerHandler(LedgerService ledgerService) {
		this.ledgerService = ledgerService;
	}

	public JSONObject handleGetAtomStatus(JSONObject request) {
		return withNamedParameter(request, "aid", (params, aid) -> ledgerService.getAtomStatus(request, aid));
	}

	public JSONObject handleGetAtoms(JSONObject request) {
		return withNamedParameter(request, "address", (params, address) -> ledgerService.getAtoms(request, address));
	}
}
