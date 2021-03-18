//package hellocucumber.listener;
//
//import io.cucumber.plugin.ConcurrentEventListener;
//import io.cucumber.plugin.event.*;
//
//public class MyTestListener implements ConcurrentEventListener {
//
//    @Override
//    public void setEventPublisher(EventPublisher publisher) {
//        publisher.registerHandlerFor(TestCaseFinished.class, this::handleTestCaseFinished);
//    }
//
//    private void handleTestCaseFinished(TestCaseFinished event) {
//        TestCase testCase = event.getTestCase();
//        Result result = event.getResult();
//        Status status = result.getStatus();
//        Throwable error = result.getError();
//        String scenarioName = testCase.getName();
//
//        TestStep testStep = testCase.getTestSteps().get(0);
//        if (testStep instanceof PickleStepTestStep) {
//            PickleStepTestStep pickleStepTestStep  = (PickleStepTestStep) testStep;
//            String text = pickleStepTestStep.getStep().getText();
//            System.out.println("Minisha: what is the step: "+ text);
//        }
//
//        if (testStep instanceof HookTestStep) {
//            HookTestStep hookTestStep = (HookTestStep) testStep;
//            HookType hookType = hookTestStep.getHookType();
//            System.out.println("Minisha: what is the hookType: "+ hookType.name());
//        }
//
//
//
//
//
//        String id = "" + testCase.getUri() + testCase.getLine();
//        System.out.println("Minisha: Testcase " + id + " - " + status.name());
//    }
//}