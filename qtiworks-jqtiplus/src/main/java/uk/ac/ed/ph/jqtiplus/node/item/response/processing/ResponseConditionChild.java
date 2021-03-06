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
package uk.ac.ed.ph.jqtiplus.node.item.response.processing;

import uk.ac.ed.ph.jqtiplus.exception.QtiProcessingInterrupt;
import uk.ac.ed.ph.jqtiplus.group.item.response.processing.ResponseRuleGroup;
import uk.ac.ed.ph.jqtiplus.node.AbstractNode;
import uk.ac.ed.ph.jqtiplus.running.ItemProcessingContext;
import uk.ac.ed.ph.jqtiplus.validation.ValidationContext;

import java.util.List;

/**
 * Abstract parent for all responseCondition children (IF, ELSE-IF, ELSE).
 *
 * @author Jonathon Hare
 */
public abstract class ResponseConditionChild extends AbstractNode {

    private static final long serialVersionUID = 8746091136302901859L;

    public ResponseConditionChild(final ResponseCondition parent, final String qtiClassName) {
        super(parent, qtiClassName);

        getNodeGroups().add(new ResponseRuleGroup(this));
    }

    public List<ResponseRule> getResponseRules() {
        return getNodeGroups().getResponseRuleGroup().getResponseRules();
    }

    @Override
    protected void validateThis(final ValidationContext context) {
        if (getResponseRules().size() == 0) {
            context.fireValidationWarning(this, "Node " + getQtiClassName() + " should contain some rules.");
        }
    }

    /**
     * Evaluates all child responseRules and returns true.
     *
     * @return true
     * @throws QtiProcessingInterrupt
     */
    public boolean evaluate(final ItemProcessingContext context) throws QtiProcessingInterrupt {
        for (final ResponseRule responseRule : getResponseRules()) {
            responseRule.evaluate(context);
        }

        return true;
    }
}
