package projetoPoo.main;

import projetoPoo.controller.*;
import projetoPoo.models.Oficina;

public class Program {
	public static void main(String[] args) {
		var oficina = new Oficina();
		var controller = new Controller(oficina);
		controller.Run();
	}
}
