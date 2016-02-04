package fr.univrouen.pollen.domain.social;

public enum SocialProfessionalCategory {
    AGRI_SMALL("Agriculteurs sur petite exploitation"),
    AGRI_MEDIUM("Agriculteurs sur moyenne exploitation"),
    AGRI_LARGE("Agriculteurs sur grande exploitation"),
    ARTISAN("Artisan"),
    COMMERCANT("Commerçant et assimilés"),
    SMALL_COMPANY_MANAGER("Chefs d’entreprise de 10 salariés ou plus"),
    FREE_PROFESSIONNALS("Cadres de la fonction publique"),
    SCIENTISTS("Professeurs, professions scientifiques"),
    ARTS_ENTERTAINMENT("Professions de l’information, des arts et des spectacles"),
    ADMIN_SELLERS("Cadres administratifs et commerciaux d’entreprise"),
    TECHNICAL_ENGINEERS("Ingénieurs et cadres techniques d’entreprise"),
    TEACHERS("Professeurs des écoles, instituteurs et assimilés"),
    MEDIUM_HEALTH("Professions intermédiaires de la santé et du travail social"),
    RELIGIOUS("Clergé, religieux"),
    MEDIUM_PUBLIC_ADMINISTRATION("Professions intermédiaires administratives de la fonction publique"),
    MEDIUM_ADMIN_SELLERS("Professions intermédiaires administratives et commerciales des entreprises"),
    ENGINEERS("Techniciens"),
    SUPERVISORS("Contremaîtres, agents de maîtrise"),
    PUBLIC_AGENT("Employés civils et agents de service de la fonction publique"),
    POLICE_MILITARY("Policiers et militaires"),
    ADMIN_COMPANY("Employés administratifs d’entreprise"),
    SELLER_COMPANY("Employés de commerce"),
    PERSONNAL_SERVICE("Personnels des services directs aux particuliers"),
    INDUSTRIAL_WORKER("Ouvriers qualifiés de type industriel"),
    ARTISANAL_WORKER("Ouvriers qualifiés de type artisanal"),
    DRIVERS("Chauffeurs"),
    WORKER_MAINTAINEMENT("Ouvriers qualifiés de la manutention, du magasinage et du transport"),
    UNQUALIFIED_INDUSTRIAL_WORKER("Ouvriers non qualifiés de type industriel"),
    UNQUALIFIED_ARTISANAL_WORKER("Ouvriers non qualifiés de type artisanal"),
    AGRI_WORKER("Ouvriers agricoles"),
    FORMER_AGRI("Anciens agriculteurs exploitants"),
    FORMER_ARTISANAL("Anciens artisans, commerçants et chefs d’entreprise"),
    FORMER_MANAGER("Anciens cadres"),
    FORMER_MEDIUM("Anciennes professions intermédiaires"),
    FORMER_EMPLOYED("Anciens employés"),
    FORMER_WORKER("Anciens ouvriers"),
    UNEMPLOYED("Chômeurs n’ayant jamais travaillé"),
    MILITARY("Militaires du contingent"),
    STUDENTS("Élèves, étudiants"),
    NOT_RETIRED_LESS60("Personnes diverses sans activité professionnelle de moins de 60 ans sauf retraités"),
    NOT_RETIRED_MORE60("Personnes diverses sans activité professionnelle de 60 ans et plus sauf retraités"),
    RETIRED("Retraités");

    private String text;

    SocialProfessionalCategory(String text) {
        this.text = text;
    }
}
