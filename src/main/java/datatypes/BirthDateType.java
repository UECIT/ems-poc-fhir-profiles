package datatypes;

import org.hl7.fhir.dstu3.model.DateTimeType;
import org.hl7.fhir.dstu3.model.DateType;
import org.hl7.fhir.instance.model.api.ICompositeType;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Extension;

@DatatypeDef(name = "birthDate")
public class BirthDateType extends DateType implements ICompositeType {
	
	@Child(name="patient-birthTime", type={DateTimeType.class}, modifier=false, summary=true)
	@Extension(definedLocally=false, isModifier=false, url="http://hl7.org/fhir/StructureDefinition/patient-birthTime")
    @Description(
		shortDefinition="The time of day that the Patient was born. ",
		formalDefinition=
			"This includes the date to ensure that the timezone " +
			"information can be communicated effectively."
    )
    private DateTimeType birthTime;

	public DateTimeType getBirthTime() {
		return birthTime;
	}
	public BirthDateType setBirthTime(DateTimeType birthTime) {
		this.birthTime = birthTime;
		return this;
	}
}