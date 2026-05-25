package ejemploConGit;

import java.util.Scanner;
import java.util.Random;

public class Preguntate {

	public static void main(String[] args) {
		//Creacion de Random y Scanner
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		
		//Creacion de variables
		int numeroPregunta = 0, cantPreg = 0, cantPregRes = 0, salir = 0, puntaje = 0, cantUsadas = 0;
		char traerResp;
		String preguntaMasRespuesta;
		boolean resp;
		// Vector para almacenar las preguntas usadas, en este caso 10
		int[] preguntasUsadas = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
		

		//Mensajoe de presentacion
		System.out.println("==============================================");
		System.out.println("-----------Bienvenidos a Logicamente----------");
		System.out.println("==============================================");
		System.out.println("");
		System.out.println("");
		System.out.println("===============================================");
		System.out.println(" El juego cuenta con 10 preguntas sobre logica");
		System.out.println("===============================================");
		System.out.println("");

		//Comienzo de juego, bucle "do" "while".
		do {
			System.out.print("Ingresa cuantas preguntas quieres responder: ");
			cantPreg = sc.nextInt();

			//Control de cantidad de preguntas ingresadas
			if (cantPreg > 0 && cantPreg < 11) {

				cantPregRes = cantPreg;
				
				//Si son mas de 1 preguntas
				if (cantPreg > 1) {
					System.out.println("");
					System.out.println("-----Bien, responde estas " + cantPreg + " preguntas !!!-----");
					System.out.println("");
					//Si es solo una pregunta
				} else {
					System.out.println("");
					System.out.println("-----Bien, responde esta pregunta !!!-----");
					System.out.println("");
				}
				//Comienzo de bucle "do" "while", control de preguntas.
				do {
					//Comienzo de bucle "do" "while", generar numnero que no esté en las preguntas ya usadas
					do {
						numeroPregunta = rd.nextInt(10);
					} while (estaEnVector(preguntasUsadas, numeroPregunta, cantUsadas));

					// Guardar la pregunta usada en el vector
					preguntasUsadas[cantUsadas] = numeroPregunta;
					cantUsadas++;

					preguntaMasRespuesta = pedirPregunta(numeroPregunta);

					System.out.println("");
					System.out.println("Responde:\n\t" + preguntaMasRespuesta);
					System.out.println("");
					System.out.println("");

					traerResp = sc.next().charAt(0);
					resp = pedirRespuesta(numeroPregunta, traerResp);
					//Control, respuesta correcta
					if (resp) {
						System.out.println("¡Correcto!");
						puntaje++;
					} else {
						System.out.println("Incorrecto.");
					}

                    cantPregRes--;

				} while (cantPregRes > 0);

			} else {
				System.out.println();
				System.out.println("El numero debe ser entre 1 y 10");
				System.out.println();
				salir++;
			}

		} while ((cantPreg < 1 || cantPreg > 10) && salir < 3);

		System.out.println("");
		System.out.println("========================================");
		System.out.println("Juego terminado!");
		System.out.println("Correctas:   " + puntaje + " / " + cantPreg);
		System.out.println("Incorrectas: " + (cantPreg - puntaje) + " / " + cantPreg);
		System.out.println("========================================");

		sc.close();
	}

	// Método para verificar si un número ya está en el vector (usando do-while)
	public static boolean estaEnVector(int[] pregUsadas, int numeroPreg, int cantUs) {
		//Si la cantidad de preguntas usadas es 0 devuelve falso y continua sin entrar al bucle
		if (cantUs == 0)
			return false;
		//Variables de entorno
		boolean encontrado = false;
		int i = 0;
		do {//controla si el numero de pregunta es igual al numero que se encuentra en la pocicion i (comenzando en 0) por defecto viene el vector con la lista de 10 -1
			if (pregUsadas[i] == numeroPreg)
				//si entra devuelve true, por lo que la pregunta fue utilizada, en este caso se genera una nueva pregunta
				encontrado = true;
			//si no se encuentra se aumenta el numero de control para recorrer todo el vector.
			i++;
			//sale del while cuando la cantidad de preg usadas es mayor que i y encpntrado es diferente de verdadero
		} while (i < cantUs && !encontrado);
		return encontrado;
	}

