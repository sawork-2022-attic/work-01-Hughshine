import asciiPanel.AsciiPanel;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context1 = new ClassPathXmlApplicationContext("config_8x8/config.xml")) {
            AsciiPanel panel1 = context1.getBean(AsciiPanel.class);
            System.out.println("use config for 8x8: " + panel1.getAsciiFont().getFontFilename());
        }
        try (ClassPathXmlApplicationContext context2 = new ClassPathXmlApplicationContext("config_16x16/config.xml")) {
            AsciiPanel panel2 = context2.getBean(AsciiPanel.class);
            System.out.println("use config for 16x16: " + panel2.getAsciiFont().getFontFilename());
        }
    }
}
