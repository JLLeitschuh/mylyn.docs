/*******************************************************************************
 * Copyright (c) 2007, 2009 David Green and others.
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
package org.eclipse.mylyn.wikitext.ui.viewer;

import org.eclipse.jface.preference.IPreferenceStore;

/**
 * A configuration to be used with a {@link MarkupViewer}
 * 
 * @author David Green
 * @since 1.0
 */
public class MarkupViewerConfiguration extends HtmlViewerConfiguration {

	public MarkupViewerConfiguration(MarkupViewer viewer, IPreferenceStore preferenceStore) {
		super(viewer, preferenceStore);
	}

	public MarkupViewerConfiguration(MarkupViewer viewer) {
		super(viewer);
	}

}
