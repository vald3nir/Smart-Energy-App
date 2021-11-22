import 'package:charts_flutter/flutter.dart' as charts;
import 'package:flutter/material.dart';
import 'package:smart_energy_app/src/models/subscriber_series.dart';

import 'daily_consumption_viewmodel.dart';

class DailyConsumptionPage extends StatelessWidget {
  final viewModel = DailyConsumptionViewModel();

  DailyConsumptionPage({
    Key? key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    List<charts.Series<SubscriberSeries, String>> series = [
      charts.Series(
          id: "Subscribers",
          data: viewModel.timeSeries,
          domainFn: (SubscriberSeries series, _) => series.year,
          measureFn: (SubscriberSeries series, _) => series.subscribers,
          colorFn: (SubscriberSeries series, _) => series.barColor)
    ];

    return SingleChildScrollView(
      scrollDirection: Axis.horizontal,
      child: Container(
        height: 400,
        width: 500,
        padding: const EdgeInsets.all(20),
        child: Card(
          child: Padding(
              padding: const EdgeInsets.all(8.0),
              child: Expanded(
                child: charts.BarChart(series, animate: true),
              )),
        ),
      ),
    );
  }
}
