package pq.empm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pq.empm.interceptor.LoginInterceptor;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class InterceptorConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        HandlerInterceptor loginInterceptor=new LoginInterceptor();

        InterceptorRegistration ir=registry.addInterceptor(loginInterceptor);
        // 黑名单
        ir.addPathPatterns("/**");

        // 不拦 注册/登录 静态资源
        List<String> patterns=new ArrayList<String>();
        // 静态资源
        patterns.add("/bootstrap3/**");
        patterns.add("/css/**");
        patterns.add("/images/**");
        patterns.add("/js/**");
        // 注册和登录页面
        patterns.add("/web/login.html");
        patterns.add("/web/register.html");
        patterns.add("/web/index.html");
        patterns.add("/web/search.html");
        patterns.add("/web/flie.html");
        patterns.add("/web/updateInfo.html");
        patterns.add("/web/pUpdateInfo.html");
        patterns.add("/search.html");
        // 注册和登录控制器
        patterns.add("/users/login");
        patterns.add("/users/reg");
        patterns.add("/publisher/login");
        patterns.add("/publisher/reg");
        patterns.add("/users/test");
        patterns.add("/job/type");
        patterns.add("/job/hot_job_list");
        patterns.add("/job/commpany_type");
        patterns.add("/users/update_user_info");
        patterns.add("/users/query_info");
        patterns.add("/users/check_login");
        patterns.add("/search/query");
        patterns.add("http://192.168.229.132:9200");
        // 白名单
        ir.excludePathPatterns(patterns);
    }
}
