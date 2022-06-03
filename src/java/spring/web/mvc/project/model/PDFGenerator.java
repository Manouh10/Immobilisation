/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spring.web.mvc.project.model;

 
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.io.IOException; 
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Manou Mandou
 */
public class PDFGenerator {
    // List to hold all Students
	/*private List<Carnetdebord> studentList;

    public List<Carnetdebord> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Carnetdebord> studentList) {
        this.studentList = studentList;
    }*/
    

	public PDFGenerator() {
	}

    public void generate(HttpServletResponse response) throws DocumentException, IOException {
        // Creating the Object of Document
        Document document = new Document(PageSize.A4);
        
        // Getting instance of PdfWriter
        PdfWriter.getInstance(document, response.getOutputStream());
        
        // Opening the created document to modify it
        document.open();
        
        // Creating font
        // Setting font style and size
        Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontTiltle.setSize(20);
        
        // Creating paragraph
        Paragraph paragraph = new Paragraph("BONJOUR MANOU MANDOU", fontTiltle);
        
        // Aligning the paragraph in document
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);
        
        // Adding the created paragraph in document
        document.add(paragraph);
        
        // Creating a table of 3 columns
        PdfPTable table = new PdfPTable(3);
        
        // Setting width of table, its columns and spacing
        table.setWidthPercentage(100f);
        table.setWidths(new int[] { 3, 3, 3 });
        table.setSpacingBefore(5);
        
        // Create Table Cells for table header
        PdfPCell cell = new PdfPCell();
        
        // Setting the background color and padding
        cell.setBackgroundColor(CMYKColor.DARK_GRAY);
        cell.setPadding(5);
        
        // Creating font
        // Setting font style and size
        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        font.setColor(CMYKColor.WHITE);
        
        // Adding headings in the created table cell/ header
        // Adding Cell to table
        cell.setPhrase(new Phrase("Lieu", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Motif", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Kilometrage", font));
        table.addCell(cell);
//		cell.setPhrase(new Phrase("Arrive", font));
//		table.addCell(cell);
//		cell.setPhrase(new Phrase("Du", font));
//		table.addCell(cell);
//		cell.setPhrase(new Phrase("Au", font));
//		table.addCell(cell);

// Iterating over the list of students
/*for (Carnetdebord student : studentList) {
    // Adding student name
    table.addCell(student.getLieudepart()+"-"+student.getLieufin());
    // Adding student section
    table.addCell(student.getMotif()+":"+student.getDatedepart().toString()+"-"+student.getDatefin().toString());
    table.addCell(String.valueOf(student.getKilometragedepart())+"-"+String.valueOf(student.getKilometragefin()));*/
//			table.addCell(student.getLieufin());
//			table.addCell(student.getDatedepart().toString());
//			table.addCell(student.getDatefin().toString());


document.add(table);

 
document.close();
}
 

    
}
 

