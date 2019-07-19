package com.plastech.crm.controller;

import org.junit.Before;
import org.junit.Ignore;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.plastech.crm.resultdata.ResultJson;
import com.plastech.crm.service.impl.UserServiceImpl;
import junit.framework.TestCase;

/**
 * @author wangJin
 *
 * @date 2019年1月15日 上午9:46:58
 *
 */
@Ignore
public class BaseTest extends TestCase {
  protected static Logger logger;
  protected MockMvc mockMvc;

  @SuppressWarnings("rawtypes")
  protected ResultJson resultJson;

  @Autowired
  protected WebApplicationContext wac;

  @Mock
  UserServiceImpl userService;


  @Override
  @Before()
  public void setUp() {
    logger = LoggerFactory.getLogger(BaseTest.class);
    mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    MockitoAnnotations.initMocks(this);
  }


}
