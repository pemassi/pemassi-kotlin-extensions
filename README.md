# Pemassi Kotlin Extensions
[![Release](https://jitpack.io/v/pemassi/pemassi-kotlin-extensions.svg)](https://jitpack.io/#pemassi/pemassi-kotlin-extensions)
![Gradle CI](https://github.com/pemassi/pemassi-kotlin-extensions/actions/workflows/gradle-ci.yml/badge.svg)

Useful Kotlin Extension Set

## Example
See the [Wiki](https://github.com/pemassi/pemassi-kotlin-extensions/wiki)

## Setup
Add the JitPack repository in your build.gradle (top level module):
```gradle
allprojects {
    repositories {
        jcenter()
        maven { url "https://jitpack.io" }
    }
}
```

And add next dependencies in the build.gradle of the module:
```gradle
dependencies {
    implementation 'com.github.pemassi:pemassi-kotlin-extensions:{version}'
}
```
