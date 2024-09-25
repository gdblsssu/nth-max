package com.example.nth_max.rest;

import com.example.nth_max.service.NthMaxService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class NthMaxController {

    final NthMaxService nthMaxService;

    public NthMaxController(NthMaxService nthMaxService) {
        this.nthMaxService = nthMaxService;
    }

    @Operation(summary = "Получить N-ное максимальное число", description = "Возвращает N-ое максимальное число из файла Excel")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное получение N-го максимального числа"),
            @ApiResponse(responseCode = "400", description = "Некорректный путь к файлу или значение N"),
            @ApiResponse(responseCode = "500", description = "Ошибка на стороне сервера")
    })
    @GetMapping("/get_nth_max")
    public ResponseEntity<Integer> getNthMaxNumber(
            @Parameter(description = "Путь к файлу Excel", required = true) @RequestParam String path,
            @Parameter(description = "Порядковое число N для поиска максимального значения", required = true, example = "3") @RequestParam int n) {

        try {
            return ResponseEntity.ok(nthMaxService.getNthMaxNumber(path, n));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(-1);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
