package com.example;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;


import com.example.filter.JWTFilter;





@Component
public class AuthFilter2 extends AbstractGatewayFilterFactory<AuthFilter2.Config> {


    @Autowired
    private RouteValidator validator;

    

    @Autowired
    private JWTFilter jwtUtil;

    public AuthFilter2(){
        super(Config.class);
    } 


    public static class  Config {
    
        
    }



    @Override
    public GatewayFilter apply(Config config) {

return ((exchange,chain)->{


    if(validator.isSecured.test(exchange.getRequest())){
//header contains token or not

if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)){
    throw new RuntimeException("missing authorization header");
}


//taking token from the header
String authHeaders= exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);

if(authHeaders != null && authHeaders.startsWith("Bearer ")){
    authHeaders=authHeaders.substring(7);
}

try{
    // //REST call to AUTH service
    // restTemplate.getForObject("http://SECURITY//validate?token"+authHeaders,String.class);

jwtUtil.validateToken(authHeaders);
}

catch(Exception e){
throw new RuntimeException("unauthorized user");
}

    }

    return chain.filter(exchange);
});


    }


    



}
