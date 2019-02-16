# SimpleSponge

[![Downloads](http://cf.way2muchnoise.eu/full_simple-sponge_downloads.svg)](https://minecraft.curseforge.com/projects/simple-sponge) [![MCVersion](http://cf.way2muchnoise.eu/versions/simple-sponge.svg)](https://minecraft.curseforge.com/projects/simple-sponge)

[![GitHub issues](https://img.shields.io/github/issues/JackyyTV/SimpleSponge.svg)](https://github.com/JackyyTV/SimpleSponge/issues) [![GitHub pull requests](https://img.shields.io/github/issues-pr/JackyyTV/SimpleSponge.svg)](https://github.com/JackyyTV/SimpleSponge/pulls) [![license](https://img.shields.io/github/license/JackyyTV/SimpleSponge.svg)](../dev-1.12/LICENSE)

[![Logo](https://i.gyazo.com/c21d28bc15d3fa76bc753f0a93942b71.png)](https://minecraft.curseforge.com/projects/simple-sponge)

---

## About

This is the GitHub repo for the Simple Sponge Minecraft mod, where the source code and issue tracker are in here.

Submit any bug reports / suggestions via [issue tracker](https://github.com/JackyyTV/SimpleSponge/issues).

[Pull requests](https://github.com/JackyyTV/SimpleSponge/pulls) are welcome if you would like to add features / help with bug fixes or translations.

---

## Contact Me

- Twitter - [@JackyyTV](https://twitter.com/JackyyTV)
- Discord - Jacky#1234
- Twitch - [Jackyy](https://www.twitch.tv/jackyy)
- Reddit - [JackyyTV](https://www.reddit.com/message/compose/?to=JackyyTV)

---

## Setting up workspace / compile the mod yourself

If you would like to set up the workspace yourself to submit PRs of features additions or bug fixes, or compile the mod, here's how you do it.

1. Clone the mod.
    - HTTPS: `git clone https://github.com/JackyyTV/SimpleSponge.git`
    - SSH: `git clone git@github.com:JackyyTV/SimpleSponge.git`
    - Or, use the GitHub desktop app to clone the repo via GUI interface.

2. Setting up the workspace, depending on what you need.
    - Decompiled source: `gradlew setupDecompWorkspace`
    - Obfuscated source: `gradlew setupDevWorkspace`
    - CI server: `gradlew setupCIWorkspace`
    
3. Either use `gradlew build` to build the jar file (Output is in `build/libs`), or setup the IDE if you are going to modify any codes. Both IntelliJ IDEA and Eclipse are included below since they're more popular IDEs.
    - IntelliJ IDEA: Do `gradlew idea`, open the `.ipr` file and import the gradle file, then execute the `genIntellijRuns` task in the "Gradle" tab.
    - Eclipse: Do `gradlew eclipse` and open the directory as project.

