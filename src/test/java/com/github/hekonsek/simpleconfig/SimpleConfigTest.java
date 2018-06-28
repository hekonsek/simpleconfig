package com.github.hekonsek.simpleconfig;

import org.junit.Test;

import static com.github.hekonsek.simpleconfig.SimpleConfig.simple;
import static org.assertj.core.api.Assertions.assertThat;

public class SimpleConfigTest {

    // Absent properties

    @Test
    public void shouldUseDefaultValueForAbsentProperty() {
        String value = simple().config().getString("NO_SUCH_PROPERTY", "default");
        assertThat(value).isEqualTo("default");
    }

    @Test
    public void shouldReturnNullForAbsentProperty() {
        String value = simple().config().getString("NO_SUCH_PROPERTY");
        assertThat(value).isNull();
    }

    // In-memory properties

    @Test
    public void shouldReadInMemoryProperty() {
        simple().reset().property("foo", "bar");
        String value = simple().config().getString("foo");
        assertThat(value).isEqualTo("bar");
    }

    @Test
    public void shouldResetInMemoryProperties() {
        simple().property("foo", "bar").reset();
        String value = simple().config().getString("foo");
        assertThat(value).isNull();
    }

    // Env properties

    @Test
    public void shouldResolveEnvProperty() {
        String pathValue = simple().config().getString("PATH");
        assertThat(pathValue).isNotBlank();
    }

}