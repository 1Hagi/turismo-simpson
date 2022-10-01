package model;

import java.util.List;

public class PromoPorcentual extends Promocion {

	private Integer descuento;

	public PromoPorcentual(String nombre, String imagen_ruta, Integer id, OfertaTipo tipo, List<Excursion> excursiones, Integer descuento) {
		super(nombre, imagen_ruta, id, tipo, excursiones);
		this.descuento = descuento;
	}

	public Double getCosto() {
		Double costoTotal = 0.0;
		for (Oferta e : excursiones) {
			costoTotal += e.getCosto();
		}
		return costoTotal * descuento / 100;
	}

	@Override
	public String toString() {
		return "Promocion Porcentual: '" + this.nombre + "' incluye las excursiones:" + super.mostrarExcursiones()
				+ "\nPorcentaje de descuento: " + this.descuento + " %\n\tTiempo total necesario: " + this.getTiempo()
				+ " min.\n\tCosto en dinero total: $ " + this.getCosto();
	}
}