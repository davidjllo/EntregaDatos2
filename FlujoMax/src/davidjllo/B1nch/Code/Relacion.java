package davidjllo.B1nch.Code;

public class Relacion  {
	private char id1;
	private char id2;
	private int Capacidad;
	
	public Relacion(String relacion){
		id1 = relacion.charAt(0);
		
		if(relacion.charAt(1)==' '){
			id2 = relacion.charAt(2);
			Capacidad = Integer.parseInt(relacion.substring(2));
			System.out.println(id2 + " " + Capacidad);
		}
		else {
			id2 = relacion.charAt(1);
			Capacidad = Integer.parseInt(relacion.substring(1));
			System.out.println(id2 + " " + Capacidad);
		}
		
	}
	
	public int getCapacidad(){
		return Capacidad;
	}
	public char getId1(){
		return id1;
	}
	public char getId2(){
		return id2;
	}
	
}
