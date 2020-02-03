package com.example.lab1;

public class Question_db_CEH {
    private String questions_CEH[] = {
            "Which of the following don't use ICMP in the attack?",
            "Which virus is only executed when a specific condition is met?",
            "Which of the following is component of a risk assessment?",
            "Which of the following is the greatest threat posed by backups?",
            "Which tool can be used to perform session splicing attacks?",
            "Which item is the primary concern  on OWASPs Top Ten Project most critical web application security rules?",
            "Which of the following EXEC commands will reset LLDP traffic error counters?"

    };

    private String choices_CEH[][] = {
            {"SYN flood", "Ping of death", "Smurf", "Peer to Peer"},
            {"Sparse Infector", "Multipartite", "Metamorphic", "Cavity"},
            {"Logical interface", "DMZ", "Administrative safeguards", "Physical security"},
            {"An un-encrypted backup can be misplaced or stolen","A back is incomplete because no verification done", "A backup is a source of malware","A back up is unvailable during disaster recovery"},
            {"Hydra","Burp", "Whisker", "Tcpsplice"},
            {"Injection", "cross site Scripting", "Cross site Request Forgery", "Path disclosure"},
            {"clear lldp","clear lldp all","clear table lldp","clear lldp counters"}

    };
    private String answers_CEH[] = {"SYN flood", "Metamorphic","Administrative safeguards", "An un-encrypted backup can be misplaced or stolen","Whisker","Injection", "clear lldp counters"};

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

