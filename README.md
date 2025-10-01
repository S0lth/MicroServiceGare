# MicroService
**Projet réalisé dans le cadre scolaire. Ce projet visait à créer divers microservices en Java avec Spring Boot le tout avec un Discovery Server et une API Gateway**
Note: ce projet avait été versionné à l'origine avec git mais pour des raisons que je ne comprends pas il m'a été impossible de le récupérer.
| Pile technologique | Version                            |
|--------------------|------------------------------------|
| IntelliJ           | 2024.1 Ultimate                    |
| MongoDB            | db version v7.0.15                 |
| MySQL              | 8.0.40-debian                      |
| Docker             | Docker version 27.3.1 build 2.fc41 |
| Java               | 21                                 |

## Lancement de la base de données MySQL

**Linux**

```sh
docker run --name mysql-container \
-e MYSQL_ROOT_PASSWORD=root \
-e MYSQL_DATABASE=mydb -p 3306:3306 -d mysql:latest


**Windows**

Sous Windows la même commande peut être lancée depuis PowerShell

## Lancement de la base de données MongoDB

**Linux**
Depuis n'importe où dans le terminal lancer la commande suivante (la configuration par défaut suffit)
```sh
sudo systemctl restart mongod
sudo mongod --config=<chemin-vers-votre-config>

```

**Windows**
Depuis PowerShell lancer depuis le dossier contenant l'exécutable de MongoDB

```sh
.\mongod.exe --config=.\mongod.conf
```

avec la configuration suivante

  ```yml
  storage:
     dbPath: ../data/db 
  net:
     port: 27017
     bindIp: 127.0.0.1 
  
  ```


## Lancement des Microservices

Depuis le terminal chaque microservice peut être lancé en se plaçant à la racine du microservice (au niveau du pom.xml) avec la commande en respectant l'ordre

1.Discovery server
2.Gateway API
3.Microservice de votre choix

```sh
mvn spring-boot:run

```
