package com.github.hekonsek.simpleconfig;

import org.junit.Test;

import static com.github.hekonsek.simpleconfig.SimpleConfig.simple;
import static org.assertj.core.api.Assertions.assertThat;

public class SimpleConfigTest {

    @Test
    public void shouldResolveEnvProperty() {
        String pathValue = simple().config().getString("PATH");
        assertThat(pathValue).isNotBlank();
    }

    @Test
    public void shouldUseDefaultValueForAbsentEnv() {
        String value = simple().config().getString("NO_SUCH_ENV", "default");
        assertThat(value).isEqualTo("default");
    }

}
