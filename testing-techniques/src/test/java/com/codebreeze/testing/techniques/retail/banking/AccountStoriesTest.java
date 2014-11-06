package com.codebreeze.testing.techniques.retail.banking;

import com.codebreeze.testing.techniques.retail.banking.steps.AccountSteps;
import org.jbehave.core.InjectableEmbedder;
import org.jbehave.core.annotations.Configure;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.annotations.UsingSteps;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.AnnotatedEmbedderRunner;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.ParameterConverters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.text.SimpleDateFormat;
import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

@RunWith(AnnotatedEmbedderRunner.class)
@Configure(storyControls = AccountStoriesTest.MyStoryControls.class, storyLoader = AccountStoriesTest.MyStoryLoader.class, storyReporterBuilder = AccountStoriesTest.MyReportBuilder.class,
        parameterConverters = { AccountStoriesTest.MyDateConverter.class })
@UsingEmbedder(embedder = Embedder.class, generateViewAfterStories = true, ignoreFailureInStories = false, ignoreFailureInView = false, verboseFailures = true,
        storyTimeoutInSecs = 100, threads = 1, metaFilters = "-skip")
@UsingSteps(instances = { AccountSteps.class })
public class AccountStoriesTest extends InjectableEmbedder {

    @Test
    public void run() {
        List<String> storyPaths = new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/*.story", "");
        injectedEmbedder().runStoriesAsPaths(storyPaths);
    }

    public static class MyStoryControls extends StoryControls {
        public MyStoryControls() {
            doDryRun(false);
            doSkipScenariosAfterFailure(false);
        }
    }

    public static class MyStoryLoader extends LoadFromClasspath {
        public MyStoryLoader() {
            super(AccountStoriesTest.class.getClassLoader());
        }
    }

    public static class MyReportBuilder extends StoryReporterBuilder {
        public MyReportBuilder() {
            this.withFormats(
                    org.jbehave.core.reporters.Format.CONSOLE,
                    org.jbehave.core.reporters.Format.TXT,
                    org.jbehave.core.reporters.Format.HTML,
                    org.jbehave.core.reporters.Format.XML).withDefaultFormats();
        }
    }

    public static class MyDateConverter extends ParameterConverters.DateConverter {
        public MyDateConverter() {
            super(new SimpleDateFormat("yyyy-MM-dd"));
        }
    }

}
