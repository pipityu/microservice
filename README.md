# microservice

-serviceA: szerver alkalmazás ami egy MSSql adatbázishoz fér hozzá és egyszerű CRUD-ot valósít meg.

-serviceB: kliens alkalmazás ami a serviceA által biztosított végponton egy entitást kérhet le.

-eurekaServer: nyilvántartja az alkalmazáspéldányokat így a Ribbon kliens oldali Load Balancing egyszerűsödik.


Egy egyszerű teszt adatbázis az "sql.txt"-ben: DB-név/user/pw : TestDB/sa/test (properties file)

Endpointok összegyűjtve "crud.txt"-ben
