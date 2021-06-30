# linguin-ai-java
Java 11 API Wrapper for https://linguin.ai
 
[![Build Status](https://travis-ci.com/imagineobjects/linguin-ai-java.svg?branch=master)](https://travis-ci.com/imagineobjects/linguin-ai-java)
[![Coverage Status](https://coveralls.io/repos/github/imagineobjects/linguin-ai-java/badge.svg?branch=master)](https://coveralls.io/github/imagineobjects/linguin-ai-java?branch=master)

[![Managed By Self XDSD](https://self-xdsd.com/b/mbself.svg)](https://self-xdsd.com/p/imagineobjects/linguin-ai-java?provider=github) 
[![DevOps By Rultor.com](http://www.rultor.com/b/imagineobjects/linguin-ai-java)](http://www.rultor.com/p/imagineobjects/linguin-ai-java)
[![We recommend IntelliJ IDEA](http://amihaiemil.github.io/images/intellij-idea-recommend.svg)](https://www.jetbrains.com/idea/)

To get the latest release from Maven Central, simply add the following to your ``pom.xml``:

```xml
<dependency>
    <groupId>io.imagineobjects.web</groupId>
    <artifactId>linguin-ai-java</artifactId>
    <version>not-yet-released</version>
</dependency>
```

or download the <a href="https://oss.sonatype.org/service/local/repositories/releases/content/io/imagineobjects/web/linguin-ai-java/0.0.1/linguin-ai-java-0.0.1-jar-with-dependencies.jar">fat</a> jar.

If you use Gradle, add this to your dependencies:

```gradle
implementation group: 'io.imagineobjects.web', name: 'linguin-ai-java', version: 'not-yet-released'
```

The releases are also available on [Github Packages](https://github.com/imagineobjects/linguin-ai-java/packages)!


### Contributing 

If you would like to contribute, just open an issue or a PR.

Make sure the maven build:

``$mvn clean install -Pcheckstyle,itcases``

passes before making a PR. [Checkstyle](http://checkstyle.sourceforge.net/) will make sure
you're following our code style and guidlines.
