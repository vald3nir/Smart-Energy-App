import 'dart:math';

import 'package:charts_flutter/flutter.dart' as charts;
import 'package:flutter/material.dart';

class GaugeChart2 extends StatelessWidget {
  final List<charts.Series> seriesList;
  final bool animate;

  const GaugeChart2({
    Key? key,
    required this.seriesList,
    required this.animate,
  }) : super(key: key);

  factory GaugeChart2.withSampleData() {
    return GaugeChart2(
      seriesList: _createSampleData(),
      animate: false,
    );
  }

  @override
  Widget build(BuildContext context) {

    return SingleChildScrollView(
      scrollDirection: Axis.horizontal,
      child: Container(
        height: 500,
        width: MediaQuery.of(context).size.width,
        padding: const EdgeInsets.all(20),
        child: Card(
          child: Padding(
              padding: const EdgeInsets.all(8.0),
              child: Expanded(
                // valdenir: PieChart<Data>
                child: charts.PieChart(
                  seriesList,
                  // animate: animate,
                  // defaultRenderer: charts.ArcRendererConfig(
                  //     arcWidth: 30,
                  //     startAngle: 4 / 5 * pi,
                  //     arcLength: 7 / 5 * pi)
                ),
              )),
        ),
      ),
    );
  }

  /// Create one series with sample hard coded data.
  static List<charts.Series<GaugeSegment, String>> _createSampleData() {
    final data = [
      GaugeSegment('Low', 75),
      GaugeSegment('Acceptable', 100),
      GaugeSegment('High', 50),
      GaugeSegment('Highly Unusual', 5),
    ];

    return [
      charts.Series<GaugeSegment, String>(
        id: 'Segments',
        domainFn: (GaugeSegment segment, _) => segment.segment,
        measureFn: (GaugeSegment segment, _) => segment.size,
        data: data,
      )
    ];
  }
}

/// Sample data type.
class GaugeSegment {
  final String segment;
  final int size;

  GaugeSegment(this.segment, this.size);
}
