/*******************************************************************************
 * Copyright (c) 2007, 2011 David Green and others.
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

package org.eclipse.mylyn.internal.wikitext.ui.editor.preferences;

import org.eclipse.osgi.util.NLS;

/**
 * @author David Green
 */
class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.mylyn.internal.wikitext.ui.editor.preferences.messages"; //$NON-NLS-1$

	public static String CssStyleFieldEditor_1;

	public static String CssStyleFieldEditor_invalidColor;

	public static String CssStyleFieldEditor_unexpectedToken;

	public static String CssStyleFieldEditor_unsupportedRule;

	public static String EditorPreferencePage_blockModifiers;

	public static String EditorPreferencePage_introInfo;

	public static String EditorPreferencePage_phraseModifiers;

	public static String EditorPreferencePage_openInPreview;

	public static String EditorPreferencePage_openInPreviewInvalidRegEx;

	public static String EditorPreferencePage_openMode;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
