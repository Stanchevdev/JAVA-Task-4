package fmi.informatics.gui;

import javax.swing.table.AbstractTableModel;

import fmi.informatics.extending.Person;

// Създаваме клас PersonDataModel
public class PersonDataModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
	private Person[] people;

	// constructor
	public PersonDataModel(Person[] people) {
		this.people = people;
	}

	@Override
	public int getColumnCount() {
		return 8; // брой колони в таблицата
	}

	@Override
	public int getRowCount() {
		return people.length; // брой редове в таблицата
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
			case 0:
				return people[rowIndex].getName();
			case 1:
				return people[rowIndex].getFamily();
			case 2:
				return people[rowIndex].getEgn();
			case 3:
				return people[rowIndex].getAge();
			case 4:
				return people[rowIndex].getHeight();
			case 5:
				return people[rowIndex].getWeight();
			case 6:
				return people[rowIndex].getGender();
			case 7:
				return people[rowIndex].getFak();
		}
		return null;
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
			case 0:
				return "Име";
			case 1:
				return "Фамилия";
			case 2:
				return "ЕГН";
			case 3:
				return "Години";
			case 4:
				return "Височина";
			case 5:
				return "Тегло";
			case 6:
				return "Пол";
			case 7:
				return "Фак. номер";
			default:
				return super.getColumnName(column);
		}
	}
}
