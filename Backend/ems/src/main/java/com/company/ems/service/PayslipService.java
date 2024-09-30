
package com.company.ems.service;

import com.company.ems.model.Employee;
import com.company.ems.model.Finance;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;

import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Service
public class PayslipService {

    public ByteArrayInputStream generatePayslip(Employee employee){
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        PdfWriter writer = new PdfWriter(out);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        document.add(new Paragraph("Payslip for " + employee.getPersonalDetails().getFullName()));
        document.add(new Paragraph("Employment Code: " + employee.getEmploymentCode()));
        // Add more details from Finance and other sections

        document.close();
        return new ByteArrayInputStream(out.toByteArray());
    }
}
