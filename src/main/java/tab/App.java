package tab;

import java.util.ArrayList;
import java.util.List;

public class App {
    List<School> schools;
    List<Judge> judges;
    List<Tournament> tournaments;

    public App() {
       schools = new ArrayList<>();
       judges = new ArrayList<>();
       tournaments = new ArrayList<>();
    }

    public School addSchool(String schoolName, String schoolMascot) {
        School school = new School(schoolName, schoolMascot);
        if (schools.contains(school)) {
            throw new IllegalArgumentException("School already added");
        }
        schools.add(school);

        return school;
    }

    public Judge addJudge(String firstName, String lastName) {
        Judge judge = new Judge(firstName, lastName);
        if(judges.contains(judge)) {
            throw new IllegalArgumentException("Judge already added");
        }
        judges.add(judge);

        return judge;
    }

    public Tournament addTournament(String name, int year) {
        Tournament tournament = new Tournament(name, year);
        if(tournaments.contains(tournament)) {
            throw new IllegalArgumentException("Tournament already added");
        }
        tournaments.add(tournament);

        return tournament;
    }

    public List<School> getSchools() {
        return schools;
    }

    public List<Judge> getJudges() {
        return judges;
    }

    public List<Tournament> getTournaments() {
        return tournaments;
    }
}
