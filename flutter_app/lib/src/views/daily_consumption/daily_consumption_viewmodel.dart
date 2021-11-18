import 'package:charts_flutter/flutter.dart' as charts;
import 'package:flutter/material.dart';
import 'package:smart_energy_app/src/models/subscriber_series.dart';

class DailyConsumptionViewModel {
  final List<SubscriberSeries> timeSeries = [
    SubscriberSeries(
      year: "2008",
      subscribers: 24,
      barColor: charts.ColorUtil.fromDartColor(Colors.blue),
    ),
    SubscriberSeries(
      year: "2009",
      subscribers: 23,
      barColor: charts.ColorUtil.fromDartColor(Colors.red),
    ),
    SubscriberSeries(
      year: "2010",
      subscribers: 12,
      barColor: charts.ColorUtil.fromDartColor(Colors.green),
    ),
  ];
}
