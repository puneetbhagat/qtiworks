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
package uk.ac.ed.ph.qtiworks.services.domain;

import uk.ac.ed.ph.qtiworks.domain.entities.ItemDeliverySettings;

import uk.ac.ed.ph.jqtiplus.node.AssessmentObjectType;

/**
 * Template for creating/editing an {@link ItemDeliverySettings} entity
 *
 * @author David McKain
 */
public final class ItemDeliverySettingsTemplate extends DeliverySettingsTemplate {

    private int maxAttempts;
    private boolean allowClose;
    private boolean allowResetWhenInteracting;
    private boolean allowResetWhenClosed;
    private boolean allowReinitWhenInteracting;
    private boolean allowReinitWhenClosed;
    private boolean allowSolutionWhenInteracting;
    private boolean allowSolutionWhenClosed;
    private boolean allowSource;
    private boolean allowResult;

    //------------------------------------------------------------

    public ItemDeliverySettingsTemplate() {
        super(AssessmentObjectType.ASSESSMENT_ITEM);
    }

    //------------------------------------------------------------



    public Integer getMaxAttempts() {
        return maxAttempts;
    }

    public void setMaxAttempts(final Integer maxAttempts) {
        this.maxAttempts = maxAttempts;
    }


    public boolean isAllowClose() {
        return allowClose;
    }

    public void setAllowClose(final boolean allowClose) {
        this.allowClose = allowClose;
    }


    public boolean isAllowSource() {
        return allowSource;
    }

    public void setAllowSource(final boolean allowSource) {
        this.allowSource = allowSource;
    }


    public boolean isAllowResult() {
        return allowResult;
    }

    public void setAllowResult(final boolean allowResult) {
        this.allowResult = allowResult;
    }


    public boolean isAllowResetWhenInteracting() {
        return allowResetWhenInteracting;
    }

    public void setAllowResetWhenInteracting(final boolean allowReset) {
        this.allowResetWhenInteracting = allowReset;
    }


    public boolean isAllowResetWhenClosed() {
        return allowResetWhenClosed;
    }

    public void setAllowResetWhenClosed(final boolean allowReset) {
        this.allowResetWhenClosed = allowReset;
    }


    public boolean isAllowReinitWhenInteracting() {
        return allowReinitWhenInteracting;
    }

    public void setAllowReinitWhenInteracting(final boolean allowReinit) {
        this.allowReinitWhenInteracting = allowReinit;
    }


    public boolean isAllowReinitWhenClosed() {
        return allowReinitWhenClosed;
    }

    public void setAllowReinitWhenClosed(final boolean allowReinitWhenClosed) {
        this.allowReinitWhenClosed = allowReinitWhenClosed;
    }


    public boolean isAllowSolutionWhenInteracting() {
        return allowSolutionWhenInteracting;
    }

    public void setAllowSolutionWhenInteracting(final boolean allowSolution) {
        this.allowSolutionWhenInteracting = allowSolution;
    }


    public boolean isAllowSolutionWhenClosed() {
        return allowSolutionWhenClosed;
    }

    public void setAllowSolutionWhenClosed(final boolean allowSolutionWhenClosed) {
        this.allowSolutionWhenClosed = allowSolutionWhenClosed;
    }
}
