/* Copyright 2021 Radix Publishing Ltd incorporated in Jersey (Channel Islands).
 *
 * Licensed under the Radix License, Version 1.0 (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of the License at:
 *
 * radixfoundation.org/licenses/LICENSE-v1
 *
 * The Licensor hereby grants permission for the Canonical version of the Work to be
 * published, distributed and used under or by reference to the Licensor’s trademark
 * Radix ® and use of any unregistered trade names, logos or get-up.
 *
 * The Licensor provides the Work (and each Contributor provides its Contributions) on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * including, without limitation, any warranties or conditions of TITLE, NON-INFRINGEMENT,
 * MERCHANTABILITY, or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * Whilst the Work is capable of being deployed, used and adopted (instantiated) to create
 * a distributed ledger it is your responsibility to test and validate the code, together
 * with all logic and performance of that code under all foreseeable scenarios.
 *
 * The Licensor does not make or purport to make and hereby excludes liability for all
 * and any representation, warranty or undertaking in any form whatsoever, whether express
 * or implied, to any entity or person, including any representation, warranty or
 * undertaking, as to the functionality security use, value or other characteristics of
 * any distributed ledger nor in respect the functioning or value of any tokens which may
 * be created stored or transferred using the Work. The Licensor does not warrant that the
 * Work or any use of the Work complies with any law or regulation in any territory where
 * it may be implemented or used or that it will be appropriate for any specific purpose.
 *
 * Neither the licensor nor any current or former employees, officers, directors, partners,
 * trustees, representatives, agents, advisors, contractors, or volunteers of the Licensor
 * shall be liable for any direct or indirect, special, incidental, consequential or other
 * losses of any kind, in tort, contract or otherwise (including but not limited to loss
 * of revenue, income or profits, or loss of use or data, or loss of reputation, or loss
 * of any economic or other opportunity of whatsoever nature or howsoever arising), arising
 * out of or in connection with (without limitation of any use, misuse, of any ledger system
 * or use made or its functionality or any performance or operation of any code or protocol
 * caused by bugs or programming or logic errors or otherwise);
 *
 * A. any offer, purchase, holding, use, sale, exchange or transmission of any
 * cryptographic keys, tokens or assets created, exchanged, stored or arising from any
 * interaction with the Work;
 *
 * B. any failure in a transmission or loss of any token or assets keys or other digital
 * artefacts due to errors in transmission;
 *
 * C. bugs, hacks, logic errors or faults in the Work or any communication;
 *
 * D. system software or apparatus including but not limited to losses caused by errors
 * in holding or transmitting tokens by any third-party;
 *
 * E. breaches or failure of security including hacker attacks, loss or disclosure of
 * password, loss of private key, unauthorised use or misuse of such passwords or keys;
 *
 * F. any losses including loss of anticipated savings or other benefits resulting from
 * use of the Work or any changes to the Work (however implemented).
 *
 * You are solely responsible for; testing, validating and evaluation of all operation
 * logic, functionality, security and appropriateness of using the Work for any commercial
 * or non-commercial purpose and for any reproduction or redistribution by You of the
 * Work. You assume all risks associated with Your use of the Work and the exercise of
 * permissions under this License.
 */

extern crate core;

mod accumulator_tree;
mod commit_bundle;
mod committer;
mod formatter;
pub mod jni;
mod limits;
mod mempool;
mod metrics;
mod protocol;
pub mod query;
mod receipt;
mod staging;
pub mod state_manager;
pub mod store;
mod system_commits;
mod system_executor;
mod transaction;
mod types;

#[cfg(test)]
mod test;

pub mod prelude {
    // Other prelude re-exports
    pub(crate) use crate::engine_prelude::*;
    pub(crate) use node_common::prelude::*;

    // Public prelude
    pub use crate::formatter::*;
    pub use crate::mempool::*;
    pub use crate::protocol::*;
    pub use crate::query::*;
    pub use crate::receipt::*;
    pub use crate::state_manager::*;
    pub use crate::store::*;
    pub use crate::transaction::*;
    pub use crate::types::*;

    // Extra items on the internal prelude
    pub(crate) use crate::accumulator_tree::*;
    pub(crate) use crate::committer::*;
    pub(crate) use crate::jni::LedgerSyncLimitsConfig;
    pub(crate) use crate::limits::*;
    pub(crate) use crate::metrics::*;
    pub(crate) use crate::staging::*;
    pub(crate) use crate::system_commits::*;
    pub(crate) use crate::system_executor::*;
}

pub mod jni_prelude {
    pub use crate::jni::node_rust_environment::*;
    pub(crate) use crate::prelude::*;
    pub use node_common::jni_prelude::*;
}

// We have made this public because the ledger-tools relies on it to ensure that it's using the same
// engine dependencies.
#[allow(unused_imports)]
pub mod engine_prelude {
    pub use radix_common::prelude::*;

    pub use radix_engine::errors::*;
    pub use radix_engine::system::bootstrap::*;
    #[cfg(feature = "db_checker")]
    pub use radix_engine::system::checkers::*;
    pub use radix_engine::system::system_db_reader::*;
    pub use radix_engine::system::system_substates::*;
    pub use radix_engine::transaction::*;
    pub use radix_engine::updates::*;
    pub use radix_engine::vm::*;
    pub use radix_engine::*;

    pub use radix_engine_interface::blueprints::account::*;
    pub use radix_engine_interface::blueprints::transaction_processor::*;
    pub use radix_engine_interface::prelude::*;

    pub use radix_substate_store_impls::state_tree::tree_store::*;
    pub use radix_substate_store_impls::state_tree::*;
    pub use radix_substate_store_impls::*;
    pub use radix_substate_store_interface::db_key_mapper::*;
    pub use radix_substate_store_interface::interface::*;
    pub use radix_substate_store_queries::query::*;
    pub use radix_substate_store_queries::typed_substate_layout::*;

    pub use radix_transaction_scenarios::scenario::*;

    pub use radix_transactions::builder::*;
    pub use radix_transactions::define_raw_transaction_payload;
    pub use radix_transactions::errors::*;
    pub use radix_transactions::manifest::*;
    pub use radix_transactions::model::*;
    pub use radix_transactions::prelude::*;
    pub use radix_transactions::validation::*;

    // Note: plain `pub use radix_engine::track::*` would clash with the top-level `utils::prelude`
    // (because it contains a private module of the same name)
    pub use radix_engine::track::interface::*;
    pub use radix_engine::track::state_updates::*;
}
