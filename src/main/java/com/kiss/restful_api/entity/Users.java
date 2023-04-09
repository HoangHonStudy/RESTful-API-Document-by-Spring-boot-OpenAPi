package com.kiss.restful_api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data   //Tạo getter, setter
@NoArgsConstructor  //Hàm tạo không tham số
@AllArgsConstructor     //Hàm tạo với đầy đủ tham sô
public class Users {
    @Id
    @Schema(description = "User UUID in the database")      // Mô tả ý nghĩa field trong document
    @JsonProperty("UserId")     //Thay đôi name property cho json trả về
    private int id;

    private String fristName;

    private String lastName;

    private String email;
}
