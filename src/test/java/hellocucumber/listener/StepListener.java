package hellocucumber.listener;

import hellocucumber.StepDefinitions;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;

public class StepListener implements ConcurrentEventListener {


    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestStepFinished.class, this::handleTestStepFinished);
    }

    private void handleTestStepFinished(final TestStepFinished event) {
        System.out.println("Status: "+event.getResult().getStatus());
        System.out.println("Id: "+ event.getTestStep().getId());
        System.out.println("Code Location: "+event.getTestStep().getCodeLocation());

        if (event.getTestStep() instanceof PickleStepTestStep) {
            PickleStepTestStep testStep = (PickleStepTestStep) event.getTestStep();
            System.out.println("Get Step:" + testStep.getStep());
            System.out.println(extractId(testStep));
        }
    }

    //  hellocucumber.StepDefinitions.today_is_Sunday()
    private String extractId(PickleStepTestStep testStep ) {
        try {
           String location = testStep.getCodeLocation();

            String[] locationArray = location.split("\\.");
            String methodName = null;
            Method m = null;

            if(testStep.getDefinitionArgument().size() == 0) {
                 methodName = locationArray[locationArray.length-1].replaceAll("\\(", "").replaceAll("\\)", "");
                m = Class.forName(getClassNameWithPackage(locationArray)).getMethod(methodName);
            } else {
                List<Argument> definitionArgument = testStep.getDefinitionArgument();
                List<String> collect = definitionArgument.stream().map(d -> d.getParameterTypeName()).collect(Collectors.toList());

                String tempMethodName = location.split("\\(")[0];
                String[] methodNameArray = tempMethodName.split("\\.");
                methodName = methodNameArray[methodNameArray.length-1];
                m = findMethod(getClassNameWithPackage(tempMethodName.split("\\.")), methodName, collect.toArray(new String[collect.size()]));
            }

          //  System.out.println("Method name is: "+methodName);


            hellocucumber.annotation.Group a = m.getAnnotation(hellocucumber.annotation.Group.class);
            String value1 = a.id();
            return value1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getClassNameWithPackage(String[] array) {
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<array.length-1; i++) {
            builder.append(array[i]);
            builder.append(".");
        }
        String s = builder.toString().replaceAll(".$", "");
    //    System.out.println("ClassName is "+ s);
        return s;
    }


    private Method  findMethod(String className, String methodName, String ...arguments) {
        try {
            if (arguments.length == 1) {
               return Class.forName(className).getMethod(methodName, Class.forName(getPackage(arguments[0])));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    private String getPackage(String argumentType) {
        switch (argumentType) {
            case "string":
                return "java.lang.String";
            default:
                return null;
        }
    }


}
