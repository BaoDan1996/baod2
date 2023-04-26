package com.example.demo.service;

import com.example.demo.bean.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author: baodan
 * @date: 2023/4/26
 * @version: 1.1.0
 **/
@RestController
@RequestMapping(value = "/users")   // 通过这里配置使下面的映射都在/users下
public class UserController {

    // 创建线程安全的Map
    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    /**
     * 查询user列表
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUserList() {
        // 处理"/users/"的GET请求，用来获取用户列表
        // 还可以通过@RequestParam从⻚面中传递参数来进行查询条件或者翻⻚信息的传递
        List<User> user = new ArrayList<>(users.values());
        return user;
    }

    /**
     * 创建user
     * @param user
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postUser(@ModelAttribute User user){
        // 处理"/users/"的POST请求，用来创建User
        // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从⻚面中传递参数
        users.put(user.getId(), user);
        return "success";
    }

    /**
     * 通过id返回指定的user
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id){
        // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
        // url中的id可通过@PathVariable绑定到函数的参数中
        return users.get(id);
    }

    /**
     * 更新指定user的属性值
     * @param id
     * @param user
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable Long id,@ModelAttribute User user){
        // 处理"/users/{id}"的PUT请求，用来更新User信息
        User user1 = users.get(id);
        user1.setName(user.getName());
        user1.setAge(user.getAge());
        users.put(id,user1);
        return "success";
    }

    /**
     * 删除指定user
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id){
        // 处理"/users/{id}"的DELETE请求，用来删除User
        users.remove(id);
        return "success";
    }

}
