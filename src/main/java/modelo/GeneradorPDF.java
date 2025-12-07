package modelo;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JTable;

public class GeneradorPDF {

    /**
     * Genera un PDF con los datos de una JTable
     *
     * @param rutaArchivo Ruta completa donde se guardará el PDF
     * @param tabla JTable con los datos a exportar
     * @param titulo Título del documento
     * @param descripcion Descripción breve del reporte
     * @return true si se generó correctamente, false en caso contrario
     */
    public boolean generarPDFTabla(String rutaArchivo, JTable tabla, String titulo, String descripcion) {
        try {
            // Crear el escritor y documento PDF
            PdfWriter writer = new PdfWriter(rutaArchivo);
            PdfDocument pdf = new PdfDocument(writer);

            // Configurar página en orientación HORIZONTAL (landscape) para más espacio
            pdf.setDefaultPageSize(com.itextpdf.kernel.geom.PageSize.A4.rotate());

            Document document = new Document(pdf);

            // Reducir márgenes para aprovechar más espacio
            document.setMargins(30, 20, 30, 20);

            // Configurar fuente en negrita para títulos
            PdfFont fontBold = PdfFontFactory.createFont(com.itextpdf.io.font.constants.StandardFonts.HELVETICA_BOLD);
            PdfFont fontRegular = PdfFontFactory.createFont(com.itextpdf.io.font.constants.StandardFonts.HELVETICA);

            // ==================== TÍTULO ====================
            Paragraph tituloParrafo = new Paragraph(titulo)
                    .setFont(fontBold)
                    .setFontSize(18)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setMarginBottom(10);
            document.add(tituloParrafo);

            // ==================== DESCRIPCIÓN ====================
            Paragraph descripcionParrafo = new Paragraph(descripcion)
                    .setFont(fontRegular)
                    .setFontSize(12)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setMarginBottom(20);
            document.add(descripcionParrafo);

            // ==================== TABLA ====================
            // Obtener número de columnas
            int numColumnas = tabla.getColumnCount();

            // Crear arreglo de anchos relativos basados en el contenido
            float[] anchosColumnas = new float[numColumnas];

            // Calcular ancho aproximado por columna según contenido
            for (int col = 0; col < numColumnas; col++) {
                int maxLength = tabla.getColumnName(col).length(); // Longitud del encabezado

                // Revisar el contenido de cada fila para encontrar el texto más largo
                for (int fila = 0; fila < tabla.getRowCount(); fila++) {
                    Object valor = tabla.getValueAt(fila, col);
                    if (valor != null) {
                        int length = valor.toString().length();
                        if (length > maxLength) {
                            maxLength = length;
                        }
                    }
                }

                // Asignar peso relativo (mínimo 1, para evitar columnas muy pequeñas)
                anchosColumnas[col] = Math.max(1, maxLength);
            }

            // Crear tabla con anchos proporcionales al contenido
            Table pdfTable = new Table(UnitValue.createPercentArray(anchosColumnas))
                    .useAllAvailableWidth();

            // ===== ENCABEZADOS DE LA TABLA =====
            // Color personalizado RGB(50, 130, 181)
            com.itextpdf.kernel.colors.DeviceRgb colorEncabezado
                    = new com.itextpdf.kernel.colors.DeviceRgb(50, 130, 181);

            for (int i = 0; i < numColumnas; i++) {
                Cell headerCell = new Cell()
                        .add(new Paragraph(tabla.getColumnName(i)))
                        .setFont(fontBold)
                        .setFontSize(10)
                        .setFontColor(ColorConstants.WHITE)
                        .setBackgroundColor(colorEncabezado)
                        .setTextAlignment(TextAlignment.CENTER)
                        .setPadding(5);
                pdfTable.addHeaderCell(headerCell);
            }

            // ===== FILAS DE DATOS =====
            for (int fila = 0; fila < tabla.getRowCount(); fila++) {
                for (int col = 0; col < numColumnas; col++) {
                    Object valor = tabla.getValueAt(fila, col);
                    String texto = (valor != null) ? valor.toString() : "";

                    Cell dataCell = new Cell()
                            .add(new Paragraph(texto))
                            .setFont(fontRegular)
                            .setFontSize(9)
                            .setTextAlignment(TextAlignment.CENTER)
                            .setPadding(5);
                    pdfTable.addCell(dataCell);
                }
            }

            document.add(pdfTable);

            // ==================== FECHA ====================
            // Obtener fecha actual en formato personalizado
            SimpleDateFormat formatoFecha = new SimpleDateFormat("EEEE d 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
            String fechaActual = formatoFecha.format(new Date());

            // Capitalizar primera letra del día
            fechaActual = fechaActual.substring(0, 1).toUpperCase() + fechaActual.substring(1);

            Paragraph fechaParrafo = new Paragraph(fechaActual)
                    .setFont(fontRegular)
                    .setFontSize(11)
                    .setTextAlignment(TextAlignment.RIGHT)
                    .setMarginTop(20);
            document.add(fechaParrafo);

            // Cerrar documento
            document.close();
            return true;

        } catch (FileNotFoundException e) {
            System.err.println("Error: No se pudo crear el archivo en la ruta especificada.");
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            System.err.println("Error al generar el PDF: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
