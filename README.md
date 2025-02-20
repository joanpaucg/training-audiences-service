# Audiences service training
The purpose of this project is to develop a service that processes user audiences 
in order to make an example of a real world application.

A User audience is an entity created by an external system that will communicate it to through HTTP.
The audience has a name that identifies it, for example Name: "people who buy cars in BCN"
The external system will communicate an audience with an input or output signal and a user identifier that is a
type and a value.

Payload example:

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
This service will store the ids that enter the audience and will send this information to external platforms.
Each external platform has a different way of creating audiences. But all of them offer the way to do it through HTTP.

Audiences of each platform can have different restrictions:
- Minimum time between creation and being able to start receiving user ids.
- Maximum number of ids that can be sent within a time frame.
- Maximum number of requests that can be made in a given time.

Each platform accepts some types of ids


## Links
https://start.spring.io/#!type=gradle-project-kotlin&language=java&platformVersion=3.4.3&packaging=jar&jvmVersion=21&groupId=com.jp.audiences&artifactId=audiences-service&name=audiences-service&description=Demo%20project%20for%20Spring%20Boot&packageName=com.jp.audiences&dependencies=devtools,configuration-processor,docker-compose,web,postgresql,data-jpa,amqp,flyway