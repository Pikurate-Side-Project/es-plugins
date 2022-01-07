package com.elasticsearch.analyzer;

import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.AbstractIndexAnalyzerProvider;

public class ExampleAnalyzerProvider extends AbstractIndexAnalyzerProvider<ExampleAnalyzer> {

    private final ExampleAnalyzer analyzer;

    public ExampleAnalyzerProvider(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        super(indexSettings, name, settings);
        analyzer = new ExampleAnalyzer();
    }

    @Override
    public ExampleAnalyzer get() {
        return this.analyzer;
    }

}