# Projekt2_Gruppe_3

Ønskeliste-applikation lavet i Spring Boot med Thymeleaf og MySQL.

## Krav

- Java 21
- MySQL
- IntelliJ (eller en anden IDE)

## Hent projektet

```
git clone https://github.com/aramariofficial-alt/Projekt2_Gruppe_3.git
```

## Gendan databasen

Databasescriptet ligger i `src/main/resources/Databasescript.sql`.

Åbn filen i MySQL Workbench og kør hele scriptet. Det opretter databasen `projekt2_gruppe_3_db` med tabellerne og noget testdata.

Brugernavn og kodeord til databasen står i `src/main/resources/application.properties`. Ret dem til jeres egen MySQL-bruger, hvis de ikke passer.

## Start applikationen

Åbn projektet i IntelliJ og kør `Projekt2Gruppe3Application`.

Gå derefter ind på http://localhost:8080 i browseren.