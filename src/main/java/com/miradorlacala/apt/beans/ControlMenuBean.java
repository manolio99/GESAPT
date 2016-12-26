package com.miradorlacala.apt.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.miradorlacala.apt.util.MenuOption;

@ManagedBean
@SessionScoped
public class ControlMenuBean {

	private MenuOption optionSelected = MenuOption.PRICES;

	public String changeToMenuOption(MenuOption newOption) {
		optionSelected = newOption;
		return optionSelected.url();
	}

	public String isOptionStyle(MenuOption option) {
		if (option.equals(optionSelected)) {
			return "active";
		} else {
			return "";
		}
	}

	// GETTERS & SETTERS

	public MenuOption getOptionSelected() {
		return optionSelected;
	}

	public void setOptionSelected(MenuOption optionSelected) {
		this.optionSelected = optionSelected;
	}	

}
