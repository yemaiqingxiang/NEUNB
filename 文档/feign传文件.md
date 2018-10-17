
## feign上传文件  
#### 服务提供方（接收文件）
服务提供方的实现比较简单，就按Spring MVC的正常实现方式即可
#### 服务消费方（发送文件）
在服务消费方由于会使用Feign客户端，所以在这里需要在引入feign对表单提交的依赖，具体如下：
```xml 
<dependency>
   <groupId>io.github.openfeign.form</groupId>
   <artifactId>feign-form</artifactId>
   <version>3.0.3</version>
</dependency>
<dependency>
   <groupId>io.github.openfeign.form</groupId>
   <artifactId>feign-form-spring</artifactId>
   <version>3.0.3</version>
</dependency>
<dependency>
   <groupId>commons-fileupload</groupId>
   <artifactId>commons-fileupload</artifactId>
   <version>1.3.3</version>
</dependency>
```
> 定义文件上传方的应用主类和FeignClient，假设服务提供方的服务名为eureka-feign-upload-server
```java
package com.didispace.api.consumer;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "eureka-feign-upload-server", configuration = UploadService.MultipartSupportConfig.class)
public interface UploadService {

    @PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String handleFileUpload(@RequestPart(value = "file") MultipartFile file);

    @Configuration
    class MultipartSupportConfig {
        @Bean
        public Encoder feignFormEncoder() {
            return new SpringFormEncoder();
        }
    }

}
```
