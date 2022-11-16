# DVDTek
La DVDTheque

Projet POO, à rendre pour le 16 novembre à 22h

Check cours info pour le sujet

Les membres sont dans les contributeurs 👍 

Étape 1 :

Dans la constitution du prix de location il faut prendre en compte :

- [x] le support DVD ou Blue Ray
- [x] la catégorie du film (nouveauté, récent, de l’année, de l’an passé, plus ancien) pour laquelle il y a une tarification.
- [x] la durée prévue de la location dont le tarif peut ne pas être linéaire (cad différent d’un prix par jour * nombre de jours)
- [x] Pour effectuer le règlement, le client peut utiliser différents moyens (CB, chèque, espèce).

Étape 2 :

- [x] une identification complète du client
- [ ] la mémorisation des locations qui ont été effectuées avec la date de la location
- [ ] la mémorisation d’éléments statistiques comme :
- [x] dénombrement par support (DVD / Blue Ray)
- [x] dénombrement par genre (action, comédie...)
- [ ] préférence en terme de catégorie (loue essentiellement des sorties récentes...)
- [ ] la gestion d’un compte prépayé (qui peut être utilisé comme moyen de paiement pour
les locations)
- [x] la gestion de réservation de film pour une date (qui impacte la possibilité de sortir un exemplaire du film dans le courant de la journée de la réservation : l’agence doit concerver un exemplaire du film par réservation)
- [ ] pour les titulaires d’un compte prépayé, un retour avant la date de retour prévu donne lieu à remboursement par tranche de 12h du temps non consommé. Exemple : une location initialement prévue sur 72h pour un montant de 9€ donnera lieu à un remboursement de :
- 1,5€ pour un retour entre la 48ième et la 60ième heure
- 3€ pour un retour entre la 36ième et la 48ième heure
- 4,5€ pour un retour entre la 24ième et la 36ième heure
- 6€ pour un retour entre la 12ième et la 24ième heure
- 7,5€ pour un retour entre la 0ième et la 12ième heure
