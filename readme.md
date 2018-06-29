# SimpleConfig

[![Version](https://img.shields.io/badge/SimpleConfig-0.1-blue.svg)](https://github.com/hekonsek/simpleconfig/releases)
[![Build](https://api.travis-ci.org/hekonsek/simpleconfig.svg)](https://travis-ci.org/hekonsek/simpleconfig)
[![Coverage](https://sonarcloud.io/api/badges/measure?key=com.github.hekonsek%3Asimpleconfig&metric=coverage)](https://sonarcloud.io/component_measures?id=com.github.hekonsek%3Asimpleconfig&metric=coverage)

SimpleConfig provides opinionated configuration of [Apache Commons Configuration](https://commons.apache.org/proper/commons-configuration/) project
providing SpringBoot-like configuration experience.

## Installation

In order to start using SimpleConfig add the following dependency to your Maven project:

    <dependency>
      <groupId>com.github.hekonsek</groupId>
      <artifactId>simpleconfig</artifactId>
      <version>0.1</version>
    </dependency>

## Usage

`SimpleConfig` provides pre-defined instance of Apache Commons Configuration class:

    import org.apache.commons.configuration2.Configuration;
    import static com.github.hekonsek.simpleconfig.SimpleConfig.simple;
    ...
    Configuration commonsConfig = simple().config();

The usual way to use SimpleConfig is to invoke `simple().config()` method chain and then execute appropriate
Apache Commons `Configuration` method. For example to read configuration entry, use the following code:

    import static com.github.hekonsek.simpleconfig.SimpleConfig.simple;
    ...
    String myApiUrl = simple().config().getString("myapi.url");

### Data sources

This predefined configuration instance is a composite configuration resolving configuration values in the following order:
- Java system properties
- OS environment variables

When key in format `foo.bar` cannot be resolved, SimpleConfig tries to resolve `FOO_BAR` property. This approach is
useful when trying to resolve properties which have been set using environment variables.
For example configuration value set as `MYAPI_URL=http://myapi.com java -jar app.jar` can be resolved from application
using `myapi.url` key.

## License

This project is distributed under Apache 2.0 license.