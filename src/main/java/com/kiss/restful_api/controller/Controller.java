package com.kiss.restful_api.controller;

import com.kiss.restful_api.entity.Users;
import com.kiss.restful_api.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController     //Trả về dữ liệu dạng json
@RequestMapping("/api/v1/")
//Mô tả các trạng thái phản hồi của api
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Thành công"),
        @ApiResponse(responseCode = "401", description = "Chưa xác thực"),
        @ApiResponse(responseCode = "403", description = "Truy cập bị cấm"),
        @ApiResponse(responseCode="404", description = "Không tìm thấy")
})
public class Controller {
    @Autowired
    private UserRepository userRepository;
    @Operation(description = "Xem danh sách User")      //Mô tả chức năng của api
    @GetMapping("/users")
    public ResponseEntity<List<Users>> getUsers() {
        List<Users> listUser = userRepository.findAll();
        if(listUser.isEmpty()) return ResponseEntity.noContent().build();
        return new ResponseEntity<>(listUser, HttpStatus.OK);
    }

    @Operation(description = "lấy một User bằng id")
    @GetMapping("/users/{id}")
    public ResponseEntity<Users> getUser(@PathVariable("id") int id) {
        Users user = userRepository.findById(id).orElse(null);
        System.out.println(user);
        if(user == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(user);
    }

    @Operation(description = "Tạo một User")
    @PostMapping("/Users")
    public ResponseEntity<Users> createUser(@Valid @RequestBody Users user) {
        return ResponseEntity.ok(userRepository.save(user));
    }

    @Operation(description = "Cập nhật User theo id")
    @PutMapping("/Users/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable("id") int id, @Valid @RequestBody Users user) {
        user.setId(id);
        return ResponseEntity.ok(userRepository.save(user));
    }

    @Operation(description = "Xóa User theo id")
    @DeleteMapping("/Users/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        userRepository.deleteById(id);
    }
}
