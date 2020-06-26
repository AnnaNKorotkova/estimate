package ru.topjava.estimate.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.topjava.estimate.util.JacksonObjectMapper;

import java.util.List;


public class WebConfig implements WebMvcConfigurer {

    public ObjectMapper customJacksonObjectMapper() {
        return JacksonObjectMapper.getMapper();
    }

//    @Override
//    public void configureMessageConverters(
//            List<HttpMessageConverter<?>> converters) {
//        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
//        converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
//    }
}
