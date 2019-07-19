package com.plastech.crm.rpcservice;

import org.springframework.cloud.netflix.feign.FeignClient;
import com.plastech.crm.rpcservice.hystrix.RpcSalesAnalysisServiceHystrix;

/**
 *
 *
 * @author : yemin
 * @date : 2019年2月18日 下午5:20:04
 *
 */
@FeignClient(value = "crmSalesAnalysisClient", fallback = RpcSalesAnalysisServiceHystrix.class)
public interface RpcSalesAnalysisService {

}
