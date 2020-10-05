package com.gaseousmammel.service;

import com.cerner.beadledom.resteasy.ResteasyContextListener;
import com.google.common.collect.Lists;
import com.google.inject.Module;
import java.util.List;
import javax.servlet.ServletContext;

public class ApiExampleContextListener extends ResteasyContextListener {
  @Override
  protected List<? extends Module> getModules(ServletContext context) {
    return Lists.newArrayList(new ApiExampleModule(), new ResteasyBootstrapModule());
  }
}
