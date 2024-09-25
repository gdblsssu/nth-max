package com.example.nth_max.service;

import com.example.nth_max.utils.NMaxNumbers;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Service
@Primary
@Slf4j
public class NthMaxServiceImpl implements NthMaxService {
    @Override
    public int getNthMaxNumber(String path, int n) {
        File file = new File(path);

        if (!file.exists()) {
            log.error("Файл не найден. Неверный путь: {}", path);
            throw new IllegalArgumentException("Файл не найден. Не верный путь: " + path);
        }

        if (n < 1) {
            log.error("N не может быть отрицательным: {}", n);
            throw new IllegalArgumentException("N не может быть отрицательным: " + n);
        }

        try (FileInputStream fis = new FileInputStream(file);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            var sheet = workbook.getSheetAt(0);
            int rowCount = sheet.getPhysicalNumberOfRows();

            if (rowCount < n) {
                log.error("Файл {} содержит меньше строк, чем число N: {}", file.getName(), n);
                throw new IllegalArgumentException("Файл" + file.getName() + " содержит меньше строк, чем N: " + n);
            }

            NMaxNumbers nMaxNumbers = new NMaxNumbers(n);
            for (int i = 0; i < rowCount; i++) {
                var row = sheet.getRow(i);
                if (row != null && row.getCell(0) != null) {
                    int num = (int) row.getCell(0).getNumericCellValue();
                    if (num > nMaxNumbers.getN() || nMaxNumbers.getSize() < n) {
                        nMaxNumbers.addNumber(num);
                    }
                }
            }

            if (!nMaxNumbers.isSorted()) nMaxNumbers.sort();

            log.info("N-ое максимальное число: {}", nMaxNumbers.getN());
            return nMaxNumbers.getN();

        } catch (IOException e) {
            log.error("Ошибка чтения файла: {}", path, e);
            throw new RuntimeException(e);
        }
    }
}