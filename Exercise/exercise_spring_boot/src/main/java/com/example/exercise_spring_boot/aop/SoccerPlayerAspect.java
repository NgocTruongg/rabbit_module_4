package com.example.exercise_spring_boot.aop;

import com.example.exercise_spring_boot.model.SoccerPlayer;
import com.example.exercise_spring_boot.service.ISoccerPlayerService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.List;

@Aspect
@Component
public class SoccerPlayerAspect {
    @Autowired
    private ISoccerPlayerService iSoccerPlayerService;
    @After("execution(* com.example.exercise_spring_boot.controller.SoccerPlayerController.*(..))")
    public void logAfterSoccerPlayer(JoinPoint joinPoint) {
        List<SoccerPlayer> soccerPlayerList = iSoccerPlayerService.footballTeam();
        int number = soccerPlayerList.size();
        String methodName = joinPoint.getSignature().getName();
        try {
            File file = new File("D:\\Module_4\\rabbit_module_4\\Exercise\\exercise_spring_boot\\src\\main\\java\\com\\example\\exercise_spring_boot\\file\\football.txt");
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
            String line;
            if ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            File file = new File("D:\\Module_4\\rabbit_module_4\\Exercise\\exercise_spring_boot\\src\\main\\java\\com\\example\\exercise_spring_boot\\file\\football.txt");
            FileOutputStream outputStream = new FileOutputStream(file, true);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            writer.write(methodName + " Số lượng cầu thủ đăng ký đá : " + number + "\n");
            writer.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
