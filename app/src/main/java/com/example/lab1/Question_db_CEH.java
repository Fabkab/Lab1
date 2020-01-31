package com.example.lab1;

public class Question_db_CEH {
    private String questions_CEH[] = {
            "Which of the following don't use ICMP in the attack?",
            "Which virus is only executed when a specific condition is met?"

    };

    private String choices_CEH[][] = {
            {"SYN flood", "Ping of death", "Smurf", "Peer to Peer"},
            {"Sparse Infector", "Multipartite", "Metamorphic", "Cavity"}

    };
    private String answers_CEH[] = {"SYN flood", "Multipartite"};

    public String getQuestion_CEH(int x) {
        String question = questions_CEH[x];
        return question;
    }

    public String getChoice1_CEH(int x) {
        String choice1 = choices_CEH[x][0];
        return choice1;
    }

    public String getChoice2_CEH(int x) {
        String choice2 = choices_CEH[x][1];
        return choice2;
    }

    public String getChoice3_CEH(int x) {
        String choice3 = choices_CEH[x][2];
        return choice3;
    }

    public String getChoice4_CEH(int x) {
        String choice4 = choices_CEH[x][3];
        return choice4;
    }

    public String getAnswer_CEH(int x) {
        String answer = answers_CEH[x];
        return answer;
    }

    public int getLength_CEH(){

        return questions_CEH.length;
    }


}

