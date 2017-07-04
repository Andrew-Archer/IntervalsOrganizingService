/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.razandale.workperiodsorganizer.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author Andrew
 */
@Data
@AllArgsConstructor
public class Work {
    private String name;
    private String description;
}
