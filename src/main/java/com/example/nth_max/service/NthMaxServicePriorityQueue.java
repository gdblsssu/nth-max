package com.example.nth_max.service;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.PriorityQueue;

@Service
public class NthMaxServicePriorityQueue implements NthMaxService {
    @Override
    public int getNthMaxNumber(String path, int n) {
        File file = new File(path);

        if (!file.exists()) {
            throw new IllegalArgumentException("File not found at path: " + path);
        }

        if (n < 1) {
            throw new IllegalArgumentException("The value of N must be positive: " + n);
        }

        try (FileInputStream fis = new FileInputStream(file);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            var sheet = workbook.getSheetAt(0);
            int rowCount = sheet.getPhysicalNumberOfRows();

            if (rowCount < n) {
                throw new IllegalArgumentException("The file " + file.getName() + " contains less than " + n + " rows");
            }

            PriorityQueue<Integer> pq = new PriorityQueue<>(n);
            for (int i = 0; i < rowCount; i++) {
                var row = sheet.getRow(i);
                if (row != null && row.getCell(0) != null) {
                    int num = (int) row.getCell(0).getNumericCellValue();
                    pq.offer(num);
                    
                    if(pq.size() > n){
                        pq.poll();
                    }

                }
            }
            
            return pq.peek();
            

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
