# Hexagonal POC

Simple Spring Boot project as an example of the hexagonal architecture implemented by four layers:

adapter
: Implementation of the infrastructure adapters e.g. DB, REST, messaging adapters.

api
: Use case interfaces with their accompanying command and query objects.

application
: Orchestration services implementing the use cases.

domain
: Domain aggregates, entities and value objects implementing the domain logic.

The layers are named in order to sort alphabetically from the outermost "adapter" (aka. "infrastructure") shell to the innermost "domain" core.

Dirk Dühr, June 2024

