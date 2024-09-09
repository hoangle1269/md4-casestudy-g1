package com.example.md4casestudy.config.email;

import com.example.md4casestudy.model.ENUM.FEE_STATUS;
import com.example.md4casestudy.model.Fee;
import com.example.md4casestudy.repository.FeeRepository;
import com.example.md4casestudy.service.email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class FeeReminderScheduler {

    @Autowired
    private FeeRepository feeRepository;

    @Autowired
    private EmailService emailService;
    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    String formattedDate1 = formatter.format(date);
    Date dueSoonDate = new Date(date.getTime() - 3L * 24 * 60 * 60 * 1000);
    String formattedDate2 = formatter.format(dueSoonDate);

    java.sql.Date sqlDate1 = java.sql.Date.valueOf(formattedDate1);
    java.sql.Date sqlDate2 = java.sql.Date.valueOf(formattedDate2);

    @Scheduled(cron = "0 */2 * * * *")
    public void checkFeesAndSendReminders() {
        List<Fee> feesDueSoon = feeRepository.findFeesDueSoon(sqlDate2, sqlDate1);
        for (Fee fee : feesDueSoon) {
            if (fee.getStatus().equals(FEE_STATUS.TUITION.getRoleName())){
                String email = fee.getStudent().getUser().getEmail();
                String subject = "Hạn nộp học phí sắp đến!";
                String text = String.format("Chào %s, hạn nộp học phí của bạn là ngày %s. Vui lòng thanh toán trước ngày đó để tránh bị phạt.",
                        fee.getStudent().getUser().getFullName(), fee.getDueDate().toString());
                emailService.sendFeeReminderEmail(email, subject, text);
            }
        }
    }
}
