package com.elasticsearch.analyzer;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.core.WhitespaceTokenizer;

public class ExampleAnalyzer extends Analyzer {
    
    public ExampleAnalyzer() {
    }

    @Override
    protected TokenStreamComponents createComponents(String fieldName) {
        final Tokenizer src = new WhitespaceTokenizer();
        return new TokenStreamComponents(src, new ExampleFilter(src));
    }
}
