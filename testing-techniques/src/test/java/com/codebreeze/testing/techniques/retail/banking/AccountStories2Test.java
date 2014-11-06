package com.codebreeze.testing.techniques.retail.banking;

import com.codebreeze.testing.techniques.retail.banking.steps.AccountSteps;
import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.runner.RunWith;
import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import static com.google.common.collect.Lists.newLinkedList;


@RunWith(JUnitReportingRunner.class)
public class AccountStories2Test extends JUnitStories {

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new AccountSteps());
    }

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration();
    }

    @Override
    protected List<String> storyPaths() {
        final Reflections reflections = new Reflections(configurationForReflection());

        final Set<String> stories = reflections.getResources(Pattern.compile(".*\\.story"));
        return newLinkedList(stories);
    }

    private ConfigurationBuilder configurationForReflection() {
        return new ConfigurationBuilder()
                .filterInputsBy(new FilterBuilder().includePackage("stories"))
                .setUrls(ClasspathHelper.forPackage("stories"))
                .setScanners(new ResourcesScanner());
    }
}