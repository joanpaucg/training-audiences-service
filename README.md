# Audiences service training

Servei-> Processar audiencies usuari
Una audiencia d'usuari -> entitat creada per sistema extern que ens la comunicara a traves de HTTP
Audiencia te : nom que l'identifica per exemple   Nom:"persones que compren cotxer a BCN"
El sistema extern ens comunicara una audiencia amb una senyal d'entrada o sortida i un identificador d'usuari que és un 
tipus i un valor.

Payload:

```json
{
  "userIds": [
    {
      "type": "email",
      "value": "demo@email.com"
    },
    {
      "type": "android.aaid",
      "value": "36e18894-1496-4b09-8b61-5d8bb46df90f"
    }
  ],
    "signal": "IN",
    "audience":"persones que compren cotxes a BCN"
}
```
El servei ha d'emmagatzemar els ids que entren a l'audiencia
Aquesta informació s'enviarà a plataformes externes.
Cada plataforma externa té una forma diferent de crear audiències. Pero totes
ofereixen la forma de fer-ho via HTTP.

Les audiencies de cada plataforma poden tenir restriccions diferents:
- Temps mínim entre la creació i poder començar a rebre ids d'usuari.
- Quantitat màxima d'ids que es poden enviar dins una franja de temps.
- Quantitat màxima de peticions que es poden fer en un temps determinat.

Cada plataforma accepta alguns tipus de ids


## Links
https://start.spring.io/#!type=gradle-project-kotlin&language=java&platformVersion=3.4.3&packaging=jar&jvmVersion=21&groupId=com.jp.audiences&artifactId=audiences-service&name=audiences-service&description=Demo%20project%20for%20Spring%20Boot&packageName=com.jp.audiences&dependencies=devtools,configuration-processor,docker-compose,web,postgresql,data-jpa,amqp,flyway