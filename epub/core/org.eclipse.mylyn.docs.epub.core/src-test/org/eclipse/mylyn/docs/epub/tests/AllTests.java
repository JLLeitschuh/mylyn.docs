/*******************************************************************************
 * Copyright (c) 2011-2015 Torkild U. Resheim.
 *
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Torkild U. Resheim - initial API and implementation
 *******************************************************************************/
package org.eclipse.mylyn.docs.epub.tests;

import org.eclipse.mylyn.docs.epub.tests.api.TestEPUB;
import org.eclipse.mylyn.docs.epub.tests.api.TestEPUBPublication;
import org.eclipse.mylyn.docs.epub.tests.api.TestOPSPublication;
import org.eclipse.mylyn.docs.epub.tests.api.TestPublication;
import org.eclipse.mylyn.docs.epub.tests.core.TestEPUBFileUtil;
import org.eclipse.mylyn.docs.epub.tests.core.TestEclipseTocImporter;
import org.eclipse.mylyn.docs.epub.tests.core.TestOPSValidator;
import org.eclipse.mylyn.docs.epub.tests.core.TestTOCGenerator;

import junit.framework.Test;
import junit.framework.TestSuite;

@SuppressWarnings("nls")
public class AllTests {
	public static Test suite() {
		return suite(false);
	}

	public static Test suite(boolean defaultOnly) {
		TestSuite suite = new TestSuite("Tests for org.eclipse.mylyn.docs.epub");
		// API tests
		suite.addTestSuite(TestEPUB.class);
		suite.addTestSuite(TestOPSPublication.class);
		suite.addTestSuite(TestEPUBPublication.class);
		suite.addTestSuite(TestPublication.class);
		// Core tests
		suite.addTestSuite(TestEPUBFileUtil.class);
		suite.addTestSuite(TestOPSValidator.class);
		suite.addTestSuite(TestTOCGenerator.class);
		suite.addTestSuite(TestEclipseTocImporter.class);
		// Ant tests
		//suite.addTestSuite(TestAntTask.class);
		return suite;
	}
}
