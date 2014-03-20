package domain;

import java.util.ArrayList;


public class ExporterAdapter implements Exporter
{


	@Override
	public void ExportAllPatterns(ArrayList<Pattern> patterns) {
		TextExporter te = new TextExporter();
		te.ExportAllPatterns(patterns);
	}

	@Override
	public void ExportAllContext(ArrayList<Context> contexts) {
		TextExporter te = new TextExporter();
		te.ExportAllContext(contexts);
		
	}

}
