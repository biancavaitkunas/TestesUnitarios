package exercicio_medicamentos;

import java.util.List;
import java.util.ArrayList;


import org.junit.jupiter.api.BeforeEach;

public class UtilTest {
	
	private Util util = new Util();
	
	@BeforeEach
	void init() {
		
		List<String>sintoma = new ArrayList<String>();
		sintoma.add("dor de cabeça");
		List<String>alergia = new ArrayList<String>();
		alergia.add("dorflex");
		
		Pessoa p1 = new Pessoa("Bianca", sintoma, alergia);
		util.add(p1);
		
	}

}
