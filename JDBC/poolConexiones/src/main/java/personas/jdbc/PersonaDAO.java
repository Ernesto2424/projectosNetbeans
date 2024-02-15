package personas.jdbc;

import java.sql.SQLException;
import java.util.List;
import personas.dto.Persona;

public interface PersonaDAO {

int insert(Persona persona)throws SQLException;


int update(Persona persona)throws SQLException;

int delete(Persona persona)throws SQLException;

Persona select(Persona persona) throws SQLException;

List<Persona> select()throws SQLException; 



    
}
