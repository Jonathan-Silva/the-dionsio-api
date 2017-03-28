#### THE-DIONISIO-API
##### resource : /login 
##### methods : post
#
>This resource support the login for all entitys
##### json structure:
#
```json
{
  "_id": "58d1b31255eb441fee7d414a",
  "email": "alan@turing.com",
  "password": "you shall not pass",
  "token": "5112fe4cc58d1b31255eb441fee7d414a97ba26920a1d25f929ba0c258d1b31255eb441fee7d414a3055241e",
  "entity": "person"
}
```
##### Example

##### [ post ]
#
The post method has required attributes (email, password and entity).
###### request:
#
```json
{
  "email": "alan@turing.com",
  "password": "turing",
  "entity": "person"
}
```
###### response: [ loged ]
#
```json
{
  "_id": "58d1b31255eb441fee7d414a",
  "email": "alan@turing.com",
  "password": "you shall not pass",
  "token": "5112fe4cc58d1b31255eb441fee7d414a97ba26920a1d25f929ba0c258d1b31255eb441fee7d414a3055241e",
  "entity": "person"
}
```
###### response: [ not loged ]
#
```json
{
  "_id": "58d1b31255eb441fee7d414a",
  "email": "alan@turing.com",
  "password": "you shall not pass",
  "token": "fail",
  "entity": "person"
}
```
##### Main possible fail response
#
###### NOT_ACCEPTABLE:
#
```json
{
  "status": "NOT_ACCEPTABLE",
  "description": "required information not declared",
  "additional": "fields required: <email, password, entity>"
}
```
