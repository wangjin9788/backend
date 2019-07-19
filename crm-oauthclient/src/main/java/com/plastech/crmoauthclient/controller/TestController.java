package com.plastech.crmoauthclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.plastech.crmoauthclient.model.User;

/**
 *
 *
 * @author : yemin
 * @date : 2019年1月7日 下午1:19:10
 *
 */
@RestController
@RequestMapping("/user-management")
public class TestController {


  @GetMapping("/userinfo")
  public User demo(@RequestParam(value = "name") final String name) {
    return new User(name, 10, "this is a student");
  }
}
