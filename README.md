# SpringRestTemplate
Just my personal Spring Rest Template 

## API Methods
The base-uri is ```/api/v1/XXXXXXXXXXXXXXXXXXX```


## Service Workflow


### Example 

        
## Getting Started

These instructions will get you a copy of the project up and running on your local machine for 
development and testing purposes. See deployment for notes on how to deploy the project on a 
live system.

### Prerequisites

For developing, running and testing the project you need to have the following components installed
(independent of your operating system):

* [Git](https://git-scm.com/) 
* [Java SDK 12](https://www.oracle.com/technetwork/java/javase/downloads/jdk12-downloads-5295953.html)
* [Gradle Community Edition](https://gradle.org/)
* [Docker](https://www.docker.com/community-edition)

Further the project suggests to use either [IntelliJ IDEA](https://www.jetbrains.com/idea) or
[Eclipse](https://www.eclipse.org) 
as an IDE.


### Installing

To install and run the application, follow the following steps:

1. Download the code using Git. 
2. Start Docker.
3. Ensure that along with Docker, you have a Minikube and Docker Compose installation up and 
   running - please check the upper prerequisite and then continue.

Now you can start the service in two modes:

```bash
# Docker Compose
./run.sh

# Local Kubernetes
kubectl config use-context docker-desktop;
  kubectl --namespace default delete services --all \
    && kubectl --namespace default delete deployments --all \
    && kubectl --namespace default delete pods --all \
    && kubectl --namespace default delete secrets --all \
    && kubectl --namespace default delete configmaps --all \
    && kubectl --namespace default delete namespaces --all;

kubectl apply -f k8s-XXXXXXXXXXXXXXXXXX.yml
```


## Running the tests

To run the tests, run the following command in a Terminal or in the Git Bash:

```
./gradlew clean test
```

The command above will run all tests (JUnit, Integration, Spring Boot, etc).

### Break down into end to end tests

To run JUnit and Spring Boot tests only, start the test-cases using the according IDE functions.
The test cases are contained in the `src/test/main` directory.

### Code Style and Findbugs Notes

Due to some issues with the Gradle plugin we did not start the Checkstyle and Findbugs tests.
However, this projects provides a working configuration in the project root directory 
under `codequality`.

If necessary for further development, you can implement the automatic checks in the Gradle build.
Please refer to the proper documentation of the specific plugins.
This documentation does not reference specific documentation, since the plugins are not supported well.


## Deployment

The `k8s-XXXXXXXXXXXXXXXXXXXX.yml` file allows you to deploy the service to on of your desired Kubernetes clusters.
Usually, we deploy the service into the `default` Kubernetes namespaces. We expect that you're familiar 
with Kubernetes  production deployments, iff not, please refer to the Kubernetes documentation above.

The K8S-Deployment and Service are made for production, but feel free to adjust the config for 
Namespace, Configmap and Secret Configuration as you desire. By default, no RBAC specific service account will be created.

## Code Structure
Since this service was built based on a spring boot template, the code structure is the same as the other services that were built on the template. 

## Built With

* [Gradle](https://gradle.org/) - The Dependency Management and Build tool used.
* [Docker](https://www.docker.com/) - The virtualization platform used.
* [Spring Boot](https://projects.spring.io/spring-boot/) - The Java web, REST-API, JPA and Microservice framework used.
* [Swagger](https://swagger.io/) - The REST-API specification.


## Contributing

Please read [CONTRIBUTING.md](CONTRIBUTING.md) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the
[tags on this repository](https://git.isw.uni-stuttgart.de/st110342/manufacturing/tags). 

## Author

* **Jiacheng Qian** - *Template* - 

## License

This project is licensed under the Apache V2 License - see the [LICENSE](LICENSE) file for details.
