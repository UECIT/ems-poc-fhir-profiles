package org.hl7.fhir.dstu3.model;

import java.util.List;

import org.hl7.fhir.dstu3.model.CareTeam;
import org.hl7.fhir.dstu3.model.Group;
import org.hl7.fhir.dstu3.model.Reference;

import ca.uhn.fhir.model.api.annotation.Block;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.ResourceDef;

@ResourceDef(name="CareTeam", profile="https://fhir.hl7.org.uk/STU3/StructureDefinition/CareConnect-CareTeam-1")
public class CareConnectCareTeam extends CareTeam {
	
	private static final long serialVersionUID=1L;
	
	@Child(name="identifier", type={CareConnectIdentifier.class}, order=Child.REPLACE_PARENT, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(
    	shortDefinition="External Ids for this team", 
    	formalDefinition="This records identifiers associated with this care team that are defined by business " +
    		"processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate." 
    )
    protected List<CareConnectIdentifier> identifier;
	
    @Child(name="subject", type={CareConnectPatient.class, Group.class}, order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=true)
    @Description(
    	shortDefinition="Who care team is for", 
    	formalDefinition="Identifies the patient or group whose intended care is handled by the team." 
    )
    protected Reference subject;

    @Child(name="context", type={CareConnectEncounter.class, CareConnectEpisodeOfCare.class}, 
    	order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=true)
    @Description(
    	shortDefinition="Encounter or episode associated with CareTeam", 
    	formalDefinition="The encounter or episode of care that establishes the context for this care team." 
    )
    protected Reference context;

    @Child(name="participant", order=Child.REPLACE_PARENT, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(
    	shortDefinition="Members of the team", 
    	formalDefinition="Identifies all people and organizations who are expected to be involved in the care team." 
    )
    protected List<CareTeamParticipantComponent> participant;
    
    @Child(name="reasonReference", type={CareConnectCondition.class}, 
    	order=Child.REPLACE_PARENT, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(
    	shortDefinition="Why the care team exists", 
    	formalDefinition="Condition(s) that this care team addresses." 
    )
    protected List<Reference> reasonReference;

    @Child(name="managingOrganization", type={CareConnectOrganization.class}, 
    	order=Child.REPLACE_PARENT, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(
    	shortDefinition="Organization responsible for the care team", 
    	formalDefinition="The organization responsible for the care team." 
    )
    protected List<Reference> managingOrganization;
    
    @Block()
    public static class CareTeamParticipantComponent 
    		extends org.hl7.fhir.dstu3.model.CareTeam.CareTeamParticipantComponent {

		private static final long serialVersionUID=1L;
    	
        @Child(name="member", type={CareConnectPractitioner.class, CareConnectRelatedPerson.class, 
        	CareConnectPatient.class, CareConnectOrganization.class, CareConnectCareTeam.class}, 
        	order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=true
        )
        @Description(
        	shortDefinition="Who is involved", 
        	formalDefinition="The specific person or organization who is participating/expected to participate in the care team." 
        )
        protected Reference member;

        @Child(name="onBehalfOf", type={CareConnectOrganization.class}, 
        	order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=true)
        @Description(
        	shortDefinition="Organization of the practitioner", 
        	formalDefinition="The organization of the practitioner." 
        )
        protected Reference onBehalfOf;
    }
}
