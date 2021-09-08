package rpc_04.client;

import rpc_04.common.RPCRequest;
import rpc_04.common.RPCResponse;

public interface RPCClient {
    RPCResponse sendRequest(RPCRequest request);
}
