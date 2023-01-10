package core_java_problem_solution.song_service;

import java.util.*;
import java.util.stream.Collectors;

public class SongServiceImpl implements SongService{

    @Override
    public List<Song> addSongDetail() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
        List<Song> songList = new ArrayList<>();

        System.out.println("Enter number of Song you want ");
        int num = scanner.nextInt();
        for (int i=0; i<num; i++){
            Song song = new Song();
            System.out.println("Enter song Id");
            song.setSongId(scanner.nextInt());
            System.out.println("Enter song Title");
            song.setTitle(scanner.next());
            System.out.println("Enter song Artist ");
            song.setArtist(scanner.next());
            System.out.println("Enter song Duration");
            song.setDuration(scanner.nextDouble());
            if (songList.isEmpty()){
                songList.add(song);
            }
            if (!checkIdOrArtistAndDurationExit(songList,song)){
                songList.add(song);
            }
        }
        return songList;
    }

    private boolean checkIdOrArtistAndDurationExit(List<Song> songList , Song song){
        for (Song song1 : songList){
            if (song1.getSongId()==song.getSongId() || (song1.getArtist().equalsIgnoreCase(song.getArtist())
                && song1.getDuration()==song.getDuration())){
                return true;
            }
        }
        return false;
    }

    static double getFindSongDuration(List<Song> songList, String artist){
        return songList.stream()
                .filter(song -> song.getArtist().equalsIgnoreCase(artist))
                .mapToDouble(Song::getDuration)
                .sum();
    }

    static List<Song> getSongsInAscendingOrder(List<Song> songList, String artist){
        List<Song> idAndTitleList = songList.stream()
                                    .filter(song -> song.getArtist().equalsIgnoreCase(artist))
                                    .sorted(Comparator.comparingDouble(Song::getDuration))
                                    .collect(Collectors.toList());
        return idAndTitleList;
    }
}
