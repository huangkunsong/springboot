package com.hks.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

public class TokenFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(TokenFilter.class);

    /**
     * pre：
     *      这种过滤器在请求被路由之前调用。我们可利用这种过滤器实现身份验证、
     *      在集群中选择请求的微服务、记录调试信息等。
     * routing：
     *      这种过滤器将请求路由到微服务。这种过滤器用于构建发送给微服务的请求，
     *      并使用 Apache HttpClient 或 Netfilx Ribbon 请求微服务。
     * post：
     *      这种过滤器在路由到微服务以后执行。
     *      这种过滤器可用来为响应添加标准的 HTTP Header、收集统计信息和指标、
     *      将响应从微服务发送给客户端等。
     * error：
     *      在其他阶段发生错误时执行该过滤器。
     *      除了默认的过滤器类型，Zuul 还允许我们创建自定义的过滤器类型。
     *      例如，我们可以定制一种 STATIC 类型的过滤器，
     *      直接在 Zuul 中生成响应，而不将请求转发到后端的微服务。
     * @return
     */
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        if (true) {
            throw new RuntimeException("asdasdasdasd");
        }
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("sned {} request to {}",
            request.getMethod(),
            request.getRequestURL().toString()
        );
        Object token = request.getParameter("token");
        if (ObjectUtils.isEmpty(token)) {
            log.warn("access token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }
        log.warn("access token ok");
        return null;
    }
}
