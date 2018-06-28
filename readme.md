# SimpleConfig

[![Version](https://img.shields.io/badge/SimpleConfig-0.0-blue.svg)](https://github.com/hekonsek/simpleconfig/releases)
[![Build](https://api.travis-ci.org/hekonsek/simpleconfig.svg)](https://travis-ci.org/hekonsek/simpleconfig)
[![Coverage](https://sonarcloud.io/api/badges/measure?key=com.github.hekonsek%3Asimpleconfig&metric=coverage)](https://sonarcloud.io/component_measures?id=com.github.hekonsek%3Asimpleconfig&metric=coverage)

SimpleConfig provides opinionated configuration of [Apache Commons Configuration](https://commons.apache.org/proper/commons-configuration/) project.

## Installation

In order to start using SimpleConfig add the following dependency to your Maven project:

    <dependency>
      <groupId>com.github.hekonsek</groupId>
      <artifactId>simpleconfig</artifactId>
      <version>0.0</version>
    </dependency>

## Usage

`SimpleConfig` provides pre-defined instance of Apache Commons Configuration class:

    import org.apache.commons.configuration2.Configuration;
    import static com.github.hekonsek.simpleconfig.SimpleConfig.simple;
    ...
    Configuration commonsConfig = simple().config();

This predefined instance is a composite configuration resolving configuration values in the following order:
- Java system properties
- OS environment variables

The usual way to use SimpleConfig is to invoke `simple().config()` method chain and then execute appropriate
Apache Commons `Configuration` method. For example to read configuration entry, use the following code:

    import static com.github.hekonsek.simpleconfig.SimpleConfig.simple;
    ...
    String value = simple().config().getString("SUPER_API_URL");


## License

This project is distributed under Apache 2.0 license.