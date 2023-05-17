package org.example;

import jakarta.persistence.EntityManager;
import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.variables.BoolVar;

import java.util.ArrayList;
import java.util.List;

public class AlbumSelector {
    private static final int YEAR_GAP = 10;

    public List<Album> selectConstrainedAlbums(List<Album> Albums, int requiredAlbums) {
        Model model = new Model("Album Selection Model");

        int totalAlbums = Albums.size();

        BoolVar[] isSelected = model.boolVarArray(totalAlbums);

        // Constraint: At least 'requiredAlbums' should be selected
        model.sum(isSelected, ">=", requiredAlbums).post();

        // Constraints for albums that can't be in the solution together
        for (int i = 0; i < totalAlbums; i++) {
            for (int j = i + 1; j < totalAlbums; j++) {
                if (!isValidPair(Albums.get(i), Albums.get(j))) {
                    model.arithm(isSelected[i], "+", isSelected[j], "<=", 1).post();
                }
            }
        }

        Solution solution = model.getSolver().findSolution();

        if (solution != null) {
            List<Album> outputAlbums = new ArrayList<>();
            for (int i = 0; i < totalAlbums; i++) {
                if (isSelected[i].getValue() == 1) {
                    outputAlbums.add(Albums.get(i));
                }
            }
            return outputAlbums;
        }

        return null;
    }

    private boolean isValidPair(Album album1, Album album2) {
        if (album1.getTitle().charAt(0) == album2.getTitle().charAt(0) && Math.abs(album1.getReleaseYear() - album2.getReleaseYear()) < YEAR_GAP)
            return true;
        return false;
    }

    public static void main(String[] args) {
        EntityManager entityManager = EntityManagementSingleton.getSingleInstance().em;
        List<Album> allAlbums = entityManager.createQuery("SELECT a FROM Album a").getResultList();
        AlbumSelector albumSelector = new AlbumSelector();
        List<Album> solution = albumSelector.selectConstrainedAlbums(allAlbums, 15);
        System.out.println(solution);
    }
}
