package cn.grace;

import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.util.StrUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * 多线程 测试类
 * @Author：陆
 */
public class CompletabFutureTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "2", "3");
        List<String> list1 = Collections.synchronizedList(new ArrayList<>());
        List<CompletableFuture> result = new ArrayList<>();
        for (String key : list) {
            CompletableFuture<Void> stringCompletableFuture = CompletableFuture.completedFuture(list1).thenAcceptAsync(a -> {
                try {
                    System.out.println("开始执行" + key);
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if(StrUtil.equals(key,"2")){
                    throw new RuntimeException();
                }
                a.add(key);
            }).whenComplete((resul1,Exception)->{
                System.out.println("获取异常:"+ExceptionUtil.getMessage(Exception));

               // return resul1;
            });
            result.add(stringCompletableFuture);
        }
        CompletableFuture.allOf(result.toArray(new CompletableFuture[0])).join();
        System.out.println(list1);

    }
}
