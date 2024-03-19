package ee.tlu.salat;
//koosneb toiduainest ja temaga seotud kogus toidu sees
//klassikomplekt -> Kartul+omadused ja mitu grammi seda on

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Toidukomponent {
    ToiduaineEntity toiduaine;
    int kogus;

}
