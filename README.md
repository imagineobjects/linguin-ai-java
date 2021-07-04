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

### Usage

For a given text, the library returns an instance of ``Languages``, representing the possible languages of the given text. Each ``Language`` has a 
``code`` and a ``confidence``. Call ``.bestMatch()`` to get the most probable ``Language``.

### Single detection

To detect the Language of a single text:

```java
final LinguinAi linguin = new RestLinguinAi("API-TOKEN-HERE");
final Languages detected = linguin.detect("What language is this?");
System.out.println("Possible languages: ")
for(final Language language : detected) {
    System.out.println("Code: " + language.code());
    System.out.println("Confidence: " + language.confidence());
}
System.out.println("Most probable language: " + detected.bestMatch().code());
```

### Bulk Detection

You can detect the possible ``Languages`` of multpile texts at the same time. It will return an instance of 
``BulkDetection`` which is an iterable of ``Languages``. Each ``Languages`` in the iterable represents the possible languages
of the text given at the same index.

```java
final LinguinAi linguinAi = new RestLinguinAi("API-TOKEN-HERE");
final BulkDetection bulk = linguinAi.bulkDetect(
    "What's up??",
    "Woher kommst du?",
    "Eu vin din Romania.",
    "La langue Francaise..."
);
final Iterator<Languages> languages = bulk.iterator();
languages.next().bestMatch().code(); // "en"
languages.next().bestMatch().code(); // "de"
languages.next().bestMatch().code(); // "ro"
languages.next().bestMatch().code(); // "fr"
```

### Account Status

You can fetch the account Status, containing info about the API limits of your account:

```java
final LinguinAi linguinAi = new RestLinguinAi("API-TOKEN-HERE");
final Status status = linguinAi.status();
status.dailyLimit(); //100
status.detectionsToday(); //5
status.remainingToday(); //95
```

### Supported Languages

You can get all the supported languages of the API like this:

```java
final LinguinAi linguinAi = new RestLinguinAi("API-TOKEN-HERE");
final SupportedLanguages supported = linguiAi.languages();
for(final SupportedLanguage language : supported) {
    System.out.println("Code: " + language.code());
    System.out.println("English names: " + Arrays.toString(language.englishNames()));
    System.out.println("Native names: " + Arrays.toString(language.nativeNames()));
}
```

### Exceptions

At the moment the library will throw ``IllegalStateException`` if the API responds with any
status code other than ``200 OK``.

### Contributing 

If you would like to contribute, just open an issue or a PR.

Make sure the maven build:

``$mvn clean install -Pcheckstyle,itcases -Dlinguin-ai-token=<YOUR_API_TOKEN>``

passes before making a PR. [Checkstyle](http://checkstyle.sourceforge.net/) will make sure
you're following our code style and guidlines.
