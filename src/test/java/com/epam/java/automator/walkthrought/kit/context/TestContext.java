package com.epam.java.automator.walkthrought.kit.context;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TestContext {

  private static TestContext instance;

  private ThreadLocal<Map<String, Object>> map = ThreadLocal.withInitial(HashMap::new);

  public <T> T getTestObject(String key) {
    return (T) map.get().get(key);
  }

  public void setTestObject(String key, Object object) {
    map.get().put(key, object);
  }

  public static TestContext getInstance() {
    if (Objects.isNull(instance)) {
      instance = new TestContext();
    }
    return instance;
  }
}
