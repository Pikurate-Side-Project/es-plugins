package com.elasticsearch.analyzer;

import org.apache.lucene.analysis.Analyzer;
import org.elasticsearch.index.analysis.AnalyzerProvider;
import org.elasticsearch.indices.analysis.AnalysisModule.AnalysisProvider;
import org.elasticsearch.plugins.AnalysisPlugin;
import org.elasticsearch.plugins.Plugin;

import java.util.Map;
import static java.util.Collections.singletonMap;
public class ExampleAnalyzerPlugin extends Plugin implements AnalysisPlugin {
    
    @Override
    public Map<String, AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> getAnalyzers() {
        return singletonMap("example_analyzer", ExampleAnalyzerProvider::new);
    }
}
