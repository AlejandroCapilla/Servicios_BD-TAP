package com.example.servicios_bdtap.PDFreports;

import com.example.servicios_bdtap.modelosReportes.*;
import com.example.servicios_bdtap.models.MySQLConnection;
import com.example.servicios_bdtap.models.daos.ConsultasDAO;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

public class PDFreports {
    ConsultasDAO consultasDAO = new ConsultasDAO(MySQLConnection.getConnection());

    Stage anterior;
    Color v_font = new DeviceRgb(0, 0, 0);
    Color v_header = new DeviceRgb(34, 219, 240);
    Color v_background = new DeviceRgb(175, 242, 250);
    Color v_font2 = new DeviceRgb(0, 0, 0);
    Color v_fontwhite = new DeviceRgb(255, 255, 255);
    Color v_header2 = new DeviceRgb(163, 162, 162);
    Color v_background2 = new DeviceRgb(247, 247, 247);
    Color font3 = new DeviceRgb();
    Color header3 = new DeviceRgb(77, 0, 110);
    Color Background3 = new DeviceRgb(152, 0, 217);
    Color header4 = new DeviceRgb(255, 255, 255);
    Color background4 = new DeviceRgb(0, 0, 0);
    public static final String DEST1 = "Reportes/ReportePorCompañia/compañias_report.pdf";
    public static final String DEST2 = "Reportes/ReporteDeRecargas/recargas_report.pdf";
    public static final String DEST3 = "Reportes/ReportePorServicio/servicio_report.pdf";
    public static final String DEST4 = "Reportes/ReporteDeServicios/servicios_report.pdf";
    public static final String DEST5 = "Tickets/TicketsRecargas/ticket_Recarga.pdf";
    public static final String DEST6 = "Tickets/TicketsServicios/ticket_Servicio.pdf";

    @FXML
    Button btnReporDCom, btnReporPCom, btnReporDSer, btnReporPSer, rbt_PagoSer, rbt_Recarga;

    public PDFreports() {
    }

    public void initialize(URL location, ResourceBundle resources) {

    }

    public void m_ReporPCom(){
        File file1;
        file1 = new File("Reportes/ReportePorCompañia/compañias_report.pdf");
        file1.getParentFile().mkdirs();
        try {
            PDFreports.this.createPdfPorCompanias("Reportes/ReportePorCompañia/compañias_report.pdf");
            PDFreports.this.sendMessage("Reported succesfull", "File: Reportes/ReportePorCompañia/compañias_report.pdfgenerated...");
            PDFreports.this.openPdfFile("Reportes/ReportePorCompañia/compañias_report.pdf");
        } catch (IOException e) {
            e.printStackTrace();
            PDFreports.this.sendMessage("Reported Error", "File: Reportes/ReportePorCompañia/compañias_report.pdfnotgenerated...");
        }
    }

    public void m_ReporDCom(){
        File file2;
        file2 = new File("Reportes/ReporteDeRecargas/recargas_report.pdff");
        file2.getParentFile().mkdirs();
        try {
            PDFreports.this.createPdfDeRecargas("Reportes/ReporteDeRecargas/recargas_report.pdf");
            PDFreports.this.sendMessage("Reported succesfull", "File: Reportes/ReporteDeRecargas/recargas_report.pdfgenerated...");
            PDFreports.this.openPdfFile("Reportes/ReporteDeRecargas/recargas_report.pdf");
        } catch (IOException e) {
            e.printStackTrace();
            PDFreports.this.sendMessage("Reported Error", "File: Reportes/ReporteDeRecargas/recargas_report.pdf.pdfnotgenerated...");
        }
    }

