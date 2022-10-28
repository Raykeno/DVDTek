public interface GlobalVals {
     int DUREE_1 = 24;
     int DUREE_2 = 48;
     int DUREE_3 = 72;


     // Les Duréees sont limitées à 24, 48, 72 heures
     enum durees {DUREE_1, DUREE_2, DUREE_3}

     float PRIX_DUREE_1 = 0.5f;
     float PRIX_DUREE_2 = 0.7f;
     float PRIX_DUREE_3 = 1.1f;


     enum categories {Ancien, Recent, Nouveau, DeLAnnee, DeLAnPasse}
     enum genres {Fantaisie, ScienceFiction, Comedie, DrameRomantique, Action}
     float PRIX_ANCIEN = 2f;
     float PRIX_RECENT = 6f;
     float PRIX_NOUVEAU = 8f;
     float PRIX_DELANNEE = 5f;
     float PRIX_DELANPASSE = 4f;


     enum typeSupport {BluRay, DVD}
     float PRIX_SUPPORT_DVD = 2.10f;
     float PRIX_SUPPORT_BLURAY = 2.40f;
}
