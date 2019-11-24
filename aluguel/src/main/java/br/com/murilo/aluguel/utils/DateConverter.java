package br.com.murilo.aluguel.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateConverter {

	public static Date convert(String data, String formato) {
		DateFormat df = new SimpleDateFormat(formato);
		try {
			return df.parse(data);
		} catch (ParseException e) {
			throw new IllegalStateException("Não foi possivel converter!");
		}
	}

	public static String convert(Date data, String formato) {
		DateFormat df = new SimpleDateFormat(formato);
		return df.format(data);

	}

	public static LocalDate convert(Date data) {
		return new java.sql.Date(data.getTime()).toLocalDate();
	}

	public static Date convert(LocalDate data) {
		return Date.from(data.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}
}
