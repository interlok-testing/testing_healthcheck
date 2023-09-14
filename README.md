# Interlok Health-Check and Cluster Testing

[![license](https://img.shields.io/github/license/interlok-testing/testing_healthcheck.svg)](https://github.com/interlok-testing/testing_healthcheck/blob/develop/LICENSE)
[![Actions Status](https://github.com/interlok-testing/testing_healthcheck/actions/workflows/gradle-build.yml/badge.svg)](https://github.com/interlok-testing/testing_healthcheck/actions/workflows/gradle-build.yml)

Project tests;
 - interlok-rest-cluster
 - interlok-rest-health-check

## What it does

The configuration will fire two http requests, one of which will fire every 30 seconds the other every 5 seconds.  Each http request will trigger another channel in the workflow, the first channel configured to always fail processing thereby returning a http server error response, the second always returning a 200 OK response.

The message processing is actually not the focus of this testing piece; instead the message processing provides simply provides Interlok noise to show the instance is running.

The actual focus here is to demonstrate how you or your container management can use Interlok restful services to compliment their own functionality.

 For example you can configure your kubernetes containers to probe "alive" and "readiness" statuses from here; [alive](http://localhost:8080/workflow-health-check/alive) and [readiness](http://localhost:8080/workflow-health-check/readiness)
 For a more detailed status of your Interlok components state (started/stopped/initialised/closed) you can fire a GET request here; [health-check](http://localhost:8080/workflow-health-check).

Secondly, you can cluster your Interlok instances together purely to help you keep track of the Instances running.  This is particularly useful when you want to launch additional instances based on scale or performance, in these instances you may not know exactly how many instances are currently running.  To keep track of each instance fire a GET request here; [cluster](http://localhost:8080/cluster-manager). 

![health diagram](/health.png "health diagram")


## Getting started

Please note this project uses a licensed component; therefore you will need an Interlok license.
Once obtained create a file "src/main/interlok/config/license.properties" that contains your license key.

* `./gradlew clean build`
* `(cd ./build/distribution && java -jar lib/interlok-boot.jar)`
