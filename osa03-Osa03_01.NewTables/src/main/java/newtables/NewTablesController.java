/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newtables;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author anton
 */
public class NewTablesController {
    
    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private CourseRepository courserepository;
    
}
