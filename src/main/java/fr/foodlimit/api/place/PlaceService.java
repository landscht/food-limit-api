package fr.foodlimit.api.place;

import fr.foodlimit.api.shared.models.Place;
import fr.foodlimit.api.shared.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Classe de service concernant les foyers
 */
@Service
public class PlaceService {

  @Autowired
  PlaceRepository placeRepository;

  /**
   * Récupère tous les foyers
   * @return
   */
  public Iterable<Place> getPlaces() {
    return placeRepository.findAll();
  }

  /**
   * Récupère les foyers de l'utilisateur
   * @param username
   * @return
   */
  public List<Place> getPlaces(String username) {
    User user = new User();
    user.setUsername(username);

    return placeRepository.findByUser(user);
  }

  /**
   * Récupère un foyer de l'utilisateur
   * @param id
   * @return
   */
  public Place getPlace(Long id) {
    return placeRepository.findById(id).get();
  }

  /**
   * Supprime un foyer de l'utilisateur
   * @param id
   */
  public void deletePlace(Long id) {
    placeRepository.deleteById(id);
  }

  /**
   * Créé un foyer pour l'utilisateur
   * @param place
   * @param username
   * @return
   */
  public Place createPlace(Place place, String username) {
    place.setId(null);
    User user = new User();
    user.setUsername(username);
    place.setUser(user);
    return placeRepository.save(place);
  }

  /**
   * Modifie un foyer de l'utilisateur
   * @param place
   * @param username
   * @return
   */
  public Place updatePlace(Place place, String username) {
    place.setId(place.getId());
    User user = new User();
    user.setUsername(username);
    place.setUser(user);
    return placeRepository.save(place);
  }
}