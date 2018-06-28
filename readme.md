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

    import static com.github.hekonsek.simpleconfig.SimpleConfig.simple;
    ...
    String value = simple().config().getString("SUPER_API_URL");


## License

This project is distributed under Apache 2.0 license.