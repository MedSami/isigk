package com.isigk.Model;

public class DataModel {
    String id, nom, prenom, email, nCin, motDePasse, id_filiere;
    String id_etudiant, id_projet, etat,nom_filiere,titreDeProjet, id_encadreur;

    public DataModel(String id, String nom, String prenom, String email, String nCin, String motDePasse, String id_filiere, String id_etudiant, String id_projet, String etat, String nom_filiere, String titreDeProjet, String id_encadreur) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.nCin = nCin;
        this.motDePasse = motDePasse;
        this.id_filiere = id_filiere;
        this.id_etudiant = id_etudiant;
        this.id_projet = id_projet;
        this.etat = etat;
        this.nom_filiere = nom_filiere;
        this.titreDeProjet = titreDeProjet;
        this.id_encadreur = id_encadreur;
    }

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getnCin() {
        return nCin;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public String getId_filiere() {
        return id_filiere;
    }

    public String getId_etudiant() {
        return id_etudiant;
    }

    public String getId_projet() {
        return id_projet;
    }

    public String getEtat() {
        return etat;
    }

    public String getNom_filiere() {
        return nom_filiere;
    }

    public String getTitreDeProjet() {
        return titreDeProjet;
    }

    public String getId_encadreur() {
        return id_encadreur;
    }
}
