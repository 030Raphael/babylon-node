/*
 * Engine State API - Babylon (Anemone)
 *
 * This API provides a complete view of the current ledger state, operating at a relatively low level (i.e. returning Entities' data and type information in a generic way, without interpreting specifics of different native or custom components).  It mirrors how the Radix Engine views the ledger state in its \"System\" layer, and thus can be useful for Scrypto developers, who need to inspect how the Engine models and stores their application's state, or how an interface / authentication scheme of another component looks like. 
 *
 * The version of the OpenAPI document: v0.0.1
 * 
 * Generated by: https://openapi-generator.tech
 */


/// 
#[derive(Clone, Copy, Debug, Eq, PartialEq, Ord, PartialOrd, Hash, serde::Serialize, serde::Deserialize)]
pub enum EntityType {
    #[serde(rename = "GlobalPackage")]
    GlobalPackage,
    #[serde(rename = "GlobalConsensusManager")]
    GlobalConsensusManager,
    #[serde(rename = "GlobalValidator")]
    GlobalValidator,
    #[serde(rename = "GlobalGenericComponent")]
    GlobalGenericComponent,
    #[serde(rename = "GlobalAccount")]
    GlobalAccount,
    #[serde(rename = "GlobalIdentity")]
    GlobalIdentity,
    #[serde(rename = "GlobalAccessController")]
    GlobalAccessController,
    #[serde(rename = "GlobalVirtualSecp256k1Account")]
    GlobalVirtualSecp256k1Account,
    #[serde(rename = "GlobalVirtualSecp256k1Identity")]
    GlobalVirtualSecp256k1Identity,
    #[serde(rename = "GlobalVirtualEd25519Account")]
    GlobalVirtualEd25519Account,
    #[serde(rename = "GlobalVirtualEd25519Identity")]
    GlobalVirtualEd25519Identity,
    #[serde(rename = "GlobalFungibleResource")]
    GlobalFungibleResource,
    #[serde(rename = "InternalFungibleVault")]
    InternalFungibleVault,
    #[serde(rename = "GlobalNonFungibleResource")]
    GlobalNonFungibleResource,
    #[serde(rename = "InternalNonFungibleVault")]
    InternalNonFungibleVault,
    #[serde(rename = "InternalGenericComponent")]
    InternalGenericComponent,
    #[serde(rename = "InternalKeyValueStore")]
    InternalKeyValueStore,
    #[serde(rename = "GlobalOneResourcePool")]
    GlobalOneResourcePool,
    #[serde(rename = "GlobalTwoResourcePool")]
    GlobalTwoResourcePool,
    #[serde(rename = "GlobalMultiResourcePool")]
    GlobalMultiResourcePool,
    #[serde(rename = "GlobalTransactionTracker")]
    GlobalTransactionTracker,

}

impl ToString for EntityType {
    fn to_string(&self) -> String {
        match self {
            Self::GlobalPackage => String::from("GlobalPackage"),
            Self::GlobalConsensusManager => String::from("GlobalConsensusManager"),
            Self::GlobalValidator => String::from("GlobalValidator"),
            Self::GlobalGenericComponent => String::from("GlobalGenericComponent"),
            Self::GlobalAccount => String::from("GlobalAccount"),
            Self::GlobalIdentity => String::from("GlobalIdentity"),
            Self::GlobalAccessController => String::from("GlobalAccessController"),
            Self::GlobalVirtualSecp256k1Account => String::from("GlobalVirtualSecp256k1Account"),
            Self::GlobalVirtualSecp256k1Identity => String::from("GlobalVirtualSecp256k1Identity"),
            Self::GlobalVirtualEd25519Account => String::from("GlobalVirtualEd25519Account"),
            Self::GlobalVirtualEd25519Identity => String::from("GlobalVirtualEd25519Identity"),
            Self::GlobalFungibleResource => String::from("GlobalFungibleResource"),
            Self::InternalFungibleVault => String::from("InternalFungibleVault"),
            Self::GlobalNonFungibleResource => String::from("GlobalNonFungibleResource"),
            Self::InternalNonFungibleVault => String::from("InternalNonFungibleVault"),
            Self::InternalGenericComponent => String::from("InternalGenericComponent"),
            Self::InternalKeyValueStore => String::from("InternalKeyValueStore"),
            Self::GlobalOneResourcePool => String::from("GlobalOneResourcePool"),
            Self::GlobalTwoResourcePool => String::from("GlobalTwoResourcePool"),
            Self::GlobalMultiResourcePool => String::from("GlobalMultiResourcePool"),
            Self::GlobalTransactionTracker => String::from("GlobalTransactionTracker"),
        }
    }
}

impl Default for EntityType {
    fn default() -> EntityType {
        Self::GlobalPackage
    }
}




