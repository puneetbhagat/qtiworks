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
package uk.ac.ed.ph.jqtiplus.node.block;

import uk.ac.ed.ph.jqtiplus.node.AbstractNode;
import uk.ac.ed.ph.jqtiplus.node.LoadingContext;
import uk.ac.ed.ph.jqtiplus.node.QtiNode;
import uk.ac.ed.ph.jqtiplus.node.content.basic.TextRun;
import uk.ac.ed.ph.jqtiplus.serialization.QtiSaxDocumentFirer;
import uk.ac.ed.ph.jqtiplus.validation.ValidationContext;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * FIXME: Clarify this Javadoc, cos this class doesn't do what it says!
 *
 * Container block. Contains other blocks and no text content (it can contain one or more TextBlocks).
 *
 * @author Jonathon Hare
 * @author Jiri Kajaba
 */
public abstract class ContainerBlock extends AbstractNode {

    private static final long serialVersionUID = -577148022486574797L;

    /** Children of this block. */
    private final List<QtiNode> children;

    public ContainerBlock(final QtiNode parent, final String qtiClassName) {
        super(parent, qtiClassName);

        children = new ArrayList<QtiNode>();
    }

    /**
     * Gets children of this block.
     *
     * @return children of this block
     */
    public List<QtiNode> getChildren() {
        return children;
    }

    @Override
    protected void loadChildren(final Element element, final LoadingContext context) {
        children.clear();

        final NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            final Node node = nodes.item(i);
            final short nodeType = node.getNodeType();
            if (nodeType == Node.ELEMENT_NODE || nodeType == Node.TEXT_NODE) {
                readChildNode(node, context);
            }
        }
    }

    private void readChildNode(final Node node, final LoadingContext context) {
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            final ForeignElement foreignElement = new ForeignElement(this, node.getLocalName(), node.getNamespaceURI());
            children.add(foreignElement);
            foreignElement.load((Element) node, context);
        }
        else if (node.getNodeType() == Node.TEXT_NODE) {
            final String textContent = node.getTextContent().trim();
            if (textContent.length() > 0) {
                final TextRun textRun = new TextRun(this, textContent);
                children.add(textRun);
            }
        }
    }

    @Override
    protected void fireBodySaxEvents(final QtiSaxDocumentFirer qtiSaxDocumentFirer) throws SAXException {
        for (final QtiNode childNode : children) {
            childNode.fireSaxEvents(qtiSaxDocumentFirer);
        }
    }

    @Override
    protected void validateChildren(final ValidationContext context) {
        for (final QtiNode child : children) {
            child.validate(context);
        }
    }
}
