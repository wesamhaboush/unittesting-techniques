package com.codebreeze.testing.techniques.retail.banking

import org.jbehave.core.configuration.Configuration
import org.jbehave.core.configuration.MostUsefulConfiguration
import org.jbehave.core.io.LoadFromClasspath
import org.jbehave.core.io.StoryFinder
import org.jbehave.core.junit.JUnitStoryMaps
import org.jbehave.core.reporters.Format
import org.jbehave.core.reporters.StoryReporterBuilder

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass

class GAccountStoriesMapTest extends JUnitStoryMaps {

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
    List<String> metaFilters() {
        ["+author *", "theme *","-skip", '@simple', '@financial']
    }
}

//public class TraderStoryMaps extends JUnitStoryMaps {
//
//    public TraderStoryMaps() {
//        configuredEmbedder().useMetaFilters(metaFilters());
//    }
//
//    @Override
//    public Configuration configuration() {
//        return new MostUsefulConfiguration()
//                .useStoryReporterBuilder(new StoryReporterBuilder()
//                .withCodeLocation(CodeLocations.codeLocationFromClass(this.getClass())));
//    }
//
//    @Override
//    protected List<String> metaFilters() {
//        return asList("+author *", "theme *","-skip");
//    }
//
//    @Override
//    protected List<String> storyPaths() {
//        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/*.story", "");
//
//    }
//
//}