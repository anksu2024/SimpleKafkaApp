public class Runner {
    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("Please provide some arguments");
        }

        switch(args[0]) {
            case "SampleProducer":
                new SampleProducer();
                break;
            case "ScaledProducer":
                new ScaledProducer();
                break;
            default:
                System.out.println("Wrong Arguments");
        }
    }
}