package br.com.avp.apirest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage( "br.com.avp.apirest" ))             
          .paths(PathSelectors.any())                          
          .build()
          .apiInfo(apiInfo());

    }

	private ApiInfo apiInfo() {

		ApiInfo apiInfo = new ApiInfoBuilder().title("API de Estados")
				.description("Essa é a API de Avaliação de Estados.").license("Apache License Version 2.0")
				.licenseUrl("https://www.youtube.com/watch?v=dQw4w9WgXcQ&ab_channel=RickAstley").termsOfServiceUrl("/service.html")
				.version("0.0.1").contact(new Contact("Giovanni Torres", "www.teste.com.br", "contato@exemplo.com.br"))
				.build();
				
		return apiInfo;
	}

}