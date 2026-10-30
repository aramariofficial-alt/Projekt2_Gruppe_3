# Projekt2_Gruppe_3 – Ønskeliste-applikation

Dette er vores 2. semester projekt. Det er en webapplikation, hvor man kan oprette ønskelister og tilføje ønsker til dem. Man kan oprette, se, redigere og slette både ønskelister og ønsker.

Applikationen er lavet med:
- Java 21
- Spring Boot (Spring MVC og Spring JDBC)
- Thymeleaf (HTML-templates)
- MySQL (database)
- Maven (build-værktøj)

## Krav

Følgende skal være installeret på computeren, før projektet kan køres:

- **Java JDK 21**
- **MySQL Server 8** (eller nyere)
- **MySQL Workbench** (anbefales, men man kan også bruge MySQL i terminalen)
- **IntelliJ IDEA** (anbefales)
- **Git**

Maven skal ikke installeres separat, fordi projektet har Maven Wrapper med (`mvnw` / `mvnw.cmd`).

## 1. Hent projektet

Klon projektet fra GitHub:

```bash
git clone https://github.com/aramariofficial-alt/Projekt2_Gruppe_3.git
cd Projekt2_Gruppe_3
```

Man kan også trykke på **Code → Download ZIP** på GitHub og pakke filen ud.

## 2. Gendan databasen

Databasescriptet ligger her i projektet:

```
src/main/resources/Databasescript.sql
```

Scriptet opretter databasen `projekt2_gruppe_3_db`, laver tabellerne `wishlist` og `wish` (to ønskelister med nogle ønsker).

**OBS:** Scriptet starter med `DROP DATABASE IF EXISTS`, så hvis der allerede findes en diver den slettet.

### Med MySQL Workbench
1. Åbn MySQL Workbench og forbind til din lokale MySQL-server.
2. Vælg **File → Open SQL Script** og åbn `Databasescript.sql`.
3. Kør hele scriptet ved at trykke på lynet (Execute).
4. Tryk på refresh under **Schemas**. Nu burde `projekt2_gruppe_3_db` være der.

### Med terminalen
```bash
mysql -u root -p < src/main/resources/Databasescript.sql
```

## 3. Opsæt forbindelsen til databasen

Applikationen forbinder til databasen med oplysningerne i:

```
src/main/resources/application.properties
```

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/projekt2_gruppe_3_db
spring.datasource.username=F26A
spring.datasource.password=1234
```

Man kan gøre én af to ting:

**Mulighed A:** Opret den samme bruger i MySQL, som projektet bruger. Kør det her i MySQL Workbench som root:

```sql
CREATE USER 'F26A'@'localhost' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON projekt2_gruppe_3_db.* TO 'F26A'@'localhost';
FLUSH PRIVILEGES;
```

**Mulighed B:** Ret `username` og `password` i `application.properties` til din egen MySQL-bruger (fx `root` og din egen adgangskode).

Hvis MySQL kører på en anden port end 3306, skal porten også rettes i `spring.datasource.url`.

## 4. Start applikationen

### I IntelliJ IDEA
1. Åbn projektmappen i IntelliJ (**File → Open**), og vent til Maven har hentet alle depe
2. Sørg for at projektet bruger JDK 21 (**File → Project Structure → SDK**).
3. Åbn `src/main/java/dk/kea/projekt2_gruppe_3/Projekt2Gruppe3Application.java`.
4. Tryk på den grønne play-knap ved `main`-metoden.

### I terminalen
Mac/Linux:
```bash
./mvnw spring-boot:run
```

Windows:
```bash
mvnw.cmd spring-boot:run
```

## 5. Åbn applikationen

Når applikationen kører, kan den åbnes i browseren på:

```
http://localhost:8080
```

Forsiden viser alle ønskelister. Herfra kan man:
- oprette en ny ønskeliste
- klikke ind på en ønskeliste og se dens ønsker
- tilføje, redigere og slette ønsker
- redigere og slette ønskelister
- læse om gruppen på "About us"-siden (`/aboutus`)

## Fejlfinding

- **"Access denied for user"**: Brugernavn eller adgangskode i `application.properties` passer ikke med din MySQL-bruger. Se trin 3.
- **"Unknown database 'projekt2_gruppe_3_db'"**: Databasescriptet er ikke blevet kørt. Se
- **"Communications link failure"**: MySQL-serveren kører ikke, eller den kører på en anden port.
- **"Port 8080 was already in use"**: Et andet program bruger port 8080. Luk det, eller t `application.properties` og brug `http://localhost:8081`.

## Projektstruktur

```
src/main/java/dk/kea/projekt2_gruppe_3/
├── controller/   WishController, WishlistController
├── model/        Wish, Wishlist
├── repository/   WishRepository, WishlistRepository (SQL mod databasen)
└── service/      WishService

src/main/resources/
├── templates/    Thymeleaf HTML-sider
├── static/       CSS og billeder
├── application.properties
└── Databasescript.sql
```

## Gruppe

Gruppe 3, 2. semester, KEA
