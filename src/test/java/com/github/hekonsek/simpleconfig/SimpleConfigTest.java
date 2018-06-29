package com.github.hekonsek.simpleconfig;

import org.junit.Test;

import java.util.NoSuchElementException;

import static com.github.hekonsek.simpleconfig.SimpleConfig.simple;
import static org.assertj.core.api.Assertions.assertThat;

public class SimpleConfigTest {

    // Absent properties

    @Test
    public void shouldUseDefaultValueForAbsentProperty() {
        String value = simple().config().getString("NO_SUCH_PROPERTY", "default");
        assertThat(value).isEqualTo("default");
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldReturnNullForAbsentProperty() {
        simple().config().getString("NO_SUCH_PROPERTY");
    }

    // In-memory properties

    @Test
    public void shouldReadInMemoryProperty() {
        simple().clearProperty("foo");
        simple().config().addProperty("foo", "bar");
        String value = simple().config().getString("foo");
        assertThat(value).isEqualTo("bar");
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldResetInMemoryProperties() {
        simple().config().addProperty("foo", "bar");
        simple().clearProperty("foo");
        simple().config().getString("foo");
    }

    // Env properties

    @Test
    public void shouldResolveEnvProperty() {
        String pathValue = simple().config().getString("PATH");
        assertThat(pathValue).isNotBlank().isNotNull();
    }

    // Flexible properties

    @Test
    public void shouldResolveEnvPropertyWithLowerCase() {
        String pathValue = simple().config().getString("path");
        assertThat(pathValue).isNotBlank().isNotNull();
    }

    @Test
    public void shouldResolveEnvPropertyWithUnderscore() {
        simple().config().addProperty("FOO_BAR", "baz");
        String pathValue = simple().config().getString("foo.bar");
        assertThat(pathValue).isNotBlank().isNotNull();
    }


}