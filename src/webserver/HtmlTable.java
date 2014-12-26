package webserver;

import java.util.HashMap;

/**
 *
 * @author franko
 */
public class HtmlTable {

    private String tableHtml;
    private final HashMap<String, Integer> funciones;

    public HtmlTable(int columna, int fila, int[] datos, String operacion) {

        tableHtml = "";
        funciones = new HashMap<>();
        loadFunciones();
        generarTabla(columna, fila, datos, operacion);

    }

    public String getTableHtml() {
        return tableHtml;
    }

    private void generarTabla(int columna, int fila, int[] datos, String operacion) {
        switch (getOperacion(operacion)) {
            case 0:
                tableHtml += "<h1>Funcion no implementado</h1>";
                break;
            case 1:
                tableHtml = "<table border=2><tr><th colspan=" + columna + ">" + operacion + "</th><th>Total</th></tr>\n";
                sumar(columna, fila, datos);
                tableHtml += "</table>\n";
                break;
            case 2:
                tableHtml = "<table border=2><tr><th colspan=" + columna + ">" + operacion + "</th><th>Total</th></tr>\n";
                multiplicar(columna, fila, datos);
                tableHtml += "</table>\n";
                break;

        }
    }

    private void loadFunciones() {
        funciones.put("sumar", 1);
        funciones.put("multiplicar", 2);
    }

    private Integer getOperacion(String operacion) {

        if (funciones.get(operacion) != null) {
            return funciones.get(operacion);
        } else {
            return 0;
        }
    }

    private void sumar(int columna, int fila, int[] datos) {
        int index = 0;
        int total = 0;
        for (int i = 0; i < fila; i++) {
            tableHtml += "<tr>";
            for (int j = 0; j < columna; j++) {
                total += getNumero(datos, index);
                tableHtml += "<td>" + getNumero(datos, index) + "</td>";
                index++;
            }
            tableHtml += "<td>" + total + "</td></tr>\n";
            total = 0;
        }
    }

    private int getNumero(int[] datos, int i) {
        if (i < datos.length) {
            return datos[i];
        } else {
            return 0;
        }
    }

    private void multiplicar(int columna, int fila, int[] datos) {
        int index = 0;
        int total = 1;
        for (int i = 0; i < fila; i++) {
            tableHtml += "<tr>";
            for (int j = 0; j < columna; j++) {
                total *= getNumero(datos, index);
                tableHtml += "<td>" + getNumero(datos, index) + "</td>";
                index++;
            }
            tableHtml += "<td>" + total + "</td></tr>\n";
            total = 1;
        }
    }

}
