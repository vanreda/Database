package fr.univrouen.pollen.domain.social;
/*
This Enum describe the profession. It was made with a list find on the internet.
It way miss some works but it's easy to add.

 */
public enum Profession {
    ACCOUNTANT("Comptable"),
    ACTOR("Acteur"),
    AMBULANCE_DRIVER("Ambulancier"),
    ARCHITECT("Architecte"),
    AUTHOR("Auteur"),
    BUYER("Acheteur"),
    BAKER("Boulanger"),
    BUTCHER("Boucher"),
    BOXER("Boxeur"),
    BROKER("Courtier"),
    BASKETBALL_PLAYER("Basketeur"),
    CABINE_MAKER("Ebeniste"),
    CASHIER("Caissier"),
    CARPENTER("Charpentier"),
    CHEMIST("Chimiste"),
    COBLER("Cordonnier"),
    COMPOSITOR("Compositeur"),
    CONSULTANT("Consultant"),
    COOKER("Cuisinier"),
    DANCER("Danseur"),
    DENTIST("Dentiste"),
    DEPUTY("Depute"),
    DRAUGHTSMAN("Dessinateur"),
    DRIVER("Chauffeur"),
    DEVELOPER("Developpeur"),
    DUSTMAN("Eboueur"),
    ECONOMIST("Economiste"),
    ELECTRICIAN("Electricien"),
    EMPLOYEE("Employe"),
    FARMER("Agriculteur"),
    REFEREE("Arbitre"),
    LAWYER("Avocat"),
    LUMBERJACK("Bucheron"),
    TAXI_DRIVER("Chauffeur de Taxi"),
    SINGER("Chanteur"),
    SURGEON("Chirurgien"),
    HAIRDRESSER("Coiffeur"),
    SALESMAN("Commercial"),
    RETAILLER("Detaillant"),
    HUMAN_RESOURCES_DIRECTOR("DRH"),
    PUBLISHER("Editeur"),
    GROCER("Epicier"),
    POSTMAN("Facteur"),
    FLORIST("Fleuriste"),
    FOOTBALL_PLAYER("Footballeur"),
    GRAVEDIGGER("Fossoyeur"),
    GENDARME("Gendarme"),
    COURT_CLERK("Greffier"),
    WHOLESALER("Grossiste"),
    MOUNTAIN_GUIDE("Guide de haute montagne"),
    STEWARDESS("Hotesse de l'air"),
    BAILIFF("Huissier de justice"),
    IMPRESSIONIST("Imitateur"),
    MALE_NURSE("Infirmier"),
    GARDENER("Jardinier"),
    JUDGE("Juge"),
    MASON("Maçon"),
    MAGISTRATE("Magistrat"),
    MAYOR("Maire"),
    MARINE("Marin"),
    MATHEMATICIAN("Mathematicien"),
    ENGINEER("Mecanicien"),
    DOCTOR("Medecin"),
    JOINER("Menuisier"),
    MILITARY("Militaire"),
    MINISTER("Ministre"),
    MUSICIEN("Musicien"),
    NOTARY_PUBLIC("Notaire"),
    OPTICIAN("Opticien"),
    SPEECH_THERAPIST("Orthophoniste"),
    WOKER("Ouvrier"),
    ORTHODONTIST("Paysagiste"),
    CEO("Pdg"),
    FISHERMAN("Pecheur"),
    Paediatrician("Pediatre"),
    PAINTER("Peintre"),
    PHARMACIST("Pharmacien"),
    PHOTOGRAPHER("Photographe"),
    PHYSICIST("Physicien"),
    PILOT("Pilote"),
    PLUMBER("Plombier"),
    FISH_MONGER("Poissonier"),
    POLICEMAN("Policier"),
    POTTER("Potier"),
    PRESIDENT("President"),
    PROSECUTOR("Procureur"),
    TEACHER("Professeur"),
    PROPERTY_DEVELOPER("Promoteur immobilier"),
    PSYCHIATRIST("Psychiatre"),
    PSYCOLOGIST("Psychologue"),
    DIRECTOR("Realisateur"),
    POMPOUS("Sapeur pompier"),
    SECRETARY("Secretaire"),
    WAITER("Serveur"),
    TAILOR("Tailleur"),
    CLEANER("Technicien de surface"),
    TRADER("Trader"),
    TRANSLATOR("Traducteur"),
    CATERER("Traiteur"),
    TREASURER("Trésorier"),
    SELLER("Vendeur"),
    VETERINARIAN("Veterinaire"),
    WINE_GROWER("Vigneron"),
    JOURNALIST("Journaliste"),
    WEBMASTER("Webmester");


    private String text;

    Profession(String text) {
        this.text = text;
    }
}