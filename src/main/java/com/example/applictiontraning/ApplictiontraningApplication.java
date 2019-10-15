package com.example.applictiontraning;

import com.google.common.base.Predicate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

@SpringBootApplication
@EnableSwagger2
public class ApplictiontraningApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplictiontraningApplication.class, args);
	}

	// DocketはSpring Foxが提供するAPI。Swaggerで書き起こすために設定が必要
	@Bean
	public Docket petApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select() // ApiSelector : Swaggerで書き起こすAPIを選択する。
				.paths(paths())
				.build() // ApiSelectorを作成
				.useDefaultResponseMessages(false) // 定義していないステータスコードを自動で付与してくれる。今回は自動付与をOFFに
				.apiInfo(apiInfo()); // APIのインフォメーションを設定
	}

	private Predicate<String> paths() {
		return or(
				regex("/api/v1/product.*"),
				regex("/api/v1/baseball.*")
		);
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Training Service")
				.description("API&DataFormat Training API")
				.version("1.0.0")
				.build();
	}

}
