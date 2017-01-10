[![Codacy Badge](https://api.codacy.com/project/badge/Grade/bc68db066ccb47828d27331db8eed3e6)](https://www.codacy.com/app/jacek-spolnik/JAlgoArena-Auth?utm_source=github.com&utm_medium=referral&utm_content=spolnik/JAlgoArena-Auth&utm_campaign=badger)
# JAlgoArena Auth [![Build Status](https://travis-ci.org/spolnik/JAlgoArena-Auth.svg?branch=master)](https://travis-ci.org/spolnik/JAlgoArena-Auth) [![codecov](https://codecov.io/gh/spolnik/JAlgoArena-Auth/branch/master/graph/badge.svg)](https://codecov.io/gh/spolnik/JAlgoArena-Auth) [![GitHub release](https://img.shields.io/github/release/spolnik/jalgoarena-auth.svg)]()

JAlgoArena Auth is core service dedicated for authentication and authorization of the JAlgoArena users. It's keeping all data in Xodus DB, and for authorization it's using JWT tokens which are verified on the requests. Initial creation of accounts happens through AJAX requests.

- [Introduction](#introduction)
- [Components](#components)
- [Continuous Delivery](#continuous-delivery)
- [Infrastructure](#infrastructure)
- [Running Locally] (#running-locally)
- [Notes](#notes)

## Introduction

- JAlgoArena Auth allows for creation of account, login in using username and password, authenticating using previously received token or just taking information about users of JAlgoArena.
- Submissions service talks directly with Auth service to make sure users are authenticated and they have required roles

![Component Diagram](https://github.com/spolnik/JAlgoArena/raw/master/design/component_diagram.png)

## Components

- [JAlgoArena](https://github.com/spolnik/JAlgoArena)
- [JAlgoArena UI](https://github.com/spolnik/JAlgoArena-UI)
- [JAlgoArena Submissions (and Ranking)](https://github.com/spolnik/JAlgoArena-Submissions)
- [JAlgoArena Eureka Server](https://github.com/spolnik/JAlgoArena-Eureka)
- [JAlgoArena API Gateway](https://github.com/spolnik/JAlgoArena-API)

## Continuous Delivery

- initially, developer push his changes to GitHub
- in next stage, GitHub notifies Travis CI about changes
- Travis CI runs whole continuous integration flow, running compilation, tests and generating reports
- coverage report is sent to Codecov
- application is deployed into Heroku machine

## Infrastructure

- Heroku (PaaS)
- Xodus (embedded highly scalable database) - http://jetbrains.github.io/xodus/
- Spring Boot, Spring Cloud (Eureka Client)
- TravisCI - https://travis-ci.org/spolnik/JAlgoArena-Auth

## Running locally

There are two ways to run it - from sources or from binaries.
- Default port: `9999`

### Running from binaries
- go to [releases page](https://github.com/spolnik/JAlgoArena-Auth/releases) and download last app package (JAlgoArena-Auth-[version_number].zip)
- after unpacking it, go to folder and run `./run.sh` (to make it runnable, invoke command `chmod +x run.sh`)
- you can modify port and Eureka service url in run.sh script, depending on your infrastructure settings. The script itself can be found in here: [run.sh](run.sh)

### Running from sources
- run `git clone https://github.com/spolnik/JAlgoArena-Auth` to clone locally the sources
- now, you can build project with command `./gradlew clean bootRepackage` which will create runnable jar package with app sources. Next, run `java -Dserver.port=9999 -jar build\libs\jalgoarena-auth-*.jar` which will start application
- there is second way to run app with gradle. Instead of running above, you can just run `./gradlew clean bootRun`

## Notes
- [Travis Builds](https://travis-ci.org/spolnik)

![Component Diagram](https://github.com/spolnik/JAlgoArena/raw/master/design/JAlgoArena_Logo.png)
