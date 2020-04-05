# FHIR CareConnect Profiles

## Overview
The FHIR Profiles library provides strongly typed definitions of the [CareConnect profiles](https://nhsconnect.github.io/CareConnectAPI/explore.html).

This include definitions for all resources relevant to the $evaluate, Encounter Report and Check-Services interactions.

## Source Code Location
The repository for this library is located in a public GitLab space here:
https://gitlab.com/ems-test-harness/ems-poc-fhir-profiles

## Project Structure
### Implementation
FHIR Profiles is a Java library that contains the class definitions for the CareConnect profiles.

### Tests
The FHIR Profiles library currently includes tests for the main profile implementations.

## Deployment
The library is deployed as a package within [a publicly accessible bintray repository](https://bintray.com/beta/#/ems-test-harness/EMS-Test-Harness). For deployment one must clone/pull the repository onto their local machine, setup their maven deployment settings (`%UserProfile%\.m2\settings.xml` on Windows) with their manager bintray credentials (can be obtained from the bintray repository setup guide) and run the following maven task:

```bash
mvn deploy
```