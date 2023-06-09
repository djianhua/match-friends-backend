package com.hua.matchfriends.service;

import com.hua.matchfriends.mapper.UserMapper;
import com.hua.matchfriends.model.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@SpringBootTest
public class InsertUsersTest {


    @Resource
    private UserService userService;

    private ExecutorService executorService = new ThreadPoolExecutor(40, 1000, 10000, TimeUnit.MINUTES, new ArrayBlockingQueue<>(10000));



    /**
     * 批量插入
     */
    @Test
    public void doInsertUsers() {
        StopWatch stopWatch = new StopWatch(); // 用来监听执行时间
        stopWatch.start();
        final int INSERT_NUM = 100000;
        ArrayList<User> userList = new ArrayList<>();
        for (int i = 0; i < INSERT_NUM; i++) {
            User user = new User();
            user.setUsername("hua");
            user.setUserAccount("119110");
            user.setAvatarUrl("https://pic4.zhimg.com/80/v2-84a1a7ba4d10a42b25d79d9da051f4db_720w.webp");
            user.setGender(0);
            user.setUserPassword("12345678");
            user.setPhone("110");
            user.setEmail("110@hua.com");
            user.setUserStatus(0);
            user.setUserRole(0);
            user.setPlanetCode("11111");
            user.setTags("[]");
            userList.add(user);
        }
        userService.saveBatch(userList, 100000);
        stopWatch.stop();
        System.out.println("花费时间：" + stopWatch.getTotalTimeMillis());
    }

    /**
     * 并发批量插入用户
     */
    @Test
    public void doConcurrencyInsertUsers() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        // 分十组
        int batchSize = 5000;
        int j = 0;
        List<CompletableFuture<Void>> futureList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            List<User> userList = new ArrayList<>();
            while (true) {
                j++;
                User user = new User();
                user.setUsername("假鱼皮");
                user.setUserAccount("fakeyupi");
                user.setAvatarUrl("https://636f-codenav-8grj8px727565176-1256524210.tcb.qcloud.la/img/logo.png");
                user.setGender(0);
                user.setUserPassword("12345678");
                user.setPhone("123");
                user.setEmail("123@qq.com");
                user.setTags("[]");
                user.setUserStatus(0);
                user.setUserRole(0);
                user.setPlanetCode("11111111");
                userList.add(user);
                if (j % batchSize == 0) {
                    break;
                }
            }
            // 异步执行
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                System.out.println("threadName: " + Thread.currentThread().getName());
                userService.saveBatch(userList, batchSize);
            }, executorService);
            futureList.add(future);
        }
        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[]{})).join();
        // 20 秒 10 万条
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
    }
}
