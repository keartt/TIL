공식문서 따라해봤으나 안되서, 삽질하다가 성공한 내용 정리
##### version
>  EgovFrame 3.7 (Spring 4.2.4)
>  Java 8 (OpenJDK 1.8)

#### swagger 2.9.2 버전 추가(maven)
버전 충돌 오류 해결을 위해 guava 버전 직접 명시 후 추가

```xml title:'pom.xml'
<dependency>  
    <groupId>io.springfox</groupId>  
    <artifactId>springfox-swagger2</artifactId>  
    <version>2.9.2</version>  
</dependency>  
<dependency>  
    <groupId>io.springfox</groupId>  
    <artifactId>springfox-swagger-ui</artifactId>  
    <version>2.9.2</version>  
</dependency>  
<dependency>  
    <groupId>com.google.guava</groupId>  
    <artifactId>guava</artifactId>  
    <version>20.0</version>  
</dependency>
```

guava 버전 명시 안할경우 아래 오류 발생할 수 있음
```bash 
NoSuchMethodError: com.google.common.collect.FluentIterable.toList()
com.google.common.collect.FluentIterable.toList()Lcom/google/common/collect/ImmutableList
```


#### add servlet-mapping in web.xml
.do 를 사용하고 있기 때문에 `web.xml` 파일에 아래 action 밑에 url 매핑 추가
```xml title:'web.xml'
	<servlet-mapping>
		<servlet-name>action</servlet-name>
		<url-pattern>*.do</url-pattern>
		<!--아래 내용 추가-->
		<url-pattern>/swagger-resources/configuration/ui</url-pattern>
		<url-pattern>/swagger-resources/configuration/security</url-pattern>
		<url-pattern>/swagger-resources</url-pattern>
		<url-pattern>/v2/api-docs</url-pattern>
	</servlet-mapping>
```


#### SwaggerConfig.java 생성
egovframework.example.cmmn.config -> [공식문서](https://www.egovframe.go.kr/wiki/doku.php?id=egovframework:hyb3.10:guide:swaggerui) 따라서 config 패키지 만들고 안에 생성
```java title:swaggerConfig'
@EnableSwagger2  
@EnableWebMvc  
public class SwaggerConfig {  
  
    @Bean  
    public Docket api(){  
        return new Docket(DocumentationType.SWAGGER_2)  
                .select()  
                // 프로젝트에 맞게 설정
                .apis(RequestHandlerSelectors.basePackage("project"))  
                .paths(PathSelectors.any())  
                // .paths(PathSelectors.regex("(?!/error.*).*"))  
                .build()  
                .pathMapping("/")  
                .useDefaultResponseMessages(false)  
                .apiInfo(apiInfo());  
    }  
  
    private ApiInfo apiInfo() {  
        return new ApiInfoBuilder()  
                .title("제목")  
                .description("설명")  
                .version("1.0.0")  
                .build();  
    }  
  
    @Bean  
    public UiConfiguration uiconfig() {  
        return UiConfigurationBuilder  
                .builder().operationsSorter(OperationsSorter.ALPHA)  
                .build();  
    }  
}
```

#### dispatcher-servlet 에 SwaggerConfig 빈 추가
이때 `class=` 에는 방금 만든 SwaggerConfig 클래스의 경로가 들어가야 함
```xml title:'dispatcher-servlet.xml'
	<bean name="applicationSwaggerConfig" class="egovframework.example.cmmn.config.SwaggerConfig"/>  
	<mvc:resources mapping="/swagger-ui.html" location="classpath:/META-INF/resources/"/>  
	<mvc:resources mapping="/webjars/**" location="classpath:/META-INF/resources/webjars/"/>
```


접속하기 + `/swagger-ui.html`
ex) http://localhost:8080/swagger-ui.html/

```

> 참고 & 출처

전자정부 [공식문서](https://www.egovframe.go.kr/wiki/doku.php?id=egovframework:hyb3.10:guide:swaggerui)
참고블로그[스프링레거시-스웨거](https://velog.io/@dailylifecoding/apply-swagger2-on-spring-legacy-project)