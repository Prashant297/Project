package core_java_problem_solution.song_service;

import java.util.*;

public class MyClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
        SongServiceImpl songService = new SongServiceImpl();
        List<Song> songList = new ArrayList<>(songService.addSongDetail());

        System.out.println("Enter Artist Name");
        String artist = scanner.next();
        System.out.println("Enter Artist Name");
        String artist1 = scanner.next();

        double duration = SongServiceImpl.getFindSongDuration(songList,artist);
        if (duration>0){
            System.out.println(duration);
        }else {
            System.out.println("There are no song with given Artist");
        }

        List<Song> idAndTitleList = SongServiceImpl.getSongsInAscendingOrder(songList,artist1);
        if (!idAndTitleList.isEmpty()) {
            for (Song song : idAndTitleList){
                System.out.println(song.getSongId()+"\n"+song.getTitle());
            }
        } else {
            System.out.println("There are no songs with given artist");
        }

    }
}
