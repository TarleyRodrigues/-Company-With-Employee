package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the number of employees: ");
		int num = sc.nextInt();
		List<Employee> list = new ArrayList<>();

		for (int i = 1; i <= num; i++) {
			System.out.println("Employee #" + i + " data:");
			System.out.print("Outsourced (y/n)? ");
			char c = sc.next().charAt(0);

			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();

			System.out.print("Hours: ");
			int hours = sc.nextInt();

			System.out.print("Value Per Hour: ");
			double valuePerHour = sc.nextDouble();

			if (c == 'y') {
				System.out.print("Additional charge: ");
				double additionalCharge = sc.nextDouble();
				//instanciando employee antes do list.add
				Employee employee = new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge);
				list.add(employee);

			} else {
				//melhor forma de add na list
				//add (instanciando) employee diretamente no metodo list.add
				list.add(new Employee(name, hours, valuePerHour));
			}
		}

		System.out.println("---------------------------");
		System.out.println("PAYMENTS:");
		for (Employee employee : list) {
			System.out.println(employee.getName() + " - $" + String.format("%.2f", employee.payment()));
		}

		sc.close();

	}

}
