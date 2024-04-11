# Beispielprojekt

### Rahmenbedingungen

+ Es gibt beliebig viele Firmen.
    + Jede Firma hat einen Namen und eine VAT-ID (UID-Nr.)
    + Jede Firma hat ihr eigenes, definiertes Set an Rollen (Leadership, Entwicklung, Küche, sei kreativ), die Mitarbeiter/innen innehaben können 
+ Es gibt pro Firma beliebig viele Mitarbeiter/innen.
    + Jede/r Mitarbeiter/in hat einen Namen und eine Mitarbeiternummer
    + Jede/r Mitarbeiter/in hat min. eine Rolle
    + Jede/r Mitarbeiter/in ist genau einer Firma zugehörig.
     
+ Projektsprache ist Englisch.

### Wir brauchen dafür

+ Passendes, relationales DB-Modell
    + PostgreSQL in Docker
    + Als Datentyp für IDs verwenden wir UUIDs (nicht irgendwelche Numbers/Sequences o.ä.)
+ Eine Backend-Applikation, die mittels REST-Endpoints eine möglichst sinnvolle API zur Verfügung stellt, um Firmen und Mitarbeiter zu verwalten.
    + Die API kann mit OpenAPI beschrieben werden, sonst im README.md o.ä.
    + Java + Spring, jeweils aktuelle Versionen
    + Buildsystem: Maven oder Gradle
    + Deliverable: Docker bzw. besser OCI Image
        + Vorzugsweise mit Jib (da gibt's auch Plugins für Maven und Gradle)
    + Es sollte Tests (mit jUnit 5) in irgendeiner Ausprägung geben
+ Optional
    + Die PostgreSQL Datenbank und die Applikation soll mit docker-compose gestartet werden können.


    test

    test
