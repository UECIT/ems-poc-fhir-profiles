package resources;

import java.util.List;

import org.hl7.fhir.dstu3.model.Identifier;
import org.hl7.fhir.dstu3.model.Organization;
import org.hl7.fhir.dstu3.model.Period;
import org.hl7.fhir.dstu3.model.Reference;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;

@ResourceDef(name="Organization", profile="https://fhir.hl7.org.uk/STU3/StructureDefinition/CareConnect-Organization-1")
public class CareConnectOrganization extends Organization {

	private static final long serialVersionUID = 1L;
	
	@Child(name = "odsOrganisationCode", type = {Identifier.class}, order=0, min=0, max=1, modifier=false, summary=true)
	@Extension(url="https://fhir.hl7.org.uk/STU3/StructureDefinition/CareConnect-Organization-1", definedLocally=false, isModifier=false)
    @Description(shortDefinition="Organizations are known by a variety of ids. Some institutions maintain several, and most collect identifiers for exchange with other organizations concerning the organization.", formalDefinition="An identifier for this patient." )
    protected List<Identifier> odsOrganisationCode;
	
	@Child(name = "odsSiteCode", type = {Identifier.class}, order=0, min=0, max=1, modifier=false, summary=true)
	@Extension(url="https://fhir.hl7.org.uk/STU3/StructureDefinition/CareConnect-Organization-1", definedLocally=false, isModifier=false)
    @Description(shortDefinition="Organizations are known by a variety of ids. Some institutions maintain several, and most collect identifiers for exchange with other organizations concerning the organization.", formalDefinition="ODS Site code to identify the organisation at site level" )
    protected List<Identifier> odsSiteCode;
	
	@Child(name="mainLocation", type = {CareConnectLocation.class})  
    @Extension(url="https://fhir.hl7.org.uk/STU3/StructureDefinition/Extension-CareConnect-MainLocation-1", definedLocally=false, isModifier=false)
    @Description(shortDefinition="The main location of the organization.")
    private Reference mainLocation;  // CareConnect-Location-1
	
	@Child(name="organization-period")  
    @Extension(url="http://hl7.org/fhir/StructureDefinition/organization-period", definedLocally=false, isModifier=false)
    @Description(shortDefinition="The date range that this organization should be considered available.")
    private Period organizationPeriod;
	
	@Child(name = "partOf", type = {CareConnectOrganization.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The organization of which this organization forms a part", formalDefinition="The organization of which this organization forms a part." )
    protected Reference partOf;

	public List<Identifier> getOdsOrganisationCode() {
		return odsOrganisationCode;
	}

	public void setOdsOrganisationCode(List<Identifier> odsOrganisationCode) {
		this.odsOrganisationCode = odsOrganisationCode;
	}

	public List<Identifier> getOdsSiteCode() {
		return odsSiteCode;
	}

	public void setOdsSiteCode(List<Identifier> odsSiteCode) {
		this.odsSiteCode = odsSiteCode;
	}

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
	
	// contact adjust name.family cardinality to be 1..1

}
