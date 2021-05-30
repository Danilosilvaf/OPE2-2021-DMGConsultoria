package com.IJeans.Backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.IJeans.Backend.model.FuncionarioModel;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {

	@Bean
	public Docket Ijeans() {
        return new Docket(DocumentationType.SWAGGER_2)
  	          .select()
  	          .apis(RequestHandlerSelectors.basePackage("com.IJeans.Backend"))
  	          .paths(PathSelectors.ant("/**"))
  	          .build()
  	          .ignoredParameterTypes(FuncionarioModel.class)
  	          .apiInfo(apiInfo());
  	    }
	
	public ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("IJeans REST API")
				.description("Api utilizada para manter em funcionamento o site IJeans").version("1.0.0")
				.license("Apache License Version 2.0").licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
				.contact(new Contact("DMGConsultoria", "http://localhost:4200", "danilo.e@aluno.faculdadeimpacta.com.br")).build();
	}
	
}
