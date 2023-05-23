package com.polaris.apipassenger.gray;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import com.netflix.niws.loadbalancer.DiscoveryEnabledServer;

import java.util.List;
import java.util.Map;

public class GrayRule extends AbstractLoadBalancerRule {
    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object o) {
        return choose(getLoadBalancer(), o);
    }

    private Server choose(ILoadBalancer lb, Object key) {
        System.out.println("灰度 rule");
        Server server = null;
        while (server == null) {
            // 获取所有 可达的服务
            List<Server> reachableServers = lb.getServerList(true);

            // 获取当前线程的参数 用户id version = 1
            Map<String, String> map = RibbonParameters.get();
            String version = "";
            if (map != null && map.containsKey("version")) {
                version = map.get("version");
            }
            System.out.println("当前rule version: " + version);
            // 根据用户选服务
            for (int i = 0; i < reachableServers.size(); i++) {
                server = reachableServers.get(i);
                // 获取服务的自定义meta

                //eureka:
                //  instance:
                //    metadata-map:
                //      version: v1

                Map<String, String> metadata = ((DiscoveryEnabledServer) server).getInstanceInfo().getMetadata();
                String metadataVersion = metadata.get("version");
                if (version.trim().equals(metadataVersion)) {
                    break;
                }
            }
        }
        return server;
    }
}
