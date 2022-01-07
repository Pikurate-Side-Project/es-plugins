package com.elasticsearch.analyzer;

import java.util.Map;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.util.TokenFilterFactory;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.AbstractTokenFilterFactory;

public class ExampleFilterFactory extends AbstractTokenFilterFactory {

    public ExampleFilterFactory(IndexSettings indexSettings, String name, Settings settings) {
        super(indexSettings, name, settings);
    }

    @Override
    public TokenStream create(TokenStream tokenStream) {
        return new ExampleFilter(tokenStream);
    }
}
