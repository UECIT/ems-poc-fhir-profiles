package resources;

import java.util.List;

import org.hl7.fhir.dstu3.model.CareTeam;
import org.hl7.fhir.dstu3.model.EpisodeOfCare;
import org.hl7.fhir.dstu3.model.Reference;
import org.hl7.fhir.dstu3.model.ReferralRequest;

import ca.uhn.fhir.model.api.annotation.Block;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import datatypes.Identifier;

public class CareConnectEpisodeOfCare extends EpisodeOfCare {

	private static final long serialVersionUID = 1L;

    @Child(name="identifier", type={Identifier.class}, order=Child.REPLACE_PARENT, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(
    	shortDefinition="Business Identifier(s) relevant for this EpisodeOfCare", 
    	formalDefinition=
    		"The EpisodeOfCare may be known by different identifiers for different contexts of use, " +
    		"such as when an external agency is tracking the Episode for funding purposes." )
    protected List<Identifier> identifier;
    
    /**
     * The patient who is the focus of this episode of care.
     */
    @Child(name="patient", type={CareConnectPatient.class}, order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=true)
    @Description(
    	shortDefinition="The patient who is the focus of this episode of care", 
    	formalDefinition="The patient who is the focus of this episode of care." 
    )
    protected Reference patient;

    /**
     * The organization that has assumed the specific responsibilities for the specified duration.
     */
    @Child(name="managingOrganization", type={CareConnectOrganization.class}, order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=true)
    @Description(
    	shortDefinition="Organization that assumes care", 
    	formalDefinition="The organization that has assumed the specific responsibilities for the specified duration." 
    )
    protected Reference managingOrganization;
    
    /**
     * The list of diagnosis relevant to this episode of care.
     */
    @Child(name="diagnosis", order=Child.REPLACE_PARENT, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(
    	shortDefinition="The list of diagnosis relevant to this episode of care", 
    	formalDefinition="The list of diagnosis relevant to this episode of care." 
    )
    protected List<DiagnosisComponent> diagnosis;
    
    /**
     * Referral Request(s) that are fulfilled by this EpisodeOfCare, incoming referrals.
     */
    @Child(name="referralRequest", type={ReferralRequest.class}, order=Child.REPLACE_PARENT, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(
    	shortDefinition="Originating Referral Request(s)", 
    	formalDefinition="Referral Request(s) that are fulfilled by this EpisodeOfCare, incoming referrals." 
    )
    protected List<Reference> referralRequest; //TODO Use CareConnectReferralRequest

    /**
     * The practitioner that is the care manager/care co-ordinator for this patient.
     */
    @Child(name="careManager", type={CareConnectPractitioner.class}, order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=false)
    @Description(
    	shortDefinition="Care manager/care co-ordinator for the patient", 
    	formalDefinition="The practitioner that is the care manager/care co-ordinator for this patient." 
    )
    protected Reference careManager;
    
    /**
     * The list of practitioners that may be facilitating this episode of care for specific purposes.
     */
    @Child(name="team", type={CareTeam.class}, order=Child.REPLACE_PARENT, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(
    	shortDefinition="Other practitioners facilitating this episode of care", 
    	formalDefinition="The list of practitioners that may be facilitating this episode of care for specific purposes." 
    )
    protected List<Reference> team; //TODO Use CareConnectCareTeam
    
    @Block()
    public static class DiagnosisComponent extends EpisodeOfCare.DiagnosisComponent {

		private static final long serialVersionUID = 1L;
		
		/**
         * A list of conditions/problems/diagnoses that this episode of care is intended to be providing care for.
         */
        @Child(name="condition", type={CareConnectCondition.class}, order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=true)
        @Description(
        	shortDefinition="Conditions/problems/diagnoses this episode of care is for", 
        	formalDefinition=
        		"A list of conditions/problems/diagnoses that this " +
        		"episode of care is intended to be providing care for." 
        )
        protected Reference condition;
    }

}
