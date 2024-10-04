package org.example;

import org.example.answer.Answer;

import java.util.ArrayList;
import java.util.List;

public class RightAnswersResolver {

    private ArrayList<Integer> categories;

    public RightAnswersResolver (ArrayList <Integer> c) {
        categories = c;
    }

    private boolean isAnsweRight(String right, String pupil) {
        return right.equals(pupil);
    }

    public Integer resultSum(List<Answer> rights, List<Answer> pupils) {

        int sum = 0;
        for (int i = 0; i < rights.size(); i++) {
            if (isAnsweRight(rights.get(i).getAnswer_letter(),pupils.get(i).getAnswer_letter()))
                switch ((1 <= i && i <= 4 ) ? categories.get(0) :
                        (5 <= i && i <= 8) ? categories.get(1) : categories.get(2)) {
                    case 1:
                        sum += categories.get(0);
                        break;
                    case 2:
                        sum += categories.get(1);
                        break;
                    case 3:
                        sum += categories.get(2);
                        break;
                }
        }
        return sum;
    }

}
