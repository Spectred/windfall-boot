## windfall-boot-creep

Spring Boot Web，支持Spring MVC



### 1. 处理HTTP请求

```java
@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping(value = "/getUser")
    public User getUser() {
        return User.builder().name("java").age(24).gender(true).build();
    }
}

```

### 2. HttpMessageConverters

```java
@Configuration(proxyBeanMethods = false)
public class FastJsonHttpMessageConvertersConfig {
    
    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters(@Qualifier("fastJsonConfig") FastJsonConfig fastJsonConfig) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        converter.setFastJsonConfig(fastJsonConfig);
        return new HttpMessageConverters(converter);
    }

    @Bean
    public FastJsonConfig fastJsonConfig() {
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        return fastJsonConfig;
    }
}

```

### 3. 自定义JSON序列化器和反序列化器

```java
/**
 * Json 序列化器配置
 * [未实现]
 * 参考 <a>https://javadeveloperzone.com/spring-boot/spring-boot-custom-json-serialize-deserialize-example/</a>
 *
 * @author SWD
 */
@JsonComponent
public class JsonSerializerConfig {

}
```

### 4. MessageCodesResolver

用于从绑定的errors产生用来渲染错误信息的错误码

```java
    @PostMapping(value = "/postUser")
    public User postUser(@Valid @RequestBody User user) {
        return user;
    }
    // ---
     @Email
    private String name;
```

```yml
spring:
  mvc:
    message-codes-resolver-format: postfix_error_code  # prefix_error_code
```

```http
POST http://localhost:8080/creep/demo/postUser
Content-Type: application/json

{
  "name": "java",
  "age": 10,
  "gender": false
}
```

```
Result 
prefix_error_code: 提示为Email.user.name
postfix_error_code: 提示为user.name.Email
```

### 5. 静态内容

暂时忽略

### 6. 欢迎页面&自定义图标

暂时忽略

### 7. 模板引擎

暂时忽略

### 8. ConfigurableWebBindingInitializer

暂时忽略

### 9. 统一异常处理

#### 9.1 声明异常

```java
@Data
@AllArgsConstructor
public class BusinessException extends RuntimeException {

    /**
     * 错误码
     */
    private String errorCode;

    /**
     * 错误信息
     */
    private String errorMsg;
}

```

#### 9.2 构建通用响应实体

```java
@Data
public class CommonResult<T> {

    @JSONField(ordinal = 0)
    private String status;
    @JSONField(ordinal = 1)
    private String errorCode;
    @JSONField(ordinal = 2)
    private String errorMsg;
    @JSONField(ordinal = 3)
    private T resultBody;


    public static <T> CommonResult<T> errorResult(String errorCode, String errorMsg) {
        CommonResult<T> errorResult = new CommonResult<>();
        errorResult.setStatus("-1");
        errorResult.setErrorCode(errorCode);
        errorResult.setErrorMsg(errorMsg);
        return errorResult;
    }
}
```

#### 9.3 全局异常处理器

```java
/**
 * 全局异常处理器
 *
 * @author SWD
 */
@RestControllerAdvice(basePackages = {"com.spectred.creep.controller"})
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public CommonResult<Void> handleBusinessException(BusinessException be) {
        return CommonResult.errorResult(be.getErrorCode(), be.getErrorMsg());
    }

}
```

#### 9.4 使用

```java
@GetMapping(value = "/testTempException")
public User testTempException() {
    if (true) {
        throw new TempException("200", "testTempExceptionMsg");
    }
    return null;
}
---
调用结果:
{
  "status": "-1",
  "errorCode": "100",
  "errorMsg": "testExceptionMsg",
  "resultBody": null
}
```

### 10. 统一返回值处理

#### 10.1 配置

```java
@RestControllerAdvice("com.spectred.creep.controller")
public class CommonResultResponseAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof CommonResponse) {
            return body;
        }
        return new CommonResponse<>(body);
    }
}

```

#### 10.2 使用

```java
   @GetMapping(value = "/getUserList")
    public List<User> getUserList() {
        return List.of(User.builder().name("Java").age(24).gender(false).build(),
                User.builder().name("Lisa").age(19).gender(true).build());
    }

--- 
  调用返回:
{
  "status": "1",
  "errorCode": null,
  "errorMsg": null,
  "resultBody": [
    {
      "age": 24,
      "gender": false,
      "name": "Java"
    },
    {
      "age": 19,
      "gender": true,
      "name": "Lisa"
    }
  ]
}
```

### 11. 全局配置CORS跨域支持

```java
@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        // 允许跨域访问资源定义： /creep/** 所有资源
        corsRegistry.addMapping("/creep/**")
                // 只允许本地的9000端口访问
                .allowedOrigins("http://localhost:8080", "http://127.0.0.1:8080")
                // 允许发送Cookie
                .allowCredentials(true)
                // 允许所有方法
                .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD");

    }
}
```