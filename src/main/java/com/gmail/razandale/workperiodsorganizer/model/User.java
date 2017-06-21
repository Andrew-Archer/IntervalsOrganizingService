/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.razandale.workperiodsorganizer.model;

import java.util.List;
import lombok.Data;

/**
 *
 * @author Andrew
 */
@Data
public class User {
    private Long id;
    private List<Work> typeOfWork;
    private String role;
}
