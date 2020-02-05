package com.caguilera.rockpaperscissors.util;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.AliasFor;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public @interface WebIntegrationTest {
    /**
     * The configuration classes to use. Alias for {@link SpringBootTest#classes()}.
     */
    @AliasFor(annotation = SpringBootTest.class, attribute = "classes")
    Class<?>[] config() default {WebIntegrationTestConfig.class};
}