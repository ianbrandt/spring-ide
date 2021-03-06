/*******************************************************************************
 * Copyright (c) 2014 GoPivotal, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     GoPivotal, Inc. - initial API and implementation
 *******************************************************************************/
package org.springframework.ide.eclipse.wizard.gettingstarted.boot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ide.eclipse.wizard.gettingstarted.guides.SelectionModel;
import org.springsource.ide.eclipse.commons.livexp.core.FieldModel;
import org.springsource.ide.eclipse.commons.livexp.core.LiveVariable;
import org.springsource.ide.eclipse.commons.livexp.core.Validator;
import org.springsource.ide.eclipse.commons.livexp.ui.Ilabelable;

public class RadioGroup extends FieldModel<RadioInfo> {

	private List<RadioInfo> radios = new ArrayList<RadioInfo>();
	private RadioInfo defaultRadio;

	public RadioGroup(String name) {
		super(RadioInfo.class, name, null);
	}

	public void add(RadioInfo radioInfo) {
		this.radios.add(radioInfo);
		if (radioInfo.isCheckedInitially()) {
			defaultRadio = radioInfo;
			getVariable().setValue(radioInfo);
		}
	}

	public RadioInfo[] getRadios() {
		return radios.toArray(new RadioInfo[radios.size()]);
	}

	public RadioInfo getDefault() {
		return defaultRadio;
	}

	@Override
	public String toString() {
		return "RadioGroup("+getName()+")";
	}

	public SelectionModel<RadioInfo> getSelection() {
		return new SelectionModel<RadioInfo>(getVariable(), getValidator());
	}

	public RadioInfo getRadio(String value) {
		for (RadioInfo r : radios) {
			if (r.getValue().equals(value)) {
				return r;
			}
		}
		return null;
	}

}
