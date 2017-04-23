package com.github.alebabai.jmp2k17.tomcat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"com.github.alebabai.jmp2k17.tomcat"})
@EnableSwagger2
@Import(SpringDataRestConfiguration.class)
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = "com.github.alebabai.jmp2k17.tomcat.repository")
public class TomcatApplication {

    public static void main(String[] args) {
        SpringApplication.run(TomcatApplication.class, args);
    }

    @Bean
    public Docket getApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/posts/**"))
                .build();
    }
}
