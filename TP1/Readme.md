# Description du protocole de communication entre le client et le service

Ce protocole doit être complété pour préciser la forme des résultats
retournés par le côté serveur.

```
<invocation> ::= "CALL:" <methode> | <methode> ":" <param> [ ":" <param> ]*
<methode> ::= <chaine>
<param> ::= "param[" <type> "," <valeur> "]"
<type> ::= "char" | "string" | "int" | "float"
<valeur> ::= <char> | <chaine> | [0-9]* | [0-9]* "." [0-9]*
<chaine> :: <char>*
<char> ::= un charactère alphanumérique
<reponse> ::= "RESPONSE:" <methode> ":" <param>
<exception> ::= "EXCEPTION:" <methode> ":[" <chaine> "]"

```

## Exemples de ce qui devra être transmis

Voici deux exemples de messages transmis par le côté client pour une
invocation :

  + CALL:nombreMots:param[string,"Travail à la  chaîne"]
  + CALL:compteChar:param[string,"arrête ton char"]:param[char,"a"]
