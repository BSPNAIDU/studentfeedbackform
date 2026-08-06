package com.studentfeedback.servlet;

import com.studentfeedback.dao.FeedbackDAO;
import com.studentfeedback.model.Feedback;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@WebServlet("/ExportExcelServlet")
public class ExportExcelServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private FeedbackDAO feedbackDAO;

    @Override
    public void init() throws ServletException {
        feedbackDAO = new FeedbackDAO();
    }

    @Override
    protected void doGet(jakarta.servlet.http.HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        List<Feedback> feedbackList = feedbackDAO.getAllFeedback();

        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("Student Feedback");

        Row header = sheet.createRow(0);

        header.createCell(0).setCellValue("Feedback ID");
        header.createCell(1).setCellValue("Student Name");
        header.createCell(2).setCellValue("Email");
        header.createCell(3).setCellValue("Department");
        header.createCell(4).setCellValue("Rating");
        header.createCell(5).setCellValue("Feedback");
        header.createCell(6).setCellValue("Submitted At");

        int rowNumber = 1;

        for (Feedback feedback : feedbackList) {

            Row row = sheet.createRow(rowNumber++);

            row.createCell(0).setCellValue(feedback.getFeedbackId());

            row.createCell(1).setCellValue(feedback.getStudentName());

            row.createCell(2).setCellValue(feedback.getEmail());

            row.createCell(3).setCellValue(feedback.getDepartment());

            row.createCell(4).setCellValue(feedback.getRating());

            row.createCell(5).setCellValue(feedback.getFeedbackMessage());

            if (feedback.getSubmittedAt() != null) {
                row.createCell(6).setCellValue(feedback.getSubmittedAt().toString());
            } else {
                row.createCell(6).setCellValue("");
            }
        }

        for (int i = 0; i < 7; i++) {
            sheet.autoSizeColumn(i);
        }

        response.setContentType(
                "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

        response.setHeader(
                "Content-Disposition",
                "attachment; filename=Student_Feedback_Report.xlsx");

        workbook.write(response.getOutputStream());

        workbook.close();
    }
}