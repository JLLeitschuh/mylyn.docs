/*******************************************************************************
 * Copyright (c) 2013 Tasktop Technologies and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     David Green - initial API and implementation
 *******************************************************************************/

package org.eclipse.mylyn.wikitext.parser.builder.event;

import java.util.Objects;

import org.eclipse.mylyn.wikitext.parser.DocumentBuilder;

/**
 * An {@link DocumentBuilderEvent} corresponding to {@link DocumentBuilder#endHeading()}.
 *
 * @author david.green
 * @since 3.0
 */
public class EndHeadingEvent extends DocumentBuilderEvent {

	@Override
	public void invoke(DocumentBuilder builder) {
		builder.endHeading();
	}

	@Override
	public int hashCode() {
		return Objects.hash(EndHeadingEvent.class);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof EndHeadingEvent)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "endHeading()"; //$NON-NLS-1$
	}

}
