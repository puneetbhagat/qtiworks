/* Copyright (c) 2012, University of Edinburgh.
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
package uk.ac.ed.ph.jqtiplus;

import uk.ac.ed.ph.jqtiplus.node.XmlNode;
import uk.ac.ed.ph.jqtiplus.node.expression.ExpressionParent;
import uk.ac.ed.ph.jqtiplus.node.expression.operator.CustomOperator;
import uk.ac.ed.ph.jqtiplus.node.item.interaction.CustomInteraction;

import java.io.Serializable;
import java.util.Map;

/**
 * Interface for connecting QTI extensions, such as MathAssess. 
 * 
 * @author David McKain
 */
public interface JqtiExtensionPackage extends LifecycleListener, Serializable {
    
    /**
     * Returns a displayable name for this extension package.
     * <p>
     * (This may change in future if we ever have some kind of centralised
     * registry for extensions...)
     */
    String getDisplayName();

    /**
     * Return details about each namespace used by this extension, in the form
     * of a {@link Map} keyed on namespace URI.
     * <p>
     * In JQTI, it is illegal to register more than one package handling the same namespace URI.
     * <p>
     * This must not be null.
     */
    Map<String, ExtensionNamespaceInfo> getNamespaceInfoMap();

    /**
     * Instantiate and return a new {@link CustomOperator} corresponding to the given class name,
     * returning null if this package does not support the stated class.
     * 
     * @param expressionParent
     * @param operatorClassName
     */
    CustomOperator createCustomOperator(ExpressionParent expressionParent, String operatorClassName);

    /**
     * Instantiate and return a new {@link CustomInteraction} corresponding to the given class name,
     * returning null if this package does not support the stated class.
     */
    CustomInteraction createCustomInteraction(XmlNode parentObject, String interactionClassName);

}
