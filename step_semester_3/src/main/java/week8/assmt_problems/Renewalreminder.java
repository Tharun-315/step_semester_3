import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

abstract class StreamingPlan {
    protected String name;
    protected LocalDate startDate;

    StreamingPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract LocalDate calculateRenewalDate();
}

class BasicPlan extends StreamingPlan {

    BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    LocalDate calculateRenewalDate() {
        return startDate.plusDays(30);
    }
}

class StandardPlan extends StreamingPlan {

    StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    LocalDate calculateRenewalDate() {
        return startDate.plusDays(90);
    }
}

class PremiumPlan extends StreamingPlan {

    PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    LocalDate calculateRenewalDate() {
        return startDate.plusDays(365);
    }
}

public class Renewalreminder {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        StreamingPlan[] plans = new StreamingPlan[n];

        Map<String, Function<String[], StreamingPlan>> factory =
                new HashMap<>();

        factory.put("BASIC", data ->
                new BasicPlan(
                        data[0],
                        LocalDate.parse(data[1])
                )
        );

        factory.put("STANDARD", data ->
                new StandardPlan(
                        data[0],
                        LocalDate.parse(data[1])
                )
        );

        factory.put("PREMIUM", data ->
                new PremiumPlan(
                        data[0],
                        LocalDate.parse(data[1])
                )
        );

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();
            String startDate = sc.next();

            String[] data = {
                    name,
                    startDate
            };

            plans[i] = factory.get(type).apply(data);
        }

        for (StreamingPlan plan : plans) {

            LocalDate renewalDate =
                    plan.calculateRenewalDate();

            System.out.printf(
                    "%s: %s%n",
                    plan.name,
                    renewalDate
            );
        }

        sc.close();
    }
}