/*******************************************************************************
 * Copyright (c) 2007, 2008 David Green and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     David Green - initial API and implementation
 *******************************************************************************/

package org.eclipse.mylyn.wikitext.asciidoc.internal.phrase;

import org.eclipse.mylyn.wikitext.parser.Attributes;
import org.eclipse.mylyn.wikitext.parser.DocumentBuilder.SpanType;
import org.eclipse.mylyn.wikitext.parser.markup.PatternBasedElement;
import org.eclipse.mylyn.wikitext.parser.markup.PatternBasedElementProcessor;

public class CssClassPhraseModifier extends PatternBasedElement {

	@Override
	protected String getPattern(int groupOffset) {
		return "(?:\\[\\.*(.+?)\\])?#(.+?)#";
	}

	@Override
	protected int getPatternGroupCount() {
		return 2;
	}

	@Override
	protected PatternBasedElementProcessor newProcessor() {
		return new PatternBasedElementProcessor() {

			@Override
			public void emit() {
				Attributes attributes = new Attributes();
				SpanType span = SpanType.SPAN;
				String cssClass = group(1);
				if (cssClass != null && !cssClass.isEmpty()) {
					attributes.setCssClass(cssClass);
				} else {
					span = SpanType.MARK;
				}
				getBuilder().beginSpan(span, attributes);
				getBuilder().characters(group(2));
				getBuilder().endSpan();
			}
		};
	}

}
