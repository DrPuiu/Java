package org.example;

import org.graph4j.Graph;
import org.graph4j.GraphBuilder;
import org.graph4j.alg.clique.BronKerboschCliqueIterator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlaylistAlgorithmGraph4J {
    private List<Album> albumList;

    public PlaylistAlgorithmGraph4J(List<Album> albumList) {
        this.albumList = albumList;
    }

    public List<Playlist> GeneratePlaylist() {
        try {
            var RollingStones = new RollingStones();
            RollingStones.ParseCSVFile();
            albumList = RollingStones.getAlbumList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Graph graph = GraphBuilder.numVertices(albumList.size()).buildGraph();
        for (int i = 0; i < albumList.size(); i++) {
            for (int j = 0; j < albumList.size(); j++) {
                if (i == j) continue;
                if (albumList.get(i).getArtist().equals(albumList.get(j).getArtist())
                        || albumList.get(i).getReleaseYear() == albumList.get(j).getReleaseYear()
                        || albumList.get(i).getGenreList().equals(albumList.get(j).getGenreList())
                ) {
                    if (!graph.containsEdge(i, j)) graph.addEdge(i, j);
                }

            }
        }
        System.out.println(graph);
        Graph complementGraph = graph.complement();
        System.out.println(complementGraph);
        /*
         * BronKerboschCliqueIterator iterator = new BrownKerboschCliqueIterator(complementGrsph);
         * */
        return null;

    }


}
