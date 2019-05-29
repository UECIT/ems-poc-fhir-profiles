package resources;

import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Period;
import org.hl7.fhir.dstu3.model.StringType;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Extension;

@DatatypeDef(name="EncounterTransport")
public class EncounterTransport extends org.hl7.fhir.dstu3.model.Extension {
	
	private static final long serialVersionUID = 1L;

	@Child(name="transportType", order=2, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Transport type")
	@Extension(url="transportType", definedLocally=false, isModifier=false)
    protected CodeableConcept transportType;
	
	@Child(name="transportPeriod", order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Transport period")
	@Extension(url="transportPeriod", definedLocally=false, isModifier=false)
	protected Period transportPeriod;
	
	@Child(name="reasonForTransport", order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Transport type")
	@Extension(url="reasonForTransport", definedLocally=false, isModifier=false)
	protected StringType reasonForTransport;

    @Child(name="value", order=Child.REPLACE_PARENT, min=0, max=0, modifier=false, summary=false)
    @Description(
    	shortDefinition="Value of extension", 
    	formalDefinition=
    		"Value of extension - may be a resource or one of a constrained set " +
    		"of the data types (see Extensibility in the spec for list)." 
    )
    protected org.hl7.fhir.dstu3.model.Type value;

	public CodeableConcept getTransportType() {
		return transportType;
	}
	public void setTransportType(CodeableConcept transportType) {
		this.transportType = transportType;
	}

	public Period getTransportPeriod() {
		return transportPeriod;
	}
	public void setTransportPeriod(Period transportPeriod) {
		this.transportPeriod = transportPeriod;
	}

	public StringType getReasonForTransport() {
		return reasonForTransport;
	}
	public void setReasonForTransport(StringType reasonForTransport) {
		this.reasonForTransport = reasonForTransport;
	}

}