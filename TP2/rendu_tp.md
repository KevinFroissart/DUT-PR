Froissart Kévin J

# Découpage d'URI

## éléments des URI

http://www.univ-lille1.fr/Accueil/Contacts/Services+étudiants/
- Protocole: http
- IP/Nom: www.univ-lille1.fr
- Ressource: Accueil/Contacts/Services+étudiants
- Requête:
- Ancre:

https://tools.ietf.org/html/rfc3986
- Protocole: https 
- IP/Nom: tools.ietf.org
- Ressource: html/rfc3986
- Requête:
- Ancre:

http://localhost:8080/users/1
- Protocole: http
- IP/Nom: localhost:8080
- Ressource: users/1
- Requête:
- Ancre:

https://fr.wikipedia.org/wiki/Markdown#Titres
- Protocole: https
- IP/Nom: fr.wikipedia.org
- Ressource: wiki/Markdown
- Requête:
- Ancre: Titres

http://traduction.culturecommunication.gouv.fr/url/Result.aspx?to=en&url=http%3A%2F%2Fwww.culturecommunication.gouv.fr%2F
- Protocole: http
- IP/Nom: traduction.culturecommunication.gouv.fr
- Ressource: url/Result.aspx
- Requête: to=en&url=http%3A%2F%2Fwww.culturecommunication.gouv.fr%2F
- Ancre:

## URL décodée

http%3A%2F%2Fwww.culturecommunication.gouv.fr%2F
- %3A = :
- %2F = /

http://www.culturecommunication.gouv.fr/
# Analyse de requête HTTP

## URI des requêtes

http://graphql.org/code/
http://httpbin.org/post?foo=bar&toto=tutu

## méthode utilisée et effet

La méthode utilisée est **POST**, le champ **_201 Created_** nous indique
qu'une ressource a été créée, soit via un **PUT** ou **POST**.
La section **_location_** nous indique alors qu'il sagit de la méthode **POST**.

# Gestion du cache
```
GET / HTTP/1.1
Host: localhost
Accept: test/html
If-None-Match: "29cd-53cd739c04ce7"
Vary: Accept-Encoding
```
# En pratique

## Commandes curl question 2a

### URL 1 :
Commande : ```curl -x http://cache.univ-lille.fr:3128 -v http://graphql.org/code/```
Entête de requête:
``` 
GET http://graphql.org/code/ HTTP/1.1
Host: graphql.org
User-Agent: curl/7.52.1
Accept: */*
Proxy-Connection: Keep-Alive
```

Entête de réponse:
```
HTTP/1.1 301 Moved Permanently
Cache-Control: public, max-age=0, must-revalidate
Content-Length: 41
Content-Type: text/plain
Date: Wed, 05 Feb 2020 17:01:44 GMT
Location: https://graphql.org/code/
Age: 69284
Server: Netlify
X-NF-Request-ID: 610330e8-a642-4666-a990-954b14f25190-3868019
X-Cache: MISS from cacheserv2
Via: 1.1 cacheserv2 (squid/3.3.3-20130325-r12517)
Connection: keep-alive
```

### URL 2:

Commande : ```curl -x http://cache.univ-lille.fr:3128 -v http://httpbin.org/post?foo=bar&toto=tutu```
Entête de requête:
```
GET http://httpbin.org/post?foo=bar HTTP/1.1
Host: httpbin.org
User-Agent: curl/7.52.1
Accept: */*
Proxy-Connection: Keep-Alive
```

Entête de réponse:
```
HTTP/1.0 405 Method Not Allowed
Date: Thu, 06 Feb 2020 12:18:53 GMT
Content-Type: text/html
Content-Length: 178
Server: gunicorn/19.9.0
Allow: POST, OPTIONS
Access-Control-Allow-Origin: *
Access-Control-Allow-Credentials: true
X-Cache: MISS from cacheserv3.univ-lille1.fr
Via: 1.1 cacheserv3.univ-lille1.fr:3128 (squid/2.7.STABLE5-20081024)
Connection: close
```

## curl cache

Commande : ```curl -v http://localhost -H 'If-None-Match: "1288-593d84c9d22f6"' -H 'Vary: Accept-Encoding'```
Entête de requête:
``` 
GET / HTTP/1.1
Host: localhost
User-Agent: curl/7.52.1
Accept: */*
If-None-Match: "1288-593d84c9d22f6"
Vary: Accept-Encoding
```

Entête de réponse:
```
HTTP/1.1 304 Not Modified
Date: Thu, 06 Feb 2020 12:28:20 GMT
Server: Apache/2.4.25 (Debian)
ETag: "1288-593d84c9d22f6"
```

## curl sur ULille

Commande : ```curl -v http://www.univ-lille.fr```

Entête de requête:
``` 
GET / HTTP/1.1
Host: www.univ-lille.fr
User-Agent: curl/7.52.1
Accept: */*
```
Entête de réponse:
```
HTTP/1.1 302 Found
Date: Thu, 06 Feb 2020 12:09:57 GMT
Server: Apache
Location: https://www.univ-lille.fr/
Content-Length: 210
Content-Type: text/html; charset=iso-8859-1
```

Adresse correcte: ```https://www.univ-lille.fr```
