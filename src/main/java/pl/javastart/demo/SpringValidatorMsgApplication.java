package pl.javastart.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import pl.javastart.demo.model.NumberBean;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@SpringBootApplication
public class SpringValidatorMsgApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = SpringApplication.run(SpringValidatorMsgApplication.class, args);
        Validator validator = ctx.getBean(Validator.class);
        NumberBean numberBean = new NumberBean(2);
        Set<ConstraintViolation<NumberBean>> constraintViolations = validator.validate(numberBean);
        constraintViolations.forEach(numberBeanConstraintViolation ->
                System.out.println(numberBeanConstraintViolation.getMessage()));
    }


    @Bean
    public Validator validator(){
        return new LocalValidatorFactoryBean();
    }
}
