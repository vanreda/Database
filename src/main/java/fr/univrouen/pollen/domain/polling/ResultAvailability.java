package fr.univrouen.pollen.domain.polling;

/**
 * Defines when the result of a Poll is visible.
 */
public enum ResultAvailability {
    ALWAYS,          //TODO check MOA
    DURING_CAMPAIGN, //Allways during campaign
    AFTER_CAMPAIGN,  //At the end of the campaign
    AT_DATE,         //At a date
    NEVER            //Never available, should be made available manually
}
