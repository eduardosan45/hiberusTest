package com.superhero;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.superhero.dao.BaseModelDAO;
import com.superhero.dao.CustomSuperHeroDAO;
import com.superhero.model.entity.SuperHero;
import com.superhero.service.SuperHeroService;

@RunWith(MockitoJUnitRunner.class)
public class SpringServiceTest {
	
	
	@InjectMocks
    private SuperHeroService superHeroService;
     
    @Mock
    private BaseModelDAO dao;
    
    @Mock
    private CustomSuperHeroDAO customSuperHeroDAO;
    
    @Test
    public void getFindAll(){
    	List<SuperHero> list = new ArrayList<SuperHero>();
    	SuperHero super1 = new SuperHero(1L, "Spiderman", "Man bitten by a spider");
    	SuperHero super2 = new SuperHero(2L, "Batman", "Man like a bat");
    	SuperHero super3 = new SuperHero(3L, "Superman", "Man with super strength");
    	SuperHero super4 = new SuperHero(4L, "Super Lopez", "Spanish super hero");
         
        list.add(super1);
        list.add(super2);
        list.add(super3);
        list.add(super4);
         
        when(dao.findAll()).thenReturn(list);
        //test 
        List<SuperHero> superHeros = superHeroService.getSuperHeros();
         
        assertEquals(4, superHeros.size());
        verify(dao, times(1)).findAll();
    }
    
    @Test
    public void getFindOne(){
    	SuperHero super1 = new SuperHero(1L, "Spiderman", "Man bitten by a spider");
    	
    	Optional<SuperHero> optional= Optional.of(super1);
       
         
        when(dao.findById(1L)).thenReturn(optional);
        //test 
        Optional<SuperHero> superHero = superHeroService.getSuperHero(1L);
         
        assertEquals(true, superHero.isPresent());
        verify(dao, times(1)).findById(1L);
    }
    
    @Test
    public void getFindByName(){
    	List<SuperHero> list = new ArrayList<SuperHero>();
    	SuperHero super1 = new SuperHero(1L, "Spiderman", "Man bitten by a spider");
    	String name = "Spiderman";
    	
    	 list.add(super1);
        
         
        when(dao.findByname(name)).thenReturn(list);
        //test 
        List<SuperHero> superHeros = superHeroService.getSuperHeroByName(name);
         
        assertEquals(1, superHeros.size());
        verify(dao, times(1)).findByname(name);
    }
    
    @Test
    public void getFindByNameLike(){
    	List<SuperHero> list = new ArrayList<SuperHero>();
    	SuperHero super1 = new SuperHero(1L, "Spiderman", "Man bitten by a spider");
    	SuperHero super2 = new SuperHero(2L, "Batman", "Man like a bat");
    	SuperHero super3 = new SuperHero(3L, "Superman", "Man with super strength");
         
        list.add(super1);
        list.add(super2);
        list.add(super3);

        String name = "man";
        
        when(customSuperHeroDAO.findByLikeName(name)).thenReturn(list);
        //test 
        List<SuperHero> superHeros = superHeroService.getSuperHeroByNameLike(name);
         
        assertEquals(3, superHeros.size());
        verify(customSuperHeroDAO, times(1)).findByLikeName(name);
    }
    
    @Test
    public void save(){
    	List<SuperHero> list = new ArrayList<SuperHero>();
    	
    	SuperHero super1 = new SuperHero(1L, "Spiderman", "Man bitten by a spider");
         
        list.add(super1);

        String newName = "Hello";
        
		super1.setName(newName);
		superHeroService.save(super1);
        
        when(dao.findByname(newName)).thenReturn(list);
        //test 
        List<SuperHero> superHeros = dao.findByname(newName);
         
        assertEquals(1, superHeros.size());
        verify(dao, times(1)).findByname(newName);
    }
}
