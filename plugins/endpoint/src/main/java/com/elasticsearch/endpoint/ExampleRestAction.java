package com.elasticsearch.endpoint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.action.admin.cluster.node.info.NodeInfo;
import org.elasticsearch.action.admin.cluster.node.info.NodesInfoResponse;
import org.elasticsearch.client.node.NodeClient;
import org.elasticsearch.rest.BaseRestHandler;
import org.elasticsearch.rest.BytesRestResponse;
import org.elasticsearch.rest.RestRequest;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.xcontent.XContentBuilder;

import static org.elasticsearch.rest.RestRequest.Method.GET;
import static org.elasticsearch.rest.RestRequest.Method.POST;

public class ExampleRestAction extends BaseRestHandler {

    @Override
    public List<Route> routes() {
        return List.of(
            new Route(GET, "/_master/nodes"),
            new Route(POST, "/_master/nodes"));
    }

    @Override
    public String getName() {
        return "endpoint_handler_by_jerrry";
    }

    @Override
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
        String prefix = request.param("prefix", "");
        return channel -> {
            XContentBuilder builder = channel.newBuilder();
            builder.startObject();
            List<String> nodes = new ArrayList<String>();
            NodesInfoResponse response = client.admin().cluster().prepareNodesInfo().get();
            for (NodeInfo nodeInfo : response.getNodes()) {
                String nodeName = nodeInfo.getNode().getName();
                if (prefix.isEmpty()) {
                    nodes.add(nodeName);
                } else if (nodeName.startsWith(prefix)) {
                    nodes.add(nodeName);
                }
            }
            builder.field("nodes", nodes);
            builder.endObject();
            
            channel.sendResponse(new BytesRestResponse(RestStatus.OK, builder));
        };
    }
}
