/* Copyright (c) 2012-2013, University of Edinburgh.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright notice, this
 *   list of conditions and the following disclaimer in the documentation and/or
 *   other materials provided with the distribution.
 *
 * * Neither the name of the University of Edinburgh nor the names of its
 *   contributors may be used to endorse or promote products derived from this
 *   software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *
 * This software is derived from (and contains code from) QTItools and MathAssessEngine.
 * QTItools is (c) 2008, University of Southampton.
 * MathAssessEngine is (c) 2010, University of Edinburgh.
 */
package uk.ac.ed.ph.jqtiplus.attribute.value;

import uk.ac.ed.ph.jqtiplus.attribute.MultipleAttribute;
import uk.ac.ed.ph.jqtiplus.node.QtiNode;
import uk.ac.ed.ph.jqtiplus.types.Identifier;
import uk.ac.ed.ph.jqtiplus.validation.ValidationContext;

import java.util.List;

/**
 * Attribute with identifier values.
 *
 * @author Jiri Kajaba
 */
public final class IdentifierMultipleAttribute extends MultipleAttribute<Identifier> {

    private static final long serialVersionUID = -4902112764512399666L;

    public IdentifierMultipleAttribute(final QtiNode parent, final String localName, final boolean required) {
        super(parent, localName, MultipleAttribute.SPACE_FIELD_SEPARATOR, required);
    }

    public IdentifierMultipleAttribute(final QtiNode parent, final String localName, final List<Identifier> defaultValue, final boolean required) {
        super(parent, localName, MultipleAttribute.SPACE_FIELD_SEPARATOR, defaultValue, required);
    }

    @Override
    public void validateBasic(final ValidationContext context) {
        super.validateBasic(context);

// FIXME: Re-enable this once we relax constraints on running invalid assessments
//        /* Spec recommends identifiers are not more than 32 characters */
//        if (value!=null) {
//            for (final Identifier item : value) {
//                if (item.toString().length() > 32) {
//                    context.fireAttributeValidationWarning(this, "The identifiers " + item + " is recommended to be no more than 32 characters long");
//                }
//            }
//        }
    }

    @Override
    protected Identifier parseItemValue(final String value) {
        return Identifier.parseString(value);
    }

    @Override
    protected String itemToQtiString(final Identifier item) {
        return item.toString();
    }
}
