package com.isigk.Model;

public class DataModel {
   String id, idetudiant, nomencadreur, prenomenca, ncin, emailenca, motdepasse, domaine;
   String iddemande, nomdemande, url_document;
   String nomentreprise, adresse, num_tel, nbr_stag;
   String  n_inscrit, n_cin, filiere, nom, prenom, email, mot_de_passe;
   String idfiche, idencadreur, identreprise, nomsuijet;
   String idsout, etudiant_id,encadreur_id, nom_jury, sujet_pfe,salle, date, horaire;


    public DataModel(String id, String idetudiant, String nomencadreur,
                     String prenomenca, String ncin, String emailenca, String motdepasse,
                     String domaine, String iddemande, String nomdemande, String url_document,
                     String nomentreprise, String adresse, String num_tel, String nbr_stag,
                     String n_inscrit, String n_cin, String filiere, String nom, String prenom,
                     String email, String mot_de_passe, String idfiche, String idencadreur,
                     String identreprise, String nomsuijet, String idsout, String etudiant_id,
                     String encadreur_id,
                     String nom_jury, String sujet_pfe, String salle, String date, String horaire) {
        this.id = id;
        this.idetudiant = idetudiant;
        this.nomencadreur = nomencadreur;
        this.prenomenca = prenomenca;
        this.ncin = ncin;
        this.emailenca = emailenca;
        this.motdepasse = motdepasse;
        this.domaine = domaine;
        this.iddemande = iddemande;
        this.nomdemande = nomdemande;
        this.url_document = url_document;
        this.nomentreprise = nomentreprise;
        this.adresse = adresse;
        this.num_tel = num_tel;
        this.nbr_stag = nbr_stag;
        this.n_inscrit = n_inscrit;
        this.n_cin = n_cin;
        this.filiere = filiere;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mot_de_passe = mot_de_passe;
        this.idfiche = idfiche;
        this.idencadreur = idencadreur;
        this.identreprise = identreprise;
        this.nomsuijet = nomsuijet;
        this.idsout = idsout;
        this.etudiant_id = etudiant_id;
        this.encadreur_id = encadreur_id;
        this.nom_jury = nom_jury;
        this.sujet_pfe = sujet_pfe;
        this.salle = salle;
        this.date = date;
        this.horaire = horaire;
    }


    public String getId() {
        return id;
    }

    public String getIdetudiant() {
        return idetudiant;
    }

    public String getNomencadreur() {
        return nomencadreur;
    }

    public String getPrenomenca() {
        return prenomenca;
    }

    public String getNcin() {
        return ncin;
    }

    public String getEmailenca() {
        return emailenca;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public String getDomaine() {
        return domaine;
    }

    public String getIddemande() {
        return iddemande;
    }

    public String getNomdemande() {
        return nomdemande;
    }

    public void setNomdemande(String nomdemande) {
        this.nomdemande = nomdemande;
    }

    public String getUrl_document() {
        return url_document;
    }

    public String getNomentreprise() {
        return nomentreprise;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getNum_tel() {
        return num_tel;
    }

    public String getNbr_stag() {
        return nbr_stag;
    }

    public String getN_inscrit() {
        return n_inscrit;
    }

    public String getN_cin() {
        return n_cin;
    }

    public String getFiliere() {
        return filiere;
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

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public String getIdfiche() {
        return idfiche;
    }

    public String getIdencadreur() {
        return idencadreur;
    }

    public String getIdentreprise() {
        return identreprise;
    }

    public String getNomsuijet() {
        return nomsuijet;
    }

    public String getIdsout() {
        return idsout;
    }

    public String getEtudiant_id() {
        return etudiant_id;
    }

    public String getEncadreur_id() {
        return encadreur_id;
    }

    public String getNom_jury() {
        return nom_jury;
    }

    public String getSujet_pfe() {
        return sujet_pfe;
    }

    public String getSalle() {
        return salle;
    }

    public String getDate() {
        return date;
    }

    public String getHoraire() {
        return horaire;
    }
}
