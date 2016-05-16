/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ua.encontreja.services;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import pt.ua.encontreja.dao.CategoryDAO;
import pt.ua.encontreja.entity.Category;

/**
 *
 * @author arrais
 */
@Stateless
@Path("/category") 
public class CategoryService {
    
    @EJB
    CategoryDAO categoryDAO;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Category> getAll() {
        return categoryDAO.findAll();
       
    }
}
