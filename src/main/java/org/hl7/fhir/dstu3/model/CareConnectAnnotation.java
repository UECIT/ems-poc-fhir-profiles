package org.hl7.fhir.dstu3.model;

import org.hl7.fhir.dstu3.model.StringType;
import org.hl7.fhir.dstu3.model.Type;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.model.api.annotation.Description;

@DatatypeDef(name="Annotation")
public class CareConnectAnnotation extends Annotation {

	private static final long serialVersionUID = 1L;

    /**
     * The individual responsible for making the annotation.
     */
    @Child(
    	name="author", type={CareConnectPractitioner.class, CareConnectPatient.class, 
    			CareConnectRelatedPerson.class, StringType.class}, order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=true
    )
    @Description(
    	shortDefinition="Individual responsible for the annotation", 
    	formalDefinition="The individual responsible for making the annotation." 
    )
    protected Type author;
    
    public CareConnectAnnotation() {
    	super();
    }
    
    public CareConnectAnnotation(StringType text) {
    	super(text);
    }
}
