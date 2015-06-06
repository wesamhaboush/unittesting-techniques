package com.codebreeze.testing.techniques.retail.banking

import com.codebreeze.testing.techniques.retail.banking.steps.GAccountSteps
import org.jbehave.core.configuration.Configuration
import org.jbehave.core.configuration.MostUsefulConfiguration
import org.jbehave.core.io.LoadFromClasspath
import org.jbehave.core.io.StoryFinder
import org.jbehave.core.junit.JUnitStories
import org.jbehave.core.reporters.Format
import org.jbehave.core.reporters.StoryReporterBuilder
import org.jbehave.core.steps.InjectableStepsFactory
import org.jbehave.core.steps.InstanceStepsFactory

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass

class GAccountStoriesTest extends JUnitStories {

    @Override
    Configuration configuration() {
        new MostUsefulConfiguration()
                .useStoryLoader(new LoadFromClasspath(this.getClass()))
                .useStoryReporterBuilder(
                        new StoryReporterBuilder()
                                .withFormats(
                                        Format.HTML,
                                        Format.STATS,
                                        Format.CONSOLE,
                                        Format.IDE_CONSOLE,
                                        Format.TXT,
                                        Format.HTML_TEMPLATE)
                )
    }

    @Override
    List<String> storyPaths() {
        new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), ["**/*.story"], [""])
    }

    @Override
    InjectableStepsFactory stepsFactory() {
        new InstanceStepsFactory(configuration(), new GAccountSteps())
    }
}