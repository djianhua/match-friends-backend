//package com.hua.matchfriends.once;
//import java.util.Date;
//
//import com.hua.matchfriends.mapper.UserMapper;
//import com.hua.matchfriends.model.domain.User;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StopWatch;
//
//import javax.annotation.Resource;
//
//@Component
//public class InsertUsers {
//
//    @Resource
//    private UserMapper userMapper;
//
//    /**
//     * 批量插入
//     */
//    @Scheduled(fixedDelay = 5000, fixedRate = Long.MAX_VALUE)
//    public void doInsertUsers() {
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start();
//        final int INSERT_NUM = 10000;
//        for (int i = 0; i < INSERT_NUM; i++) {
//            User user = new User();
//            user.setUsername("hua");
//            user.setUserAccount("119110");
//            user.setAvatarUrl("https://pic4.zhimg.com/80/v2-84a1a7ba4d10a42b25d79d9da051f4db_720w.webp");
//            user.setGender(0);
//            user.setUserPassword("12345678");
//            user.setPhone("110");
//            user.setEmail("110@hua.com");
//            user.setUserStatus(0);
//            user.setUserRole(0);
//            user.setPlanetCode("11111");
//            user.setTags("[]");
//            userMapper.insert(user);
//        }
//        stopWatch.stop();
//        System.out.println("花费时间：" + stopWatch.getTotalTimeMillis());
//    }
//}
