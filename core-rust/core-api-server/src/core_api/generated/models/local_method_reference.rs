/*
 * Babylon Core API
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node. It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Heavy load may impact the node's function.  If you require queries against historical ledger state, you may also wish to consider using the [Gateway API](https://betanet-gateway.redoc.ly/). 
 *
 * The version of the OpenAPI document: 0.3.0
 * 
 * Generated by: https://openapi-generator.tech
 */



#[derive(Clone, Debug, PartialEq, serde::Serialize, serde::Deserialize)]
#[serde(tag = "type")]
pub enum LocalMethodReference {
    #[serde(rename="NativeMethod")]
    LocalNativeMethodReference {
        #[serde(rename = "name")]
        name: String,
    },
    #[serde(rename="ScryptoMethod")]
    LocalScryptoMethodReference {
        #[serde(rename = "name")]
        name: String,
    },
}




