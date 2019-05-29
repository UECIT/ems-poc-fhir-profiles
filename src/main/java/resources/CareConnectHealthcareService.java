package resources;

import java.util.List;

import org.hl7.fhir.dstu3.model.HealthcareService;
import org.hl7.fhir.dstu3.model.Identifier;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.ResourceDef;

@ResourceDef(name="HealthcareService", profile="https://fhir.hl7.org.uk/STU3/StructureDefinition/CareConnect-HealthcareService-1")
public class CareConnectHealthcareService extends HealthcareService {

	private static final long serialVersionUID = 1L;

    /**
     * External identifiers for this item.
     */
    @Child(name="identifier", type={Identifier.class}, order=Child.REPLACE_PARENT, min=1, max=1, modifier=false, summary=true)
    @Description(
    	shortDefinition="External identifiers for this item", 
    	formalDefinition="External identifiers for this item." 
    )
    protected List<Identifier> identifier;
}
