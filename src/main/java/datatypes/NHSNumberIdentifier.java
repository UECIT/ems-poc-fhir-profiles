package datatypes;

import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Identifier;
import org.hl7.fhir.instance.model.api.ICompositeType;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Extension;

@DatatypeDef(name = "identifier")
public class NHSNumberIdentifier extends Identifier implements ICompositeType{
	
	private static final long serialVersionUID = 1L;
	
	@Child(name = "nhsNumberVerificationStatus", type = {CodeableConcept.class}, modifier=false, summary=true)
	@Extension(url="https://fhir.hl7.org.uk/STU3/StructureDefinition/Extension-CareConnect-NHSNumberVerificationStatus-1", definedLocally=false, isModifier=false)
    @Description(shortDefinition="The time of day that the Patient was born. This includes the date to ensure that the timezone information can be communicated effectively.")
    private CodeableConcept nhsNumberVerificationStatus;

	public CodeableConcept getNhsNumberVerificationStatus() {
		return nhsNumberVerificationStatus;
	}

	public void setNhsNumberVerificationStatus(CodeableConcept nhsNumberVerificationStatus) {
		this.nhsNumberVerificationStatus = nhsNumberVerificationStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
