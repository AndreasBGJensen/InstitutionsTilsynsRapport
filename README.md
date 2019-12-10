# InstitutionsTilsynsRapport
E19 DevOps
# Tilsyn.dk

## Vision
Single Page Application aiming to give an overview of daycare options, based on publicly available information, as well as letting people know what we know about them.


## Dependencies

- Node.js
- JDK 1.8
- Maven

## How to develop

- Clone the repository from git.
- Import maven project (e.g. right-click pom.xml and mark as maven) and enable maven auto-import.
- open terminal and navigate to web folder `cd web`
- run `npm install`
- run `npm install axios`
- Build the project using maven package `mvn package`
- Run with `npm 

## Launching the backend

- Run main in `/src/main/java/Main.java`

#How to use the application
Applikationen kan tilgår vi linket https://tilsyndk.herokuapp.com. 
Funktionaliteterne der kan afprøves på SPA’en er: 
1 .Se tilsyn: Henter alle de tilsynsrapporter der er oprettet i databasen.
2. Indhente tilsynsraporter: 
  - Klik på: “admin” indtast vejnavn og postnummer på en fra en adresse der er lokaliseret i københavns kommune. 
  - Klik på: “admin” indtast vejnavn og postnummer på en fra en adresse der er lokaliseret i københavns kommune. 
  - Klik “Send forespørgsel”:
Hvis du får denne respons :"Forespørgslen kunne ikke gennemføres" er det sandsynligvis fordi at vejnavnet indeholder mellemrum, eller en character som ikke kan genkendes. Løsning: Prøv et andet vejnavn.
Får du ingen respons er di request gået igennem. Grundet timeout på forbindelsen vil du ikke få nogen respons. Så er det bare med at væbne sig med tålmodighed og opdatere Se tilsyns viewet regelmæssigt indtil at listen er opdateret.
Kan du ikke vente kan du logge ind på heroku CLI og se hvad der sker på serveren: 
Komando: heroku logs --app tilsyndk
Kodeord og password står i appendix:
