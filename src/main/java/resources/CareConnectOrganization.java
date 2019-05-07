package resources;

import java.util.List;

import org.hl7.fhir.dstu3.model.Organization;
import org.hl7.fhir.dstu3.model.Period;
import org.hl7.fhir.dstu3.model.Reference;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import datatypes.Identifier;

@ResourceDef(name="Organization", profile="https://fhir.hl7.org.uk/STU3/StructureDefinition/CareConnect-Organization-1")
public class CareConnectOrganization extends Organization {

	private static final long serialVersionUID = 1L;
	
	@Child(name="identifier", type={Identifier.class}, order=Child.REPLACE_PARENT, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(
    	shortDefinition="An identifier for this organization.", 
    	formalDefinition=
    		"Organizations are known by a variety of ids. Some institutions maintain " +
    		"several, and most collect identifiers for exchange with other organizations concerning the organization." 
    )
    protected List<Identifier> identifier;
	
	@Child(name="mainLocation", type = {CareConnectLocation.class})  
    @Extension(url="https://fhir.hl7.org.uk/STU3/StructureDefinition/Extension-CareConnect-MainLocation-1", definedLocally=false, isModifier=false)
    @Description(shortDefinition="The main location of the organization.")
    private Reference mainLocation;  // CareConnect-Location-1
	
	@Child(name="organization-period")  
    @Extension(url="http://hl7.org/fhir/StructureDefinition/organization-period", definedLocally=false, isModifier=false)
    @Description(shortDefinition="The date range that this organization should be considered available.")
    private Period organizationPeriod;
	
	@Child(name="partOf", type={CareConnectOrganization.class}, order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=true)
    @Description(
    	shortDefinition="The organization of which this organization forms a part", 
    	formalDefinition="The organization of which this organization forms a part." 
    )
    protected Reference partOf;

	public Reference getMainLocation() {
		return mainLocation;
	}

	public void setMainLocation(Reference mainLocation) {
		this.mainLocation = mainLocation;
	}

	public Period getOrganizationPeriod() {
		return organizationPeriod;
	}

	public void setOrganizationPeriod(Period organizationPeriod) {
		this.organizationPeriod = organizationPeriod;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
