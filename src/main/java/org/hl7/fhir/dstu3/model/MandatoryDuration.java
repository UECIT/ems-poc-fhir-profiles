package org.hl7.fhir.dstu3.model;

import org.hl7.fhir.dstu3.model.CodeType;
import org.hl7.fhir.dstu3.model.DecimalType;
import org.hl7.fhir.dstu3.model.Duration;
import org.hl7.fhir.dstu3.model.UriType;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.model.api.annotation.Description;

@DatatypeDef(name="Duration")
public class MandatoryDuration extends Duration {

	private static final long serialVersionUID = 1L;

	@Child(name="value", type={DecimalType.class}, order=Child.REPLACE_PARENT, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Numerical value (with implicit precision)", formalDefinition="The value of the measured amount. The value includes an implicit precision in the presentation of the value." )
    protected DecimalType value;
	
    @Child(name="system", type={UriType.class}, order=Child.REPLACE_PARENT, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="System that defines coded unit form", formalDefinition="The identification of the system that provides the coded form of the unit." )
    protected UriType system;

    @Child(name="code", type={CodeType.class}, order=Child.REPLACE_PARENT, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Coded form of the unit", formalDefinition="A computer processable form of the unit in some unit representation system." )
    protected CodeType code;
}
