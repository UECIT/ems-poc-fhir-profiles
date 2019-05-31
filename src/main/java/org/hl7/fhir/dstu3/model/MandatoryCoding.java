package org.hl7.fhir.dstu3.model;

import org.hl7.fhir.dstu3.model.CodeType;
import org.hl7.fhir.dstu3.model.Coding;
import org.hl7.fhir.dstu3.model.StringType;
import org.hl7.fhir.dstu3.model.UriType;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.model.api.annotation.Description;

@DatatypeDef(name="Coding")
public class MandatoryCoding extends Coding {

	private static final long serialVersionUID = 1L;

    /**
     * The identification of the code system that defines the meaning of the symbol in the code.
     */
    @Child(name="system", type={UriType.class}, order=Child.REPLACE_PARENT, min=1, max=1, modifier=false, summary=true)
    @Description(
    	shortDefinition="Identity of the terminology system", 
    	formalDefinition="The identification of the code system that defines the meaning of the symbol in the code." 
    )
    protected UriType system;

    /**
     * A symbol in syntax defined by the system. 
     * The symbol may be a predefined code or an expression in a syntax defined by the coding system (e.g. post-coordination).
     */
    @Child(name="code", type={CodeType.class}, order=Child.REPLACE_PARENT, min=1, max=1, modifier=false, summary=true)
    @Description(
    	shortDefinition="Symbol in syntax defined by the system",
    	formalDefinition=
    		"A symbol in syntax defined by the system. The symbol may be a predefined code " +
    		"or an expression in a syntax defined by the coding system (e.g. post-coordination)." 
    )
    protected CodeType code;

    /**
     * A representation of the meaning of the code in the system, following the rules of the system.
     */
    @Child(name="display", type={StringType.class}, order=Child.REPLACE_PARENT, min=1, max=1, modifier=false, summary=true)
    @Description(
    	shortDefinition="Representation defined by the system", 
    	formalDefinition="A representation of the meaning of the code in the system, following the rules of the system." 
    )
    protected StringType display;
}
