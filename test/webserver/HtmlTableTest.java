package webserver;

import org.junit.Test;
import static org.junit.Assert.*;

public class HtmlTableTest {

    @Test
    public void noExisteFuncion() {
        int columna = 3;
        int fila = 2;
        String operacion = "restar";
        int datos[] = {5, 7, 2, 3, 4, 6};
        HtmlTable tabla = new HtmlTable(columna, fila, datos, operacion);
        String esperado = "<h1>Funcion no implementado</h1>";
        assertEquals(esperado, tabla.getTableHtml());
    }

    @Test
    public void sumarTablaNxM() {
        int columna = 3;
        int fila = 2;
        String operacion = "sumar";
        int datos[] = {5, 7, 2, 3, 4, 6};
        HtmlTable tabla = new HtmlTable(columna, fila, datos, operacion);
        String esperado = "<table border=2><tr><th colspan=3>sumar</th><th>Total</th></tr>\n"
                + "<tr><td>5</td><td>7</td><td>2</td><td>14</td></tr>\n"
                + "<tr><td>3</td><td>4</td><td>6</td><td>13</td></tr>\n"
                + "</table>\n";

        assertEquals(esperado, tabla.getTableHtml());
        //assertTrue(esperado.equals(tabla.getTableHtml()));
    }

    @Test
    public void sumarTablaNxM2() {
        int columna = 4;
        int fila = 2;
        String operacion = "sumar";
        int datos[] = {5, 7, 2, 3, 4, 6};
        HtmlTable tabla = new HtmlTable(columna, fila, datos, operacion);
        String esperado = "<table border=2><tr><th colspan=4>sumar</th><th>Total</th></tr>\n"
                + "<tr><td>5</td><td>7</td><td>2</td><td>3</td><td>17</td></tr>\n"
                + "<tr><td>4</td><td>6</td><td>0</td><td>0</td><td>10</td></tr>\n"
                + "</table>\n";
        assertEquals(esperado, tabla.getTableHtml());
    }

    @Test
    public void sumarTablaNxN() {
        int columna = 3;
        int fila = 3;
        String operacion = "sumar";
        int datos[] = {5, 7, 2, 3, 4, 6, 7, 6, 5};
        HtmlTable tabla = new HtmlTable(columna, fila, datos, operacion);
        String esperado = "<table border=2><tr><th colspan=3>sumar</th><th>Total</th></tr>\n"
                + "<tr><td>5</td><td>7</td><td>2</td><td>14</td></tr>\n"
                + "<tr><td>3</td><td>4</td><td>6</td><td>13</td></tr>\n"
                + "<tr><td>7</td><td>6</td><td>5</td><td>18</td></tr>\n"
                + "</table>\n";
        assertEquals(esperado, tabla.getTableHtml());
    }

    @Test
    public void sumarTablaNxN2() {
        int columna = 3;
        int fila = 3;
        String operacion = "sumar";
        int datos[] = {5, 7, 2, 3, 4, 6, 7, 6};
        HtmlTable tabla = new HtmlTable(columna, fila, datos, operacion);
        String esperado = "<table border=2><tr><th colspan=3>sumar</th><th>Total</th></tr>\n"
                + "<tr><td>5</td><td>7</td><td>2</td><td>14</td></tr>\n"
                + "<tr><td>3</td><td>4</td><td>6</td><td>13</td></tr>\n"
                + "<tr><td>7</td><td>6</td><td>0</td><td>13</td></tr>\n"
                + "</table>\n";
        assertEquals(esperado, tabla.getTableHtml());
    }

    @Test
    public void sumarTablaSinDatos() {
        int columna = 3;
        int fila = 3;
        String operacion = "sumar";
        int datos[] = {};
        HtmlTable tabla = new HtmlTable(columna, fila, datos, operacion);
        String esperado = "<table border=2><tr><th colspan=3>sumar</th><th>Total</th></tr>\n"
                + "<tr><td>0</td><td>0</td><td>0</td><td>0</td></tr>\n"
                + "<tr><td>0</td><td>0</td><td>0</td><td>0</td></tr>\n"
                + "<tr><td>0</td><td>0</td><td>0</td><td>0</td></tr>\n"
                + "</table>\n";
        assertEquals(esperado, tabla.getTableHtml());
    }

    @Test
    public void multiplicarTablaNxN() {
        int columna = 2;
        int fila = 2;
        String operacion = "multiplicar";
        int datos[] = {5, 7, 2, 3, 4, 6};
        HtmlTable tabla = new HtmlTable(columna, fila, datos, operacion);
        String esperado = "<table border=2><tr><th colspan=2>multiplicar</th><th>Total</th></tr>\n"
                + "<tr><td>5</td><td>7</td><td>35</td></tr>\n"
                + "<tr><td>2</td><td>3</td><td>6</td></tr>\n"
                + "</table>\n";
        assertEquals(esperado, tabla.getTableHtml());
        //assertTrue(esperado.equals(tabla.getTableHtml()));
    }

    @Test
    public void multiplicarTablaNxM() {
        int columna = 3;
        int fila = 2;
        String operacion = "multiplicar";
        int datos[] = {5, 7, 2, 3, 4, 6};
        HtmlTable tabla = new HtmlTable(columna, fila, datos, operacion);
        String esperado = "<table border=2><tr><th colspan=3>multiplicar</th><th>Total</th></tr>\n"
                + "<tr><td>5</td><td>7</td><td>2</td><td>70</td></tr>\n"
                + "<tr><td>3</td><td>4</td><td>6</td><td>72</td></tr>\n"
                + "</table>\n";
        assertEquals(esperado, tabla.getTableHtml());
        //assertTrue(esperado.equals(tabla.getTableHtml()));
    }
}
