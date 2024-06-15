package org.example.ObjectProblems;

import java.util.*;
import java.util.stream.Collectors;

public class StreamOnObject {

  private static List<Notes> getNotesList() {
    return Arrays.asList(
        new Notes(1, "note1", 11),
        new Notes(2, "note2", 22),
        new Notes(3, "note3", 33),
        new Notes(4, "note4", 44),
        new Notes(5, "note5", 55),
        new Notes(6, "note4", 66));
  }

  public static void convertNotesIntoMap() {
    List<Notes> notes = getNotesList();

    Comparator<Notes> sortByTagId =
        (note1, note2) -> {
          return Integer.compare((int) note1.getTagId(), (int) note2.getTagId());
        };

    var noteNameAndTagIdMap =
        notes.stream()
            // In 'comparing' method we are providing the note tagId and also providing the
            // comparator
            .sorted(Comparator.comparing(note -> note.getTagId(), Collections.reverseOrder()))
            .collect(
                Collectors.toMap(
                    note -> note.getName(),
                    note -> note.getTagId(),
                    (oldValue, newValue) ->
                        oldValue, // mergeFunction to handle duplicate keys  ,here oldValue will be
                    // 66 and newValue will be 66
                    LinkedHashMap::new)); // MapFactory to define  which map will be used

    noteNameAndTagIdMap.entrySet().stream()
        .forEach(entry -> System.out.println(entry.getKey() + "==" + entry.getValue()));
  }

  public static void checkIfListIsEmptyOrNot() {
    List<Notes> notesList = getNotesList();

    Optional.ofNullable(notesList).orElseGet(Collections::emptyList).stream()
        .filter(Objects::nonNull)
        .map(Notes::getTagId)
        .forEach(System.out::println);
  }

  public static void sortByName() {
    List<Notes> notesList = getNotesList();
    Comparator<Notes> sortByName = Comparator.comparing(Notes::getName);
    Comparator<Notes> sortByNameV1 = (note1, note2) -> -(note1.name.compareTo(note1.name));

    notesList.stream().sorted(sortByName).forEach(System.out::println);
  }

  public static void hashmapOFObjects() {
    List<Notes> notesList = getNotesList();

    notesList.stream()
        .collect(
            Collectors.toMap(
                (eachNote) -> eachNote.id, // keyMapper
                (eachNote) -> eachNote.getName(), // valueMapper
                (name1, name2) -> name1 + " " + name2 // merge function based on valueMapper values
                ));
  }

  public static class Notes {
    private int id;
    private String name;
    private long tagId;

    public Notes(int id, String name, long tagId) {
      this.id = id;
      this.name = name;
      this.tagId = tagId;
    }

    public int getId() {
      return id;
    }

    public String getName() {
      return name;
    }

    public long getTagId() {
      return tagId;
    }
  }
}
