package DAO;

import java.util.List;
import Entity.Favorite;

public interface FavoriteDAO {
    List<Favorite> findAll();
    Favorite findById(Long id);
    void create(Favorite favorite);
    void update(Favorite favorite);
    void deleteById(Long id);
}
