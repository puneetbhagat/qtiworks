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
package uk.ac.ed.ph.jqtiplus.node.expression.operator;

import uk.ac.ed.ph.jqtiplus.node.expression.AbstractExpression;
import uk.ac.ed.ph.jqtiplus.node.expression.ExpressionParent;
import uk.ac.ed.ph.jqtiplus.value.IntegerValue;
import uk.ac.ed.ph.jqtiplus.value.NullValue;
import uk.ac.ed.ph.jqtiplus.value.Value;
import uk.ac.ed.ph.jqtiplus.xperimental.control.ProcessingContext;

/**
 * The integer divide operator takes 2 sub-expressions which both have single cardinality and base-type integer.
 * The result is the single integer that corresponds to the first expression (x) divided by the second
 * expression (y) rounded down to the greatest integer (i) such that i<=(x/y).
 * If y is 0, or if either of the sub-expressions is NULL then the operator results in NULL.
 * 
 * @see uk.ac.ed.ph.jqtiplus.value.Cardinality
 * @see uk.ac.ed.ph.jqtiplus.value.BaseType
 * @author Jiri Kajaba
 */
public class IntegerDivide extends AbstractExpression {

    private static final long serialVersionUID = -411466437425460752L;

    /** Name of this class in xml schema. */
    public static final String CLASS_TAG = "integerDivide";

    /**
     * Constructs expression.
     * 
     * @param parent parent of this expression
     */
    public IntegerDivide(ExpressionParent parent) {
        super(parent);
    }

    @Override
    public String getClassTag() {
        return CLASS_TAG;
    }

    @Override
    protected Value evaluateSelf(ProcessingContext context, int depth) {
        if (isAnyChildNull(context)) {
            return NullValue.INSTANCE;
        }

        final int firstNumber = ((IntegerValue) getFirstChild().getValue(context)).intValue();
        final int secondNumber = ((IntegerValue) getSecondChild().getValue(context)).intValue();

        if (secondNumber == 0) {
            return NullValue.INSTANCE;
        }

        final int result = (int) Math.floor(firstNumber / (double) secondNumber);

        return new IntegerValue(result);
    }
}
