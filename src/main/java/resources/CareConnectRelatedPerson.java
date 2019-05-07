package resources;

import java.util.List;

import org.hl7.fhir.dstu3.model.Reference;
import org.hl7.fhir.dstu3.model.RelatedPerson;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import datatypes.Identifier;

public class CareConnectRelatedPerson extends RelatedPerson {

	private static final long serialVersionUID = 1L;

	/**
     * Identifier for a person within a particular scope.
     */
    @Child(name="identifier", type={Identifier.class}, order=Child.REPLACE_PARENT, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(
    	shortDefinition="A human identifier for this person", 
    	formalDefinition="Identifier for a person within a particular scope." 
    )
    protected List<Identifier> identifier;
    
    /**
     * The patient this person is related to.
     */
    @Child(name="patient", type={CareConnectPatient.class}, order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=true)
    @Description(
    	shortDefinition="The patient this person is related to", 
    	formalDefinition="The patient this person is related to." 
    )
    protected Reference patient;
}
