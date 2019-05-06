package resources;

import java.util.List;

import org.hl7.fhir.dstu3.model.Identifier;
import org.hl7.fhir.dstu3.model.Location;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;

@ResourceDef(name="Location", profile="https://fhir.hl7.org.uk/STU3/StructureDefinition/CareConnect-Location-1")
public class CareConnectLocation extends Location {
	
	private static final long serialVersionUID = 1L;
	
	@Child(name = "odsSiteCode", type = {Identifier.class}, order=0, min=0, max=1, modifier=false, summary=true)
	@Extension(url="https://fhir.hl7.org.uk/STU3/StructureDefinition/CareConnect-Organization-1", definedLocally=false, isModifier=false)
    @Description(shortDefinition="Organization label locations in registries, need to keep track of those.", formalDefinition="ODS Site code to identify the organisation at site level" )
    protected List<Identifier> odsSiteCode;

}