    public void m_ReporPServ(){
        File file3;
        file3 = new File("Reportes/ReportePorServicio/servicio_report.pdf");
        boolean mkdirs = file3.getParentFile().mkdirs();
        try {
            PDFreports.this.createPdfPorServicios("Reportes/ReportePorServicio/servicio_report.pdf");
        } catch (IOException e) {
            e.printStackTrace();
        }
        PDFreports.this.sendMessage("Reported succesfull", "File: Reportes/ReportePorServicio/servicio_report.pdfgenerated...");
        PDFreports.this.openPdfFile("Reportes/ReportePorServicio/servicio_report.pdf");
    }

    public void m_ReporDServ(){
        File file4;
        file4 = new File("Reportes/ReporteDeServicios/servicios_report.pdf");
        file4.getParentFile().mkdirs();
        try {
            PDFreports.this.createPdfDeServicios("Reportes/ReporteDeServicios/servicios_report.pdf");
        } catch (IOException e) {
            e.printStackTrace();
        }
        PDFreports.this.sendMessage("Reported succesfull", "Reportes/ReporteDeServicios/servicios_report.pdfgenerated...");
        PDFreports.this.openPdfFile("Reportes/ReporteDeServicios/servicios_report.pdf");
    }

    public void m_TicketRecarga(String cveRec){
        File file5;
        file5 = new File("Tickets/TicketsRecargas/ticket_Recarga.pdf");
        file5.getParentFile().mkdirs();

        try {
            PDFreports.this.createPdfTicketRecargas("Tickets/TicketsRecargas/ticket_Recarga.pdf", cveRec);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PDFreports.this.sendMessage("Reported succesfull", "Tickets/TicketsRecargas/ticket_Recarga.pdfgenerated...");
        PDFreports.this.openPdfFile("Tickets/TicketsRecargas/ticket_Recarga.pdf");
    }

    public void m_TicketServicio(String a_cvePServ){
        File file6;
        file6 = new File("Tickets/TicketsServicios/ticket_Servicio.pdf");
        file6.getParentFile().mkdirs();

        try {
            PDFreports.this.createPdfTicketServicios("Tickets/TicketsServicios/ticket_Servicio.pdf", a_cvePServ);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PDFreports.this.sendMessage("Reported succesfull", "Tickets/TicketsServicios/ticket_Servicio.pdfgenerated...");
        PDFreports.this.openPdfFile("Tickets/TicketsServicios/ticket_Servicio.pdf");
    }

    public void initButtons(Button btnReporDSer, Button btnReporPSer, Button btnReporPCom, Button btnReporDCom) {
        this.btnReporPCom.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                File file1;
                file1 = new File("Reportes/ReportePorCompañia/compañias_report.pdf");
                file1.getParentFile().mkdirs();
                try {
                    PDFreports.this.createPdfDeServicios("Reportes/ReportePorCompañia/compañias_report.pdf");
                    PDFreports.this.sendMessage("Reported succesfull", "File: Reportes/ReportePorCompañia/compañias_report.pdfgenerated...");
                    PDFreports.this.openPdfFile("Reportes/ReportePorCompañia/compañias_report.pdf");
                } catch (IOException e) {
                    e.printStackTrace();
                    PDFreports.this.sendMessage("Reported Error", "File: Reportes/ReportePorCompañia/compañias_report.pdfnotgenerated...");
                }
            }
        });
//

        this.btnReporDCom.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                File file2;
                file2 = new File("Reportes/ReporteDeRecargas/recargas_report.pdff");
                file2.getParentFile().mkdirs();
                try {
                    PDFreports.this.createPdfDeRecargas("Reportes/ReporteDeRecargas/recargas_report.pdf");
                    PDFreports.this.sendMessage("Reported succesfull", "File: Reportes/ReporteDeRecargas/recargas_report.pdfgenerated...");
                    PDFreports.this.openPdfFile("Reportes/ReporteDeRecargas/recargas_report.pdf");
                } catch (IOException e) {
                    e.printStackTrace();
                    PDFreports.this.sendMessage("Reported Error", "File: Reportes/ReporteDeRecargas/recargas_report.pdf.pdfnotgenerated...");
                }
            }
        });
