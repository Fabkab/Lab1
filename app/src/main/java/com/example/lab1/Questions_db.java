package com.example.lab1;

public class Questions_db {
    private String questions [] = {
            "Which of the following is not an IPv6 address type?",
            "Which Ethernet switching method would you use if low latency is of utmost importance?",
            "No matter how it's configured, a single switch port is considered what?",
            "Identify which of the services below uses both TCP and UDP ports.",
            "What is the default 802.1D short spanning tree port cost of a 10 Gbps Ethernet link?",
            "letters choose c"

    };

    private String choices [][]= {
            {"Broadcast","Unicast","Anycast","Multicast"},
            {"First-in-first-out","Store-and-forward","Cut-through", "Cisco Express Forwarding (CEF)","Queuing"},
            {"A separate unicast domain","A separate broadcast domain","A separate multicast domain","A separate collision domain"},
            {"FTP","TFTP","DNS","SSH"},
            {"10","4","2","2000"},
            {"A", "B","C", "D"}
    };
    private String answers[]={"Broadcast","Cut-through","A separate collision domain","DNS","2", "C"};

    public String getQuestion(int x){
        String question = questions[x];
                return question;
    }
    public String getChoice1(int x){
        String choice1=choices[x][0];
        return choice1;
    }

    public String getChoice2(int x){
        String choice2=choices[x][1];
        return choice2;
    }
    public String getChoice3(int x){
        String choice3=choices[x][2];
        return choice3;
    }
    public String getChoice4(int x){
        String choice4=choices[x][3];
        return choice4;
    }


    public String getAnswer(int x){
        String answer=answers[x];
        return  answer;
    }

    public int getLength(){

        return questions.length;
    }

}
