A minimal test project for an apparent incompatibility found between Spring OXM 3.2.X and Spring Batch 2.x.

See https://jira.springsource.org/browse/BATCH-2054 for more details.

See [BUILDING](BUILDING.md) and [RUNNING](RUNNING.md) for setup and execution details.

The testOneObject case will pass with Spring OXM 3.1.x and 3.2.x.
The testTwoObjects case will only pass with Spring OXM 3.1.x.  With 3.2.x it fails on the NullPointerExcetion below.

The Spring version may be changed by editing the "spring.version" property in the project's pom.xml file.