	public static String pedirPregunta(int numPregunta) {

		String pregunta;

		switch (numPregunta) {

			case 0:
				pregunta = "1. ¿Cuál de los siguientes NO es un conectivo lógico?\n"
						+ "\n"
						+ "A) Conjunción\n"
						+ "B) Disyunción\n"
						+ "C) Multiplicación\n"
						+ "D) Negación";
				break;
			case 1:
				pregunta = "2. ¿Qué característica debe tener una proposición?\n"
						+ "\n"
						+ "A) Debe ser una pregunta\n"
						+ "B) Debe transmitir información y poder ser verdadera o falsa\n"
						+ "C) Debe contener símbolos matemáticos\n"
						+ "D) Debe tener dos conectivos";
				break;
			case 2:
				pregunta = "3. ¿Qué representa el símbolo ¬?\n"
						+ "\n"
						+ "A) Bicondicional\n"
						+ "B) Condicional\n"
						+ "C) Negación\n"
						+ "D) Disyunción";
				break;
			case 3:
				pregunta = "4. Un argumento es lógicamente válido cuando:\n"
						+ "\n"
						+ "A) Tiene muchas premisas\n"
						+ "B) La conclusión es larga\n"
						+ "C) Si las premisas son verdaderas, la conclusión necesariamente también lo es\n"
						+ "D) Todas las premisas son falsas";
				break;
			case 4:
				pregunta = "5. ¿Cuál de las siguientes expresiones representa una conjunción?\n"
						+ "\n"
						+ "A) p → q\n"
						+ "B) p ∨ q\n"
						+ "C) p ∧ q\n"
						+ "D) ¬p";
				break;
			case 5:
				pregunta = "6. Una fórmula atómica se representa mediante:\n"
						+ "\n"
						+ "A) Una ecuación\n"
						+ "B) Una letra proposicional\n"
						+ "C) Un número natural\n"
						+ "D) Un árbol lógico";
				break;
			case 6:
				pregunta = "7. ¿Cuál de las siguientes afirmaciones describe mejor un argumento sólido?\n"
						+ "\n"
						+ "A) Tiene premisas falsas\n"
						+ "B) Tiene una conclusión extensa\n"
						+ "C) Es válido y posee premisas verdaderas\n"
						+ "D) Utiliza muchos conectivos";
				break;
			case 7:
				pregunta = "8. Según las reglas semánticas, una disyunción p∨q es falsa:\n"
						+ "\n"
						+ "A) Cuando ambas proposiciones son verdaderas\n"
						+ "B) Cuando una es verdadera y otra falsa\n"
						+ "C) Solo cuando ambas son falsas\n"
						+ "D) Siempre";
				break;
			case 8:
				pregunta = "9. ¿Cuál es el símbolo del bicondicional?\n"
						+ "\n"
						+ "A) →\n"
						+ "B) ∧\n"
						+ "C) ↔\n"
						+ "D) ¬";
				break;
			case 9:
				pregunta = "10. Una fórmula es una tautología cuando:\n"
						+ "\n"
						+ "A) Es verdadera en algunas interpretaciones\n"
						+ "B) Es falsa en todas las interpretaciones\n"
						+ "C) Es verdadera en todas las interpretaciones\n"
						+ "D) Tiene solo una letra proposicional";
				break;

			default:
				pregunta = "A ocurrido un error";
				break;
		}

		return pregunta;
	}

	public static boolean pedirRespuesta(int nPregunta, char resp) {
		boolean respuesta = false;

		switch (nPregunta) {

			case 0:
				if (resp == 'C')
					respuesta = true;
				break;
			case 1:
				if (resp == 'B')
					respuesta = true;
				break;
			case 2:
				if (resp == 'C')
					respuesta = true;
				break;
			case 3:
				if (resp == 'C')
					respuesta = true;
				break;
			case 4:
				if (resp == 'C')
					respuesta = true;
				break;
			case 5:
				if (resp == 'B')
					respuesta = true;
				break;
			case 6:
				if (resp == 'C')
					respuesta = true;
				break;
			case 7:
				if (resp == 'C')
					respuesta = true;
				break;
			case 8:
				if (resp == 'C')
					respuesta = true;
				break;
			case 9:
				if (resp == 'C')
					respuesta = true;
				break;

			default:
				System.out.println("Error al obtener respuesta");
				break;
		}
		return respuesta;
	}

}