//
        this.btnReporPSer.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                File file3;
                file3 = new File("Reportes/ReportePorServicio/servicio_report.pdf");
                boolean mkdirs = file3.getParentFile().mkdirs();
                try {
                    PDFreports.this.createPdfPorServicios("Reportes/ReportePorServicio/servicio_report.pdf");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                PDFreports.this.sendMessage("Reported succesfull", "File: Reportes/ReportePorServicio/servicio_report.pdfgenerated...");
                PDFreports.this.openPdfFile("Reportes/ReportePorServicio/servicio_report.pdf");
            }
        });

        //
        this.btnReporDSer.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                File file4;
                file4 = new File("Reportes/ReporteDeServicios/servicios_report.pdf");
                file4.getParentFile().mkdirs();
                try {
                    PDFreports.this.createPdfPorCompanias("Reportes/ReporteDeServicios/servicios_report.pdf");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                PDFreports.this.sendMessage("Reported succesfull", "Reportes/ReporteDeServicios/servicios_report.pdfgenerated...");
                PDFreports.this.openPdfFile("Reportes/ReporteDeServicios/servicios_report.pdf");
            }
        });
//
        this.rbt_Recarga.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                File file5;
                file5 = new File("Tickets/TicketsRecargas/ticket_Recarga.pdf");
                file5.getParentFile().mkdirs();

                try {
                    PDFreports.this.createPdfPorCompanias("Tickets/TicketsRecargas/ticket_Recarga.pdf");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                PDFreports.this.sendMessage("Reported succesfull", "Tickets/TicketsRecargas/ticket_Recarga.pdfgenerated...");
                PDFreports.this.openPdfFile("Tickets/TicketsRecargas/ticket_Recarga.pdf");
            }
        });
        //
        this.rbt_PagoSer.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                File file6;
                file6 = new File("Tickets/TicketsServicios/ticket_Servicio.pdf");
                file6.getParentFile().mkdirs();

                try {
                    PDFreports.this.createPdfPorCompanias("Tickets/TicketsServicios/ticket_Servicio.pdf");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                PDFreports.this.sendMessage("Reported succesfull", "Tickets/TicketsServicios/ticket_Servicio.pdfgenerated...");
                PDFreports.this.openPdfFile("Tickets/TicketsServicios/ticket_Servicio.pdf");
            }
        });

    }

    public void createPdfDeServicios(String dest) throws IOException {
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf, PageSize.A4.rotate());
        Paragraph paragraph = new Paragraph("REPORTE DE SERVICIOS");
        paragraph.setFontSize(25.0F);
        paragraph.setTextAlignment(TextAlignment.CENTER);
        document.setMargins(20.0F, 20.0F, 20.0F, 20.0F);
        PdfFont font = PdfFontFactory.createFont("Helvetica");
        PdfFont bold = PdfFontFactory.createFont("Helvetica-Bold");
        Table table1 = (new Table(UnitValue.createPercentArray(new float[]{2.0F, 4.0F}))).useAllAvailableWidth();
        this.processPdfDeServicios(table1, (DeServicios)null, bold, true);
        Iterator var11 = this.consultasDAO.getDeServicios().iterator();

        while(var11.hasNext()) {
            DeServicios e = (DeServicios) var11.next();
            this.processPdfDeServicios(table1, e, bold, false);
        }

        document.add(paragraph);
        document.add(table1);
        document.close();
    }

    public void processPdfDeServicios(Table table, DeServicios user, PdfFont font, boolean isHeader) {
        if (isHeader) {
            table.addHeaderCell(new Cell().add(new Paragraph("NUMERO TICKET").setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);
            table.addHeaderCell(new Cell().add(new Paragraph("CLAVE PAGO").setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);
            table.addHeaderCell(new Cell().add(new Paragraph("USUARIO").setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);
            table.addHeaderCell(new Cell().add(new Paragraph("SERVICIO").setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);
            table.addHeaderCell(new Cell().add(new Paragraph("MONTO").setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);
        } else {
            table.addCell(new Cell().add(new Paragraph(user.getNumTickServicio()+"").setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);
            table.addCell(new Cell().add(new Paragraph(user.getCvePagoServ()+"").setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);
            table.addCell(new Cell().add(new Paragraph(user.getUsuNombre()).setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);
            table.addCell(new Cell().add(new Paragraph(user.getSerNombre()).setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);
            table.addCell(new Cell().add(new Paragraph(user.getPserMonto()+"").setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);
        }
    }

    public void createPdfDeRecargas(String dest) throws IOException {
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf, PageSize.A4.rotate());
        Paragraph paragraph = new Paragraph("REPORTE DE RECARGAS");
        paragraph.setFontSize(25.0F);
        paragraph.setTextAlignment(TextAlignment.CENTER);
        document.setMargins(20.0F, 20.0F, 20.0F, 20.0F);
        PdfFont font = PdfFontFactory.createFont("Helvetica");
        PdfFont bold = PdfFontFactory.createFont("Helvetica-Bold");
        Table table2 = (new Table(UnitValue.createPercentArray(new float[]{2.0F, 4.0F}))).useAllAvailableWidth();
        this.processPdfDeRecargas(table2, (DeRecargas)null, bold, true);
        Iterator var11 = this.consultasDAO.getDeRecargas().iterator();

        while(var11.hasNext()) {
            DeRecargas  e = (DeRecargas)var11.next();
            this.processPdfDeRecargas(table2, e, bold, false);
        }

        document.add(paragraph);
        document.add(table2);
        document.close();
    }

    public void processPdfDeRecargas(Table table, DeRecargas user, PdfFont font, boolean isHeader) {
        if (isHeader) {
            table.addHeaderCell(new Cell().add(new Paragraph("NUMERO TICKET").setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);
            table.addHeaderCell(new Cell().add(new Paragraph("CLAVE RECARGA").setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);
            table.addHeaderCell(new Cell().add(new Paragraph("USUARIO").setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);
            table.addHeaderCell(new Cell().add(new Paragraph("COMPAÑIA").setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);
            table.addHeaderCell(new Cell().add(new Paragraph("ABONO").setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);
        } else {
            table.addCell(new Cell().add(new Paragraph(user.getNumTickRecarga()+"").setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);
            table.addCell(new Cell().add(new Paragraph(user.getCveRecarga()+"").setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);
            table.addCell(new Cell().add(new Paragraph(user.getUsuNombre()).setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);
            table.addCell(new Cell().add(new Paragraph(user.getComNombre()).setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);
            table.addCell(new Cell().add(new Paragraph(user.getRecAbono()+"").setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);
        }
    }

    public void createPdfPorServicios(String dest) throws IOException {
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf, PageSize.A4.rotate());
        Paragraph paragraph = new Paragraph("REPORTE POR SERVICIOS");
        paragraph.setFontSize(25.0F);
        paragraph.setTextAlignment(TextAlignment.CENTER);
        document.setMargins(20.0F, 20.0F, 20.0F, 20.0F);
        PdfFont font = PdfFontFactory.createFont("Helvetica");
        PdfFont bold = PdfFontFactory.createFont("Helvetica-Bold");
        Table table3 = (new Table(UnitValue.createPercentArray(new float[]{5.0F, 4.0F, 4.0F, 4.0F}))).useAllAvailableWidth();
        this.processPdfPorServicios(table3, (PorServicio)null, bold, true);
        Iterator var11 = this.consultasDAO.getPorServicio().iterator();

        while(var11.hasNext()) {
            PorServicio e = (PorServicio) var11.next();
            this.processPdfPorServicios(table3, e, bold, false);
        }

        document.add(paragraph);
        document.add(table3);
        document.close();
    }

    public void processPdfPorServicios(Table table, PorServicio user, PdfFont font, boolean isHeader) {
        if (isHeader) {
            table.addHeaderCell(new Cell().add(new Paragraph("NOMBRE SERVICIO").setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);
            table.addHeaderCell(new Cell().add(new Paragraph("MONTO").setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);

        } else {
            table.addCell(new Cell().add(new Paragraph(user.getSerNombre()).setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);
            table.addCell(new Cell().add(new Paragraph(user.getPserMonto()+"").setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);

        }
    }

    public void createPdfPorCompanias(String dest) throws IOException {
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf, PageSize.A4.rotate());
        Paragraph paragraph = new Paragraph("REPORTE POR COMPAÑIAS");
        paragraph.setFontSize(25.0F);
        paragraph.setTextAlignment(TextAlignment.CENTER);
        document.setMargins(20.0F, 20.0F, 20.0F, 20.0F);
        PdfFont font = PdfFontFactory.createFont("Helvetica");
        PdfFont bold = PdfFontFactory.createFont("Helvetica-Bold");
        Table table4 = (new Table(UnitValue.createPercentArray(new float[]{6.0F, 4.0F, 4.0F, 4.0F}))).useAllAvailableWidth();
        this.processPdfPorCompania(table4, (PorCompanias)null, bold, true);
        Iterator var11 = this.consultasDAO.getPorCompanias().iterator();

        while(var11.hasNext()) {
            PorCompanias e = (PorCompanias) var11.next();
            this.processPdfPorCompania(table4, e, bold, false);
        }

        document.add(paragraph);
        document.add(table4);
        document.close();
    }

    public void processPdfPorCompania(Table table, PorCompanias user, PdfFont font, boolean isHeader) {
        if (isHeader) {
            table.addHeaderCell(new Cell().add(new Paragraph("NOMBRE COMPAÑIA").setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);
            table.addHeaderCell(new Cell().add(new Paragraph("ABONO").setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);

        } else {
            table.addCell(new Cell().add(new Paragraph(user.getComNombre()).setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);
            table.addCell(new Cell().add(new Paragraph(user.getRecAbono()+"").setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);
        }
    }
    public void createPdfTicketRecargas(String dest, String cveRec) throws IOException {
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf, PageSize.A4.rotate());
        Paragraph paragraph = new Paragraph("TICKET DE RECARGAS");
        paragraph.setFontSize(25.0F);
        paragraph.setTextAlignment(TextAlignment.CENTER);
        document.setMargins(20.0F, 20.0F, 20.0F, 20.0F);
        PdfFont font = PdfFontFactory.createFont("Helvetica");
        PdfFont bold = PdfFontFactory.createFont("Helvetica-Bold");
        Table table5 = (new Table(UnitValue.createPercentArray(new float[]{6.0F, 4.0F, 4.0F, 4.0F}))).useAllAvailableWidth();
        this.processPdfTicketRecargas(table5, (TicketRecargas)null, bold, true);
        Iterator var11 = this.consultasDAO.getTicketRecargas(cveRec).iterator();

        while(var11.hasNext()) {
            TicketRecargas e = (TicketRecargas) var11.next();
            this.processPdfTicketRecargas(table5, e, bold, false);
        }

        document.add(paragraph);
        document.add(table5);
        document.close();
    }

    public void processPdfTicketRecargas(Table table, TicketRecargas user, PdfFont font, boolean isHeader) {
        if (isHeader) {
            table.addHeaderCell((Cell)(new Cell()).add((IBlockElement)((Paragraph)((Paragraph)(new Paragraph("NUM. TICKET")).setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite)).setTextAlignment(TextAlignment.CENTER));
            table.addHeaderCell((Cell)(new Cell()).add((IBlockElement)((Paragraph)((Paragraph)(new Paragraph("NUM. AUTORI.")).setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite)).setTextAlignment(TextAlignment.CENTER));
            table.addHeaderCell((Cell)(new Cell()).add((IBlockElement)((Paragraph)((Paragraph)(new Paragraph("CLAVE RECARGA")).setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite)).setTextAlignment(TextAlignment.CENTER));
            table.addHeaderCell((Cell)(new Cell()).add((IBlockElement)((Paragraph)((Paragraph)(new Paragraph("USUARIO")).setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite)).setTextAlignment(TextAlignment.CENTER));
            table.addHeaderCell((Cell)(new Cell()).add((IBlockElement)((Paragraph)((Paragraph)(new Paragraph("COMPAÑIA")).setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite)).setTextAlignment(TextAlignment.CENTER));
            table.addHeaderCell((Cell)(new Cell()).add((IBlockElement)((Paragraph)((Paragraph)(new Paragraph("ABONO")).setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite)).setTextAlignment(TextAlignment.CENTER));
            table.addHeaderCell((Cell)(new Cell()).add((IBlockElement)((Paragraph)((Paragraph)(new Paragraph("TELEFONO")).setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite)).setTextAlignment(TextAlignment.CENTER));
            table.addHeaderCell((Cell)(new Cell()).add((IBlockElement)((Paragraph)((Paragraph)(new Paragraph("FECHA PAGO")).setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite)).setTextAlignment(TextAlignment.CENTER));
            table.addHeaderCell((Cell)(new Cell()).add((IBlockElement)((Paragraph)((Paragraph)(new Paragraph("HORA PAGO")).setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite)).setTextAlignment(TextAlignment.CENTER));
        } else {
            table.addCell(new Cell().add(new Paragraph(user.getNumTickRecarga()+"").setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);
            table.addCell(new Cell().add(new Paragraph(user.getTicrNumeAutorizacion()+"").setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);
            table.addCell(new Cell().add(new Paragraph(user.getCveRecarga()+"").setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);
            table.addCell(new Cell().add(new Paragraph(user.getUsuNombre()).setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);
            table.addCell(new Cell().add(new Paragraph(user.getComNombre()).setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);
            table.addCell(new Cell().add(new Paragraph(user.getRecAbono()+"").setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);
            table.addCell(new Cell().add(new Paragraph(user.getRecTelefono()).setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);
            table.addCell(new Cell().add(new Paragraph(user.getTicrFechaPago()+"").setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);
            table.addCell(new Cell().add(new Paragraph(user.getTicrHoraPago()).setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);
        }
    }

    public void createPdfTicketServicios(String dest, String cvePServ) throws IOException {
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf, PageSize.A4.rotate());
        Paragraph paragraph = new Paragraph("TICKET DE SERVICIOS");
        paragraph.setFontSize(25.0F);
        paragraph.setTextAlignment(TextAlignment.CENTER);
        document.setMargins(20.0F, 20.0F, 20.0F, 20.0F);
        PdfFont font = PdfFontFactory.createFont("Helvetica");
        PdfFont bold = PdfFontFactory.createFont("Helvetica-Bold");
        Table table6 = (new Table(UnitValue.createPercentArray(new float[]{6.0F, 4.0F, 4.0F, 4.0F}))).useAllAvailableWidth();
        this.processPdfTicketServicios(table6, (TicketServicios) null, bold, true);
        Iterator var11 = this.consultasDAO.getTicketServicios(cvePServ).iterator();

        while(var11.hasNext()) {
            TicketServicios e = (TicketServicios) var11.next();
            this.processPdfTicketServicios(table6, e, bold, false);
        }

        document.add(paragraph);
        document.add(table6);
        document.close();
    }

    public void processPdfTicketServicios(Table table, TicketServicios user, PdfFont font, boolean isHeader) {
        if (isHeader) {
            table.addHeaderCell((Cell)(new Cell()).add((IBlockElement)((Paragraph)((Paragraph)(new Paragraph("NUM. TICKET")).setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite)).setTextAlignment(TextAlignment.CENTER));
            table.addHeaderCell((Cell)(new Cell()).add((IBlockElement)((Paragraph)((Paragraph)(new Paragraph("NUM. AUTORI.")).setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite)).setTextAlignment(TextAlignment.CENTER));
            table.addHeaderCell((Cell)(new Cell()).add((IBlockElement)((Paragraph)((Paragraph)(new Paragraph("CLAVE PAGO")).setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite)).setTextAlignment(TextAlignment.CENTER));
            table.addHeaderCell((Cell)(new Cell()).add((IBlockElement)((Paragraph)((Paragraph)(new Paragraph("NUME. REFERENCIA")).setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite)).setTextAlignment(TextAlignment.CENTER));
            table.addHeaderCell((Cell)(new Cell()).add((IBlockElement)((Paragraph)((Paragraph)(new Paragraph("USUARIO")).setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite)).setTextAlignment(TextAlignment.CENTER));
            table.addHeaderCell((Cell)(new Cell()).add((IBlockElement)((Paragraph)((Paragraph)(new Paragraph("SERVICIO")).setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite)).setTextAlignment(TextAlignment.CENTER));
            table.addHeaderCell((Cell)(new Cell()).add((IBlockElement)((Paragraph)((Paragraph)(new Paragraph("COMISION")).setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite)).setTextAlignment(TextAlignment.CENTER));
            table.addHeaderCell((Cell)(new Cell()).add((IBlockElement)((Paragraph)((Paragraph)(new Paragraph("MONTO")).setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite)).setTextAlignment(TextAlignment.CENTER));
            table.addHeaderCell((Cell)(new Cell()).add((IBlockElement)((Paragraph)((Paragraph)(new Paragraph("TELEFONO")).setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite)).setTextAlignment(TextAlignment.CENTER));
            table.addHeaderCell((Cell)(new Cell()).add((IBlockElement)((Paragraph)((Paragraph)(new Paragraph("FECHA PAGO")).setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite)).setTextAlignment(TextAlignment.CENTER));
            table.addHeaderCell((Cell)(new Cell()).add((IBlockElement)((Paragraph)((Paragraph)(new Paragraph("HORA PAGO")).setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite)).setTextAlignment(TextAlignment.CENTER));
        } else {
            table.addCell(new Cell().add(new Paragraph(user.getNumTickServicio()+"").setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);
            table.addCell(new Cell().add(new Paragraph(user.getTicsNumeAutorizacion()+"").setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);
            table.addCell(new Cell().add(new Paragraph(user.getCvePagoServ()+"").setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);
            table.addCell(new Cell().add(new Paragraph(user.getPserNumeReferencia()+"").setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);
            table.addCell(new Cell().add(new Paragraph(user.getUsuNombre()).setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);
            table.addCell(new Cell().add(new Paragraph(user.getSerNombre()).setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);
            table.addCell(new Cell().add(new Paragraph(user.getPserComision()+"").setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);
            table.addCell(new Cell().add(new Paragraph(user.getPserMonto()+"").setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);
            table.addCell(new Cell().add(new Paragraph(user.getPserTelefono()).setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);
            table.addCell(new Cell().add(new Paragraph(user.getTicsFechaPago()+"").setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);
            table.addCell(new Cell().add(new Paragraph(user.getTicsHoraPago()).setFont(font)).setBackgroundColor(this.header3)).setFontColor(this.v_fontwhite).setTextAlignment(TextAlignment.CENTER);
        }
    }

    public void setStageAnterior(Stage stage) {
        this.anterior = stage;
    }

    private void openPdfFile(String filename) {
        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File(filename);
                Desktop.getDesktop().open(myFile);
            } catch (IOException var3) {
            }
        }

    }

    private void sendMessage(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.show();
    }
}
