package cn.grace;

import cn.grace.dto.StudentDTO;
import cn.grace.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * SpringBoot 的单元测试
 * 该测试类是创建项目时自动生成的
 */
@SpringBootTest
class GraceSpringbootDemo2ApplicationTests {


    @Autowired
    ApplicationContext ioc;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate<Object, Object>  objRedisTemplate;


    public void testMethod(){

    }

    /**
     * 测试使用 StringRedisTemplate
     * 操作 Redis（String类型数据）
     */
    @Test
    public void testStringRedisTemplate(){
        // 使用 stringRedisTemplate 操作字符串类型的数据
        stringRedisTemplate.opsForValue().append("bbb","a");
        stringRedisTemplate.opsForList().leftPush("list","a");
        //读取数据
        String str = stringRedisTemplate.opsForValue().get("bbb");
        System.out.println(str);
    }

    /**
     * 测试使用 RedisTemplate
     * 操作 Redis（Object类型数据）
     */
    @Test
    public void testRedisTemplate(){
        StudentDTO studentDTO = studentMapper.getStudentById(1);
        //使用 redisTemplate 直接操作对象类型的数据（使用的 JDK 序列化机制，会乱码）
        //redisTemplate.opsForValue().set("student-01", studentDTO);
        //objRedisTemplate.opsForValue().set("student-01", studentDTO);
    }

    /**
     * 测试日志
     * SpringBoot 默认只打印 info及以上级别的日志
     */
    Logger logger = LoggerFactory.getLogger(getClass());//注意导包的时候别导错了
    @Test
    public void testLogger(){
        logger.trace("这是 trace 日志");
        logger.debug("这是 debug 日志");
        logger.info("这是 info 日志");
        logger.warn("这是 warn 日志");
        logger.error("这是 error 日志");
    }



}
